package com.example.usuario.inventoryfragment.ui.dependency;

import android.app.Fragment;

import com.example.usuario.inventoryfragment.ui.base.BasePresenter;

public class DetailDependency extends Fragment implements DetailDependencyContract.View {

    public static final String TAG = "detaildependency";
    private DetailDependencyContract.Presenter presenter;

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (DetailDependencyContract.Presenter) presenter;
    }
}
