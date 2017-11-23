package com.example.usuario.inventoryfragment.ui.dependency;

/**
 * Created by usuario on 23/11/17.
 */
public class ListPresenter implements ListDependencyContract.Presenter {
    ListDependencyContract.View view;

    public ListPresenter(ListDependencyContract.View view) {
        this.view = view;
    }

}
