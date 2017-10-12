package com.example.fauricio.prueba0.reciclalo.Vista;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import com.example.fauricio.prueba0.reciclalo.Controlador.ControladoraBD;
import com.example.fauricio.prueba0.reciclalo.R;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {
    private EditText correo,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        correo = (EditText) findViewById(R.id.et_correo);
        password = (EditText) findViewById(R.id.et_contraseña);
    }

    public void Login(View view){
        String email = correo.getText().toString();
        String pass = password.getText().toString();
        ControladoraBD c = new ControladoraBD(this);
        c.execute("login",email,pass);
    }

    public void Registro(View view){
        Log.i("Entro","a click registro");
        startActivity(new Intent(getApplicationContext(),Registro.class));
    }

}

