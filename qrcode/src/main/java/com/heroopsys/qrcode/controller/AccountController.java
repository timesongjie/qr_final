package com.heroopsys.qrcode.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.heroopsys.qrcode.common.controller.BaseController;
import com.heroopsys.qrcode.entity.Account;
import com.heroopsys.qrcode.service.AccountService;
import com.heroopsys.qrcode.util.Grid;
import com.heroopsys.qrcode.util.MD5Util;
import com.heroopsys.qrcode.util.Pager;
import com.heroopsys.qrcode.util.Result;
import com.heroopsys.qrcode.util.Tree;

/**
 * Created by time on 15-12-15.
 */
@Controller
@RequestMapping("/account")
public class AccountController extends BaseController {

	@Resource
	private AccountService accountService;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public Result login(String username, String password,
			HttpServletRequest request) {
		Account account = new Account(username, MD5Util.MD5(password));
		account = accountService.findByAccount(account) ;
		if (account!= null && account.getAllow() == 1) {
			account.setPassword(password);
			request.getSession().setAttribute("account_info", account);
			return new Result("登陆成功!", true);
		} else {
			return new Result("登陆失败!", false);
		}
	}

	@RequestMapping("/logout")
	public Result logout(HttpServletRequest request) {
		request.getSession().removeAttribute("account_info");
		return new Result("退出成功", true);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public Grid<Account> list(Integer page, Integer rows) {
		if (page == null) {
			page = 1;
		}
		if (rows == null) {
			rows = 20;
		}
		Account account = new Account();
		Pager<Account> pager = new Pager<Account>();
		pager.setPage(page);
		pager.setRows(rows);
		Grid<Account> grid = new Grid<Account>();
		accountService.list(account, pager);
		grid.setRows(pager.getDataList());
		grid.setTotal(pager.getTotal());
		return grid;
	}

	@RequestMapping(method = RequestMethod.POST)
	public Result addAccount(Account account, Model model) {
		account.setPassword(MD5Util.MD5(account.getPassword()));
		accountService.addAccount(account);
		doClear(model, "account");
		return new Result("添加成功!", true);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public Result delAccount(@PathVariable Integer id) {
		accountService.delAccount(id);
		return new Result("删除成功!", true);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public Result updateAccount(Account account, Model model) {
		accountService.updateAccount(account);
		doClear(model, "account");
		return new Result("更新成功!", true);
	}

	@RequestMapping(value="/info",method = RequestMethod.POST)
	public Result updatePassword(Account account, Model model,HttpServletRequest request) {
		Account user = (Account) request.getSession().getAttribute("account_info");
		account.setId(user.getId());
		doClear(model, "account");
		if(user.getPassword().equals(MD5Util.MD5(account.getOldPassword()))){
			accountService.updatePassword(account);
		}else{
			return new Result("修改失败!旧密码不对", true);
		}
		return new Result("修改成功!", true);
	}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public String getAccountById(@PathVariable Long id, Model model) {
		Account account = new Account();
		account.setId(id);
		account = accountService.findByAccount(account);
		model.addAttribute("account", account);
		return "account/accountEdit";
	}

	@RequestMapping(value = "/perm", method = RequestMethod.GET)
	public List<Tree> toPermission(Long id,HttpServletRequest request) {
		Account account = new Account();
		account.setId(id);
		account = accountService.findByAccount(account);
		return trans(account,isAdmin(request));
	}

	private boolean isAdmin(HttpServletRequest request) {
		Account user = (Account) request.getSession().getAttribute("account_info");
		return isAdmin(user);
	}

	private boolean isAdmin(Account account){
		return "admin".equals(account.getName()) || (account.getId() != null && 1 == account.getId().intValue());
	}
	@RequestMapping(value = "/perm", method = RequestMethod.POST)
	public Result grantPermission(Account account, Model model) {
		if (StringUtils.isEmpty(account.getPerms())) {
			account.setPerms("000");
		}
		if(isAdmin(account)){//保证管理员永远能够登录
			account.setAllow((byte)1);
		};
		accountService.updateAccount(account);
		doClear(model, "account");
		return new Result("更新成功!", true);
	}

	private List<Tree> trans(Account account,boolean isAdmin) {
		String perms = account.getPerms();
		List<Tree> lperm = new ArrayList<Tree>(3);
		Tree first = new Tree("新增基本信息", 1l);
		isChecked(perms.charAt(0), first);
		lperm.add(first);

		Tree second = new Tree("修改基本信息", 2l);
		isChecked(perms.charAt(1), second);
		lperm.add(second);

		Tree third = new Tree("追加服务信息", 3l);
		isChecked(perms.charAt(2), third);
		lperm.add(third);
		if(isAdmin && !isAdmin(account)){//admin登录并且设置的非admin用户，能够分配登录后台权限
			Tree allow = new Tree("允许登录后台", 4l);
			isChecked(account.getAllow().toString().charAt(0), allow);
			lperm.add(allow);
		}
		return lperm;
	}

	private void isChecked(char perm, Tree tree) {
		if (perm == '0') {
			tree.setChecked(false);
		} else {
			tree.setChecked(true);
		}
	}
}
