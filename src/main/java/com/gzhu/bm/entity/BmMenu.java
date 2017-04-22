package com.gzhu.bm.entity;

import javax.persistence.*;

@Table(name = "bm_menu")
public class BmMenu {
    /**
     * 主键
     */
    @Id
    @Column(name = "bm_menu_id")
    private Long bmMenuId;

    /**
     * 角色编码
     */
    @Column(name = "menu_code")
    private String menuCode;

    /**
     * url
     */
    private String url;

    /**
     * 逻辑url，angular
     */
    @Column(name = "logistic_url")
    private String logisticUrl;

    /**
     * 启用状态0启用1禁用
     */
    private Byte status;

    /**
     * 菜单名称
     */
    @Column(name = "menu_name")
    private String menuName;

    /**
     * 权限控制
     */
    @Column(name = "is_under_control")
    private Byte isUnderControl;

    /**
     * 类型0菜单1功能
     */
    @Column(name = "menu_type")
    private Byte menuType;

    /**
     * 获取主键
     *
     * @return bm_menu_id - 主键
     */
    public Long getBmMenuId() {
        return bmMenuId;
    }

    /**
     * 设置主键
     *
     * @param bmMenuId 主键
     */
    public void setBmMenuId(Long bmMenuId) {
        this.bmMenuId = bmMenuId;
    }

    /**
     * 获取角色编码
     *
     * @return menu_code - 角色编码
     */
    public String getMenuCode() {
        return menuCode;
    }

    /**
     * 设置角色编码
     *
     * @param menuCode 角色编码
     */
    public void setMenuCode(String menuCode) {
        this.menuCode = menuCode;
    }

    /**
     * 获取url
     *
     * @return url - url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置url
     *
     * @param url url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * 获取逻辑url，angular
     *
     * @return logistic_url - 逻辑url，angular
     */
    public String getLogisticUrl() {
        return logisticUrl;
    }

    /**
     * 设置逻辑url，angular
     *
     * @param logisticUrl 逻辑url，angular
     */
    public void setLogisticUrl(String logisticUrl) {
        this.logisticUrl = logisticUrl;
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

    /**
     * 获取菜单名称
     *
     * @return menu_name - 菜单名称
     */
    public String getMenuName() {
        return menuName;
    }

    /**
     * 设置菜单名称
     *
     * @param menuName 菜单名称
     */
    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    /**
     * 获取权限控制
     *
     * @return is_under_control - 权限控制
     */
    public Byte getIsUnderControl() {
        return isUnderControl;
    }

    /**
     * 设置权限控制
     *
     * @param isUnderControl 权限控制
     */
    public void setIsUnderControl(Byte isUnderControl) {
        this.isUnderControl = isUnderControl;
    }

    /**
     * 获取类型0菜单1功能
     *
     * @return menu_type - 类型0菜单1功能
     */
    public Byte getMenuType() {
        return menuType;
    }

    /**
     * 设置类型0菜单1功能
     *
     * @param menuType 类型0菜单1功能
     */
    public void setMenuType(Byte menuType) {
        this.menuType = menuType;
    }
}