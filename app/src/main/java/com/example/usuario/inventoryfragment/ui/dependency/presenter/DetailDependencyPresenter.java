package com.example.usuario.inventoryfragment.ui.dependency.presenter;

import com.example.usuario.inventoryfragment.ui.dependency.contract.DetailDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class DetailDependencyPresenter implements DetailDependencyContract.Presenter {
    private DetailDependencyContract.View view;

    public DetailDependencyPresenter(DetailDependencyContract.View view) {
        this.view = view;
    }


}
