package com.example.usuario.inventoryfragment.ui.sector;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.widget.Toast;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.adapter.SectorAdapter;
import com.example.usuario.inventoryfragment.data.db.model.Sector;

/**
 * Actividad que maneja el alta de secciones
 *
 * @author Enrique Casielles Lapeira
 * @version 2.0
 * @see android.app.Activity
 * @see AppCompatActivity
 */
public class SectorActivity extends AppCompatActivity {

    private RecyclerView recyclerSector;
    private SectorAdapter sectorAdapter;
    //Si quiero que el listener sea multipropósito
    //en vez de inicializarlo anónimamente, le creo una clase
    //private SectorListener listener;
    private SectorAdapter.OnItemClickListener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sector);
        recyclerSector = findViewById(R.id.rvwSector);
        recyclerSector.setHasFixedSize(true);
        recyclerSector.setLayoutManager(new LinearLayoutManager(this));
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        listener = new SectorAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Sector sector) {
                Toast.makeText(SectorActivity.this, "SectorItemClick: " + sector.getName(), Toast.LENGTH_SHORT).show();
            }
        };

        if(savedInstanceState != null)
            sectorAdapter = new SectorAdapter(listener, savedInstanceState.<Sector>getParcelableArrayList("sector"));
        else
            sectorAdapter = new SectorAdapter(listener);

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

    /*
    //OPCION MULTIPROPOSITO
    class SectorListener implements SectorAdapter.OnItemClickListener, SectorAdapter.OnItemLongClickListener {
        @Override
        public void onItemClick(Sector sector) {
            Toast.makeText(SectorActivity.this, "SectorItemClick: " + sector.getName(), Toast.LENGTH_SHORT).show();
        }
    }
    */

}
