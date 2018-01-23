package com.strobertchs.final_project;

public class Student
{
    private int money;
    private int social;
    private int grades;
    private int sleep;
    private String winOrLose = "neutral";
    private int currentEventNum = 0;

    //0 = 9ner 1 = 12er 2 = Mr.Servidio
    private int difficulty;

    public Student(int nDifficulty){
        difficulty = nDifficulty;

        if(difficulty == 0){
            money = 75;
            social = 75;
            grades = 75;
            sleep = 75;
        } else if(difficulty == 1){
            money = 50;
            social = 50;
            grades = 50;
            sleep = 50;
        } else if(difficulty == 2){
            money = 25;
            social = 25;
            grades = 25;
            sleep = 25;
        }
    }

    //Getters
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
    //Setters
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
