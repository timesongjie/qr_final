package com.heroopsys.qrcode.service;

import com.heroopsys.qrcode.dao.AccountMapper;
import com.heroopsys.qrcode.entity.Account;
import com.heroopsys.qrcode.util.Pager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by time on 15-12-15.
 */
@Service
public class AccountService {
    @Resource
    private AccountMapper accountMapper;

    public void addAccount(Account account) {
	accountMapper.addAccount(account);
    }

    public void updateAccount(Account account) {
	accountMapper.updateAccount(account);
    }

    public Pager<Account> list(Account account, Pager<Account> pager) {
	pager.setTotal(accountMapper.count(account));
	List<Account> accounts = accountMapper.listAllByPager(account, pager);
	pager.setDataList(accounts);
	return pager;
    }

    public Account findByAccount(Account account) {
	return accountMapper.queryAccount(account);
    }

    public Integer delAccount(Integer id) {
	return accountMapper.deleteAccount(id);
    }
}
