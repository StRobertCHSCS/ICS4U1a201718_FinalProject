package team_infinity.boundless_manifest;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Acer on 2018-01-26.
 */

public class QuestStartRequest
{
    public long startRequest(String subject)
    {
        Log.d("qst", "QuestStartRequest.startRequest(): called");
        //create the request json string
        String request = this.createJsonObjectToString(subject);

        //create an AsyncTask and execute it
        JSONAsyncTask jsonAsyncTask = new JSONAsyncTask();
        jsonAsyncTask.execute(request, "start");

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
                return 0;
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

        //get result from thread
        String res = jsonAsyncTask.getResulte();
        Log.d("json", "QuestStartRequest.startRequest(): result string: " +  res);

        long r = convert(res);

        return r;
    }

    /**
     * creates a request json object
     * @param subj the subject
     * @return json object as a string
     */
    public String createJsonObjectToString(String subj)
    {
        String res = null;
        try
        {
            JSONObject request = new JSONObject();
            request.accumulate("subject", subj);

            res = request.toString();
        }
        catch(JSONException jsone)
        {
            Log.e("json", "QuestStartRequest.createJsonObjectToString(): exception: " + jsone.getMessage());
        }

        return res;
    }

    /**
     * converts a response json to long
     * @param j result json as string
     * @return the id returned
     */
    public long convert(String j)
    {
        long result = 0;
        try
        {
            //put the respond into a json object
            JSONObject resul = new JSONObject(j);

            //get long from the json tags
            result = resul.getLong("sessionId");
        }
        catch(JSONException jsone)
        {
            Log.e("json", "QuestStartRequest.convert(): JSONException: " + jsone.getLocalizedMessage());
        }
        Log.d("json" , "");

        return result;
    }
}
