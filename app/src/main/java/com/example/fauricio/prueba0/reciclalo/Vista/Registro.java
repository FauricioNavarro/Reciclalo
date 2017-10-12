package com.example.fauricio.prueba0.reciclalo.Vista;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.example.fauricio.prueba0.reciclalo.Controlador.ControladoraBD;
import com.example.fauricio.prueba0.reciclalo.R;

public class Registro extends AppCompatActivity {
    private EditText nombre,correo,contraseña;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        nombre = (EditText) findViewById(R.id.et_nombre);
        correo = (EditText) findViewById(R.id.et_correo);
        contraseña = (EditText) findViewById(R.id.et_contraseña);
    }

    public void Registrar(View view){
        String nomb = nombre.getText().toString();
        String email = correo.getText().toString();
        String pass = contraseña.getText().toString();
        ControladoraBD c = new ControladoraBD(this);
        c.execute("registro",nomb,email,pass);
    }
}
