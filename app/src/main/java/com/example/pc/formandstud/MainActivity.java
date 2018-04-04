package com.example.pc.formandstud;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.test.mock.MockContentProvider;
import android.test.mock.MockContext;
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
    Button btnConsultarBd;
    Button btnInsertarBd;
    Button btnAccept;
    Button btnClearId;
    Button btnClearName;
    Button btnClearPhone;
    Button btnInfo;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ConexionSQLiteHelper conn = new ConexionSQLiteHelper(this, "bd_usuarios", null, 1);

        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        editTextId = findViewById(R.id.editTextId);
        btnConsultarBd = findViewById(R.id.btnConsulta);
        btnInsertarBd = findViewById(R.id.btnInsertar);
        btnAccept = findViewById(R.id.btnAccept);
        btnClearId = findViewById(R.id.btnClearId);
        btnClearName = findViewById(R.id.btnClearName);
        btnClearPhone = findViewById(R.id.btnClearPhone);
        btnInfo = findViewById(R.id.btnInfo);


        btnInsertarBd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //crear condición, si hay algún campo vacio, botón inhabilitado o mostrar mensaje
                //de rellenar todos los campos de texto
                registrarUsuariosSql();
                Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
            }
        });

        btnConsultarBd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Insertar en BD
                Intent  listview = new Intent(MainActivity.this, ListViewActivity.class);
                startActivity(listview);
                //Toast.makeText(MainActivity.this, "Inoperative Button", Toast.LENGTH_SHORT).show();
            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //registrarUsuarios();
                //registrarUsuariosSql();
                //segundaPantalla();
                /*private FusedLocationProviderClient mFusedLocationClient;
                mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
                isMockLocationOn( location);*/

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


    /*public static void MockLocation(Location location){


        LocationManager locationManager = (LocationManager) location.isFromMockProvider();

        //location = location.isFromMockProvider();

    }*/


    public boolean isMockLocationOn(Location location) {

        return location.isFromMockProvider();
    }




    private void clearId() {
        editTextId.setText("");
    }

    private void clearName() {
        editTextName.setText("");
    }

    private void clearPhone() {
        editTextPhone.setText("");
    }


}
