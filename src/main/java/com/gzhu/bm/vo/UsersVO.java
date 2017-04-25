package com.gzhu.bm.vo;

import java.util.Date;
import java.util.List;
 
public class UsersVO implements java.io.Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private Long usersId;
    private String uid;
    private String userName;
    private String userPassword;
    private Byte sex;
    private Date birth;
    private String location;
    private String description;
    private Date createdTime;
    private Long imgsId;
    
    private List<String> menus;
    private List<String> roles;
    
    @Override
	public String toString() {
		return "UsersVO [usersId=" + usersId + ", uid=" + uid + ", userName=" + userName + ", userPassword="
				+ userPassword + ", sex=" + sex + ", birth=" + birth + ", location=" + location + ", description="
				+ description + ", createdTime=" + createdTime + ", imgsId=" + imgsId + "]";
	}

	public List<String> getMenus() {
		return menus;
	}

	public void setMenus(List<String> menus) {
		this.menus = menus;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

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

    /**
     * 获取头像img_id
     *
     * @return imgs_id - 头像img_id
     */
    public Long getImgsId() {
        return imgsId;
    }

    /**
     * 设置头像img_id
     *
     * @param imgsId 头像img_id
     */
    public void setImgsId(Long imgsId) {
        this.imgsId = imgsId;
    }
}