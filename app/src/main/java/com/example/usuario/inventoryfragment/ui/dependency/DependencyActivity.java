package com.example.usuario.inventoryfragment.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.ui.base.BaseActivity;


/**
 * Actividad contenedora de las dependencias.
 *
 * @author Enrique Casielles Lapeira
 * @version 2.0
 * @see com.example.usuario.inventoryfragment.ui.base.BaseActivity
 * @see ListPresenter
 */
//Como la actividad es contenedor y nunca se pasa como parámetro
//no implementará una interfaz
public class DependencyActivity extends BaseActivity implements ListDependency.ListDependencyListener {

    //La actividad inicializa cada fragment con su presentador
    private ListDependency listDependency;
    private ListPresenter listPresenter;

    private AddEditDependency addeditDependency;
    private AddEditPresenter addEditPresenter;

    private Fragment detailDependency;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dependency);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //1.- Se crea la vista
        listDependency = (ListDependency) fragmentManager.findFragmentByTag(ListDependency.TAG);
        if (listDependency == null){
            listDependency = (ListDependency) ListDependency.newInstance(null);
            fragmentTransaction.add(android.R.id.content, listDependency, ListDependency.TAG);
            fragmentTransaction.commit();
        }
        //2.- Se crea el presentador, y se le pasa en el constructor la vista correspondiente
        listPresenter = new ListPresenter(listDependency);

        //3.- Si fuera necesario, se asigan el presentador a su fragment
        listDependency.setPresenter(listPresenter);

    }

    /**
     * Método que se ejecuta cuando se crea una nueva Dependencia
     */
    @Override
    public void addNewDependency() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        //1.- Se crea la vista
        addeditDependency = (AddEditDependency) fragmentManager.findFragmentByTag(AddEditDependency.TAG);
        if (addeditDependency == null){
            addeditDependency = AddEditDependency.newInstance(null);
            fragmentTransaction.replace(android.R.id.content, addeditDependency, AddEditDependency.TAG);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();
        }
        //2.- Se crea el presentador, y se le pasa en el constructor la vista correspondiente
        addEditPresenter = new AddEditPresenter(addeditDependency);

        //3.- Si fuera necesario, se asigan el presentador a su fragment
        addeditDependency.setPresenter(addEditPresenter);
    }
}
