package com.example.androidlab1;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class EnterGreetingActivity extends Activity {
    private static final int START_ENTER_NAME_ACTIVITY = 1;
    private TextView greetingTextView;
    private EditText greetingEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_activity);
        greetingTextView = findViewById(R.id.greetingTextView);
        greetingEditText = findViewById(R.id.greetingEditText);

    }

    public void goToNextWindow(View v) {
        Intent intent = new Intent(EnterGreetingActivity.this, EnterNameActivity.class);
        intent.putExtra("GREETING", greetingEditText.getText().toString());
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case (START_ENTER_NAME_ACTIVITY):
                if (resultCode == 1 && data != null) {
                    String greeting = data.getStringExtra("GREETING");
                    String name = data.getStringExtra("NAME");
                    greetingTextView.setText(concatGreetingAndName(greeting, name));
                }
                break;
        }
    }

    private String concatGreetingAndName(String greeting, String name) {
        return greeting + " " + name + "!";
    }
}