package com.zz.bookstore.service;


import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.entity.Userdetail;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-20
 */
public interface UserdetailService {
    //根据userid查询该用户的个人详情
    ResultVo sUdetailByUid(String token);
    //修改个人详情
    ResultVo uUdetailByUid(Userdetail userdetail, String token);
	
}
