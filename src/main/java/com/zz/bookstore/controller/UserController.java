package com.zz.bookstore.controller;

import com.zz.bookstore.common.util.ResultUtil;
import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.entity.User;
import com.zz.bookstore.entity.Userdetail;
import com.zz.bookstore.service.UserService;
import com.zz.bookstore.service.UserdetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-20
 */
@Api(tags = "用户中心")
@RestController
@CrossOrigin
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserdetailService userdetailService;

    @ApiOperation(value = "注册", notes = "传入username和password的值，注册用户")
    @PostMapping("save.do")
    public ResultVo save(String username, String password){
        return userService.save(username,password);
    }

    @ApiOperation(value = "登录", notes = "输入username和password的值，用户登录")
    @PostMapping("login.do")
    public ResultVo login(String username, String password){
        return userService.login(username,password);
    }

    @ApiOperation(value = "查询个人详情", notes = "传入token，查询该用户的个人详细资料")
    @GetMapping("sUdetailByUid.do")
    public ResultVo sUdetailByUid(String token){
        return userdetailService.sUdetailByUid(token);
    }

    @ApiOperation(value = "修改个人详情", notes = "传入token，用户信息，修改该用户的个人详细资料")
    @PostMapping("uUdetailByUid.do")
    public ResultVo uUdetailByUid(Userdetail userdetail, String token){
        return userdetailService.uUdetailByUid(userdetail, token);
    }
}
