package com.zz.bookstore.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.bookstore.entity.Order;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-25
 */
public interface OrderDao extends BaseMapper<Order> {
    List<Order> selectOrder(Integer userid, Integer state);
}