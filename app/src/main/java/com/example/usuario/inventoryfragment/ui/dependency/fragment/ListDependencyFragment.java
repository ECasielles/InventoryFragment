package com.example.usuario.inventoryfragment.ui.dependency.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.adapter.DependencyAdapter;
import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.base.BaseView;
import com.example.usuario.inventoryfragment.ui.dependency.contract.ListDependencyContract;

import java.util.List;

public class ListDependencyFragment extends ListFragment implements BaseView, ListDependencyContract.View {

    public static final String TAG = "ListDependencyFragment";
    private ListDependencyContract.Presenter presenter;
    private ListDependencyListener callback;
    private DependencyAdapter adapter;
    FloatingActionButton fab;


    public interface ListDependencyListener {
        void addNewDependency(Bundle bundle);
    }

    public ListDependencyFragment(){
        setRetainInstance(true);
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

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Asignamos aquí el adaptador porque en el constructor no podemos porque
        //aún no está creada la activity
        this.adapter = new DependencyAdapter(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_listdependency, container, false);

        //Como se encuentra en el Fragment usamos rootView
        fab = rootView.findViewById(R.id.fab);
        presenter.loadDependencies();

        return rootView;
    }

    /**
     * Asigna el adapter sin datos a la vista.
     * @param view
     * @param savedInstanceState
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //No se puede añadir el adaptador en el onCreateView porque aún no existe la vista
        setListAdapter(adapter);

        //IMPORTANTE: CAE SEGURO
        getListView().setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            /**
             * @param adapterView Lista que hereda de AdapterView
             * @param view Vista que contiene el layout elemento
             * @param position Posición en la lista
             * @param id Id del cursor
             * @return
             */
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                Parcelable parcel = (Parcelable) adapterView.getItemAtPosition(position);
                Bundle bundle = new Bundle();
                bundle.putParcelable(Dependency.TAG, parcel);
                callback.addNewDependency(bundle);
                return false;
            }
        });

        //Si el fab se encontrara en el xml de la Activity
        //FloatingActionButton fab = (FloatingActionButton)getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callback.addNewDependency(null);
            }
        });
    }

    /**
     * Asigna el presentador a la vista
     * @param presenter
     */
    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (ListDependencyContract.Presenter) presenter;
    }

    /**
     * Este método es el que usa la vista para cargar los datos del repositorio
     * a través del esquema MVP
     * @param listDependencyInteractor
     */
    @Override
    public void showDependency(List listDependencyInteractor) {
        //Limpio el adaptador por si hubiera datos anteriores
        adapter.clear();
        adapter.addAll(listDependencyInteractor);
    }

}
