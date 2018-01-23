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
    Event event5;
    Event event6;
    Event event7;
    Event event8;
    Event event9;
    Event event10;
    Event event11;

    public Randomizer(){
        rand = new Random();
        this.value = this.rand.nextInt(11) + 1;
    }

    public int roll(){
        this.value = this.rand.nextInt(11) + 1;
        return this.value;
    }

    public int getValue(){
        return this.value;
    }

    public Event pickEvent(Event nEvent1, Event nEvent2, Event nEvent3, Event nEvent4, Event nEvent5, Event nEvent6, Event nEvent7, Event nEvent8, Event nEvent9, Event nEvent10, Event nEvent11){
        event1 = nEvent1;
        event2 = nEvent2;
        event3 = nEvent3;
        event4 = nEvent4;
        event5 = nEvent5;
        event6 = nEvent6;
        event7 = nEvent7;
        event8 = nEvent8;
        event9 = nEvent9;
        event10 = nEvent10;
        event11 = nEvent11;
        roll();
        if(getValue() == 1){
            return event1;
        }else if(getValue() == 2){
            return event2;
        }else if(getValue() == 3){
            return event3;
        }else if(getValue() == 4){
            return event4;
        }else if(getValue() == 5){
            return event5;
        }else if(getValue() == 6){
            return event6;
        }else if(getValue() == 7){
            return event7;
        }else if(getValue() == 8){
            return event8;
        }else if(getValue() == 9){
            return event9;
        }else if(getValue() == 10){
            return event10;
        }else{
            return event11;
        }
    }
}
