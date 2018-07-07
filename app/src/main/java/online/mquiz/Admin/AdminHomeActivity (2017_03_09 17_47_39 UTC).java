package online.mquiz.Admin;

import android.app.Activity;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import online.mquiz.LoginActivity;
import online.mquiz.model.*;
import online.mquiz.R;

public class AdminHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_admin);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

    }
    public void ViewStudent(View view)
    {
        Intent i = new Intent(AdminHomeActivity.this,Students.class);
        startActivity(i);
    }
    public void Quiz(View view)
    {
        if(!isConnected()) {
            Log.d("LoginActivity", " No Connectivity found !!");
            return;
        }
//        Toast.makeText(getBaseContext(), "Network Available", Toast.LENGTH_LONG).show();
//        //Means Network is available
        new HttpAsyncTask().execute("http://mquiz.online/m_quiz.php");

    }

    /**
     * It returns true if network connectivity is available.
     * @return
     */
    public boolean isConnected(){
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            return false;
    }

    public String POST(String url){

        InputStream inputStream = null;
        String result = "";
        String jsonData="";
        try {
            // 1. create HttpClient
            HttpClient httpclient = new DefaultHttpClient();
            // 2. make POST request to the given URL
            HttpPost httpPost = new HttpPost(url);


            //4. Prepare Json object
            Gson gson = new Gson();
            jsonData = gson.toJson(Session.user,User.class);


            // 5. set json to StringEntity
            StringEntity se = new StringEntity(jsonData);

            // 6. set httpPost Entity
            httpPost.setEntity(se);

            // 7. Set some headers to inform server about the type of the content
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");

            // 8. Execute POST request to the given URL
            HttpResponse httpResponse = httpclient.execute(httpPost);

            // 9. receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // 10. convert inputstream to string
            if(inputStream != null)
                result = convertInputStreamToString(inputStream);
            else
                result = "Did not work!";

        }catch (Exception e){
            e.printStackTrace();
        }

        Log.d("Result",result);
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

    private class HttpAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls)
        {
            return POST(urls[0]);
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            Gson gson=new Gson();
            Quizp q[];
            try{
                q=gson.fromJson(result,Quizp[].class);
                Session.quiz=q;
                int l=q.length;
                Toast.makeText(getBaseContext(), "length"+l, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AdminHomeActivity.this,QuizAdmin.class);
                startActivity(intent);
            }
            catch (Exception e)
            {}
//            Toast.makeText(getBaseContext(), "Data Sent!", Toast.LENGTH_LONG).show();

            }
            //IF Condition
//            Toast.makeText(getBaseContext(), result, Toast.LENGTH_LONG).show();
//            if(result.toLowerCase().contains("welcome"))
//            {
//                Intent intent = new Intent(LoginActivity.this,MainActivity.class);
//                startActivity(intent);
//            }



        }
    public void Logout(View view)
    {
       Session.user=null;
        Session.quiz=null;
        Toast.makeText(getBaseContext(), "You have been Logged out Successfully !!", Toast.LENGTH_LONG).show();

        Intent intent = new Intent(AdminHomeActivity.this,LoginActivity.class);
           startActivity(intent);

    }
    }
