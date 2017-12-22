package com.strobertchs.final_project;

public class Event
{
    private int moneyAdder;
    private int socialAdder;
    private int gradesAdder;
    private int sleepAdder;
    private static int eventNum = 0;
    private int eventID;
    private String eventName;

    public Event(String theEventName, int nMoney, int nSocial, int nGrades, int nSleep){
        eventNum ++;
        eventID = eventNum;
        eventName = theEventName;

        moneyAdder = nMoney;
        socialAdder = nSocial;
        gradesAdder = nGrades;
        sleepAdder = nSleep;
    }

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

    public String getEventName(){
        return eventName;
    }
}
