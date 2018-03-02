package com.example.pc.formandstud;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.Toast;

import java.util.concurrent.RunnableScheduledFuture;

public class MainActivity extends AppCompatActivity {

    EditText editTextName;
    EditText editTextPhone;
    Button btnAccept;
    Button btnClearName;
    Button btnClearPhone;
    Button btnInfo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextPhone = findViewById(R.id.editTextPhone);
        btnAccept = findViewById(R.id.btnAccept);
        btnClearName = findViewById(R.id.btnClearName);
        btnClearPhone = findViewById(R.id.btnClearPhone);
        btnInfo = findViewById(R.id.btnInfo);

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                segundaPantalla();
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

        if (textName.matches("") & textPhone.matches("")){

            Toast.makeText(MainActivity.this, "Empty Text Fields", Toast.LENGTH_SHORT).show();

        }else {

            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            intent.putExtra("TextName", textName);
            intent.putExtra("TextPhone", textPhone);
            startActivity(intent);
        }


    }

    private void clearName() {

        editTextName.setText("");
    }

    private void clearPhone() {

        editTextPhone.setText("");
    }


}
