package com.example.gestiondeschauffeurs;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import static android.app.ProgressDialog.show;

public class Inscription extends AppCompatActivity {

    EditText znom,zprenom,zemail,zpassword,zadresse,ztelephone;
    Button sinscrire;
    TextView inscription;
    FirebaseAuth fAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inscription);

        znom=findViewById(R.id.nom);
        zprenom=findViewById(R.id.prenom);
        zemail=findViewById(R.id.email);
        zpassword =findViewById(R.id.mp);
        zadresse=findViewById(R.id.adresse);
        ztelephone=findViewById(R.id.telephone);
        sinscrire=findViewById(R.id.inscrire);
         inscription=findViewById(R.id.textView2);
         fAuth=FirebaseAuth.getInstance();

         if(fAuth.getCurrentUser() !=null){
             startActivity(new Intent(getApplicationContext(),activity_connexion.class));
             finish();
         }

         sinscrire.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 String email=zemail.getText().toString().trim();
                 String password=zpassword.getText().toString().trim();

                 if (TextUtils.isEmpty(email)){
                     zemail.setError("email is required");
                 }

                 if (TextUtils.isEmpty(password)){
                     zpassword.setError("password is required");
                 }

                 if (password.length()<6){
                     zemail.setError("password must be >6");
                 }

      //register the user in firebase

               /*  fAuth.createUserWithEmailAndPassword(email, password)
                         .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                             @Override
                             public void onComplete(@NonNull Task<AuthResult> task) {


                                 if(task.isSuccessful()) {
                                     Toast.makeText(Inscription.this, "user created.",
                                             Toast.LENGTH_SHORT).show();
                                     startActivity(new Intent(getApplicationContext(),activity_connexion.class));
                                 }else{
                                     Toast.makeText(Inscription.this, task.getException().getMessage() , " error !",
                                             Toast.LENGTH_SHORT).show();
                                 }
                             }



                         }); */

             }
         });
    }

    public void page2(View view)
    {
        startActivity(new Intent(this, activity_connexion.class));
    }

}
