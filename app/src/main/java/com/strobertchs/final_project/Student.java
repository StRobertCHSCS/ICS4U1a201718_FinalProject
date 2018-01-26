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

    /**
     * Creates a Student
     */
    public Student(){
    }

    /**
     * Returns the amount of events completed
     * @return currentEventNum
     */
    public int getCurrentEventNum() {
        return currentEventNum;
    }

    /**
     * Returns the current Money of the Student
     * @return money
     */
    public int getMoney(){
        return money;
    }

    /**
     * Returns the current Social of the Student
     * @return social
     */
    public int getSocial(){
        return social;
    }

    /**
     * Returns the current Grades of the Student
     * @return grades
     */
    public int getGrades(){
        return grades;
    }

    /**
     * Returns the current Sleep of the Student
     * @return sleep
     */
    public int getSleep(){
        return sleep;
    }

    /**
     * Returns the current win/lose status of the Student
     * @return winOrLose
     */
    public String getWinOrLose(){
        return winOrLose;
    }

    /**
     * When called, increases the amount of events completed so far
     */
    public void increaseCurrentEventNum() {
        currentEventNum ++;
    }

    /**
     * Sets the current event number of the Student
     * @param nCurrentEventNum The new current event number
     */
    public void setCurrentEventNum(int nCurrentEventNum){
        currentEventNum = nCurrentEventNum;
    }

    /**
     * Sets the Money value of the Student
     * @param nMoney
     */
    public void setMoney(int nMoney){
        money = nMoney;
    }

    /**
     * Sets the Social value of the Student
     * @param nSocial
     */
    public void setSocial(int nSocial){
        social = nSocial;
    }

    /**
     * Sets the Grades value of the Student
     * @param nGrades
     */
    public void setGrades(int nGrades){
        grades = nGrades;
    }

    /**
     * Sets the Sleep value of the Student
     * @param nSleep
     */
    public void setSleep(int nSleep){
        sleep = nSleep;
    }

    /**
     * Sets the winOrLose value of the Student
     * @param nWinOrLose
     */
    public void setWinOrLose(String nWinOrLose){
        winOrLose = nWinOrLose;
    }
}
