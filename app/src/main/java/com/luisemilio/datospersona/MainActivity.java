package com.luisemilio.datospersona;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;

import com.google.android.material.textfield.TextInputEditText;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnConfirmar = (Button)  findViewById(R.id.btnConfirmar);
        TextInputEditText tiNombre = (TextInputEditText) findViewById(R.id.tiNombre);
        DatePicker cvFechaNacimiento = (DatePicker) findViewById((R.id.cvCalendario));
        TextInputEditText tiTelefono = (TextInputEditText) findViewById(R.id.tiTelefono);
        TextInputEditText tiEMail = (TextInputEditText) findViewById(R.id.tiEMail);
        TextInputEditText tiDescipcionContacto = (TextInputEditText) findViewById(R.id.tiDescipcionContacto);
        //cvFechaNacimiento.updateDate(2019, ,04);

        btnConfirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                //String selectedDate = sdf.format(new Date(cvFechaNacimiento.getDayOfMonth()));
                Log.i("FechaNacimiento",String.valueOf(cvFechaNacimiento.getDayOfMonth()));
                Intent intent = new Intent(MainActivity.this,MostrarDatos.class);
                intent.putExtra("nombre",tiNombre.getText().toString());
                intent.putExtra("telefono",tiTelefono.getText().toString());
                intent.putExtra("email",tiEMail.getText().toString());
                intent.putExtra("decripcion",tiDescipcionContacto.getText().toString());
                intent.putExtra("diaNacimiento",String.valueOf(cvFechaNacimiento.getDayOfMonth()));
                intent.putExtra("mesNacimiento",String.valueOf(cvFechaNacimiento.getMonth()));
                intent.putExtra("añoNacimiento",String.valueOf(cvFechaNacimiento.getYear()));
                startActivity(intent);


            }
        });

    }
}