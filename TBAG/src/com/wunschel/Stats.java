package com.wunschel;

public class Stats {
    private int hp;
    private int mp;
    private int str;

    public Stats(int hp, int mp, int str) {
        this.hp = hp;
        this.mp = mp;
        this.str = str;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        this.mp = mp;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }
}
