package com.aviabu.arknoid;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
<<<<<<< HEAD
import android.util.Log;

public class MainActivity extends Activity {

    private GameView game_view;
=======

public class MainActivity extends Activity {

>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
<<<<<<< HEAD
        game_view = (GameView) findViewById(R.id.gameViewID);
        start();
    }

    public void start()
    {
        Log.d("ddd","ttttttttt");
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                game_view.animationLoop();
            }
        });
        thread.start();
        game_view.setEnabled(false);
=======
>>>>>>> 83510fd19ae6984ae8ab280b958b2878c58df2f5
    }
}
