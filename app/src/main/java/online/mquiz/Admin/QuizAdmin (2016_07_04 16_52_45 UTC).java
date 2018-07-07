package online.mquiz.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;


import online.mquiz.R;

public class QuizAdmin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_admin);
    }
    public void CreateQuiz(View view)
    {
        Intent i = new Intent(QuizAdmin.this,CreateQuiz.class);
        startActivity(i);
    }
    public void ReviewBegin(View view)
    {
        Intent i = new Intent(QuizAdmin.this,ReviewBegin.class);
        startActivity(i);
    }


}
