package com.example.learnyourself;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    private EditText nt, lnt;
    private FirebaseAuth auth;
    private FirebaseFirestore db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        auth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        setContentView(R.layout.activity_register);
        nt = findViewById(R.id.nameText);
        lnt = findViewById(R.id.lastNameText);
    }


    public void regis(View v){
        String email = nt.getText().toString();
        String password = lnt.getText().toString();

        if(!email.isEmpty() && !password.isEmpty()){
            createAccountWithFirebase(email, password);
        } else {
            Toast.makeText(Register.this, "Error", Toast.LENGTH_SHORT).show();
        }

    }

    public void createAccountWithFirebase(String email, String password){
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            FirebaseUser user = auth.getCurrentUser();
                            storeData(user.getUid(), email, password);
                        } else {
                            Toast.makeText(Register.this, "Registro fallido", Toast.LENGTH_SHORT).show();

                        }
                    }
                });
    }

    public void storeData(String userId, String email, String password){
        Map<String, Object> userMap = new HashMap<>();
        userMap.put("email", email);
        userMap.put("password", password);

        db.collection("users")
                .document(userId)
                .set(userMap)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(Register.this, "Se registro el usuario con exito", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Register.this, "Error al registrar usuario", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    //metodo para volver a la anterior activity
    public void preView(View v)
    {
        finish();
    }
}