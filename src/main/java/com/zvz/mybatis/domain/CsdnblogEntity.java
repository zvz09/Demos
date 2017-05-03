package com.zvz.mybatis.domain;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * csdn blog抓取保存
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017-04-16 16:28:53
 */
public class CsdnblogEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//
	private Integer id;
	//作者
	private String author;
	//作者地址
	private String authorUrl;
	//原地址
	private String url;
	//标题
	private String title;
	//内容
	private String context;
	//标签
	private String label;
	//
	private Date creatDate;

	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：作者
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 获取：作者
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 设置：作者地址
	 */
	public void setAuthorUrl(String authorUrl) {
		this.authorUrl = authorUrl;
	}
	/**
	 * 获取：作者地址
	 */
	public String getAuthorUrl() {
		return authorUrl;
	}
	/**
	 * 设置：原地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	/**
	 * 获取：原地址
	 */
	public String getUrl() {
		return url;
	}
	/**
	 * 设置：标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 获取：标题
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 设置：内容
	 */
	public void setContext(String context) {
		this.context = context;
	}
	/**
	 * 获取：内容
	 */
	public String getContext() {
		return context;
	}
	/**
	 * 设置：标签
	 */
	public void setLabel(String label) {
		this.label = label;
	}
	/**
	 * 获取：标签
	 */
	public String getLabel() {
		return label;
	}
	/**
	 * 设置：
	 */
	public void setCreatDate(Date creatDate) {
		this.creatDate = creatDate;
	}
	/**
	 * 获取：
	 */
	public Date getCreatDate() {
		return creatDate;
	}


	@Override
	public String toString() {
		return "CsdnblogEntity{" +
				"id=" + id +
				", author='" + author + '\'' +
				", authorUrl='" + authorUrl + '\'' +
				", url='" + url + '\'' +
				", title='" + title + '\'' +
				", context='" + context + '\'' +
				", label='" + label + '\'' +
				", creatDate=" + creatDate +
				'}';
	}
}
