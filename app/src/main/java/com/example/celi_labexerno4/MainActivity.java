package com.example.celi_labexerno4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    String[] comNames, comCountries, comIndustries, comCeos, des;
    int[] logo = {R.drawable.a, R.drawable.b, R.drawable.c, R.drawable.d, R.drawable.e, R.drawable.f, R.drawable.g, R.drawable.h, R.drawable.i, R.drawable.j, R.drawable.k, R.drawable.l};
    ArrayList<CompanyList> cmp = new ArrayList<>();
    ListView lstCompanies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("TOP GLOBAL COMPANIES");

        comNames = getResources().getStringArray(R.array.comName);
        comCountries = getResources().getStringArray(R.array.comCountry);
        comIndustries = getResources().getStringArray(R.array.comIndustry);
        comCeos = getResources().getStringArray(R.array.comCeo);
        des = getResources().getStringArray(R.array.desc);

        for(int i=0; i < comNames.length; i++) {
            cmp.add(new CompanyList(logo[i], comNames[i], comCountries[i], comIndustries[i], comCeos[i]));
        }

        AndroidAdapter adapter = new AndroidAdapter(this, R.layout.companies, cmp);
        lstCompanies = findViewById(R.id.lvCompany);
        lstCompanies .setAdapter(adapter);
        lstCompanies .setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(this);
        dialog.setIcon(logo[i]);
        dialog.setTitle(comNames[i]);
        dialog.setMessage(des[i]);
        dialog.setNeutralButton("Close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
               // Toast.makeText(MainActivity.this, "hello", Toast.LENGTH_LONG).show();
            }
        });
        dialog.create().show();
    }
}
