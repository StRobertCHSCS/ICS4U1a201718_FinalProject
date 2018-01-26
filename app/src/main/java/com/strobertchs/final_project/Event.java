package com.strobertchs.final_project;

public class Event
{
    private String eventMessage;

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

    /**
     * Sets the effects of an Event when the "No" or "Yes" button is pressed
     * @param theEventMessage The description of the Event
     * @param aMoney Money applied when "Yes" is pressed
     * @param aSocial Social applied when "Yes" is pressed
     * @param aGrades Grades applied when "Yes" is pressed
     * @param aSleep Sleep applied when "Yes" is pressed
     * @param rMoney Money applied when "No" is pressed
     * @param rSocial Social applied when "No" is pressed
     * @param rGrades Grades applied when "No" is pressed
     * @param rSleep Sleep applied when "No" is pressed
     */
    public Event(String theEventMessage, int aMoney, int aSocial, int aGrades, int aSleep, int rMoney, int rSocial, int rGrades, int rSleep){
        eventMessage = theEventMessage;

        moneyAdder = aMoney;
        socialAdder = aSocial;
        gradesAdder = aGrades;
        sleepAdder = aSleep;

        moneyReducer = rMoney;
        socialReducer = rSocial;
        gradesReducer = rGrades;
        sleepReducer = rSleep;
    }

    public String getEventMessage(){
        return eventMessage;
    }

    /**
     * Returns the moneyAdder
     * @return moneyAdder
     */
    public int getMoneyAdder(){
        return moneyAdder;
    }

    /**
     * Returns the socialAdder
     * @return socialAdder
     */
    public int getSocialAdder(){
        return socialAdder;
    }

    /**
     * Returns the gradesAdder
     * @return gradesAdder
     */
    public int getGradesAdder(){
        return gradesAdder;
    }

    /**
     * Returns the sleepAdder
     * @return sleepAdder
     */
    public int getSleepAdder(){
        return sleepAdder;
    }

    /**
     * Returns the moneyReducer
     * @return moneyReducer
     */
    public int getMoneyReducer() {
        return moneyReducer;
    }

    /**
     * Returns the socialReducer
     * @return socialReducer
     */
    public int getSocialReducer() {
        return socialReducer;
    }

    /**
     * Returns the gradesReducer
     * @return gradesReducer
     */
    public int getGradesReducer() {
        return gradesReducer;
    }

    /**
     * Returns the sleepReducer
     * @return sleepReducer
     */
    public int getSleepReducer() {
        return sleepReducer;
    }
}
