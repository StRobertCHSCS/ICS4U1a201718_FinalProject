package team_infinity.boundless_manifest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class QuestionActivity extends AppCompatActivity
{
    TextView questionText;
    Button[] choices;
    int numChoices = 4;
    Question currentQuestion;
    int numQuestionAnswered;

    ArrayList buttonRandom = new ArrayList<Button>();

    int attribute1;
    int attribute2;
    int attribute3;
    int attribute4;

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

        Collections.shuffle(buttonRandom);

        //handlers
        for(int ct=0; ct<this.numChoices; ct++)
        {
            this.choices[ct].setOnClickListener(new OnChoiceClickListener(this, ct));
        }

        this.numQuestionAnswered = 0;
        this.attribute1 = 0;
        this.attribute2 = 0;
        this.attribute3 = 0;
        this.attribute4 = 0;
        fetchQuestion();
    }

    /**
     * method to fetch a question
     */
    private void fetchQuestion()
    {
        Question q = GlobalAttributes.questionGetter.getQuestion(0);
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
            //this.choices[ct].setText(q.getAnswers()[ct]);
            ((Button)buttonRandom.get(ct)).setText(q.getAnswers()[ct]);
        }
    }

    /**
     * called when a button for an answer is clicked
     * @param choice the choice(which button clicked)
     */
    public void answerClicked(int choice)
    {

    }
}
