package com.strobertchs.final_project;

import java.util.Random;

public class Randomizer
{
    int value;
    Random rand;
    Event event1;
    Event event2;
    Event event3;
    Event event4;

    public Randomizer(){
        rand = new Random();
        this.value = this.rand.nextInt(4) + 1;
    }

    public int roll(){
        this.value = this.rand.nextInt(4) + 1;
        return this.value;
    }

    public int getValue(){
        return this.value;
    }

    public Event pickEvent(Event nEvent1, Event nEvent2, Event nEvent3, Event nEvent4){
        event1 = nEvent1;
        event2 = nEvent2;
        event3 = nEvent3;
        event4 = nEvent4;
        roll();
        if(getValue() == 1){
            return event1;
        }else if(getValue() == 2){
            return event2;
        }else if(getValue() == 3){
            return event3;
        }else {
            return event4;
        }
    }
}
