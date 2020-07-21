package com.example.study.bean;

/**
 * 表 user_info
 *
 * @author GhostKang
 * @date 2020-05-25 14:48:25
 */
public class UserInfo {
    /**
     *
     */
    private Integer id;
    /**
     * 用户编号
     */
    private Integer numId;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户头像
     */
    private String cover;
    /**
     * 特征码
     */
    private String feature;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setNumId(Integer numId) {
        this.numId = numId;
    }

    public Integer getNumId() {
        return numId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getCover() {
        return cover;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public String getFeature() {
        return feature;
    }

    @Override
    public String toString() {
        return "UserInfo{" +
                "id=" + id +
                "numId=" + numId +
                "name=" + name +
                "cover=" + cover +
                "feature=" + feature +
                "}";
    }
}
