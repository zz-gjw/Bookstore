package com.zz.bookstore.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.bookstore.dao.OrderdetailDao;
import com.zz.bookstore.entity.Orderdetail;
import com.zz.bookstore.service.OrderdetailService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-25poi
 */
@Service
public class OrderdetailServiceImpl extends ServiceImpl<OrderdetailDao, Orderdetail> implements OrderdetailService {
	
}
