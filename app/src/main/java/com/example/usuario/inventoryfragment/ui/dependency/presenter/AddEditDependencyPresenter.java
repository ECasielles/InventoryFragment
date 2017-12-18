package com.example.usuario.inventoryfragment.ui.dependency.presenter;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.AddEditDependencyInteractor;
import com.example.usuario.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.AddEditDependencyInteractorImpl;

/**
 * Created by usuario on 23/11/17.
 */

public class AddEditDependencyPresenter implements AddEditDependencyContract.Presenter,
        AddEditDependencyInteractor.OnAddEditFinishedListener {
    public static final String TAG = "AddEditDependencyPresenter";
    private AddEditDependencyContract.View view;
    private AddEditDependencyInteractorImpl interactor;


    public AddEditDependencyPresenter(AddEditDependencyContract.View view) {
        this.view = view;
        this.interactor = new AddEditDependencyInteractorImpl(this);
    }

    @Override
    public void saveDependency(String name, String shortname, String description) {
        interactor.validateDependency(name, shortname, description);
    }

    @Override
    public void editDependency(Dependency dependency, String description) {
        interactor.editDependency(dependency, description);
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

    /**
     * Se llama cuando se destruya la Activity
     */
    @Override
    public void onDestroy() {
        view = null;
        interactor = null;
    }
}
