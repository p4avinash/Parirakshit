package com.avinash.parirakshit;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class verifyUser extends AppCompatActivity {



    public void openLogInActivity(View view){
        TextInputLayout textInputLayout=findViewById(R.id.verifyAnswertextInputLayout);
        String verifyAnswer=textInputLayout.getEditText().getText().toString();
        SharedPreferences sharedPreferencesSavedAnswer=this.getSharedPreferences("com.avinash.parirakshit", Context.MODE_PRIVATE);
        SharedPreferences sharedPreferencesSelected=this.getSharedPreferences("com.avinash.parirakshit", Context.MODE_PRIVATE);
        String savedAnswer=sharedPreferencesSavedAnswer.getString("Answer",null);
        Integer selectedItem=sharedPreferencesSelected.getInt("selectedItem",0);

        if(verifyAnswer.equals(savedAnswer)) {
            if(selectedItem.equals(0)){
                Intent i=new Intent(getApplicationContext(),forgetPassword.class);
                startActivity(i);
            }
            else  if(selectedItem.equals(1)){
                Intent i=new Intent(getApplicationContext(),forgetPin.class);
                startActivity(i);
            }
        }
        else {
            textInputLayout.setError("Wrong Answer!!");
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_user);
        TextView textView=findViewById(R.id.verifySecurityQuestionTextView);
        SharedPreferences sharedPreferencesSavedQuestion=this.getSharedPreferences("com.avinash.parirakshit", Context.MODE_PRIVATE);
        String savedQuestion=sharedPreferencesSavedQuestion.getString("Question",null);
        textView.setText(savedQuestion);



    }
}
