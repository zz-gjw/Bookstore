package com.zz.bookstore.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.bookstore.common.token.TokenUtil;
import com.zz.bookstore.common.util.ResultUtil;
import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.dao.OrderDao;
import com.zz.bookstore.entity.Order;
import com.zz.bookstore.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-25
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements OrderService {
    @Autowired
    private OrderDao orderDao;

    @Override
    public ResultVo showOrder(String token, Integer state) {
        int userid = TokenUtil.parseToken(token).getId();
        List<Order> list = orderDao.selectOrder(userid, state);
        if(list!=null){
            return ResultUtil.exec(true,"ok",list);
        }
        return ResultUtil.exec(false,"添加订单异常", null);
    }
}
