package com.example.usuario.inventoryfragment.ui.dependency;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditPresenter implements AddEditDependencyContract.Presenter {

    private AddEditDependencyContract.View view;
    public AddEditPresenter(AddEditDependencyContract.View view) {
        this.view = view;
    }

}
