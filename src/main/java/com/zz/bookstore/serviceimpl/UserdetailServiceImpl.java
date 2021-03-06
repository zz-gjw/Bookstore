package com.zz.bookstore.serviceimpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.bookstore.common.token.TokenUtil;
import com.zz.bookstore.common.util.ResultUtil;
import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.dao.UserdetailDao;
import com.zz.bookstore.entity.Userdetail;
import com.zz.bookstore.service.UserdetailService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-20
 */
@Service
public class UserdetailServiceImpl extends ServiceImpl<UserdetailDao, Userdetail> implements UserdetailService {
    @Autowired
    private UserdetailDao userdetailDao;

    @Override
    public ResultVo sUdetailByUid(String token) {
        //从token中获取用户id
        int userid = TokenUtil.parseToken(token).getId();
        QueryWrapper<Userdetail> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",userid);

        Userdetail userdetail = userdetailDao.selectOne(queryWrapper);
        return ResultUtil.exec(true,"ok",userdetail);
    }
}
