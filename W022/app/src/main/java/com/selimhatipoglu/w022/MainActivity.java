package com.selimhatipoglu.w022;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.selimhatipoglu.w022.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private FirebaseAuth Auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Auth = FirebaseAuth.getInstance();

        FirebaseUser user =Auth.getCurrentUser();
        if (user != null){
            Intent intent = new Intent(MainActivity.this,fragment.class);
            startActivity(intent);
            finish();
        }
    }


    public void signinClicked(View view) {

        String email = binding.emailtext.getText().toString();
        String password = binding.textpassword.getText().toString();

        if (email.equals("") || password.equals("")){
            Toast.makeText(this, "Enter Password and Email", Toast.LENGTH_SHORT).show();
        }
        else{
            Auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent intent = new Intent(MainActivity.this,fragment.class);
                    startActivity(intent);
                    finish();

                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this,e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }


    }

    public void signupClicked(View view) {

        String email = binding.emailtext.getText().toString();
        String password =binding.textpassword.getText().toString();

        if (email.equals("") || email.equals("")){
            Toast.makeText(this, "Enter Email and Password", Toast.LENGTH_SHORT).show();
        }
        else{
            Auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                @Override
                public void onSuccess(AuthResult authResult) {
                    Intent intent = new Intent(MainActivity.this,fragment.class);
                    startActivity(intent);
                    finish();
                }
            }).addOnFailureListener(new OnFailureListener() {
                @Override
                public void onFailure(@NonNull Exception e) {
                    Toast.makeText(MainActivity.this, e.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            });
        }

    }
}