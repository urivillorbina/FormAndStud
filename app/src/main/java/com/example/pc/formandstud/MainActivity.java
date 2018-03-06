package com.example.pc.formandstud;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pc.formandstud.baseDeDatos.ConexionSQLiteHelper;
import com.example.pc.formandstud.utilidades.Utilidades;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextPhone;
    EditText editTextId;
    Button btnAccept;
    Button btnClearId;
    Button btnClearName;
    Button btnClearPhone;
    Button btnInfo;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);

        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextId = findViewById(R.id.editTextId);
        btnAccept = findViewById(R.id.btnAccept);
        btnClearId = findViewById(R.id.btnClearId);
        btnClearName = findViewById(R.id.btnClearName);
        btnClearPhone = findViewById(R.id.btnClearPhone);
        btnInfo = findViewById(R.id.btnInfo);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //registrarUsuarios();
                registrarUsuariosSql();
                segundaPantalla();
            }
        });


        btnClearId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearId();
            }
        });

        btnClearName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearName();
            }
        });

        btnClearPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearPhone();
            }
        });

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InfoActivity();
            }
        });

    }

    private void InfoActivity() {

        Intent infoIntent = new Intent(MainActivity.this, InfoActivity.class);
        startActivity(infoIntent);
    }

    private void segundaPantalla() {

        String textName = editTextName.getText().toString();
        String textPhone = editTextPhone.getText().toString();

        if (textName.matches("") & textPhone.matches("")) {

            Toast.makeText(MainActivity.this, "Empty Text Fields", Toast.LENGTH_SHORT).show();

        } else {

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("TextName", textName);
            intent.putExtra("TextPhone", textPhone);
            startActivity(intent);
        }


    }

    private void registrarUsuariosSql() {

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        //String Insert into usuario (id, nombre, telefono) values ('ID', 'Nombre', 'Telefono')
        String insert = "INSERT INTO " + Utilidades.TABLA_USUARIO
                + " ( " + Utilidades.CAMPO_ID + " , "
                + Utilidades.CAMPO_NOMBRE + " , "
                + Utilidades.CAMPO_TELEFONO + " ) " +
                " VALUES ( '" + editTextId.getText().toString() + "' , '"
                + editTextName.getText().toString() + "' , '"
                + editTextPhone.getText().toString() + "')";

        //db.execSQL("INSERT INTO Usuario (id, nombre, telefono) VALUES (CAMPO_ID, 'CAMPO_NOMBRE', 'CAMPO_TELEFONO')");
        db.execSQL(insert);

        db.close();

    }

    private void registrarUsuarios() {

        //registrar usuarios lenguaje Android

        ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);
        SQLiteDatabase db = conn.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Utilidades.CAMPO_ID, editTextName.getText().toString());
        values.put(Utilidades.CAMPO_NOMBRE, editTextName.getText().toString());
        values.put(Utilidades.CAMPO_TELEFONO, editTextPhone.getText().toString());

        Long idResultante = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_ID, values);
        Long idNombre = db.insert(Utilidades.TABLA_USUARIO, Utilidades.CAMPO_NOMBRE, values);

        Toast.makeText(getApplicationContext(), "Id Registro: " + idResultante, Toast.LENGTH_SHORT).show();
        db.close();

    }

    private void clearName() {

        editTextName.setText("");
    }

    private void clearPhone() {

        editTextPhone.setText("");
    }

    private void clearId() {

        editTextId.setText("");
    }


}
