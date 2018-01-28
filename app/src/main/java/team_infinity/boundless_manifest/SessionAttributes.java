package team_infinity.boundless_manifest;

/**
 * Created by Acer on 2018-01-27.
 */

public class SessionAttributes
{
    int thinking = 0;
    int knowledge = 0;
    int understanding = 0;

    public SessionAttributes(){}

    //add the attribute to the list
    public void addAttributeScore(String attri)
    {
        if(attri == "thinking")
        {
            thinking++;
        }
        else if(attri == "knowledge")
        {
            knowledge++;
        }
        else if(attri == "understanding")
        {
            understanding++;
        }
    }
}
