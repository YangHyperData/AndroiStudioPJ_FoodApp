package com.example.foodapp.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityLoginBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class LoginActivity extends BaseActivity {
    ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();

    }

    private void setVariable() {
        binding.loginBtn.setOnClickListener(v -> {
            String email = binding.userEdt.getText().toString();
            String password = binding.passEdt.getText().toString();
            if (!email.isEmpty() && !password.isEmpty()) {
                if (email.equals("admin@gmail.com")) {
                    // Chuyển đến AdminActivity nếu email là admin
                    startActivity(new Intent(LoginActivity.this, AdminActivity.class));
                } else {
                    // Xác thực người dùng khác
                    mAuth.signInWithEmailAndPassword(email, password)
                            .addOnCompleteListener(LoginActivity.this, task -> {
                                if (task.isSuccessful()) {
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                } else {
                                    Toast.makeText(LoginActivity.this, "Failed", Toast.LENGTH_SHORT).show();
                                }
                            });
                }
            } else {
                // Xử lý các trường hợp còn trống
                if (email.isEmpty() && password.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in both email and password", Toast.LENGTH_SHORT).show();
                } else if (email.isEmpty()) {
                    Toast.makeText(LoginActivity.this, "Please fill in email", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Please fill in password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}