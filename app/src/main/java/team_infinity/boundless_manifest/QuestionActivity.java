package team_infinity.boundless_manifest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionActivity extends AppCompatActivity
{
    TextView questionText;
    Button[] choices;
    int numChoices = 4;
    Question currentQuestion;
    int currentScore = 0;
    int numQuestionAnswered = 0;
    //should be 5, but changed to 2 for testing purposes
    final int numTotalQuestions = 2;
    ArrayList buttonRandom = new ArrayList<Button>();
    ProgressBar questProgress;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        //setup the widget objects
        this.questionText = findViewById(R.id.Question);
        this.choices = new Button[4];

        this.choices[0] = findViewById(R.id.Choice1);
        this.choices[1] = findViewById(R.id.Choice2);
        this.choices[2] = findViewById(R.id.Choice3);
        this.choices[3] = findViewById(R.id.Choice4);

        buttonRandom.add(this.choices[0]);
        buttonRandom.add(this.choices[1]);
        buttonRandom.add(this.choices[2]);
        buttonRandom.add(this.choices[3]);

        //Collections.shuffle(buttonRandom);

        //handlers
        for(int ct=0; ct<this.numChoices; ct++)
        {
            this.choices[ct].setOnClickListener(new OnChoiceClickListener(this, ct));
        }

        questProgress = (ProgressBar)findViewById(R.id.questProgress);
        questProgress.setMax(0);
        fetchQuestion();
    }

    /**
     * method to fetch a question
     */
    private void fetchQuestion()
    {
        //fetch question from server
        Question q = GlobalAttributes.questionGetter2.getQuestion(GlobalAttributes.currentSessionId);
        this.currentQuestion = q;
        this.showQuestion(q);
    }

    /**
     * method for showing a question after fetching it
     * @param q the question to be shown
     */
    private void showQuestion(Question q)
    {
        //question text
        this.questionText.setText(q.getQuestion());
        //answer choices
        for(int ct=0; ct<this.numChoices; ct++)
        {
            this.choices[ct].setText(q.getAnswers()[ct]);
            //((Button)buttonRandom.get(ct)).setText(q.getAnswers()[ct]);
        }
    }

    /**
     * called when a button for an answer is clicked
     * @param choice the choice(which button clicked)
     */
    public void answerClicked(int choice)
    {
        Log.d("qst", "QuestionActivity.answerClicked(): called, numQuestionAnswered: " + numQuestionAnswered);
        numQuestionAnswered++;
        questProgress.setProgress(numQuestionAnswered);

        //if answer is right
        if(choice == this.currentQuestion.getCorrectAnswer())
        {
            this.currentScore++;
        }

        //if session is done
        if(numQuestionAnswered >= numTotalQuestions)
        {
            this.sessionFinish();
        }
        else
        {
            this.fetchQuestion();
        }
    }

    /**
     * method for finishing a session
     * when the number of answered question reaches number of total question
     */
    public void sessionFinish()
    {
        GlobalAttributes.currentScore = this.currentScore;

        //end this question activity and start the result screen
        Intent intent = new Intent(this, FinishActivity.class);
        this.finish();
        startActivity(intent);
    }
}
