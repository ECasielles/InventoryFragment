package com.example.usuario.inventoryfragment.ui.dependency.interactor;

import com.example.usuario.inventoryfragment.data.db.repository.DependencyRepository;

/**
 * Created by usuario on 27/11/17.
 */

public class ListDependencyInteractorImpl implements ListDependencyInteractor {

    private final OnLoadFinishedListener listener;

    public ListDependencyInteractorImpl(OnLoadFinishedListener listener) {
        this.listener = listener;
    }

    public void loadDependencies(){
        listener.onSuccess(DependencyRepository.getInstance().getDependencies());
    }
}
