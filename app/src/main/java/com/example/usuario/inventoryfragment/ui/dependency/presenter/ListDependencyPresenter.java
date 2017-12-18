package com.example.usuario.inventoryfragment.ui.dependency.presenter;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.ListDependencyInteractor;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.ListDependencyInteractorImpl;

import java.util.HashMap;
import java.util.List;

/**
 * Created by usuario on 23/11/17.
 */

public class ListDependencyPresenter implements ListDependencyContract.Presenter,
        ListDependencyInteractor.OnLoadFinishedListener {
    public static final String TAG = "ListDependencyPresenter";
    private ListDependencyContract.View view;
    private ListDependencyInteractorImpl interactor;


    public ListDependencyPresenter(ListDependencyContract.View view) {
        this.view = view;
        this.interactor = new ListDependencyInteractorImpl(this);
    }

    /**
     * Carga los datos
     */
    @Override
    public void loadDependencies() {
        //Aquí pondría un progressBar y mensajes
        interactor.loadDependencies();
    }

    @Override
    public void deleteItem(Dependency dependency) {
        interactor.deleteDependency(dependency);
        loadDependencies();
        view.showDeletedMessage();
    }

    /**
     * Es llamado por el interactor cuando el listado de dependencias esté listo.
     * Después avisa a la vista.
     * @param dependencies
     */
    @Override
    public void onSuccess(List<Dependency> dependencies) {
        view.showDependency(dependencies);
    }

    //COMUNICACION CON MENU SELECCION MULTIPLE
    HashMap<Integer, Boolean> selection = new HashMap<>();
    @Override
    public void setNewSelection(int position) {
        selection.put(position, true);
    }
    @Override
    public void removeSelection(int position) {
        selection.remove(position);
    }
    @Override
    public void clearSelection() {
        selection.clear();
    }
    /**
     * Elimina los elementos seleccionados
     */
    @Override
    public void deleteSelection() {
        view.deleteMultipleSelection(selection);
    }
    /**
     * Comprueba si el elemento existe en la selección múltiple.
     * @param position
     * @return
     */
    @Override
    public boolean getPositionChecked(int position) {
        return selection.containsKey(position);
    }

    /**
     * Se eliminan las referencias del presentador
     */
    @Override
    public void onDestroy() {
        view = null;
        interactor = null;
    }

}
