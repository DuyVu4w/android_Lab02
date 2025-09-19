package com.example.appbai1lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.text.TextUtils;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText etUsername;
    private EditText etPassword;

    private final String userEmpty = "Empty username!";
    private final String passEmpty = "Empty password!";
    private final String errorPass = "Mật khẩu không đúng yêu cầu";
    private final String signInSuccess = "Đăng nhập thành công";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        TextView tvResetPass = findViewById(R.id.tvResetPass);
        Button btnSignIn = findViewById(R.id.btnSignIn);
        btnSignIn.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (TextUtils.isEmpty(username)) {
                Toast.makeText(MainActivity.this, userEmpty,Toast.LENGTH_SHORT).show();
                return;
            }

            if (TextUtils.isEmpty(password)){
                Toast.makeText(MainActivity.this, passEmpty, Toast.LENGTH_SHORT).show();
                return;
            }

            if (!isValidPassword(password)){
                Toast.makeText(MainActivity.this, errorPass, Toast.LENGTH_SHORT).show();
                return;
            }

            if (username.equals("admin") && password.equals("Admin1234")) {
                Toast.makeText(MainActivity.this, signInSuccess, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(MainActivity.this, "Sai tên đăng nhập hoặc mật khẩu", Toast.LENGTH_SHORT).show();
            }
        });

        tvResetPass.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();

            if (TextUtils.isEmpty(username)) {
                Toast.makeText(MainActivity.this, userEmpty,Toast.LENGTH_SHORT).show();
                return;
            }

            if (username.equals("admin")){
                Toast.makeText(MainActivity.this, "Reset mật khẩu thành công", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private static boolean isValidPassword(String pass){
        if (pass == null) return false;
        if (pass.length() < 6) return false;

        boolean hasUpper = false;
        boolean hasLower = false;

        for (int i = 0; i < pass.length(); i++) {
            char c = pass.charAt(i);
            if (Character.isUpperCase(c)) {
                hasUpper = true;
            } else if (Character.isLowerCase(c)) {
                hasLower = true;
            }

            // Nếu đã đủ điều kiện, có thể thoát vòng lặp sớm
            if (hasUpper && hasLower) {
                return true;
            }
        }

        return false;  // Không đủ điều kiện
    }
}