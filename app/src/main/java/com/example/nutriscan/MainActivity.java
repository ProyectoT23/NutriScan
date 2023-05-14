package com.example.nutriscan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.nutriscan.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnLog.setOnClickListener(this);
        binding.txtReg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            /*case R.id.btnLog:
                mostrarPrincipal();
                break;*/
            case R.id.txtReg:
                mostrarRegistro();
                break;
        }
    }
    private void mostrarRegistro() {
        startActivity(new Intent(this, RegistroActivity.class));
    }
}