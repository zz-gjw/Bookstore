package com.zz.bookstore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.bookstore.common.token.TokenUtil;
import com.zz.bookstore.common.util.ResultUtil;
import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.entity.Location;
import com.zz.bookstore.entity.User;
import com.zz.bookstore.entity.Userdetail;
import com.zz.bookstore.service.LocationService;
import com.zz.bookstore.service.UserService;
import com.zz.bookstore.service.UserdetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @Autowired
    private LocationService locationService;

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

    /*@ApiOperation(value = "jm注册", notes = "传入username和password的值，注册用户")
    @PostMapping("savejm.do")
    public String add(String username, String password){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setFlag(1);
        return userService.save(user)?"注册成功":"注册失败";
    }*/

    @ApiOperation(value = "查询个人详情", notes = "传入token，查询该用户的个人详细资料")
    @GetMapping("sUdetailByUid.do")
    public ResultVo sUdetailByUid(String token){
        return userdetailService.sUdetailByUid(token);
    }


    @ApiOperation(value = "修改个人详情", notes = "传入token，用户信息，修改该用户的个人详细资料")
    @PutMapping("updataDetail.do")
    public boolean updataDetail(Userdetail userdetail, String token){
        int userid = TokenUtil.parseToken(token).getId();
        QueryWrapper<Userdetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",userid);
        return userdetailService.update(userdetail,queryWrapper);
    }

    @ApiOperation(value = "新增用户收货地址", notes = "传入token、address、phone、name新建收货地址")
    @PostMapping("addLocation.do")
    public String addLocation(String token, Location location){
        int userid = TokenUtil.parseToken(token).getId();
        location.setUserid(userid);
        location.setFlag(1);
        return locationService.save(location)?"新建成功":"新增失败";
    }

    @ApiOperation(value = "修改、删除收货地址",notes = "传入token、address、phone、name修改收货地址  删除收货地址只需要传入flag=2")
    @PutMapping("updateLocation.do")
    public Boolean updateLocation(String token, Location location){
        int userid = TokenUtil.parseToken(token).getId();
        QueryWrapper<Location> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",userid).eq("id",location.getId());
        return locationService.update(location,queryWrapper);
    }

    @ApiOperation(value = "展示收货地址", notes = "传入token，展示对应用户未被删除的所有收货地址")
    @PostMapping("showLocation.do")
    public List<Location> showLocation(String token){
        int userid = TokenUtil.parseToken(token).getId();
        QueryWrapper<Location> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",userid).eq("flag",1);
        return locationService.list(queryWrapper);
    }

}
