package com.avinash.parirakshit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import static com.avinash.parirakshit.R.*;
public class settings extends AppCompatActivity {
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.activity_settings);
        final Spinner spinner=findViewById(id.spinner);
        final List<String> input=new ArrayList<>();
        input.add("Password");
        input.add("Pin");
        final SharedPreferences sharedPreferencesSelected=this.getSharedPreferences("com.avinash.parirakshit", Context.MODE_PRIVATE);
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<String >(getApplicationContext(),android.R.layout.simple_dropdown_item_1line, input);
        spinner.setAdapter(arrayAdapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Integer inputType=0;
                String selected= (String) spinner.getSelectedItem().toString();
                if(selected.equals("Password")){
                    inputType=0;
                }else if(selected.equals("Pin")){
                    inputType=1;
                }
                sharedPreferencesSelected.edit().putInt("selectedItem",inputType).apply();
                Integer selectedItem=sharedPreferencesSelected.getInt("selectedItem",0);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
}
