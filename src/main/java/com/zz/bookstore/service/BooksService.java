package com.zz.bookstore.service;


import com.zz.bookstore.common.vo.ResultVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-20
 */
public interface BooksService{
    /**
     * 根据一级菜单cid和二级菜单sid动态查询所有的产品
     * @param cid
     * @param sid
     * @return
     */
    ResultVo showBooksSort(Integer cid, Integer sid);

    ResultVo showBooksDetail(Integer id);

    ResultVo showBooksMh(String booksname);
	
}
