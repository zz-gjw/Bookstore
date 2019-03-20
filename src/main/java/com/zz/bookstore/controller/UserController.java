package com.zz.bookstore.controller;

import com.zz.bookstore.common.util.ResultUtil;
import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.entity.User;
import com.zz.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-20
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("save.do")
    public ResultVo save(String username, String password){
        return userService.save(username,password);
    }

    @PostMapping("login.do")
    public ResultVo login(String username, String password){
        return userService.login(username,password);
    }
	
}
