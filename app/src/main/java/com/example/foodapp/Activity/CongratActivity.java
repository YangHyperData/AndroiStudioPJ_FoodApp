package com.example.foodapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.foodapp.R;
import com.example.foodapp.databinding.ActivityCongratBinding;

public class CongratActivity extends BaseActivity {
    ActivityCongratBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityCongratBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setVariable();
    }

    private void setVariable() {
        binding.backtodashboardBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CongratActivity.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}