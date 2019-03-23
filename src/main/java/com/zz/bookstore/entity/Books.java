package com.zz.bookstore.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author zz-gjw
 * @since 2019-03-20
 */
@TableName("t_books")
public class Books extends Model<Books> {

    private static final long serialVersionUID = 1L;

	@TableId(value="id", type= IdType.AUTO)
	private Integer id;
	private String booksname;
	private Integer parentid;
	private Double price;
	private String url;
	private Integer flag;

	private Goodscate goodscate;
	private Goodstyle goodstyle;

	public Goodscate getGoodscate() {
		return goodscate;
	}

	public void setGoodscate(Goodscate goodscate) {
		this.goodscate = goodscate;
	}

	public Goodstyle getGoodstyle() {
		return goodstyle;
	}

	public void setGoodstyle(Goodstyle goodstyle) {
		this.goodstyle = goodstyle;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBooksname() {
		return booksname;
	}

	public void setBooksname(String booksname) {
		this.booksname = booksname;
	}

	public Integer getParentid() {
		return parentid;
	}

	public void setParentid(Integer parentid) {
		this.parentid = parentid;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Integer getFlag() {
		return flag;
	}

	public void setFlag(Integer flag) {
		this.flag = flag;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
