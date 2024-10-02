package com.example.trasua;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private CheckBox checkBoxKemBo, checkBoxKemSauRieng, checkBoxKemDau;
    private RadioButton radioButtonS, radioButtonM, radioButtonL;
    private EditText editTextKemChon, editTextKichCo;
    private Button buttonThem, buttonXoa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        checkBoxKemBo = findViewById(R.id.checkBoxKemBo);
        checkBoxKemSauRieng = findViewById(R.id.checkBoxKemSauRieng);
        checkBoxKemDau = findViewById(R.id.checkBoxKemDau);

        radioButtonS = findViewById(R.id.radioButtonS);
        radioButtonM = findViewById(R.id.radioButtonM);
        radioButtonL = findViewById(R.id.radioButtonL);

        editTextKemChon = findViewById(R.id.editTextKemChon);
        editTextKichCo = findViewById(R.id.editTextKichCo);

        buttonThem = findViewById(R.id.buttonThem);
        buttonXoa = findViewById(R.id.buttonXoa);

        // Set click listeners for radio buttons
        radioButtonS.setOnClickListener(this::onRadioButtonClicked);
        radioButtonM.setOnClickListener(this::onRadioButtonClicked);
        radioButtonL.setOnClickListener(this::onRadioButtonClicked);

        // Set click listeners for buttons
        buttonThem.setOnClickListener(this::onButtonThemClicked);
        buttonXoa.setOnClickListener(this::onButtonXoaClicked);
    }

    private void onRadioButtonClicked(View view) {
        // Ensure only one radio button is checked at a time
        radioButtonS.setChecked(view == radioButtonS);
        radioButtonM.setChecked(view == radioButtonM);
        radioButtonL.setChecked(view == radioButtonL);

        // Update the size in editTextKichCo
        if (radioButtonS.isChecked()) {
            editTextKichCo.setText("S");
        } else if (radioButtonM.isChecked()) {
            editTextKichCo.setText("M");
        } else if (radioButtonL.isChecked()) {
            editTextKichCo.setText("L");
        }
    }

    private void onButtonThemClicked(View view) {
        if (!isIceCreamSelected() || !isSizeSelected()) {
            showErrorMessage("Vui lòng chọn ít nhất một loại kem và một kích cỡ");
            return;
        }

        StringBuilder selectedIceCreams = new StringBuilder();

        if (checkBoxKemBo.isChecked()) {
            selectedIceCreams.append("Kem bơ, ");
        }
        if (checkBoxKemSauRieng.isChecked()) {
            selectedIceCreams.append("Kem sầu riêng, ");
        }
        if (checkBoxKemDau.isChecked()) {
            selectedIceCreams.append("Kem dâu, ");
        }

        // Remove the last comma and space if any ice creams were selected
        if (selectedIceCreams.length() > 0) {
            selectedIceCreams.setLength(selectedIceCreams.length() - 2);
        }

        editTextKemChon.setText(selectedIceCreams.toString());
    }

    private void onButtonXoaClicked(View view) {
        // Clear all selections
        checkBoxKemBo.setChecked(false);
        checkBoxKemSauRieng.setChecked(false);
        checkBoxKemDau.setChecked(false);

        radioButtonS.setChecked(false);
        radioButtonM.setChecked(false);
        radioButtonL.setChecked(false);

        editTextKemChon.setText("");
        editTextKichCo.setText("");
    }

    private boolean isIceCreamSelected() {
        return checkBoxKemBo.isChecked() || checkBoxKemSauRieng.isChecked() || checkBoxKemDau.isChecked();
    }

    private boolean isSizeSelected() {
        return radioButtonS.isChecked() || radioButtonM.isChecked() || radioButtonL.isChecked();
    }

    private void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}