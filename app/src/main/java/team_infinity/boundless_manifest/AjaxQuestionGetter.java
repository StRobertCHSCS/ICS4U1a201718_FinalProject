package team_infinity.boundless_manifest;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
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
        InputStream inputS = null;
        String result = "";

        try
        {
            HttpURLConnection con = null;
            //create url
            URL url = new URL(GlobalAttributes.ServerFullUrl);
            //start connection
            con = (HttpURLConnection) url.openConnection();

            //define the specific meat for the request
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            Writer write = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
            String jsonStr = this.createJsonObjectToString(id);

            //write and flust the json to send it to server
            write.write(jsonStr);
            write.close();


        }
        catch(IOException ioe)
        {

        }

        return null;
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
            Log.e("json", "AjaxQuestionGetter.createJsonObject(): exception: " + e.getMessage());
        }

        return requestBody.toString();
    }
}
