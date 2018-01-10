package com.strobertchs.final_project;

public class Event
{
    //Adder variables
    private int moneyAdder;
    private int socialAdder;
    private int gradesAdder;
    private int sleepAdder;

    //Reducer Variables
    private int moneyReducer;
    private int socialReducer;
    private int gradesReducer;
    private int sleepReducer;

    private String eventName;

    public Event(String theEventName, int aMoney, int aSocial, int aGrades, int aSleep, int rMoney, int rSocial, int rGrades, int rSleep){
        eventName = theEventName;

        moneyAdder = aMoney;
        socialAdder = aSocial;
        gradesAdder = aGrades;
        sleepAdder = aSleep;

        moneyReducer = rMoney;
        socialReducer = rSocial;
        gradesReducer = rGrades;
        sleepReducer = rSleep;
    }

    public String getEventName(){
        return eventName;
    }

    //Adder Getters
    public int getMoneyAdder(){
        return moneyAdder;
    }

    public int getSocialAdder(){
        return socialAdder;
    }

    public int getGradesAdder(){
        return gradesAdder;
    }

    public int getSleepAdder(){
        return sleepAdder;
    }


    //Reducer Getters
    public int getMoneyReducer() {
        return moneyReducer;
    }

    public int getSocialReducer() {
        return socialReducer;
    }

    public int getGradesReducer() {
        return gradesReducer;
    }

    public int getSleepReducer() {
        return sleepReducer;
    }
}
