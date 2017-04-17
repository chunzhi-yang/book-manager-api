package com.gzhu.bm.entity;

import java.util.Date;
import javax.persistence.*;

@Table(name = "bm_role")
public class BmRole {
    /**
     * 主键
     */
    @Id
    @Column(name = "bm_role_id")
    private Long bmRoleId;

    /**
     * 角色编码
     */
    @Column(name = "role_code")
    private String roleCode;

    /**
     * 角色名称
     */
    @Column(name = "role_name")
    private String roleName;

    /**
     * 创建时间
     */
    @Column(name = "created_time")
    private Date createdTime;

    /**
     * 启用状态0启用1禁用
     */
    private Byte status;

    /**
     * 获取主键
     *
     * @return bm_role_id - 主键
     */
    public Long getBmRoleId() {
        return bmRoleId;
    }

    /**
     * 设置主键
     *
     * @param bmRoleId 主键
     */
    public void setBmRoleId(Long bmRoleId) {
        this.bmRoleId = bmRoleId;
    }

    /**
     * 获取角色编码
     *
     * @return role_code - 角色编码
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * 设置角色编码
     *
     * @param roleCode 角色编码
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode;
    }

    /**
     * 获取角色名称
     *
     * @return role_name - 角色名称
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * 设置角色名称
     *
     * @param roleName 角色名称
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName;
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
     * 获取启用状态0启用1禁用
     *
     * @return status - 启用状态0启用1禁用
     */
    public Byte getStatus() {
        return status;
    }

    /**
     * 设置启用状态0启用1禁用
     *
     * @param status 启用状态0启用1禁用
     */
    public void setStatus(Byte status) {
        this.status = status;
    }
}