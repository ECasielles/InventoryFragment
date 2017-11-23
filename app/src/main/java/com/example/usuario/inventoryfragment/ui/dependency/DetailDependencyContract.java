package com.example.usuario.inventoryfragment.ui.dependency;

/**
 * Created by usuario on 23/11/17.
 */

interface DetailDependencyContract {
    interface View {
        void setPresenter(DetailDependencyContract.Presenter presenter);
    }
    interface Presenter {

    }
}
