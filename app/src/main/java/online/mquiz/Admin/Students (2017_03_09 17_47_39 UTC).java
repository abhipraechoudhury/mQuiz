package online.mquiz.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import online.mquiz.R;

public class Students extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
    }
    public void AddStudents(View view)
    {
        Intent i = new Intent(Students.this,AddStudent.class);
        startActivity(i);
    }
    public void ViewStudents(View view)
    {
        Intent i = new Intent(Students.this,ViewStudent.class);
        startActivity(i);
    }

}
