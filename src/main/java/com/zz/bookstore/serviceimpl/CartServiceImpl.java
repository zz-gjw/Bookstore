package com.zz.bookstore.serviceimpl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.bookstore.dao.CartDao;
import com.zz.bookstore.entity.Cart;
import com.zz.bookstore.service.CartService;
import org.springframework.stereotype.Service;

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
	
}
