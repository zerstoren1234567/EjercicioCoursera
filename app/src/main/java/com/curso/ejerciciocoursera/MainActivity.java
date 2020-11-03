package com.curso.ejerciciocoursera;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private DatePickerDialog.OnDateSetListener dateSetListener;

    private EditText etNombre;
    private EditText etFecha;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;
    private Button btnSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.etFecha);

        editText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Calendar calendar = Calendar.getInstance();
                int anio = calendar.get(Calendar.YEAR);
                int mes = calendar.get(Calendar.MONTH);
                int dia = calendar.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(
                        MainActivity.this,
                        //R.style.Theme_AppCompat_DayNight_DarkActionBar,
                        dateSetListener,
                        anio,mes,dia
                );
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });

        dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int anio, int mes, int dia) {
                mes += 1;
                String fecha = anio + "/" + mes + "/" + dia;
                editText.setText(fecha);
            }
        };

        etNombre = findViewById(R.id.etNombre);
        etFecha = findViewById(R.id.etFecha);
        etTelefono = findViewById(R.id.etTelefono);
        etEmail = findViewById(R.id.etEmail);
        etDescripcion = findViewById(R.id.etDescripcion);
        btnSiguiente = findViewById(R.id.btnSiguiente);

        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Activity2.class);
                intent.putExtra(getResources().getString(R.string.pNombre), etNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pFecha), etFecha.getText().toString());
                intent.putExtra(getResources().getString(R.string.pTelefono), etTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pEmail), etEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pDescripcion), etDescripcion.getText().toString());
                startActivity(intent);
                finish();
            }
        });

        Bundle bundle = getIntent().getExtras();
        if (bundle != null){
            String nombre = bundle.getString(getResources().getString(R.string.pNombre));
            String fecha = bundle.getString(getResources().getString(R.string.pFecha));
            String telefono = bundle.getString(getResources().getString(R.string.pTelefono));
            String email = bundle.getString(getResources().getString(R.string.pEmail));
            String descripcion = bundle.getString(getResources().getString(R.string.pDescripcion));

            etNombre.setText(nombre);
            etFecha.setText(fecha);
            etTelefono.setText(telefono);
            etEmail.setText(email);
            etDescripcion.setText(descripcion);
        }

    }
}
