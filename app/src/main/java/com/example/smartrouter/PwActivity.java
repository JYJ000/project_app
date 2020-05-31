package com.example.smartrouter;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class PwActivity extends AppCompatActivity {

    EditText chg_pw2, chg_pw3;
    ImageView setImage;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pw);

        button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDialog();
            }
        });


        chg_pw2 = (EditText)findViewById(R.id.chg_pw2);
        chg_pw3 = (EditText)findViewById(R.id.chg_pw3);
        setImage = (ImageView)findViewById(R.id.setImage);

        chg_pw3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if(chg_pw2.getText().toString().equals(chg_pw3.getText().toString())) {
                    setImage.setImageResource(R.drawable.sign_up_password_right);
                } else {

                    setImage.setImageResource(R.drawable.sign_up_password_incorrect);

                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }

        });
    }

    public void openDialog() {
        if(chg_pw2.getText().toString().equals(chg_pw3.getText().toString())) {
            chgpwDialogR chgpwDialogR = new chgpwDialogR();
            chgpwDialogR.show(getSupportFragmentManager(), "chgpwDialogR");
        } else {
            chgpwDialog chgpwDialog = new chgpwDialog();
            chgpwDialog.show(getSupportFragmentManager(), "chgpwDialog");
        }
    }

}
