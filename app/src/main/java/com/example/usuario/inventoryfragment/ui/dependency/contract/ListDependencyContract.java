package com.example.usuario.inventoryfragment.ui.dependency.contract;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.ListDependencyInteractor;

import java.util.List;

/**
 * Aglutina distintas interfaces
 */
public interface ListDependencyContract {

    interface View extends BaseView {
        void showDependency(List listDependencyInteractor);
    }

    interface Presenter extends BasePresenter {
        void loadDependencies();

        void deleteItem(Dependency parcelable);
    }

}
