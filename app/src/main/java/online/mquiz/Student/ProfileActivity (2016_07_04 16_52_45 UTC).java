package online.mquiz.Student;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import online.mquiz.R;
import online.mquiz.model.ImageLoadTask;
import online.mquiz.model.Session;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        //To set the values
        fillDetails();
    }
    public void fillDetails(){
        TextView firstName = (TextView)findViewById(R.id.firstName);
        TextView lastName = (TextView)findViewById(R.id.lastName);
        TextView mobileNo = (TextView)findViewById(R.id.mobileNo);
        TextView emailId = (TextView)findViewById(R.id.emailId);
        TextView dob = (TextView)findViewById(R.id.dob);
        TextView id = (TextView)findViewById(R.id.id);
        ImageView profilePic = (ImageView)findViewById(R.id.profilePic);
        firstName.setText(firstName.getText().toString() + " : " +Session.user.firstName);
        lastName.setText(lastName.getText().toString() + " : " +Session.user.lastName);
        mobileNo.setText(mobileNo.getText().toString() + " : " +Session.user.phone);
        emailId.setText(emailId.getText().toString() + " : " +Session.user.email);
        dob.setText(dob.getText().toString() + " : " +Session.user.dob);
        id.setText(id.getText().toString() + " : " +Session.user.id);
        new ImageLoadTask("http://mquiz.online/"+Session.user.pic, profilePic).execute();
    }
    public void edit(View view){
        Intent intent = new Intent(this,EditProfileActivity.class);
        MediaPlayer mp = MediaPlayer.create(this, R.raw.click);
        mp.start();
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}
