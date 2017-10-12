package com.example.fauricio.prueba0.reciclalo.Vista;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.example.fauricio.prueba0.reciclalo.Controlador.ControladoraBD;
import com.example.fauricio.prueba0.reciclalo.R;
import com.google.zxing.Result;

import me.dm7.barcodescanner.zxing.ZXingScannerView;


public class EscanerFragment extends Fragment implements ZXingScannerView.ResultHandler{
    private ZXingScannerView mScannerView;
    private Spinner tipo;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mScannerView = new ZXingScannerView(getActivity());

        return mScannerView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void handleResult(final Result rawResult) {
        /*
        Toast.makeText(getActivity(), "Contents = " + rawResult.getText() +
                ", Format = " + rawResult.getBarcodeFormat().toString(), Toast.LENGTH_SHORT).show();
        // Note:
        // * Wait 2 seconds to resume the preview.
        // * On older devices continuously stopping and resuming camera preview can result in freezing the app.
        // * I don't know why this is the case but I don't have the time to figure out.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mScannerView.resumeCameraPreview(EscanerFragment.this);
            }
        }, 2000);*/

        Button agregar;
        ArrayAdapter<CharSequence> adapter;
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(getContext());
        View view = getActivity().getLayoutInflater().inflate(R.layout.popup_producto,null);
        tipo = (Spinner) view.findViewById(R.id.Sp_tipo);
        agregar = (Button) view.findViewById(R.id.Bt_agregar);
        adapter = ArrayAdapter.createFromResource(getActivity(),R.array.tipos,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo.setAdapter(adapter);
        agregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mensj = tipo.getSelectedItem().toString();
                long tipoID = tipo.getSelectedItemId();
                String tipo = Long.toString(tipoID)+1;
                ControladoraBD c = new ControladoraBD(getContext());
                c.execute("addProducto",rawResult.getText(),rawResult.getBarcodeFormat().toString(),tipo);
                //Toast.makeText(getContext(),"Codigo = " + rawResult.getText() +
                //        ", Formato = " + rawResult.getBarcodeFormat().toString()+mensj+" numero: "+tipo,Toast.LENGTH_SHORT).show();
            }
        });

        alertDialog.setView(view);
        AlertDialog dialog = alertDialog.create();
        dialog.show();
    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }
}
