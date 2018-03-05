package com.example.pc.formandstud;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {

    TextView textViewPhone;
    TextView textViewName;
    Button btnYes;
    Button btnNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        textViewPhone = findViewById(R.id.textViewPhone);
        textViewName = findViewById(R.id.textViewName);
        btnNo = findViewById(R.id.btnNo);
        btnYes = findViewById(R.id.btnYes);

        String name = getIntent().getStringExtra("TextName");
        String phone = getIntent().getStringExtra("TextPhone");

        textViewPhone.setText(phone);
        textViewName.setText(name);

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                devolverPrimeraPantalla();
            }
        });

        btnYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarPopUpName();
                mostrarPopUpPhone();
            }
        }

        );

    }

    public void devolverPrimeraPantalla() {

       /* String textName = textViewName.getText().toString();
        String textPhone = textViewPhone.getText().toString();*/

        Intent intentBack = new Intent (SecondActivity.this, MainActivity.class);
        /*intentBack.putExtra("textName", textName);
        intentBack.putExtra("textPhone", textPhone);*/
        startActivity(intentBack);
    }



    public void terceraPantalla(){

        Intent intentThird = new Intent(SecondActivity.this, ThirdActivity.class);
        startActivity(intentThird);

    }

    private void mostrarPopUpName() {

        String name = getIntent().getStringExtra("TextName");
       // String phone = getIntent().getStringExtra("TextPhone");


        AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);

        builder.setTitle("Do you want to save your data?");

        builder.setMessage(name);
        //builder.setMessage(phone);

// Add the buttons
        builder.setPositiveButton(R.string.btnYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                //guardar información en alguna lista
            }
        });
        builder.setNegativeButton(R.string.btnNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
// Set other dialog properties


// Create the AlertDialog
        builder.show();
        AlertDialog dialog = builder.create();

    }

    private void mostrarPopUpPhone() {

        //String name = getIntent().getStringExtra("TextName");
        String phone = getIntent().getStringExtra("TextPhone");


        AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);

        builder.setTitle("Do you want to save your data?");

        builder.setMessage(phone);
        //builder.setMessage(phone);

// Add the buttons
        builder.setPositiveButton(R.string.btnYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                terceraPantalla();
            }
        });
        builder.setNegativeButton(R.string.btnNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();
            }
        });
// Set other dialog properties


// Create the AlertDialog
        builder.show();
        AlertDialog dialog = builder.create();

    }
}
