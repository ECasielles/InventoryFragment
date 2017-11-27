package com.example.usuario.inventoryfragment.ui.dependency.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.adapter.DependencyAdapter;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;
import com.example.usuario.inventoryfragment.ui.dependency.contract.ListDependencyContract;

public class ListDependencyFragment extends ListFragment implements BaseView, ListDependencyContract.View {

    public static final String TAG = "listdependency";
    private ListDependencyContract.Presenter presenter;
    private ListDependencyListener callback;

    public interface ListDependencyListener {
        void addNewDependency();
    }

    public static ListDependencyFragment newInstance(Bundle arguments) {
        ListDependencyFragment listDependencyFragment = new ListDependencyFragment();
        if(arguments != null) {
            listDependencyFragment.setArguments(arguments);
        }
        return listDependencyFragment;
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
