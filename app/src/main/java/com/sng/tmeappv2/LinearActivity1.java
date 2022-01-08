package com.sng.tmeappv2;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class LinearActivity1 extends AppCompatActivity {
    public static final String EXTRA_MESSAGE =  "com.sng.tmeappv2.MESSAGE";
    String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());
    String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear1);
    }

    public void showDate(View view) {
        TextView displayDate=(TextView)findViewById(R.id.timeText);
        displayDate.setText(currentDate + System.getProperty("line.separator") + currentTime);
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, LinearActivity2.class);
        EditText editText = (EditText) findViewById(R.id.sendTextBox);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
}