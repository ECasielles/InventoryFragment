package com.example.usuario.inventoryfragment.ui.dependency.contract;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;
import com.example.usuario.inventoryfragment.ui.dependency.interactor.ListDependencyInteractor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

/**
 * Aglutina distintas interfaces
 */
public interface ListDependencyContract {

    interface View extends BaseView {
        void showDependency(List listDependencyInteractor);
        void showDeletedMessage();
        void showMessage(String message);

        void deleteMultipleSelection(HashMap<Integer, Boolean> selection);
    }

    interface Presenter extends BasePresenter, Serializable {
        void loadDependencies();

        void deleteItem(Dependency parcelable);

        @Override
        void onDestroy();

        void setNewSelection(int position);
        void removeSelection(int position);
        void deleteSelection();
        void clearSelection();
        boolean getPositionChecked(int position);
    }

}
