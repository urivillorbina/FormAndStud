package com.example.pc.formandstud;


import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.security.cert.LDAPCertStoreParameters;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;


public class InfoActivity extends AppCompatActivity {

    Button checkHour1;
    Button checkHour2;
    Button checkHour3;
    Button checkHour4;
    Button saveContent;

    TextView DisplayDateTime1;
    TextView DisplayDateTime2;
    TextView DisplayDateTime3;
    TextView DisplayDateTime4;
    TextView Result;

    long Time1;
    long Time2;
    long Time3;
    long Time4;
    long Time789;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        final Date Resta = new Date();
        Time789 = Resta.getTime();

        System.out.println(Time789);


        checkHour1 = findViewById(R.id.checkHour1);
        checkHour2 = findViewById(R.id.checkHour2);
        checkHour3 = findViewById(R.id.checkHour3);
        checkHour4 = findViewById(R.id.checkHour4);
        saveContent = findViewById(R.id.btnSaveContent);
        DisplayDateTime1 = findViewById(R.id.textViewCheck1);
        DisplayDateTime2 = findViewById(R.id.textViewCheck2);
        DisplayDateTime3 = findViewById(R.id.textViewCheck3);
        DisplayDateTime4 = findViewById(R.id.textViewCheck4);
        Result = findViewById(R.id.textViewResultado);

        saveContent.setEnabled(false);



        checkHour1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Date DatosHora1 = new Date();
                Time1 = DatosHora1.getTime();


                if (DisplayDateTime1 == null) {
                    return;
                }
                Toast.makeText(InfoActivity.this, "Check in, DONE ", Toast.LENGTH_SHORT).show();
                DisplayDateTime1.setText(new SimpleDateFormat("dd-MM-yyyy k:mm", Locale.getDefault()).format(DatosHora1));
                checkHour1.setEnabled(false);



            }
        });


        checkHour2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Date DatosHora2 = new Date();
                Time2 = DatosHora2.getTime();


                if (DisplayDateTime1.getText().equals("")) {
                    Toast.makeText(InfoActivity.this, "Check in the button above", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(InfoActivity.this, "Check in, DONE ", Toast.LENGTH_SHORT).show();
                DisplayDateTime2.setText(new SimpleDateFormat("dd-MM-yyyy k:mm", Locale.getDefault()).format(DatosHora2));
                checkHour2.setEnabled(false);

            }
        });


        checkHour3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Date DatosHora3 = new Date();
                Time3 = DatosHora3.getTime();

                if (!(!DisplayDateTime1.getText().equals("") & !DisplayDateTime2.getText().equals(""))) {
                    Toast.makeText(InfoActivity.this, "Check in the button above", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(InfoActivity.this, "Check in, DONE ", Toast.LENGTH_SHORT).show();
                DisplayDateTime3.setText(new SimpleDateFormat("dd-MM-yyyy k:mm", Locale.getDefault()).format(DatosHora3));
                checkHour3.setEnabled(false);

            }
        });


        checkHour4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Date DatosHora4 = new Date();

                Time4 = DatosHora4.getTime();

                if (!(!DisplayDateTime1.getText().equals("") & !DisplayDateTime2.getText().equals("") & !DisplayDateTime3.getText().equals(""))) {
                    Toast.makeText(InfoActivity.this, "Check in the button above", Toast.LENGTH_SHORT).show();
                    return;
                }

                Toast.makeText(InfoActivity.this, "ALL checked. ", Toast.LENGTH_SHORT).show();
                DisplayDateTime4.setText(new SimpleDateFormat("dd-MM-yyyy k:mm", Locale.getDefault()).format(DatosHora4));
                checkHour4.setEnabled(false);

                saveContent.setEnabled(true);


            }
        });


        saveContent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Long total;
                long time1 = Time1 - Time789;
                long time2 = Time2 - Time789;
                long time3 = Time3 - Time789;
                long time4 = Time4 - Time789;

                total = (time2 - time1) + (time4 - time3);
                System.out.println(total);

                long MilliToSeconds = total / 1000;
                long hours = MilliToSeconds / 3600;
                long minutes = (MilliToSeconds % 3600) / 60;
                long seconds = (MilliToSeconds % 3600) % 60;

                System.out.println(hours);
                System.out.println(minutes);
                System.out.println(seconds);

                Result.setText(hours + ("h:") + minutes + ("min:") + seconds + ("s"));


                Toast.makeText(InfoActivity.this, "Worked Hours", Toast.LENGTH_SHORT).show();

                saveContent.setEnabled(false);

            }
        });


    }
}
