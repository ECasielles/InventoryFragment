package com.example.usuario.inventoryfragment.ui.dependency.contract;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;

import java.io.Serializable;
import java.util.List;

/**
 * Aglutina distintas interfaces
 */
public interface ListDependencyContract {

    interface View extends BaseView {
        void showDependency(List listDependencyInteractor);

        Dependency getDependency(int position);

        void showDeletedMessage();
        void showMessage(String message);

    }

    interface Presenter extends BasePresenter, Serializable {
        void loadDependencies();

        void deleteDependency(Dependency parcelable);

        @Override
        void onDestroy();

        void setNewSelection(int position);
        void removeSelection(int position);
        void deleteSelection();
        void clearSelection();
        boolean getPositionChecked(int position);

    }

}
