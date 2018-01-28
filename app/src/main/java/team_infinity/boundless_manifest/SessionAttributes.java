package team_infinity.boundless_manifest;

import android.util.Log;

/**
 * Created by Acer on 2018-01-27.
 */

public class SessionAttributes
{
    int thinking = 0;
    int knowledge = 0;
    int understanding = 0;
    int thinkingCorrect = 0;
    int knowledgeCorrect = 0;
    int understandingCorrect = 0;

    public SessionAttributes(){}

    //add the attribute to the list
    public void addAttributeScore(String attri, boolean correct)
    {
        Log.d("qst", "SesssionAttributes.addAttributeScore(): called: attribute: " + attri);

        if(attri == "thinking")
        {
            thinking++;
            if(correct)
            {
                thinkingCorrect++;
            }
        }
        else if(attri == "knowledge")
        {
            knowledge++;
            if(correct)
            {
                knowledgeCorrect++;
            }
        }
        else if(attri == "understanding")
        {
            understanding++;
            if(correct)
            {
                understandingCorrect++;
            }
        }
    }

    //getters
    public int getThinking(){return this.thinking;}
    public int getKnowledge(){return this.knowledge;}
    public int getUnderstanding(){return this.understanding;}

    public int getThinkingCorrect(){return thinkingCorrect;}
    public int getKnowledgeCorrect(){return knowledgeCorrect;}
    public int getUnderstandingCorrect(){return understandingCorrect;}
}
