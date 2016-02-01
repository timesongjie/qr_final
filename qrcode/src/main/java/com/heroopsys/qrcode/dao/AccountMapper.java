package com.heroopsys.qrcode.dao;

import com.heroopsys.qrcode.entity.Account;
import com.heroopsys.qrcode.util.Pager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by time on 15-12-14.
 */
public interface AccountMapper {
    public Integer addAccount(Account account);

    public Integer updateAccount(Account account);

    public List<Account> listAllByPager(@Param("account") Account account, @Param("page") Pager<Account> pager);

    public Account queryAccount(Account account);

    public Integer count(Account account);

    public Integer deleteAccount(Integer id);
}
