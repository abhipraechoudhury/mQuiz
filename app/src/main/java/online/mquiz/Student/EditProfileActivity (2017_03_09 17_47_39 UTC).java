package online.mquiz.Student;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import online.mquiz.R;

public class EditProfileActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editprofile);
    }
    public void done(View view){
        Intent intent = new Intent(this,ProfileActivity.class);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent(this,ProfileActivity.class);
        startActivity(intent);
    }
}
