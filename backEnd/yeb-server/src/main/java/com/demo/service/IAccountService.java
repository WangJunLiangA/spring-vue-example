package com.demo.service;

import com.demo.pojo.Account;
import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.pojo.ResponseBean;

import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Wangjunliang
 * @since 22-01-19 01:56
 */
public interface IAccountService extends IService<Account> {

    ResponseBean login(String username, String password,String code ,HttpServletRequest request);

    Account getAccountByUserName(String username);
}
