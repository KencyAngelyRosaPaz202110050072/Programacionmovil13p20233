package com.example.programacionmovil13p2023;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.programacionmovil13p2023.configuracion.SQLiteConexion;
import com.example.programacionmovil13p2023.configuracion.Transacciones;

public class MainActivity extends AppCompatActivity
{
    EditText nombres,apellidos,edad, correo;
    Button btnentrar;

    @Override
    protected void onCreate(Bundle savedInstanceState)    {

        super.onCreate(savedInstanceState);
        //R. --> hace referencia a la carpeta res
        setContentView(R.layout.activity_main);

        nombres = (EditText) findViewById(R.id.txtnombre);
        apellidos = (EditText) findViewById(R.id.txtapellidos);
        edad = (EditText) findViewById(R.id.txtnombre);
        correo = (EditText) findViewById(R.id.txtcorreo);



       // nombres.setText(getIntent().getStringExtra("numero1"));
       // apellidos.setText(getIntent().getStringExtra("numero2"));

        btnentrar = (Button) findViewById(R.id.btnentrar);

        btnentrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AddPerson();
            }
        });
    }

    private void AddPerson()
    {
        try {
        SQLiteConexion conexion = new SQLiteConexion(this, Transacciones.namedb, null, 1);
        SQLiteDatabase db = conexion.getReadableDatabase();

        ContentValues valores = new ContentValues();

        valores.put(Transacciones.nombres, nombres.getText().toString());
        valores.put(Transacciones.apellidos, apellidos.getText().toString());
        valores.put(Transacciones.edad, edad.getText().toString());
        valores.put(Transacciones.correo, correo.getText().toString());

        Long Result = db.insert(Transacciones.Tabla, Transacciones.id, valores);

        Toast.makeText(this, getString(R.string.Respuesta), Toast.LENGTH_LONG).show();
        db.close();
    }

    catch (Exception exception)
    {

        Toast.makeText(this,getString(R.string.ErrorResp), Toast.LENGTH_LONG).show();
        }

    }
}