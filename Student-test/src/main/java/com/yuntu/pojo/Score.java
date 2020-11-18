package com.yuntu.pojo;

public class Score {
    private int sc_id;
    private int stu_id;
    private int sc_fen;

    public Score(int sc_id, int stu_id, int sc_fen) {
        this.sc_id = sc_id;
        this.stu_id = stu_id;
        this.sc_fen = sc_fen;
    }

    public Score() {
    }

    public Score(int stu_id, int sc_fen) {
        this.stu_id = stu_id;
        this.sc_fen = sc_fen;
    }

    public int getSc_id() {
        return sc_id;
    }

    public void setSc_id(int sc_id) {
        this.sc_id = sc_id;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public int getSc_fen() {
        return sc_fen;
    }

    public void setSc_fen(int sc_fen) {
        this.sc_fen = sc_fen;
    }
}
