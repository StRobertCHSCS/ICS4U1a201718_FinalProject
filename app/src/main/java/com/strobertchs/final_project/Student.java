package com.strobertchs.final_project;

public class Student
{
    //Starting values
    private int money = 50;
    private int social = 50;
    private int grades = 50;
    private int sleep = 50;
    private String winOrLose = "neutral";
    private int currentEventNum = 0;

    public Student(){
    }

    public int getCurrentEventNum() {
        return currentEventNum;
    }

    public int getMoney(){
        return money;
    }

    public int getSocial(){
        return social;
    }

    public int getGrades(){
        return grades;
    }

    public int getSleep(){
        return sleep;
    }

    public String getWinOrLose(){
        return winOrLose;
    }

    public void increaseCurrentEventNum() {
        currentEventNum ++;
    }

    public void setCurrentEventNum(int nCurrentEventNum){
        currentEventNum = nCurrentEventNum;
    }

    public void setMoney(int nMoney){
        money = nMoney;
    }

    public void setSocial(int nSocial){
        social = nSocial;
    }

    public void setGrades(int nGrades){
        grades = nGrades;
    }

    public void setSleep(int nSleep){
        sleep = nSleep;
    }

    public void setWinOrLose(String nWinOrLose){
        winOrLose = nWinOrLose;
    }
}
