package com.example.checkbox;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxInt, checkBoxDouble, checkBoxString, checkBoxAll;
    private Button buttonResult, buttonSuggest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkBoxInt = findViewById(R.id.checkBoxInt);
        checkBoxDouble = findViewById(R.id.checkBoxDouble);
        checkBoxString = findViewById(R.id.checkBoxString);
        checkBoxAll = findViewById(R.id.checkBoxAll);
        buttonResult = findViewById(R.id.buttonResult);
        buttonSuggest = findViewById(R.id.buttonSuggest);

        buttonResult.setOnClickListener(v -> checkResult());
        buttonSuggest.setOnClickListener(v -> showSuggestion());
    }

    private void checkResult() {
        if (checkBoxString.isChecked() && !checkBoxInt.isChecked() && !checkBoxDouble.isChecked() && !checkBoxAll.isChecked()) {
            Toast.makeText(this, "Chính xác!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Chưa chính xác, hãy thử lại!", Toast.LENGTH_SHORT).show();
        }
    }

    private void showSuggestion() {
        Toast.makeText(this, "Đáp án là (String).", Toast.LENGTH_LONG).show();
    }
}