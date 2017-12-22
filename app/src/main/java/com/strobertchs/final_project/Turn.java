package com.strobertchs.final_project;

public class Turn
{
    private static int turn = 0;
    private static int grade = 9;
    private Student student;
    private Event event;

    //Initializing Randomizer
    Randomizer random = new Randomizer();

    //Initalizing Event
    Event allNighter = new Event("all Nighter", -5, 30, -5, -30);
    Event doYourHomework = new Event("homework assignment", -5, -20, 25, -5);
    Event extraCurricular = new Event("extra curricular", -5, 15, 5, -5);
    Event partTimeJob = new Event("part time job", 30, 10, -15, -10);

    public Turn(Student nStudent){
        student = nStudent;
        event = random.pickEvent(allNighter, doYourHomework, extraCurricular, partTimeJob);
    }

    public void makeTurn(){
        for(int i = 0; i < 8; i ++){
            turn ++;
            if(turn >= 3 && turn <= 4){
                grade = 10;
            } else if(turn >= 5 && turn <= 6){
                grade = 11;
            } else if(turn > 6 && turn <= 8){
                grade = 12;
            }
            System.out.println("Turn " + turn + " | Grade "+ grade + " | Do you want to perform a/an " + (event.getEventName() + "?"));

            //Make it so that it requires user input
            student.setChoice(true);

            if(student.getChoice() == true){
                //Sets Student values
                student.setMoney(student.getMoney() + event.getMoneyAdder());
                student.setSocial(student.getSocial() + event.getSocialAdder());
                student.setGrades(student.getGrades() + event.getGradesAdder());
                student.setSleep(student.getSleep() + event.getSleepAdder());

                //Prints Student values
                System.out.println("Money: " + student.getMoney());
                System.out.println("Social: " + student.getSocial());
                System.out.println("Grades: " + student.getGrades());
                System.out.println("Sleep: " + student.getSleep() + "\n");

                event = random.pickEvent(allNighter, doYourHomework, extraCurricular, partTimeJob);
            } else {
                //Prints Student values
                System.out.println("Money: " + student.getMoney());
                System.out.println("Social: " + student.getSocial());
                System.out.println("Grades: " + student.getGrades());
                System.out.println("Sleep: " + student.getSleep() + "\n");
            }
        }
    }

    public Event getEvent(){
        return event;
    }
}