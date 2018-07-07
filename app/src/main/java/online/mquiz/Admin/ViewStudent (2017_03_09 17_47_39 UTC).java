package online.mquiz.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import online.mquiz.R;
import online.mquiz.Student.ViewProfile;

public class ViewStudent extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);


    }
    public void ViewProfile(View view)
    {
        Intent i = new Intent(ViewStudent.this,ViewProfile.class);
        startActivity(i);
    }
    public void ViewProgress(View view)
    {
        Intent i = new Intent(ViewStudent.this,ViewProgress.class);
        startActivity(i);
    }

}
