package team_infinity.boundless_manifest;

import android.content.Intent;
import android.media.Image;
import android.view.View;

import java.util.HashMap;

/**
 * Created by Acer on 2017-12-22.
 */

public class GlobalAttributes
{
    //the map for all characters
    public static CharacterMap characters;

    static
    {
        characters = new CharacterMap();

        //Paulline
        characters.add(new Character(1, "Paulline", "chemistry", R.drawable.game_alchemist3));
    }
}

//class for a character
class Character
{
    int serialNum;
    String name;
    String questionSubject;
    int characterSprite;
    View.OnClickListener eventHandle;

    public Character(int n, String na, String sub, int spr)
    {
        this.serialNum = n;
        this.name = na;
        this.questionSubject = sub;
        this.characterSprite = spr;

        eventHandle = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //set the current selected hero's index number
                GameController.getInstance().setCurrentSelectedHero(serialNum);
            }
        };
    }
}

//class for
class CharacterMap extends HashMap<Integer, Character>
{
    /**
     * add the character into the map
     * @param c the character to be added
     */
    public void add(Character c) {this.put(c.serialNum, c);}

    /**
     * getter for a character
     * @param i the serial number
     * @return the character
     */
    public Character get(Integer i){return super.get(i);}
}