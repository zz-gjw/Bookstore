package com.zz.bookstore.serviceimpl;

import com.zz.bookstore.common.util.ResultUtil;
import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.dao.BooksDao;
import com.zz.bookstore.entity.Books;
import com.zz.bookstore.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-20
 */
@Service
public class BooksServiceImpl implements BooksService {
    @Autowired
    private BooksDao booksDao;

    @Override
    public ResultVo showBooksSort(Integer cid, Integer sid) {
        Map map = new HashMap();
        map.put("cid",cid);
        map.put("sid",sid);
        List<Books> list = booksDao.selectBooksBySort(map);
        if(list!=null){
            return ResultUtil.exec(true,"ok",list);
        }
        return ResultUtil.exec(false,"",null);
    }

    @Override
    public ResultVo showBooksDetail(Integer id) {
        Books books = booksDao.selectBooksDetail(id);
        if(books!=null){
            return ResultUtil.exec(true,"ok",books);
        }
        return ResultUtil.exec(false,"未查询到数据",null);
    }

    @Override
    public ResultVo showBooksMh(String booksname) {
        booksname = "%"+booksname+"%";
        List<Books> list = booksDao.selectBooksMh(booksname);
        if(list!=null){
            return ResultUtil.exec(true,"ok",list);
        }
        return ResultUtil.exec(false,"未查询到数据",null);
    }
}
