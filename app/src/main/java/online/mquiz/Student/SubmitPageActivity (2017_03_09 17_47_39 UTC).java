package online.mquiz.Student;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import online.mquiz.R;
import online.mquiz.model.Session;

/**
 * Created by Abhiprae on 6/27/2016.
 */
public class SubmitPageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submitpage);
        WebView result = (WebView)findViewById(R.id.result);
        result.setWebChromeClient(new WebChromeClient());
        result.clearCache(true);
        result.clearHistory();
        result.getSettings().setJavaScriptEnabled(true);
        result.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        result.loadUrl("http://mquiz.online/m_quizResult.php?qid="+ Session.q.getQuizId()+"&userId="+Session.user.getId()+"&noq="+Session.q.noq);
        Log.d("webUrl","http://mquiz.online/m_quizResult.php?qid="+ Session.q.getQuizId()+"&userId="+Session.user.getId()+"&noq="+Session.q.noq);
    }
    public void finish(View view){
        Intent intent = new Intent(this,AvailableQuizActivity.class);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent(this,AvailableQuizActivity.class);
        startActivity(intent);
    }
}
