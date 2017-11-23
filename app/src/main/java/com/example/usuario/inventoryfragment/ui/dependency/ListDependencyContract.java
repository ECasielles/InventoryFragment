package com.example.usuario.inventoryfragment.ui.dependency;

/**
 * Aglutina distintas interfaces
 */
public interface ListDependencyContract {

    interface View {
        void setPresenter(ListDependencyContract.Presenter presenter);
    }

    interface Presenter {

    }
}
