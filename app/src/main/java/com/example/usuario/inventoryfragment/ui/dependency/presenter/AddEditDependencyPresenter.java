package com.example.usuario.inventoryfragment.ui.dependency.presenter;

import com.example.usuario.inventoryfragment.ui.dependency.AddEditDependencyInteractor;
import com.example.usuario.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyPresenter implements AddEditDependencyContract.Presenter,
        AddEditDependencyContract.Interactor.OnAddeditFinishedListener {
    private AddEditDependencyContract.View view;
    private AddEditDependencyContract.Interactor interactor;


    public AddEditDependencyPresenter(AddEditDependencyContract.View view) {
        this.view = view;
        this.interactor = new AddEditDependencyInteractor();
    }

    @Override
    public void saveDependency(String name, String sortname, String description) {
        interactor.validateDependecy(name, sortname, description, this);
    }

    @Override
    public void onNameEmptyError() {
        view.setNameEmptyError();
    }


    @Override
    public void onShortNameEmptyError() {
        view.setShortNameEmptyError();
    }


    @Override
    public void onShortNameLengthError() {
        view.setShortNameLengthError();
    }


    @Override
    public void onDescriptionEmptyError() {
        view.setDescriptionEmptyError();
    }


    @Override
    public void onSuccess(String name, String shortname, String description) {
        interactor.addDependency(name, shortname, description);
        view.navigateToListDependency();
    }

}
