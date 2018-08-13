package com.howtochange.springboot.pojo;

import java.util.Date;
import java.util.Objects;

public class Links {
    private Integer pk;

    private String name;

    private String type;

    private String link;

    private String code;

    private Integer userPk;

    private String aboutLink;

    private Date createTime;

    private Date updateTime;

    private User user;

    public Integer getPk() {
        return pk;
    }

    public void setPk(Integer pk) {
        this.pk = pk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link == null ? null : link.trim();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public Integer getUserPk() {
        return userPk;
    }

    public void setUserPk(Integer userPk) {
        this.userPk = userPk;
    }

    public String getAboutLink() {
        return aboutLink;
    }

    public void setAboutLink(String aboutLink) {
        this.aboutLink = aboutLink == null ? null : aboutLink.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Links links = (Links) o;
        return Objects.equals(pk, links.pk);
    }

    @Override
    public int hashCode() {

        return Objects.hash(pk);
    }
}