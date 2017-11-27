package com.example.usuario.inventoryfragment.ui.dependency.contract;

import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;

/**
 * Created by usuario on 23/11/17.
 */

public interface AddEditDependencyContract {

    interface View extends BaseView {
        void navigateToListDependency();
        void setNameEmptyError();
        void setShortNameEmptyError();
        void setShortNameLengthError();
        void setDescriptionEmptyError();
        void setValidateDependencyError();
    }

    interface Presenter extends BasePresenter {
        void saveDependency(String name, String shortName, String description);
    }

}
