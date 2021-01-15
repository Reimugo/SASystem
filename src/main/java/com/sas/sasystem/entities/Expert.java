package com.sas.sasystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "EXPERT")
public class Expert extends User{
    @Column
    private int score;

    public Expert() {
        super();
        this.isExpert = true;
    }

    public Expert(String userName) {
        super(userName);
        this.isExpert = true;
        this.score = 0;
    }

    public int getScore() {
        return score;
    }

    public void updateScore(Grade oldGrade, Grade newGrade) {
        this.score += newGrade.getNum();
        this.score -= oldGrade.getNum();
    }

    public void updateScore(Grade grade) {
        this.score += grade.getNum();
    }

    public void setScore(int score) {
        this.score = score;
    }
}
