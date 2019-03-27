package com.zz.bookstore.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.zz.bookstore.common.vo.ResultVo;
import com.zz.bookstore.entity.Books;
import com.zz.bookstore.entity.Goodscate;
import com.zz.bookstore.entity.Goodstyle;
import com.zz.bookstore.service.BooksService;
import com.zz.bookstore.service.GoodscateService;
import com.zz.bookstore.service.GoodstyleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-20
 */
@RestController
@Api(tags = "商品相关")
@CrossOrigin
public class BooksController {
    @Autowired
    private GoodscateService goodscateService;
    @Autowired
    private GoodstyleService goodstyleService;
    @Autowired
    private BooksService booksService;

    @ApiOperation(value = "一级菜单", notes = "查询所有的一级菜单")
    @GetMapping("selelAllCate.do")
    public List<Goodscate> selelAllCate(){
        return goodscateService.list();
    }

    @ApiOperation(value = "二级菜单", notes = "根据parentid查询所有的一级菜单下的二级菜单")
    @GetMapping("selectAllTyleByCid.do")
    public List<Goodstyle> selectAllTyleByCid(Integer cateid){
        QueryWrapper<Goodstyle> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cateid",cateid);

        return goodstyleService.list(queryWrapper);
    }

    @ApiOperation(value = "展示books", notes = "根据一级分类cid，二级分类sid展示对应的books")
    @GetMapping("showBooksSort.do")
    public ResultVo showBooksSort(Integer cid, Integer sid){
        return booksService.showBooksSort(cid, sid);
    }

    @ApiOperation(value = "展示books的详情",notes = "根据商品id，展示商品详情页")
    @GetMapping("showBooksDetail.do")
    public ResultVo showBooksDetail(Integer id){
        return booksService.showBooksDetail(id);
    }

    @ApiOperation(value = "模糊搜索", notes = "根据输入的名称  进行模糊查找")
    @GetMapping("showBooksMh.do")
    public ResultVo showBooksMh(String booksname){
        return booksService.showBooksMh(booksname);
    }

   /* @ApiOperation(value = "abc", notes = "qwe")
    @PostMapping("updata.do")
    public String updata(Goodstyle a, Integer cateid){
        QueryWrapper<Goodstyle> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("cateid",cateid);
        return goodstyleService.update(a,queryWrapper)==true?"成功":"shibai";
    }*/
}
