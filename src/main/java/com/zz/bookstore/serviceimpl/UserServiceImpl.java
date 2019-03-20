package com.zz.bookstore.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.bookstore.common.token.TokenUtil;
import com.zz.bookstore.common.util.ResultUtil;
import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.dao.UserDao;
import com.zz.bookstore.entity.User;
import com.zz.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;



/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-20
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public ResultVo save(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);

        User a = new User();
        a.setUsername(username);
        a.setPassword(password);
        a.setFlag(1);

        User user = userDao.selectOne(queryWrapper);
        if(user==null){
            userDao.insert(a);
            return ResultUtil.exec(true,"ok",null);
        }
        return ResultUtil.exec(false,"该用户已存在，请直接登录",null);
    }

    @Override
    public ResultVo login(String username, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",username);

        User user = userDao.selectOne(queryWrapper);
        if(user!=null){
            if(Objects.equals(user.getPassword(),password)){
                String token = TokenUtil.createToken(user);
                return ResultUtil.exec(true,"OK",token);
            }
        }
        return ResultUtil.exec(false,"该账号未注册，请先注册",null);
    }
}
