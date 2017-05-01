package com.gzhu.bm.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "book_shelf")
public class BookShelf {
    /**
     * 主键ID
     */
    @Id
    @Column(name = "book_shelf_id")
    private Long bookShelfId;

    /**
     * 图书ID
     */
    @Column(name = "books_id")
    private Long booksId;

    /**
     * 用户ID
     */
    @Column(name = "uid")
    private String uid;

    /**
     * 阅读进度
     */
    @Column(name = "read_process")
    private BigDecimal readProcess;

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
     * 获取主键ID
     *
     * @return book_shelf_id - 主键ID
     */
    public Long getBookShelfId() {
        return bookShelfId;
    }

    /**
     * 设置主键ID
     *
     * @param bookShelfId 主键ID
     */
    public void setBookShelfId(Long bookShelfId) {
        this.bookShelfId = bookShelfId;
    }

    /**
     * 获取图书ID
     *
     * @return books_id - 图书ID
     */
    public Long getBooksId() {
        return booksId;
    }

    /**
     * 设置图书ID
     *
     * @param booksId 图书ID
     */
    public void setBooksId(Long booksId) {
        this.booksId = booksId;
    }

    

    public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	/**
     * 获取阅读进度
     *
     * @return read_process - 阅读进度
     */
    public BigDecimal getReadProcess() {
        return readProcess;
    }

    /**
     * 设置阅读进度
     *
     * @param readProcess 阅读进度
     */
    public void setReadProcess(BigDecimal readProcess) {
        this.readProcess = readProcess;
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
}