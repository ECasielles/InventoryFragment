package com.example.usuario.inventoryfragment.ui.dependency;

import android.app.Fragment;

public class DetailDependency extends Fragment implements DetailDependencyContract.View {

    public static final String TAG = "detaildependency";
    private DetailDependencyContract.Presenter presenter;


    @Override
    public void setPresenter(DetailDependencyContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
