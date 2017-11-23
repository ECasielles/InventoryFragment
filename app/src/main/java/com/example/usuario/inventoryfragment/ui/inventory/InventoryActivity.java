package com.example.usuario.inventoryfragment.ui.inventory;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.usuario.inventoryfragment.R;

/**
 * Actividad que maneja un inventario.
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 * @see android.app.Activity
 * @see AppCompatActivity
 */
public class InventoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inventory);
    }
}
