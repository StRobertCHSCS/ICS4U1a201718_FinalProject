package team_infinity.boundless_manifest;

/**
 * Created by Acer on 2018-01-08.
 * class to model a question
 */

public class Question
{
    String question;
    String[] answers;

    int correctAnswer;

    long id;

    public Question(String q, String[] a, long i, int c)
    {
        this.question = q;
        this.answers = a;
        this.id = i;
        this.correctAnswer = c;
    }

    //getters
    public String getQuestion(){return this.question;}
    public String[] getAnswers(){return this.answers;}
    public long getId(){return this.id;}
    public int getCorrectAnswer(){return this.correctAnswer;}
}
