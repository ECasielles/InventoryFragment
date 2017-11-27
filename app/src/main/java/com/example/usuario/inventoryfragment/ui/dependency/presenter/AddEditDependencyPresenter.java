package com.example.usuario.inventoryfragment.ui.dependency.presenter;

import com.example.usuario.inventoryfragment.ui.dependency.interactor.AddEditDependencyInteractor;
import com.example.usuario.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.AddEditDependencyInteractorImpl;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyPresenter implements AddEditDependencyContract.Presenter,
        AddEditDependencyInteractor.OnAddeditFinishedListener {
    private AddEditDependencyContract.View view;
    private AddEditDependencyInteractorImpl interactor;


    public AddEditDependencyPresenter(AddEditDependencyContract.View view) {
        this.view = view;
        this.interactor = new AddEditDependencyInteractorImpl();
    }

    @Override
    public void saveDependency(String name, String sortname, String description) {
        interactor.validateDependency(name, sortname, description, this);
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
