package com.example.usuario.inventoryfragment.ui.dependency;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.adapter.DependencyAdapter;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;

public class ListDependency extends ListFragment implements BaseView, ListDependencyContract.View {

    public static final String TAG = "listdependency";
    private BasePresenter presenter;
    private ListDependencyListener callback;

    interface ListDependencyListener {
        void addNewDependency();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            callback = (ListDependencyListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() +
                    " must implement ListDependencyListener");
        }
    }

    public static ListDependency newInstance(Bundle arguments) {
        ListDependency listDependency = new ListDependency();
        if(arguments != null) {
            listDependency.setArguments(arguments);
        }
        return listDependency;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_listdependency, container, false);
        //Como se encuentra en el Fragment usamos rootView
        FloatingActionButton floatingActionButton = rootView.findViewById(R.id.fab);
        //Si el floatingActionButton se encontrara en el xml de la Activity
        //FloatingActionButton floatingActionButton = (FloatingActionButton)getActivity().findViewById(R.id.fab);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.addNewDependency();
            }
        });
        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setListAdapter(new DependencyAdapter(getActivity()));
    }


    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListDependencyContract.Presenter) presenter;
    }

}
