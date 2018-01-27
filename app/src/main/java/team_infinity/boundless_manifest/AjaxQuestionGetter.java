package team_infinity.boundless_manifest;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Acer on 2018-01-24.
 */

public class AjaxQuestionGetter implements QuestionGetterBase
{
    /**
     * getting a question by sending a JSON Ajax request
     * @return a question
     */
    @Override
    public Question getQuestion(long id)
    {
        String request = this.createJsonObjectToString(id);

        //create an AsyncTask and execute it
        JSONAsyncTask jsonAsyncTask = new JSONAsyncTask();
        jsonAsyncTask.execute(request, "qestn");

        //infinite loop to check if progress done
        while(true)
        {
            /*
            note:
            this is definitly not de right waey to use AsyncTask
            but since AsyncTask.onPostExecute() is sent to and called
            directly in the GUI dispatcher thread,
            and I want to do something else with the result,
            so I do it the very stupid way
            (could have used a Thread Runnable lol)
                                                    -Kevin
             */
            String prog = jsonAsyncTask.getProgress();
            if(prog == "done")
            {
                break;
            }
            else if (prog == "error")
            {
                Log.e("json", "AjaxQuestionGetter.getQuestion(): error occured");
                return null;
            }

            try
            {
                Thread.sleep(10);
            }
            catch (InterruptedException ie)
            {
                Log.d("json", "AjaxQuestionGetter.getQuestion(): thread sleep interrupted");
            }
        }

        //get the string and print to debug log
        String res = jsonAsyncTask.getResulte();
        Log.d("json", "AjaxQuestionGetter.getQuestion(): result string: " +  res);

        Question result = this.convert(res);

        return result;
    }

    /**
     * method for creating a JSONObject object
     * @param id the id of the session
     * @return the json object
     */
    public String createJsonObjectToString(long id)
    {
        JSONObject requestBody = new JSONObject();

        try
        {
            //only id matters
            requestBody.accumulate("subject", "");
            requestBody.accumulate("level", 0);
            requestBody.accumulate("sessionId", id);
        }
        catch(org.json.JSONException e)//handle exception
        {
            Log.e("json", "AjaxQuestionGetter.createJsonObjectToString(): exception: " + e.getMessage());
        }

        return requestBody.toString();
    }

    /**
     * convert the output to Question object
     * @param s the String returned from request
     * @return the Question object
     */
    public Question convert(String s)
    {
        Question result = null;

        try
        {
            JSONObject resul = new JSONObject(s);
            JSONObject qstn = resul.getJSONObject("question");

            //get the content of the question from JSON
            String questionTitle = qstn.getString("question");

            //get the answers from answers array
            JSONArray answersJson = qstn.getJSONArray("answers");
            String[] answers = new String[4];
            for(int ct=0; ct<4; ct++)
            {
                answers[ct] = answersJson.getString(ct);
            }
            //id and correct answer
            int correctAnswer = qstn.getInt("correctAnswer");
            long id = qstn.getLong("id");

            //put them all together into one object
            result = new Question(questionTitle, answers, id, correctAnswer);
        }
        catch(JSONException jsone)
        {
            Log.e("json", "AjaxQuestionGetter.convert() JSONException: " + jsone.getLocalizedMessage());
        }

        return result;
    }
}
