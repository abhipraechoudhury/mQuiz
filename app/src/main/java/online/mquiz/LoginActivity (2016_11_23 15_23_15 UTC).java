package online.mquiz;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
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

import online.mquiz.Admin.AdminHomeActivity;
import online.mquiz.Student.MainActivity;
import online.mquiz.model.Session;
import online.mquiz.model.User;

/**
 * Created by Abhiprae on 6/23/2016.
 */
public class LoginActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        }
    public void login(View view){
        //1. Validate the form, check if not blank
        //2. Check for network
        //3. Read data from login form and prepare the user object.
        ProgressBar pb = (ProgressBar)findViewById(R.id.progress);
        pb.setVisibility(View.VISIBLE);
        if(!isConnected()) {
            Toast.makeText(getBaseContext(), "No network found!", Toast.LENGTH_LONG).show();
            return;
        }
        //Means Network is available
        new HttpAsyncTask().execute("http://mquiz.online/m_login.php");
        MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
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
            //3. Create data Object
            EditText email = (EditText)findViewById(R.id.email);
            EditText password = (EditText)findViewById(R.id.password);
            User user = new User();
            user.setEmail(email.getText().toString());
            user.setPassword(password.getText().toString());

            //4. Prepare Json object
            Gson gson = new Gson();
            jsonData = gson.toJson(user,User.class);
            Log.d("Login",jsonData);

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
            Gson gson = new Gson();
            User u; //check for null
            try {
                u = gson.fromJson(result,User.class);
                Log.d("type",u.type);
                if(u.type.equals("student")){
                    Session.user = u;
                    Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    startActivity(intent);
                    Toast.makeText(getBaseContext(), "Login Successful!", Toast.LENGTH_LONG).show();
                }
                else if(u.type.equals("admin")){
                    Session.user = u;
                    Intent intent = new Intent(LoginActivity.this,AdminHomeActivity.class);
                    startActivity(intent);
                    Toast.makeText(getBaseContext(), "Login Successful!", Toast.LENGTH_LONG).show();
                }
                else{
                    Toast.makeText(getBaseContext(), "Invalid Username or Password!", Toast.LENGTH_LONG).show();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            ProgressBar pb = (ProgressBar)findViewById(R.id.progress);
            pb.setVisibility(View.INVISIBLE);
        }
    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}