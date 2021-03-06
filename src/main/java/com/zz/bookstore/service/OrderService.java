package com.zz.bookstore.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.entity.Order;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-25
 */
public interface OrderService extends IService<Order> {
	ResultVo showOrder(String token, Integer state);
}
