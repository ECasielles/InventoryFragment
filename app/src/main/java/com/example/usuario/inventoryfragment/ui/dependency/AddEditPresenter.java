package com.example.usuario.inventoryfragment.ui.dependency;

import com.example.usuario.inventoryfragment.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditPresenter implements AddEditDependencyContract.Presenter {
    private AddEditDependencyContract.View view;

    public AddEditPresenter(AddEditDependencyContract.View view) {
        this.view = view;
    }

    @Override
    public void validateDependency() {

    }

}
