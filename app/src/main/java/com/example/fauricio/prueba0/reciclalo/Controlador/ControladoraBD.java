package com.example.fauricio.prueba0.reciclalo.Controlador;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.fauricio.prueba0.reciclalo.Vista.LoginActivity;
import com.example.fauricio.prueba0.reciclalo.Vista.MainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by Fauricio on 30/09/2017.
 */

public class ControladoraBD extends AsyncTask<String,Void,String> {
    private Context context;
    private AlertDialog alertDialog;

    public ControladoraBD(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String result = "";
        String line = "";
        String php_url = "http://192.168.43.238/reciclalo/"; //192.168.43.238 cell ip and home ip 192.168.100.8 adrian ip 192.168.0.112
        if (type.equals("login")) {
            try {
                php_url = php_url + "rec_login.php";
                String email = params[1];
                String contraseña = params[2];
                URL url = new URL(php_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("correo", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(contraseña, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                while ((line = bufferedReader.readLine()) != null) {
                    result = result + line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }else if (type.equals("registro")) {
            try {
                php_url = php_url + "rec_registro.php";
                String nombre = params[1];
                String email = params[2];
                String contraseña = params[3];
                URL url = new URL(php_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("nombre", "UTF-8") + "=" + URLEncoder.encode(nombre, "UTF-8") + "&"
                        + URLEncoder.encode("correo", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                        + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(contraseña, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                while ((line = bufferedReader.readLine()) != null) {
                    result = result + line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }else if (type.equals("addProducto")) {
            try {
                php_url = php_url + "rec_addProducto.php";
                String cod = params[1];
                String des = params[2];
                String tipo = params[3];
                URL url = new URL(php_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String post_data = URLEncoder.encode("codigo", "UTF-8") + "=" + URLEncoder.encode(cod, "UTF-8") + "&"
                        + URLEncoder.encode("descripcion", "UTF-8") + "=" + URLEncoder.encode(des, "UTF-8") + "&"
                        + URLEncoder.encode("tipo", "UTF-8") + "=" + URLEncoder.encode(tipo, "UTF-8");
                bufferedWriter.write(post_data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                while ((line = bufferedReader.readLine()) != null) {
                    result = result + line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return result;
        }
        return result;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Estado");
    }

    @Override
    protected void onPostExecute(String result) {
        try {
            JSONObject jsonObject = new JSONObject(result);
            if(jsonObject.names().get(0).equals("login exitoso")){
                context.startActivity(new Intent(context.getApplicationContext(), MainActivity.class));
            }else if(jsonObject.names().get(0).equals("Registro exitoso")){
                context.startActivity(new Intent(context.getApplicationContext(), LoginActivity.class));
            }else if(jsonObject.names().get(0).equals("Producto exitoso")){
                alertDialog.setMessage(result);
                alertDialog.show();
            }else{
                alertDialog.setMessage(result);
                alertDialog.show();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
