package com.example.usuario.inventoryfragment.ui.sector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.adapter.SectorAdapter;
import com.example.usuario.inventoryfragment.data.db.model.Sector;

/**
 * Actividad que maneja el alta de secciones
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 * @see android.app.Activity
 * @see AppCompatActivity
 */
public class SectorActivity extends AppCompatActivity {

    private RecyclerView recyclerSector;
    private SectorAdapter sectorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);
        recyclerSector = (RecyclerView) findViewById(R.id.rvwSector);
        recyclerSector.setHasFixedSize(true);
        recyclerSector.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        if(savedInstanceState != null)
            sectorAdapter = new SectorAdapter(savedInstanceState.<Sector>getParcelableArrayList("sector"));
        else
            sectorAdapter = new SectorAdapter();

        recyclerSector.setAdapter(sectorAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_activity_sector, menu);
        //En algunos casos devuelve true directamente porque es igual
        return super.onCreateOptionsMenu(menu);
    }

    /**
     * Almacena los sectores que se han modificado en la vista y no han sido guardados
     * para visualizar el estado correcto en onCreate().
     * @param outState
     */
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putParcelableArrayList("sector", sectorAdapter.getModifiedSectors());
    }

}
