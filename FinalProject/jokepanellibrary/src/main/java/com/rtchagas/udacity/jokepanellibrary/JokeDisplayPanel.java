package com.rtchagas.udacity.jokepanellibrary;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

public class JokeDisplayPanel extends AppCompatActivity {

    public static final String EXTRA_JOKE = "extra_joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_display_panel);

        String joke = getIntent().getStringExtra(EXTRA_JOKE);

        if (!TextUtils.isEmpty(joke)) {
            TextView tvJokeContent = findViewById(R.id.tv_joke_content);
            tvJokeContent.setText(joke);
        }
        else {
            // Sorry, I can just display a joke...
            finish();
        }
    }
}
