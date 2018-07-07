package online.mquiz.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import online.mquiz.R;

public class CreateQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_quiz);
    }

    public void Question_1(View view)
    {
        Intent i = new Intent(CreateQuiz.this,Question_1.class);
        startActivity(i);
    }
}
