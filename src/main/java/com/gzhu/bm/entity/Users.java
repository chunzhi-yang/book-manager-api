package com.gzhu.bm.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "users")
public class Users {
    /**
     * 主键
     */
    @Id
    @Column(name = "users_id")
    private Long usersId;

    /**
     * 唯一标识
     */
    private String uid;

    /**
     * 用户名
     */
    @Column(name = "user_name")
    private String userName;

    /**
     * 密码
     */
    @Column(name = "user_password")
    private String userPassword;

    /**
     * 性别0男1女
     */
    private Byte sex;

    /**
     * 生日
     */
    private Date birth;

    /**
     * 位置
     */
    private String location;

    /**
     * 一句话描述
     */
    private String description;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 头像路径
     */
    @Column(name = "img_path")
    private String imgPath;

    /**
	 * 手机号
	 */
	@Column(name = "mobile")
	private String mobile;

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	/**
	 * 获取主键
	 *
	 * @return users_id - 主键
	 */
    public Long getUsersId() {
        return usersId;
    }

    /**
     * 设置主键
     *
     * @param usersId 主键
     */
    public void setUsersId(Long usersId) {
        this.usersId = usersId;
    }

    /**
     * 获取唯一标识
     *
     * @return uid - 唯一标识
     */
    public String getUid() {
        return uid;
    }

    /**
     * 设置唯一标识
     *
     * @param uid 唯一标识
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * 获取用户名
     *
     * @return user_name - 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置用户名
     *
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * 获取密码
     *
     * @return user_password - 密码
     */
    public String getUserPassword() {
        return userPassword;
    }

    /**
     * 设置密码
     *
     * @param userPassword 密码
     */
    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    /**
     * 获取性别0男1女
     *
     * @return sex - 性别0男1女
     */
    public Byte getSex() {
        return sex;
    }

    /**
     * 设置性别0男1女
     *
     * @param sex 性别0男1女
     */
    public void setSex(Byte sex) {
        this.sex = sex;
    }

    /**
     * 获取生日
     *
     * @return birth - 生日
     */
    public Date getBirth() {
        return birth;
    }

    /**
     * 设置生日
     *
     * @param birth 生日
     */
    public void setBirth(Date birth) {
        this.birth = birth;
    }

    /**
     * 获取位置
     *
     * @return location - 位置
     */
    public String getLocation() {
        return location;
    }

    /**
     * 设置位置
     *
     * @param location 位置
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * 获取一句话描述
     *
     * @return description - 一句话描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * 设置一句话描述
     *
     * @param description 一句话描述
     */
    public void setDescription(String description) {
        this.description = description;
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

   
    public String getImgPath() {
        return imgPath;
    }

     
    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }
}