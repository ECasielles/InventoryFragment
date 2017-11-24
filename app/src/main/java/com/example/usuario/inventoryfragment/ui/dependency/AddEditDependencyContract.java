package com.example.usuario.inventoryfragment.ui.dependency;

import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */
public interface AddEditDependencyContract {

    interface View extends BaseView {
        void showListDependency();
        void showDescriptionError();
        void showNameError();
        void showShortNameError();
        void showDependencyDuplicated();
        void onSuccess();
    }

    interface Presenter extends BasePresenter {

    }

}
