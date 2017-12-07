package com.example.lopez_labquiz2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView tvDisplayAuthor, tvDisplayQuote;
    Button btBack;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        tvDisplayAuthor = (TextView) findViewById(R.id.tvDisplayAuthor);
        tvDisplayQuote = (TextView) findViewById(R.id.tvDisplayQuote);
        btBack = (Button) findViewById(R.id.btBack);
        preferences = getSharedPreferences("pref", Context.MODE_WORLD_READABLE);

        String author = preferences.getString("author", "");
        String quote = preferences.getString("quote", "");

        tvDisplayAuthor.setText(author + " said");
        tvDisplayQuote.setText("''" + quote + "''");
    }

    public void GoBack (View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
