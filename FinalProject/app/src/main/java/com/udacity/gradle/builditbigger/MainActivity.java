package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.rtchagas.udacity.jokepanellibrary.JokeDisplayPanel;


public class MainActivity extends AppCompatActivity implements OnJokeRetrieveListener {

    private ProgressBar mPbJoke = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // As the fragment is in the layout we can do that.
        mPbJoke = findViewById(R.id.pb_joke);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onJokeRetrieved(String joke) {

        // Show the progress bar
        mPbJoke.setVisibility(View.INVISIBLE);

        if (!TextUtils.isEmpty(joke)) {
            Intent showJokeIntent = new Intent(this, JokeDisplayPanel.class);
            showJokeIntent.putExtra(JokeDisplayPanel.EXTRA_JOKE, joke);
            startActivity(showJokeIntent);
        }
        else {
            Toast.makeText(this, R.string.joke_retrieve_error, Toast.LENGTH_SHORT).show();
        }
    }

    public void tellJoke(View view) {

        // Show the progress bar
        mPbJoke.setVisibility(View.VISIBLE);

        JokeRetrieveTask task = new JokeRetrieveTask(this);
        task.execute();
    }
}
