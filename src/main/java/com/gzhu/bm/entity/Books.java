package com.gzhu.bm.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "books")
public class Books {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "books_id")
    private Long booksId;

    /**
     * 书名
     */
    @Column(name = "book_name")
    private String bookName;

    /**
     * 作者
     */
    private String author;

    /**
     * 分类，还没定好
     */
    private Byte category;

    /**
     * 简介
     */
    private String description;

    /**
     * 是否需付费，按章节
     */
    private BigDecimal cost;

    /**
     * 缩略图路径
     */
    @Column(name = "img_path")
    private String imgPath;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 更新时间
     */
    @Column(name = "updated_time")
    private Date updatedTime;

    /**
     * 是否已删除
     */
    @Column(name = "is_delete")
    private Byte isDelete;

    /**
     * 热门指数
     */
    @Column(name = "hot_score")
    private Long hotScore;

    /**
     * 免费章节
     */
    @Column(name = "free_chapters")
    private Long freeChapters;

    /**
     * 全本购买折扣
     */
    @Column(name = "order_discount")
    private Short orderDiscount;

    /**
     * 文件路径
     */
    @Column(name = "file_path")
    private String filePath;

    /**
     * 获取主键ID
     *
     * @return books_id - 主键ID
     */
    public Long getBooksId() {
        return booksId;
    }

    /**
     * 设置主键ID
     *
     * @param booksId 主键ID
     */
    public void setBooksId(Long booksId) {
        this.booksId = booksId;
    }

    /**
     * 获取书名
     *
     * @return book_name - 书名
     */
    public String getBookName() {
        return bookName;
    }

    /**
     * 设置书名
     *
     * @param bookName 书名
     */
    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    /**
     * 获取作者
     *
     * @return author - 作者
     */
    public String getAuthor() {
        return author;
    }

    /**
     * 设置作者
     *
     * @param author 作者
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * 获取分类，还没定好
     *
     * @return category - 分类，还没定好
     */
    public Byte getCategory() {
        return category;
    }

    /**
     * 设置分类，还没定好
     *
     * @param category 分类，还没定好
     */
    public void setCategory(Byte category) {
        this.category = category;
    }

    /**
     * 获取简介
     *
     * @return description - 简介
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置简介
     *
     * @param description 简介
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 获取是否需付费，按章节
     *
     * @return cost - 是否需付费，按章节
     */
    public BigDecimal getCost() {
        return cost;
    }

    /**
     * 设置是否需付费，按章节
     *
     * @param cost 是否需付费，按章节
     */
    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    

    /**
     * 获取创建时间
     *
     * @return created_time - 创建时间
     */
    public Date getCreatedTime() {
        return createdTime;
    }

    /**
     * 设置创建时间
     *
     * @param createdTime 创建时间
     */
    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    /**
     * 获取更新时间
     *
     * @return updated_time - 更新时间
     */
    public Date getUpdatedTime() {
        return updatedTime;
    }

    /**
     * 设置更新时间
     *
     * @param updatedTime 更新时间
     */
    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }

    /**
     * 获取是否已删除
     *
     * @return is_delete - 是否已删除
     */
    public Byte getIsDelete() {
        return isDelete;
    }

    /**
     * 设置是否已删除
     *
     * @param isDelete 是否已删除
     */
    public void setIsDelete(Byte isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 获取热门指数
     *
     * @return hot_score - 热门指数
     */
    public Long getHotScore() {
        return hotScore;
    }

    /**
     * 设置热门指数
     *
     * @param hotScore 热门指数
     */
    public void setHotScore(Long hotScore) {
        this.hotScore = hotScore;
    }

    /**
     * 获取免费章节
     *
     * @return free_chapters - 免费章节
     */
    public Long getFreeChapters() {
        return freeChapters;
    }

    /**
     * 设置免费章节
     *
     * @param freeChapters 免费章节
     */
    public void setFreeChapters(Long freeChapters) {
        this.freeChapters = freeChapters;
    }

    /**
     * 获取全本购买折扣
     *
     * @return order_discount - 全本购买折扣
     */
    public Short getOrderDiscount() {
        return orderDiscount;
    }

    /**
     * 设置全本购买折扣
     *
     * @param orderDiscount 全本购买折扣
     */
    public void setOrderDiscount(Short orderDiscount) {
        this.orderDiscount = orderDiscount;
    }

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

    
}