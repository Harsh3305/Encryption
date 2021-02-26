package com.example.encryption;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.aescrypt.AESCrypt;

import java.security.MessageDigest;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button  button = findViewById(R.id.button);
        EditText editText = findViewById(R.id.editTextTextPersonName);
        TextView textView = findViewById(R.id.textView2);

        button.setOnClickListener(v -> {
            String message = editText.getText().toString();
            try
            {
                AESCrypt crypt = new AESCrypt("AES","1Hbfh667adfDEJ78");
                textView.setText(crypt.encrypt(message));

            } catch (Exception e) {
                e.printStackTrace();
            }
        });


    }
}