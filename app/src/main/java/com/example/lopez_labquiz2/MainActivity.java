package com.example.lopez_labquiz2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etAuthor, etQuote;
    Button btSave, btNext;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etAuthor = (EditText) findViewById(R.id.etAuthor);
        etQuote = (EditText) findViewById(R.id.etQuote);
        btSave = (Button) findViewById(R.id.btSave);
        btNext = (Button) findViewById(R.id.btNext);
        preferences = getSharedPreferences("pref", Context.MODE_WORLD_READABLE);
    }

    public void SaveData (View view) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("author", etAuthor.getText().toString());
        editor.putString("quote", etQuote.getText().toString());
        editor.commit();

        Toast.makeText(this, "Your quotation has been saved!", Toast.LENGTH_SHORT).show();
    }

    public void NextPage (View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        startActivity(intent);
    }
}
