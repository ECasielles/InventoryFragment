package com.example.usuario.inventoryfragment.ui.dependency;

/**
 * Created by usuario on 23/11/17.
 */
public class DetailPresenter implements DetailDependencyContract.Presenter {
    DetailDependencyContract.View view;

    public DetailPresenter(DetailDependencyContract.View view) {
        this.view = view;
    }
}
