package online.mquiz;


import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class WebViewTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        Log.d("tag","onCreate");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("tag","onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("tag","onPause");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("tag","onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("tag","onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("tag","onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("tag","onStop");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("tag","onSaveInstanceState");
    }

}
