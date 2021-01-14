package com.sas.sasystem.entities;

import javax.persistence.*;

@Entity
public class Expert extends User{
    @Column
    private int score;

    public Expert() {
        super();
        this.isExpert = true;
    }

    public Expert(String userName) {
        super();
        this.isExpert = true;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(int grade) {
        this.score += grade;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
