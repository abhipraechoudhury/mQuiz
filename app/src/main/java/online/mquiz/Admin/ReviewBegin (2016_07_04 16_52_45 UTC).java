package online.mquiz.Admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import online.mquiz.R;


public class ReviewBegin extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_review_begin);
    }
    public void Review_1(View view)
    {
        Intent i = new Intent(ReviewBegin.this,Review_1.class);
        startActivity(i);
    }

}
