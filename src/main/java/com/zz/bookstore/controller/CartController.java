package com.zz.bookstore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.bookstore.common.token.TokenUtil;
import com.zz.bookstore.entity.Cart;
import com.zz.bookstore.service.CartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-21
 */

@RestController
@CrossOrigin
@Api(tags = "购物车相关")
public class CartController {
    @Autowired
    private CartService cartService;


    @ApiOperation(value = "添加购物车",notes = "添加指定商品到购物车中")
    @PostMapping("addCart.do")
	public boolean addCart(Cart cart,String token){
        int booksid = cart.getBooksid();
        int userid = TokenUtil.parseToken(token).getId();
        cart.setNum(1);
        cart.setUserid(userid);
        cart.setCreatime(new Date());
        cart.setFlag(1);

        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",userid).eq("booksid",booksid);

        if(cartService.getOne(queryWrapper)==null){
            return cartService.save(cart);
        }else{
            Cart a = new Cart();
            a.setNum(cartService.getOne(queryWrapper).getNum()+1);
            return cartService.update(a,queryWrapper);
        }
    }

    @ApiOperation(value = "asdasdad",notes = "sad")
    @PostMapping("selectByTwo.do")
    public Cart selectByTwo(Integer booksid, String token){
        Integer userid = TokenUtil.parseToken(token).getId();
        /*Map map = new HashMap();
        map.put("userid",userid);
        map.put("booksid",booksid);*/

        QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",userid).eq("booksid",booksid);

        return cartService.getOne(queryWrapper);
    }
}
