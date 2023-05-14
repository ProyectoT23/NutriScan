package com.example.nutriscan;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.nutriscan.databinding.ActivityRegistroBinding;

import java.util.HashMap;
import java.util.Map;

public class RegistroActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityRegistroBinding binding;

    EditText edtNombres, edtApellidos, edtTelefono, edtPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegistroBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnRegistrar.setOnClickListener(this);
        edtNombres=(EditText)findViewById(R.id.etNombres);
        edtApellidos=(EditText)findViewById(R.id.etApellidos);
        edtTelefono=(EditText)findViewById(R.id.etTeléfono);
        edtPassword=(EditText)findViewById(R.id.etPassword);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnRegistrar:
                ejecutarServicio("http://192.168.27.1:80/ServicioWEB/insertar.php");
                mostrarMain();
                break;

        }
    }
    private void mostrarMain() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void ejecutarServicio(String URL){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Registro Exitoso", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError{
                Map<String,String> parametros=new HashMap<String,String>();
                parametros.put("nombres",edtNombres.getText().toString());
                parametros.put("apellidos",edtApellidos.getText().toString());
                parametros.put("telefono",edtTelefono.getText().toString());
                parametros.put("password",edtPassword.getText().toString());
                return parametros;
            }
        };

        requestQueue.add(stringRequest);
    }
}