package com.teicm.ChatAround.app.chataroundandroid.chataround;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONObject;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Hrystos on 09-Nov-15.
 */
public class LoginActivity extends Activity {

    private Button btn_login;
    private EditText txt_username;
    User user = new User();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_screen);

        btn_login = (Button) findViewById(R.id.btn_login);
        txt_username = (EditText) findViewById(R.id.txt_username);




        btn_login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                if (txt_username.getText().toString().trim().length() > 0) {

                    String username = txt_username.getText().toString().trim();
                    user.setUsername(username);


                } else {
                    Toast.makeText(getApplicationContext(),
                            "Please enter your name", Toast.LENGTH_LONG).show();
                }



                // needs url
                new HttpAsyncTask().execute("");
            }

        });

    }


    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            return POST(urls[0],user);
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getBaseContext(), "Data Sent!", Toast.LENGTH_LONG).show();
        }
    }

    public static String POST(String targetUrl, User user){

        String result = "";

        HttpURLConnection connection = null;
        try {



            //Create connection
            URL url = new URL(targetUrl);
            connection = (HttpURLConnection)url.openConnection();
            connection.setRequestMethod("POST");
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestProperty("Accept", "application/json");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.connect();



            String json = "";

            // Build jsonObject
            JSONObject jsonObject = new JSONObject();
            jsonObject.accumulate("name", user.getUsername());

            json = jsonObject.toString();


            // send json
            OutputStream os = new BufferedOutputStream(connection.getOutputStream());
            os.write(json.getBytes());
            os.flush();
            os.close();

            // get response
            InputStream is = connection.getInputStream();
            result = convertInputStreamToString(is);
            is.close();




        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }




    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null)
            result += line;

        inputStream.close();
        return result;

    }

}
