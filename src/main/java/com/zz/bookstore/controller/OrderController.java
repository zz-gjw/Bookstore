package com.zz.bookstore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.bookstore.common.token.TokenUtil;
import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.entity.Cart;
import com.zz.bookstore.entity.Order;
import com.zz.bookstore.entity.Orderdetail;
import com.zz.bookstore.service.CartService;
import com.zz.bookstore.service.OrderService;
import com.zz.bookstore.service.OrderdetailService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-21
 */
@Api(tags = "订单模块")
@CrossOrigin
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private OrderdetailService orderdetailService;
    @Autowired
    private CartService cartService;

    @ApiOperation(value = "下订单", notes = "根据booksid、num、token、address、phone、oname下订单，并把购物车中对应的商品删除")
    @PostMapping("addOrder.do")
    public boolean addOrder(String token, String address, Integer phone, String oname,Integer booksid,Integer num){
        int userid = TokenUtil.parseToken(token).getId();
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");

            String uuid = UUID.randomUUID().toString().replace("-","");
            String date = sdf.format(new Date());

            Order order = new Order();
            order.setNumber(userid + uuid + date);
            order.setCreatetime(new Date());
            order.setState(1);
            order.setUserid(userid);
            order.setAddress(address);
            order.setPhone(phone);
            order.setOname(oname);
            order.setFlag(1);
            orderService.save(order);

            //增加订单详情表的数据
            int oid = order.getId();
            Orderdetail orderdetail = new Orderdetail();
            orderdetail.setBooksid(booksid);
            orderdetail.setNum(num);
            orderdetail.setOrderid(oid);
            orderdetailService.save(orderdetail);

            //删除数据库中对用的商品的信息
            QueryWrapper<Cart> queryWrapper = new QueryWrapper<>();
            queryWrapper.eq("booksid",orderdetail.getBooksid()).eq("userid",userid);

            Cart cart = new Cart();
            cart.setFlag(2);
            cartService.update(cart,queryWrapper);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @ApiOperation(value = "查询订单", notes = "传入state、token查询指定类型的订单  state：1为待付款订单  2为待发货订单 3为待评价 不传参数为查询该用户的所有订单")
    @PostMapping("showOrder.do")
    public ResultVo showOrder(String token, Integer state){
        return orderService.showOrder(token, state);
    }

    @ApiOperation(value = "删除订单、修改订单状态",notes = "根据flag、state、token进行订单相关操作，只传入flag=2为删除订单，传入state=2为修改订单状态为已付款 传入state=3为修改订单状态为已发货")
    @PutMapping("updateOrder.do")
    public boolean updateOrder(Integer state, Integer flag, Integer id, String token){
        int userid = TokenUtil.parseToken(token).getId();

        QueryWrapper<Order> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("userid",userid).eq("id",id);
        Order order = new Order();
        order.setId(id);
        order.setState(state);
        order.setFlag(flag);

        return orderService.update(order,queryWrapper);
    }

}
