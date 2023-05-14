package com.example.nutriscan;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nutriscan.databinding.ActivityPrincipalBinding;

public class PrincipalActivity extends AppCompatActivity implements View.OnClickListener{
    private ActivityPrincipalBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrincipalBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnAgregar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAgregar:
                agregarAlergia();
                break;
        }
    }

    public void agregarAlergia(){
        AlertDialog.Builder builder = new AlertDialog.Builder(PrincipalActivity.this);
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.dialogo_alergia,null);
        builder.setView(view);
        AlertDialog dialog = builder.create();
        dialog.show();

        Button btnAdd = view.findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Agregado",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        Button btnCancel = view.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Cancelado",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
    }
}