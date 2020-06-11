package com.avinash.parirakshit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class forgetPin extends AppCompatActivity {

    public void savePin(View view){
        Intent i = new Intent(getApplicationContext(), logInByPin.class);
        TextInputLayout textInputLayout=(TextInputLayout)findViewById(R.id.forgetPinEditText);
        String newPin=textInputLayout.getEditText().getText().toString();
        try {
            int newPinn = Integer.parseInt(newPin);
        }catch (NumberFormatException e){}
        if(newPin.isEmpty()){
            textInputLayout.setError("Can't leave fields empty");
        }
        else if(newPin.length()>3 && newPin.length()<=10) {
            SharedPreferences sharedPreferencesPin=this.getSharedPreferences("com.avinash.parirakshit", Context.MODE_PRIVATE);
            sharedPreferencesPin.edit().putString("Pin",newPin).apply();
            String savedPin=sharedPreferencesPin.getString("Pin",null);
            Toast.makeText(getApplicationContext(),"Pin changed successfully!!",Toast.LENGTH_SHORT).show();
            startActivity(i);
            Log.i("Pin",savedPin);
        }
        else if(newPin.isEmpty()){
            textInputLayout.setError("Can't leave fields empty!");
        }
        else if(newPin.length()<4 || newPin.length()>10){
            textInputLayout.setError("Pin must be between 4-10 digits");
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_pin);
    }
}
