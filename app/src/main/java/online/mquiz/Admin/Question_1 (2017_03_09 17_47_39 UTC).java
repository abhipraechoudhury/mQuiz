package online.mquiz.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import online.mquiz.R;


public class Question_1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_1);
    }
    public void Question_last(View view)
    {
        Intent i = new Intent(Question_1.this,Question_last.class);
        startActivity(i);
    }

}
