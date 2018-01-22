package team_infinity.boundless_manifest;

/**
 * Created by Acer on 2018-01-08.
 * class to model a question
 */

public class Question
{
    String question;
    String[] answers;


    long id;

    public Question(String q, String[] a, long i)
    {
        this.question = q;
        this.answers = a;
        this.id = i;
    }

    //getters
    public String getQuestion(){return this.question;}
    public String[] getAnswers(){return this.answers;}
    public long getId(){return this.id;}
}
