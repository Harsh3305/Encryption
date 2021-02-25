package com.example.encryption;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = editText.getText().toString();
                try {
                    textView.setText(EncryptionMessage(message, "hello"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private String EncryptionMessage (String message, String encryptionKey) throws Exception {
        SecretKeySpec key = generateKey(message);
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        byte [] encVal = cipher.doFinal(message.getBytes());
        String encryptedValue = Base64.encodeToString(encVal, Base64.DEFAULT);


        return encryptedValue;

    }

    private SecretKeySpec generateKey (String message) throws Exception {
        final MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] bytes = message.getBytes();
        digest.update(bytes, 0, bytes.length);
        byte[] key = digest.digest();
        SecretKeySpec secretKeySpec = new SecretKeySpec(key, "ASE");
        return secretKeySpec;
    }

}