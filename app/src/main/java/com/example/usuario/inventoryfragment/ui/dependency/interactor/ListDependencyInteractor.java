package com.example.usuario.inventoryfragment.ui.dependency.interactor;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;

import java.util.List;

/**
 * Created by usuario on 27/11/17.
 */

public interface ListDependencyInteractor {

    interface OnLoadFinishedListener {
        void onSuccess(List<Dependency> dependencies);
    }

    void loadDependencies();
}
