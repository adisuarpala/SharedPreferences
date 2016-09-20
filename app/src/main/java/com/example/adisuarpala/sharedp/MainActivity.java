package com.example.adisuarpala.sharedp;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    TextView Nama, Alamat, TglLahir, Hobi;

    Button btn1, btn2, btn3;

    public static final String MyPREFERENCES = "MyPrefs";
    public static final String nama = "namaKey";
    public static final String alamat = "alamatKey";
    public static final String tglLahir = "tglLahirKey";
    public static final String hobi = "hobiKey";
    SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Nama = (TextView) findViewById(R.id.nama);
        Alamat = (TextView) findViewById(R.id.alamat);
        TglLahir = (TextView) findViewById(R.id.tglLahir);
        Hobi = (TextView) findViewById(R.id.hobi);

        btn1 = (Button) findViewById(R.id.btnSave);
        btn2 = (Button) findViewById(R.id.btnGet);
        btn3 = (Button) findViewById(R.id.btnClear);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

        if (sharedpreferences.contains(nama)) {
            Nama.setText(sharedpreferences.getString(nama, ""));
        }
        if (sharedpreferences.contains(alamat)) {
            Alamat.setText(sharedpreferences.getString(alamat, ""));
        }
        if (sharedpreferences.contains(tglLahir)) {
            TglLahir.setText(sharedpreferences.getString(tglLahir, ""));
        }
        if (sharedpreferences.contains(hobi)) {
            Hobi.setText(sharedpreferences.getString(hobi, ""));
        }

        btn1.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View view) {
                String N = Nama.getText().toString();
                String A = Alamat.getText().toString();
                String T = TglLahir.getText().toString();
                String H = Hobi.getText().toString();

                SharedPreferences.Editor editor = sharedpreferences.edit();
                editor.putString(nama, N);
                editor.putString(alamat, A);
                editor.putString(tglLahir, T);
                editor.putString(hobi, H);
                editor.commit();
                Toast.makeText(MainActivity.this,"data saved",Toast.LENGTH_LONG).show();

            }
        });

        btn2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Nama = (TextView)findViewById(R.id.nama);
                Alamat = (TextView)findViewById(R.id.alamat);
                TglLahir = (TextView)findViewById(R.id.tglLahir);
                Hobi = (TextView)findViewById(R.id.hobi);

                sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);

                if (sharedpreferences.contains(nama)) {
                    Nama.setText(sharedpreferences.getString(nama, ""));
                }
                if (sharedpreferences.contains(alamat)) {
                    Alamat.setText(sharedpreferences.getString(alamat, ""));
                }
                if (sharedpreferences.contains(tglLahir)) {
                    TglLahir.setText(sharedpreferences.getString(tglLahir, ""));
                }
                if (sharedpreferences.contains(hobi)) {
                    Hobi.setText(sharedpreferences.getString(hobi, ""));
                }
            }
        });

        btn3.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                Nama = (TextView)findViewById(R.id.nama);
                Alamat = (TextView)findViewById(R.id.alamat);
                TglLahir = (TextView)findViewById(R.id.tglLahir);
                Hobi = (TextView)findViewById(R.id.hobi);

                Nama.setText("");
                Alamat.setText("");
                TglLahir.setText("");
                Hobi.setText("");
            }
        });
    }

}
