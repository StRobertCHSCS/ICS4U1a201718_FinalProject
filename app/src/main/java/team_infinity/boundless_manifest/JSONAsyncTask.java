package team_infinity.boundless_manifest;

import android.os.AsyncTask;
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
 * this is for testing and trying,
 * not yet in use
 */

public class JSONAsyncTask extends AsyncTask<String, String, String>
{
    private String progress = "";
    private String resulte;

    /**
     * feeding a long as id and use it to fetch question from server
     * @param cont the id
     * @return result JSON object as string
     */
    @Override
    protected String doInBackground(String... cont)
    {
        Log.d("qst", "JSONAsyncTask.doInBackground(): called");
        this.changeProgress("started");

        //the response body (which is a JSON is a String form)
        String requestBody = cont[0];
        //the url extension (the part after the slash)
        String urlExtension = cont[1];
        String urlString = GlobalAttributes.ServerFullUrl + urlExtension;

        try
        {
            HttpURLConnection con = null;
            //create url
            URL url = new URL(urlString);
            //start connection
            con = (HttpURLConnection) url.openConnection();

            //define the specific meat for the request
            con.setDoOutput(true);
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");

            Writer write = new BufferedWriter(new OutputStreamWriter(con.getOutputStream()));
            //String jsonStr = this.createJsonObjectToString(id);

            //write and flust the json to send it to server
            write.write(requestBody);
            write.close();

            this.changeProgress("request sent");

            //get inputstream from socket(url connection) and create reader
            InputStream inputStream = con.getInputStream();
            BufferedReader read = new BufferedReader(new InputStreamReader(inputStream));

            //temporary strings
            StringBuffer buffer = new StringBuffer();
            String inputLine;

            //read result line by line
            while((inputLine = read.readLine()) != null)
            {
                buffer.append(inputLine + "\n");
            }

            this.changeProgress("response received");

            //put result into a string
            String jsonResponse = buffer.toString();

            //create a JSONObject from String
            //JSONObject resultJson = new JSONObject(jsonResponse);

            this.resulte = jsonResponse;
            this.changeProgress("done");
            return jsonResponse;
        }
        catch(IOException ioe)
        {
            Log.e("io", "JSONAsyncTask.doInBackground(): IOException: " + ioe.getLocalizedMessage());
            this.changeProgress("error");
        }
        /*
        catch(JSONException jsone)
        {
            Log.e("json", "JSONAsyncTask.doInBackground(): JSONException: " + jsone.getLocalizedMessage());
        }
        */

        return null;
    }

    /**
     * getter for the current progress
     * @return the progress message as a String
     */
    public synchronized String getProgress(){return this.progress;}

    /**
     * getter for result
     * @return result string
     */
    public synchronized String getResulte(){return this.resulte;}

    private synchronized void changeProgress(String s){this.progress = s;}
}
