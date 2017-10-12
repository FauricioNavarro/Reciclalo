package com.example.fauricio.prueba0.reciclalo.Controlador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fauricio.prueba0.reciclalo.Modelo.Item;
import com.example.fauricio.prueba0.reciclalo.R;

import java.util.ArrayList;

/**
 * Created by Fauricio on 01/10/2017.
 */

public class listViewAdapter extends BaseAdapter {
    private ArrayList<Item> arrayItems;
    private Context context;
    private LayoutInflater layoutInflater;

    public listViewAdapter(ArrayList<Item> arrayItems, Context context) {
        this.arrayItems = arrayItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View vistaItem = layoutInflater.inflate(R.layout.activity_lista__items, viewGroup, false);
        ImageView iv_imagen = (ImageView) vistaItem.findViewById(R.id.iv_imagen);
        TextView tv_titulo = (TextView) vistaItem.findViewById(R.id.tv_titulo);
        TextView tv_contenido = (TextView) vistaItem.findViewById(R.id.tv_contenido);
        iv_imagen.setImageResource(arrayItems.get(i).getImagen());
        tv_titulo.setText(arrayItems.get(i).getTitulo());
        tv_contenido.setText(arrayItems.get(i).getContenido());
        return vistaItem;
    }
}
