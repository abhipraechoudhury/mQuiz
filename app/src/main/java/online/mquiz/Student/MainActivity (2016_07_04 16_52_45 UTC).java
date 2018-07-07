package online.mquiz.Student;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import online.mquiz.LoginActivity;
import online.mquiz.R;
import online.mquiz.model.Question;
import online.mquiz.model.Session;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void profile(View view){
        Intent intent = new Intent(this,ProfileActivity.class);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
        startActivity(intent);
    }
    public void quiz(View view){
        Intent intent = new Intent(this,QuizActivity.class);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
        startActivity(intent);
    }
    public void logout(View view){
        MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
        Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
    }
}
