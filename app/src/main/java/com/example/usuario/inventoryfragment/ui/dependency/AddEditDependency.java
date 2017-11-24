package com.example.usuario.inventoryfragment.ui.dependency;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.ui.base.BaseFragment;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;


public class AddEditDependency extends BaseFragment implements AddEditDependencyContract.View {

    public static final String TAG = "addeditdependency";
    private BasePresenter presenter;
    private TextInputLayout tilName, tilShortname, tilDescription;
    //falta callback

    public static AddEditDependency newInstance(Bundle arguments) {
        AddEditDependency addEditDependency = new AddEditDependency();
        if(arguments != null){
            addEditDependency.setArguments(arguments);
        }
        return addEditDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_addeditdependency, container, false);

        tilName = rootView.findViewById(R.id.tilName);
        tilShortname = rootView.findViewById(R.id.tilShortName);
        tilDescription = rootView.findViewById(R.id.tilDescription);

        FloatingActionButton fab = rootView.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                presenter.validateDependency(
                        tilName.getEditText().toString(),
                        tilShortname.getEditText().toString(),
                        tilDescription.getEditText().toString(),
                        this
                );
            }
        });
        if(getArguments() != null) {
        }
        Log.d(TAG, "onCreateView");
        return rootView;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = presenter;
    }

    //Si es correcto muestro el listado de Dependencias
    @Override
    public void showListDependency() {

    }
    @Override
    public void showDescriptionError() {
        tilDescription.setError(getResources().getString(R.string.errorDescription));
    }
    @Override
    public void showNameError() {
        tilName.setError(getResources().getString(R.string.errorShortname));
    }
    @Override
    public void showShortNameError() {
        tilName.setError(getResources().getString(R.string.errorName));
    }
    @Override
    public void showDependencyDuplicated() {
        showMessage(getResources().getString(R.string.errorDependencyDuplicate));
    }
    @Override
    public void onSuccess() {
    }


}
