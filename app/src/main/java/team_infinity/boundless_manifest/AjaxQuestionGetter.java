package team_infinity.boundless_manifest;

import android.util.Log;

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
        //create an AsyncTask and execute it
        JSONAsyncTask jsonAsyncTask = new JSONAsyncTask();
        jsonAsyncTask.execute(id);

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

        return null;
    }
}
