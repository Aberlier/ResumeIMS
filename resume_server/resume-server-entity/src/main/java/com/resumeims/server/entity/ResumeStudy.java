package com.resumeims.server.entity;

import java.util.Date;

public class ResumeStudy {
    private Long id;

    private String title;

    private String titleSub;

    private String titleSubLite;

    private Date studyTimeStart;

    private Date studyTimeEnd;

    private Long createUser;

    private Long updateUser;

    private Date createTime;

    private Date updateTime;

    private String content;

    public ResumeStudy(Long id, String title, String titleSub, String titleSubLite, Date studyTimeStart, Date studyTimeEnd, Long createUser, Long updateUser, Date createTime, Date updateTime, String content) {
        this.id = id;
        this.title = title;
        this.titleSub = titleSub;
        this.titleSubLite = titleSubLite;
        this.studyTimeStart = studyTimeStart;
        this.studyTimeEnd = studyTimeEnd;
        this.createUser = createUser;
        this.updateUser = updateUser;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.content = content;
    }

    public ResumeStudy() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getTitleSub() {
        return titleSub;
    }

    public void setTitleSub(String titleSub) {
        this.titleSub = titleSub == null ? null : titleSub.trim();
    }

    public String getTitleSubLite() {
        return titleSubLite;
    }

    public void setTitleSubLite(String titleSubLite) {
        this.titleSubLite = titleSubLite == null ? null : titleSubLite.trim();
    }

    public Date getStudyTimeStart() {
        return studyTimeStart;
    }

    public void setStudyTimeStart(Date studyTimeStart) {
        this.studyTimeStart = studyTimeStart;
    }

    public Date getStudyTimeEnd() {
        return studyTimeEnd;
    }

    public void setStudyTimeEnd(Date studyTimeEnd) {
        this.studyTimeEnd = studyTimeEnd;
    }

    public Long getCreateUser() {
        return createUser;
    }

    public void setCreateUser(Long createUser) {
        this.createUser = createUser;
    }

    public Long getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(Long updateUser) {
        this.updateUser = updateUser;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}