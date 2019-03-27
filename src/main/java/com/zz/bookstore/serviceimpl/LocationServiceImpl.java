package com.zz.bookstore.serviceimpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zz.bookstore.dao.LocationDao;
import com.zz.bookstore.entity.Location;
import com.zz.bookstore.service.LocationService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-25
 */
@Service
public class LocationServiceImpl extends ServiceImpl<LocationDao, Location> implements LocationService {
	
}
