package online.mquiz.Student;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import online.mquiz.R;
import online.mquiz.model.Question;
import online.mquiz.model.Quiz;
import online.mquiz.model.Session;
import online.mquiz.model.User;

/**
 * Created by Abhiprae on 6/27/2016.
 */
public class AttemptQuestionActivity extends AppCompatActivity{
    static int index=0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attemptquestion);
        showQuestion();
    }
    public void showQuestion(){
        TextView quesNo = (TextView)findViewById(R.id.quesNo);
        TextView subheading = (TextView)findViewById(R.id.subheading);
        TextView question = (TextView)findViewById(R.id.question);
        RadioButton optionA = (RadioButton)findViewById(R.id.optionA);
        RadioButton optionB = (RadioButton)findViewById(R.id.optionB);
        RadioButton optionC = (RadioButton)findViewById(R.id.optionC);
        RadioButton optionD = (RadioButton)findViewById(R.id.optionD);
        RadioButton optionE = (RadioButton)findViewById(R.id.optionE);
        quesNo.setText("Question "+(AttemptQuestionActivity.index+1)+" of "+Session.q.noq);
        question.setText(Session.ques[AttemptQuestionActivity.index].getQues());
        optionA.setText(Session.ques[AttemptQuestionActivity.index].getOptionA());
        optionB.setText(Session.ques[AttemptQuestionActivity.index].getOptionB());
        optionC.setText(Session.ques[AttemptQuestionActivity.index].getOptionC());
        optionD.setText(Session.ques[AttemptQuestionActivity.index].getOptionD());
        optionE.setText(Session.ques[AttemptQuestionActivity.index].getOptionE());
    }
    public void next(View view){
        RadioGroup options = (RadioGroup) findViewById(R.id.options);
        Session.ques[AttemptQuestionActivity.index].setUserAnswer(findViewById(options.getCheckedRadioButtonId()).getTag().toString());
        Session.ques[AttemptQuestionActivity.index].setQno((AttemptQuestionActivity.index+1));
        Toast.makeText(getBaseContext(),""+Session.ques[AttemptQuestionActivity.index].getUserAnswer(), Toast.LENGTH_LONG).show();
        Session.ques[AttemptQuestionActivity.index].setStudentId(Session.user.getId());
        if(AttemptQuestionActivity.index==((Session.q.noq)-1)){
            new HttpAsyncTask().execute("http://mquiz.online/m_answer.php");
            MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
            mp.start();
            AttemptQuestionActivity.index=0;
            return;
        }
        if(AttemptQuestionActivity.index==((Session.q.noq)-2)) {
            Button submit = (Button)findViewById(R.id.next);
            submit.setText("Submit");
            MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
            mp.start();
        }

        AttemptQuestionActivity.index++;
        showQuestion();
        MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
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

            //4. Prepare Json object
            Gson gson = new Gson();
            jsonData = gson.toJson(Session.ques,Question[].class);
            Log.d("Answer",jsonData);

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

        Log.d("Response",result);
        //Toast.makeText(getBaseContext(),""+result, Toast.LENGTH_LONG).show();
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
            //Toast.makeText(getBaseContext(),""+result, Toast.LENGTH_LONG).show();
            if(result.contains("fail")){
                Toast.makeText(getBaseContext(),"Try Again Jack! OOPS", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(AttemptQuestionActivity.this,AvailableQuizActivity.class);
                MediaPlayer mp = MediaPlayer.create(AttemptQuestionActivity.this, R.raw.click);
                mp.start();
                startActivity(intent);
            }
            if(result.contains("success")){
                Intent intent = new Intent(AttemptQuestionActivity.this,SubmitPageActivity.class);
                MediaPlayer mp = MediaPlayer.create(AttemptQuestionActivity.this, R.raw.click);
                mp.start();
                startActivity(intent);
            }
        }
    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent(this,SubmitPageActivity.class);
        startActivity(intent);
    }
}
