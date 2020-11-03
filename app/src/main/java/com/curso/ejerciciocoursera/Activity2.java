package com.curso.ejerciciocoursera;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    TextView tvNombre;
    TextView tvFecha;
    TextView tvTelefono;
    TextView tvEmail;
    TextView tvDescripcion;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        Bundle bundle = getIntent().getExtras();
        String nombre = bundle.getString(getResources().getString(R.string.pNombre));
        String fecha = bundle.getString(getResources().getString(R.string.pFecha));
        String telefono = bundle.getString(getResources().getString(R.string.pTelefono));
        String email = bundle.getString(getResources().getString(R.string.pEmail));
        String descripcion = bundle.getString(getResources().getString(R.string.pDescripcion));

        tvNombre = findViewById(R.id.tvNombre);
        tvFecha = findViewById(R.id.tvFecha);
        tvTelefono = findViewById(R.id.tvTelefono);
        tvEmail = findViewById(R.id.tvEmail);
        tvDescripcion = findViewById(R.id.tvDescripcion);

        tvNombre.setText(getResources().getString(R.string.nombre) + ": " + nombre);
        tvFecha.setText(getResources().getString(R.string.fecha) + ": " + fecha);
        tvTelefono.setText(getResources().getString(R.string.telefono) + ": " + telefono);
        tvEmail.setText(getResources().getString(R.string.email) + ": " + email);
        tvDescripcion.setText(getResources().getString(R.string.descripcion) + ": " + descripcion);

        btnEditar = findViewById(R.id.btnEditar);

        btnEditar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Activity2.this, MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pNombre), tvNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pFecha), tvFecha.getText().toString());
                intent.putExtra(getResources().getString(R.string.pTelefono), tvTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pEmail), tvEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pDescripcion), tvDescripcion.getText().toString());
                startActivity(intent);
                finish();
            }
        });

    }
}
