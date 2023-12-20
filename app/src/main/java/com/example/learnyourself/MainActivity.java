package com.example.learnyourself;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;


public class MainActivity extends AppCompatActivity {
    private EditText userText, userPassword;
    private FirebaseAuth mAuth;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mAuth = FirebaseAuth.getInstance();
        db = FirebaseFirestore.getInstance();

        setContentView(R.layout.activity_main);
        userText = findViewById(R.id.userEdit);
        userPassword = findViewById(R.id.passEdit);

    }



    public void login(View v){
        String email = userText.getText().toString().trim();
        String password = userPassword.getText().toString().trim();

        if(!email.isEmpty() && !password.isEmpty()){
            loginWithFirebase(email, password);
        } else {
            Toast.makeText(this, "Ingrese su usario y/o contraseña",Toast.LENGTH_SHORT).show();
        }
    }

    public void loginWithFirebase(String email, String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            obtainUser(email);
                        } else {
                            Toast.makeText(getApplicationContext(), "Autentificacion fallida.",  Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void obtainUser(String email){
        db.collection("users")
                .whereEqualTo("email", email)
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {
                        if(task.isSuccessful() && task.getResult() != null){
                            goCourse();
                        } else {
                            Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public void goCourse(){
        Intent i = new Intent(MainActivity.this, Course.class);
        startActivity(i);
        finish();
    }

    //Método para el botón de registro: cambia de activity a la pagina registro.
    public void registerAc(View v)
    {
        Intent i = new Intent(this, Register.class);
        startActivity(i);
    }

    //Método para boton de recuperar contraseña
    public void recoveryPass(View v){
        Intent i = new Intent(this, Recovery.class);
        startActivity(i);
    }

}