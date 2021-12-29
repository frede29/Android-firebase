package com.example.gestiondeschauffeurs;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void page1(View view)
    {
        startActivity(new Intent(this, Inscription.class));
    }


    public void page2(View view)
    {
        startActivity(new Intent(this, activity_connexion.class));
    }
}
