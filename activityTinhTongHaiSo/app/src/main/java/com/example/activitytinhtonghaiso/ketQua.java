package com.example.activitytinhtonghaiso;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ketQua extends AppCompatActivity {
    private TextView tvKetQua;
    private TextView Sothu1;
    private TextView Sothu2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ket_qua);

        // Ánh xạ các TextView
        Sothu1 = findViewById(R.id.Sothu1);
        Sothu2 = findViewById(R.id.Sothu2);
        tvKetQua = findViewById(R.id.tvKetQua);

        // Nhận dữ liệu từ Intent
        Intent intent = getIntent();
        double ketQua = intent.getDoubleExtra("KET_QUA", 0);
        String phepToan = intent.getStringExtra("PHEP_TOAN");
        double so1 = intent.getDoubleExtra("SO1", 0);
        double so2 = intent.getDoubleExtra("SO2", 0);

        // Cập nhật giao diện
        Sothu1.setText("Số Thứ 1: " + so1);
        Sothu2.setText("Số Thứ 2: " + so2);
        tvKetQua.setText("Kết quả " + phepToan + ": " + ketQua);
    }
}