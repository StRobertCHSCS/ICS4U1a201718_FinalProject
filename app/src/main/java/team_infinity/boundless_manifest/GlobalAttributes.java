package team_infinity.boundless_manifest;

import android.content.Intent;
import android.media.Image;
import android.util.Log;
import android.view.View;

import java.util.HashMap;

/**
 * Created by Acer on 2017-12-22.
 */

public class GlobalAttributes
{
    //the dimensions of character buttons
    public static int ChooseCharacterButtonHeight = 40;
    public static int ChooseCharacterButtonWidth = 40;
    public static int knowledgeAtt = 0;
    public static int thinkingAtt = 0;
    public static int understandingAtt = 0;
    public static int numQuestionAnswered;

    //this url is temporary, 10.0.2.2 let emulator access the mother system(my laptop)'s localhost ip
    public static final String ServerFullUrl = "http://10.0.2.2:8080/BM_server/";

    //the question getter in use
    public static QuestionGetterBase questionGetter = new QuestionGetterMock();
    public static QuestionGetterBase questionGetter2 = new AjaxQuestionGetter();

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

        final String namme = na;

        eventHandle = new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                //set the current selected hero's index number
                GameController.getInstance().setCurrentSelectedHero(serialNum);

                Log.d("tag", "GlobalAttributes.Character.Character(): " + namme + " listener called");
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