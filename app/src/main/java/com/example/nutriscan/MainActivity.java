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
import com.example.nutriscan.databinding.ActivityMainBinding;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ActivityMainBinding binding;
    EditText edtTelefono, edtPassword;
    String nombres, apellidos, telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.btnLog.setOnClickListener(this);
        binding.txtReg.setOnClickListener(this);
        edtTelefono=(EditText)findViewById(R.id.etTelefonoLogin);
        edtPassword=(EditText)findViewById(R.id.etPasswordLogin);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnLog:
                mostrarPrincipal("http://192.168.27.1/ServicioWEB/login.php");
                break;
            case R.id.txtReg:
                mostrarRegistro();
                break;
        }
    }
    private void mostrarRegistro() {
        startActivity(new Intent(this, RegistroActivity.class));
    }

    private void mostrarPrincipal(String URL){
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        StringRequest stringRequest=new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    String status = jsonObject.getString("status");
                    String message = jsonObject.getString("message");
                    if(status.equals("success")){
                        nombres = jsonObject.getString("nombres");
                        apellidos = jsonObject.getString("apellidos");
                        telefono = jsonObject.getString("telefono");
                        Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
                        startActivity(intent);
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(),jsonObject.getString("message"),Toast.LENGTH_SHORT).show();
                    }
                }catch (JSONException e){
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> parametros=new HashMap<String,String>();
                parametros.put("telefono",edtTelefono.getText().toString());
                parametros.put("password",edtPassword.getText().toString());
                return parametros;
            }
        };

        requestQueue.add(stringRequest);
    }
}
