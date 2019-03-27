package com.zz.bookstore.service;

import com.baomidou.mybatisplus.extension.service.IService;
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
public interface UserService extends IService<User> {
    //注册
	ResultVo save(String username, String password);
    //登录
    ResultVo login(String username, String password);
}
