package com.jack.myrxtest.bean;

/**
 * Created by JackCheung on 2016/10/25.
 */

public class NewsBean {

    /**
     * id : 495126
     * Content : 0
     * title : 在里约 英语竟没它好使：国人惊呆
     * postdate : 2016/8/11 7:03:08
     * editor : 万南
     * icon : http://img1.mydrivers.com/img/20160811/759d3d8e01ff493f9f3d77f4112100c2.jpg
     * desc : 出门在外，懂门外语是多么重要，这是每一个到国际赛场采访的记者的一大感受。那么在里约呢？在奥运会场馆区，你只要懂英语就可以
     * reviewcount : 86
     * stress :
     * isdel : False
     * ispass : True
     */

    private int id;
    private String Content;
    private String title;
    private String postdate;
    private String editor;
    private String icon;
    private String desc;
    private int reviewcount;
    private String stress;
    private String isdel;
    private String ispass;

    public NewsBean(String title, String icon, String desc, String editor){
        this.title=title;
        this.icon=icon;
        this.desc=desc;
        this.editor=editor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String Content) {
        this.Content = Content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPostdate() {
        return postdate;
    }

    public void setPostdate(String postdate) {
        this.postdate = postdate;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getReviewcount() {
        return reviewcount;
    }

    public void setReviewcount(int reviewcount) {
        this.reviewcount = reviewcount;
    }

    public String getStress() {
        return stress;
    }

    public void setStress(String stress) {
        this.stress = stress;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }

    public String getIspass() {
        return ispass;
    }

    public void setIspass(String ispass) {
        this.ispass = ispass;
    }
}
