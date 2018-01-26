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
    Event event12;
    Event event13;
    Event event14;
    Event event15;
    Event event16;
    Event event17;
    Event event18;
    Event event19;
    Event event20;
    Event event21;

    public Randomizer(){
        rand = new Random();
        this.value = this.rand.nextInt(21) + 1;
    }

    public int roll(){
        this.value = this.rand.nextInt(21) + 1;
        return this.value;
    }

    public int getValue(){
        return this.value;
    }

    public Event pickEvent(Event nEvent1, Event nEvent2, Event nEvent3, Event nEvent4, Event nEvent5, Event nEvent6, Event nEvent7, Event nEvent8, Event nEvent9, Event nEvent10, Event nEvent11, Event nEvent12, Event nEvent13, Event nEvent14, Event nEvent15, Event nEvent16, Event nEvent17, Event nEvent18, Event nEvent19, Event nEvent20, Event nEvent21){
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
        event12 = nEvent12;
        event13 = nEvent13;
        event14 = nEvent14;
        event15 = nEvent15;
        event16 = nEvent16;
        event17 = nEvent17;
        event18 = nEvent18;
        event19 = nEvent19;
        event20 = nEvent20;
        event21 = nEvent21;


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
        }else if(getValue() == 11){
            return event11;
        }else if(getValue() == 12){
            return event12;
        }else if(getValue() == 13){
            return event13;
        }else if(getValue() == 14){
            return event14;
        }else if(getValue() == 15){
            return event15;
        }else if(getValue() == 16){
            return event16;
        }else if(getValue() == 17){
            return event17;
        }else if(getValue() == 18){
            return event18;
        }else if(getValue() == 19){
            return event19;
        }else if(getValue() == 20){
            return event20;
        }else{
            return event21;
        }
    }
}
