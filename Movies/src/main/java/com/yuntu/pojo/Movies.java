package com.yuntu.pojo;

import java.util.Date;

public class Movies {
    private int m_id;
    private String m_title;
    private double m_score;
    private String m_content;
    private Date m_release;

    public Movies() {
    }

    public int getM_id() {
        return m_id;
    }

    public void setM_id(int m_id) {
        this.m_id = m_id;
    }

    public String getM_title() {
        return m_title;
    }

    public void setM_title(String m_title) {
        this.m_title = m_title;
    }

    public double getM_score() {
        return m_score;
    }

    public void setM_score(double m_score) {
        this.m_score = m_score;
    }

    public String getM_content() {
        return m_content;
    }

    public void setM_content(String m_content) {
        this.m_content = m_content;
    }

    public Date getM_release() {
        return m_release;
    }

    public void setM_release(Date m_release) {
        this.m_release = m_release;
    }

    public Movies(String m_title, double m_score, String m_content, Date m_release) {
        this.m_title = m_title;
        this.m_score = m_score;
        this.m_content = m_content;
        this.m_release = m_release;
    }

    public Movies(int m_id, String m_title, double m_score, String m_content, Date m_release) {
        this.m_id = m_id;
        this.m_title = m_title;
        this.m_score = m_score;
        this.m_content = m_content;
        this.m_release = m_release;
    }
}
