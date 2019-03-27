package com.zz.bookstore.serviceimpl;

import com.alibaba.druid.sql.visitor.functions.Now;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.bookstore.common.token.TokenUtil;
import com.zz.bookstore.common.util.ResultUtil;
import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.dao.UserDao;
import com.zz.bookstore.dao.UserdetailDao;
import com.zz.bookstore.entity.User;
import com.zz.bookstore.entity.Userdetail;
import com.zz.bookstore.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
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
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements UserService {
    @Autowired
    private UserDao userDao;

    @Autowired
    private UserdetailDao userdetailDao;

    @Override
    @Transactional
    public ResultVo save(String username, String password) {
        QueryWrapper<User> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("username",username);

        User a = userDao.selectOne(queryWrapper);
        if(a == null){
            try {
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setFlag(1);
                user.setCreatetime(new Date());

                userDao.insert(user);

                Userdetail userdetail = new Userdetail();
                userdetail.setUserid(user.getId());
                userdetailDao.insert(userdetail);

                return ResultUtil.exec(true,"ok",null);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return ResultUtil.exec(false,"该用户已注册，请直接登录",null);
    }

    @Override
    public ResultVo login(String username, String password) {
        QueryWrapper<User> queryWrapper =new QueryWrapper<>();
        queryWrapper.eq("username",username);

        User user = userDao.selectOne(queryWrapper);
        if(user != null){
            if(Objects.equals(user.getPassword(),password)){
                //1、生成Token
                String token= TokenUtil.createToken(user);
                //2、将Token到Redis
                //jedisUtil.save(SystemConst.TOKENMAP,"user:"+token, user.getPhone());
                //3、将Token到前端
                return ResultUtil.exec(true,"ok",token);
            }
        }
        return ResultUtil.exec(false,"该用户不存在，请先注册",null);
    }
}
