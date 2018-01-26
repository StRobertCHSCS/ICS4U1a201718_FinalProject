package com.strobertchs.final_project;

import java.util.Random;

public class Randomizer
{
    int value;
    private Random rand;
    private Event event1;
    private Event event2;
    private Event event3;
    private Event event4;
    private Event event5;
    private Event event6;
    private Event event7;
    private Event event8;
    private Event event9;
    private Event event10;
    private Event event11;
    private Event event12;
    private Event event13;
    private Event event14;
    private Event event15;
    private Event event16;
    private Event event17;
    private Event event18;
    private Event event19;
    private Event event20;
    private Event event21;

    /**
     * Creates the Randomizer and it's boundaries
     */
    public Randomizer(){
        rand = new Random();
        this.value = this.rand.nextInt(21) + 1;
    }

    /**
     * Generates a number and returns the value of the roll
     * @return the value of the roll
     */
    public int roll(){
        this.value = this.rand.nextInt(21) + 1;
        return this.value;
    }

    /**
     * Returns the value of the roll without rolling it again
     * @return the value of the roll
     */
    public int getValue(){
        return this.value;
    }

    /**
     * Creates a list of events that contains all the current Events
     * @param nEvent1 Event number 1
     * @param nEvent2 Event number 2
     * @param nEvent3 Event number 3
     * @param nEvent4 Event number 4
     * @param nEvent5 Event number 5
     * @param nEvent6 Event number 6
     * @param nEvent7 Event number 7
     * @param nEvent8 Event number 8
     * @param nEvent9 Event number 9
     * @param nEvent10 Event number 10
     * @param nEvent11 Event number 11
     * @param nEvent12 Event number 12
     * @param nEvent13 Event number 13
     * @param nEvent14 Event number 14
     * @param nEvent15 Event number 15
     * @param nEvent16 Event number 16
     * @param nEvent17 Event number 17
     * @param nEvent18 Event number 18
     * @param nEvent19 Event number 19
     * @param nEvent20 Event number 20
     * @param nEvent21 Event number 21
     * @return a event chosen randomly
     */
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
