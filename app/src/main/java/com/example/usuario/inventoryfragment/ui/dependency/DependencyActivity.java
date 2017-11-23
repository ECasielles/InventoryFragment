package com.example.usuario.inventoryfragment.ui.dependency;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
//Cuidado con qué librería usamos para Toolbar
import android.support.v7.widget.Toolbar;


import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.adapter.DependencyAdapter;
import com.example.usuario.inventoryfragment.data.db.model.Dependency;

/**
 * Contiene una lista que se maneja con un Adapter personalizado
 * que contiene distintas dependencias de tipo Dependency
 *
 * @author Enrique Casielles
 * @version 2.0
 * @see ListActivity
 * @see ArrayAdapter
 * @see Dependency
 */
//Las activity ya no heredarán de ListActivity, sino de ListFragment
public class DependencyActivity extends AppCompatActivity {

    //private ArrayAdapter<Dependency> adapter;
    private DependencyAdapter adapter;
    private ListView listView;
    private FloatingActionButton fab;
    private CoordinatorLayout coordinatorLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinator);

        adapter = new DependencyAdapter(this);
        //Con android.R.id.list sigo pudiendo acceder al id genérico
        listView = (ListView) findViewById(android.R.id.list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        fab = (FloatingActionButton) findViewById(R.id.fab);

        //Así asignamos la Toolbar a la vista
        setSupportActionBar(toolbar);
        adapter = new DependencyAdapter(this);
        listView.setAdapter(adapter);

        //Al pulsar sobre el botón se visualizará el SnackBar y Fab se desplazará
        //hacia arriba.
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Al pulsar sobre el botón flotante se va a desplazar por el Snackbar
                //Podríamos usar listView directamente en lugar de coordinator pero no se recomienda
                //Snackbar.make(coordinatorLayout, "Ejemplo Snackbar", Snackbar.LENGTH_SHORT).show();

                startActivity(new Intent(DependencyActivity.this, AddDependencyActivity.class));
            }
        });

    }
}
