package com.example.androidlab1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class EnterNameActivity extends Activity {
    private EditText enterNameEditText;
    private Button enterNameButton;
    private String greeting;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        enterNameEditText = findViewById( R.id.enterNameEditText);
        enterNameButton = findViewById( R.id.enterNameButton);
        Intent callerIntent = getIntent();
        greeting = callerIntent.getStringExtra("GREETING");

        enterNameButton.setOnClickListener(v -> {
            Intent intent = new Intent(EnterNameActivity.this, EnterGreetingActivity.class);
            intent.putExtra("GREETING", greeting);
            intent.putExtra("NAME", enterNameEditText.getText().toString());
            setResult(1, intent);
            finish();
        });

    }
}
