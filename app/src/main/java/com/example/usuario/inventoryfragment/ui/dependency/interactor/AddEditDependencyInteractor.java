package com.example.usuario.inventoryfragment.ui.dependency.interactor;

/**
 * Created by usuario on 24/11/17.
 */

public interface AddEditDependencyInteractor {

    interface OnAddeditFinishedListener {
        void onNameEmptyError();
        void onShortNameEmptyError();
        void onShortNameLengthError();
        void onDescriptionEmptyError();
        void onSuccess(String name, String shortname, String description);
    }

    void validateDependency(String name, String shortname, String description, OnAddeditFinishedListener listener);

    void addDependency(String name, String sortname, String description);
}
