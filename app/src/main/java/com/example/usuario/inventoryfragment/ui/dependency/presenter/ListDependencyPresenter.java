package com.example.usuario.inventoryfragment.ui.dependency.presenter;

import android.os.Bundle;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.ui.dependency.contract.ListDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.ListDependencyInteractor;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.ListDependencyInteractorImpl;

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

    /**
     * Se eliminan las referencias del presentador
     */
    @Override
    public void onDestroy() {
        view = null;
        interactor = null;
    }

}
