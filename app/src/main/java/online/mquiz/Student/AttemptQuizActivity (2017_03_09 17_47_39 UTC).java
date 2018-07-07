package online.mquiz.Student;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import online.mquiz.R;
import online.mquiz.model.Session;

/**
 * Created by Abhiprae on 6/24/2016.
 */
public class AttemptQuizActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attemptquiz);
        TextView name = (TextView)findViewById(R.id.name);
        TextView description = (TextView)findViewById(R.id.description);
        TextView noq = (TextView)findViewById(R.id.noq);
        name.setText(Session.q.name);
        description.setText(Session.q.description);
        noq.setText(Session.q.noq+" questions");
    }
    public void proceed (View view){
        Intent intent = new Intent(this,AttemptQuestionActivity.class);
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
