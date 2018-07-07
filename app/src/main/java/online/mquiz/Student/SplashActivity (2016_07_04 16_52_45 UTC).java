package online.mquiz.Student;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ProgressBar;

import online.mquiz.LoginActivity;
import online.mquiz.R;

/**
 * Created by Abhiprae on 6/27/2016.
 */
public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ProgressBar pb = (ProgressBar)findViewById(R.id.progress);
        pb.setVisibility(ProgressBar.VISIBLE);
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
    }
}
