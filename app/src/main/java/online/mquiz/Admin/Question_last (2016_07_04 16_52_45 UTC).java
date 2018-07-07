package online.mquiz.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import online.mquiz.R;


public class Question_last extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_last);
    }
    public void ReviewBegin(View view)
    {
        Intent i = new Intent(Question_last.this,ReviewBegin.class);
        startActivity(i);
    }

}
