package com.example.gestiondeschauffeurs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class activity_connexion extends AppCompatActivity {
    private EditText email,password;
    private Button button;
    private static final String TAG="Connexion";
    private FirebaseAuth mAuth;
    private FirebaseAuth.AuthStateListener mAuthListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

       email=findViewById(R.id.email);
       password=findViewById(R.id.mp);
       button=findViewById(R.id.button);

        mAuth = FirebaseAuth.getInstance();

        mAuthListener = new FirebaseAuth.AuthStateListener(){
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth){
                FirebaseUser user= firebaseAuth.getCurrentUser();
                if (user != null) {
                    Log.d(TAG, "onAuthStateChanged:signed_in"+ user.getUid());

                } else{
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
            }
        };

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sauthentifier("anna@yahoo.fr","lililili");
            }
        });


    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        mAuth.addAuthStateListener(mAuthListener);
    }

    @Override
    public void onStop() {
       super.onStop();
       if(mAuthListener != null) {
           mAuth.removeAuthStateListener(mAuthListener);
       }
    }

public void sauthentifier(String email, String password){
    mAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                        Log.d(TAG, "createUserWithEmail:success"+task.isSuccessful());

                        Toast.makeText(activity_connexion.this, "Authentication reussie.",
                                Toast.LENGTH_SHORT).show();


                        if(!task.isSuccessful()) {
                            Toast.makeText(activity_connexion.this, "Authentication echouée.",
                                    Toast.LENGTH_SHORT).show();
                        }
                        }


                    // ...
                });


}

    public void page3(View view)
    {
        startActivity(new Intent(this, activity_profil.class));
    }


}
