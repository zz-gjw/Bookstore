package com.zz.bookstore.serviceimpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.bookstore.common.token.TokenUtil;
import com.zz.bookstore.common.util.ResultUtil;
import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.dao.CartDao;
import com.zz.bookstore.entity.Cart;
import com.zz.bookstore.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-21
 */
@Service
public class CartServiceImpl extends ServiceImpl<CartDao, Cart> implements CartService {
    @Autowired
    private CartDao cartDao;
    @Override
    public ResultVo showCartByUid(String token) {
        int userid = TokenUtil.parseToken(token).getId();

        List<Cart> list = cartDao.selectCartByUid(userid);
        if(list!=null){
            return ResultUtil.exec(true,"ok",list);
        }
        return ResultUtil.exec(false,"未查询到结果",null);
    }
}
