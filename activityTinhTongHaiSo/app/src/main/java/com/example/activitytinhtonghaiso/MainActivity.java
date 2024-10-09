package com.example.activitytinhtonghaiso;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etSo1, etSo2;
    private Button btnCong, btnTru, btnNhan, btnChia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ các thành phần giao diện
        etSo1 = findViewById(R.id.etSo1);
        etSo2 = findViewById(R.id.etSo2);
        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);

        // Thiết lập sự kiện cho các nút
        btnCong.setOnClickListener(v -> tinhToan("+"));
        btnTru.setOnClickListener(v -> tinhToan("-"));
        btnNhan.setOnClickListener(v -> tinhToan("*"));
        btnChia.setOnClickListener(v -> tinhToan("/"));
    }

    private void tinhToan(String phepToan) {
        String strSo1 = etSo1.getText().toString();
        String strSo2 = etSo2.getText().toString();

        // Kiểm tra xem người dùng đã nhập đủ hai số chưa
        if (strSo1.isEmpty() || strSo2.isEmpty()) {
            Toast.makeText(this, "Vui lòng nhập đủ hai số", Toast.LENGTH_SHORT).show();
            return;
        }

        double so1 = Double.parseDouble(strSo1);
        double so2 = Double.parseDouble(strSo2);
        double ketQua = 0;

        // Thực hiện phép toán dựa trên phép toán đã chọn
        switch (phepToan) {
            case "+":
                ketQua = so1 + so2;
                break;
            case "-":
                ketQua = so1 - so2;
                break;
            case "*":
                ketQua = so1 * so2;
                break;
            case "/":
                if (so2 == 0) {
                    Toast.makeText(this, "Không thể chia cho 0", Toast.LENGTH_SHORT).show();
                    return;
                }
                ketQua = so1 / so2;
                break;
        }

        // Gửi dữ liệu đến ketQua Activity
        Intent intent = new Intent(MainActivity.this, ketQua.class);
        intent.putExtra("KET_QUA", ketQua);
        intent.putExtra("PHEP_TOAN", phepToan);
        intent.putExtra("SO1", so1); // Gửi số thứ nhất
        intent.putExtra("SO2", so2); // Gửi số thứ hai
        startActivity(intent);
    }
}