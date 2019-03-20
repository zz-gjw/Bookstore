package com.zz.bookstore.service;

import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.entity.User;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-20
 */
public interface UserService{
    ResultVo save(String username, String password);
    ResultVo login(String username, String password);
}
