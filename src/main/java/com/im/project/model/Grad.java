package com.im.project.model;

public class Grad {
    private Integer id;
    private String name;
    private String pictureId;
    private String jianjie;
    private String xibie;
    private String grade;
    private String zhiwu;
    private String whereabout;
    private Picture picture;
    private String daoshi;

    public Grad CompareTo(Grad g) {
        this.name = this.name != g.name ? this.name : null;
        this.xibie = this.xibie != g.xibie ? this.xibie : null;
        this.jianjie = this.jianjie != g.jianjie ? this.jianjie : null;
        this.grade = this.grade != g.grade ? this.grade : null;
        this.zhiwu = this.zhiwu != g.zhiwu ? this.zhiwu : null;
        this.whereabout = this.whereabout != g.whereabout ? this.whereabout : null;
        return this;
    }

    public String getGrade() {
        return grade;
    }

    public String getDaoshi() {
        return daoshi;
    }

    public void setDaoshi(String daoshi) {
        this.daoshi = daoshi;
    }

    public Integer getId() {
        return id;
    }

    public String getJianjie() {
        return jianjie;
    }

    public void setJianjie(String jianjie) {
        this.jianjie = jianjie;
    }

    public void setPicture(Picture picture) {
        this.picture = picture;
    }

    public String getName() {
        return name;
    }

    public String getWhereabout() {
        return whereabout;
    }

    public String getXibie() {
        return xibie;
    }

    public String getZhiwu() {
        return zhiwu;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPictureId() {
        return pictureId;
    }

    public void setPictureId(String pictureId) {
        this.pictureId = pictureId;
    }

    public Picture getPicture() {
        return picture;
    }

    public void setWhereabout(String whereabout) {
        this.whereabout = whereabout;
    }

    public void setXibie(String xibie) {
        this.xibie = xibie;
    }

    public void setZhiwu(String zhiwu) {
        this.zhiwu = zhiwu;
    }

}
