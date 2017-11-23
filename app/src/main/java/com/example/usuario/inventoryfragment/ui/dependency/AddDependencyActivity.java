package com.example.usuario.inventoryfragment.ui.dependency;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.usuario.inventoryfragment.R;

/**
 * Añade nuevas dependencias al repositorio de dependencias
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 * @see AppCompatActivity
 */
public class AddDependencyActivity extends AppCompatActivity {

    private FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_dependency);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //VALIDA LOS DATOS
                //AGREGA A REPOSITORY
            }
        });
    }


}
