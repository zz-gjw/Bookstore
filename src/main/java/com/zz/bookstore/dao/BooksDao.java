package com.zz.bookstore.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.entity.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
  *  Mapper 接口
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-20
 */
public interface BooksDao extends BaseMapper<Books> {
    List<Books> selectBooksBySort(Map map);
    Books selectBooksDetail(Integer id);
    List<Books> selectBooksMh(@Param("booksname") String booksname);
}