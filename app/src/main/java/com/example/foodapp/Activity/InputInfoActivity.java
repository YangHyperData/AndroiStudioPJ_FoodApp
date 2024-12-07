package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityInputInfoBinding;

public class InputInfoActivity extends BaseActivity {
    ActivityInputInfoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityInputInfoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
    }

    private void setVariable() {
        binding.backBtn.setOnClickListener(v -> finish());
        binding.confirmBtn1.setOnClickListener(v -> {
            Intent intent = new Intent(InputInfoActivity.this,CongratActivity.class);
            startActivity(intent);
        });
    }
}