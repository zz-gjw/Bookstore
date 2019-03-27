package com.zz.bookstore.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.entity.Cart;

import java.util.List;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-20
 */
public interface CartDao extends BaseMapper<Cart> {

    List<Cart> selectCartByUid(Integer userid);

}