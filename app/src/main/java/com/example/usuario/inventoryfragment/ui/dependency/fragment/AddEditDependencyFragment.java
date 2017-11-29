package com.example.usuario.inventoryfragment.ui.dependency.fragment;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.ui.base.BasePresenter;
import com.example.usuario.inventoryfragment.ui.dependency.contract.AddEditDependencyContract;
import com.example.usuario.inventoryfragment.utils.AddEdit;


public class AddEditDependencyFragment extends Fragment implements AddEditDependencyContract.View {

    public static final String TAG = "AddEditDependencyFragment";
    private AddEditDependencyContract.Presenter presenter;
    private AddEditDependencyListener mCallback;
    private FloatingActionButton fab;
    private TextInputLayout tilName, tilShortName, tilDescription;
    private EditText edtName, edtShortName, edtDescription;
    private AddEdit addEditMode;

    public interface AddEditDependencyListener {
        void listDependency();
    }

    public static AddEditDependencyFragment newInstance(Bundle arguments) {
        AddEditDependencyFragment addEditDependencyFragment = new AddEditDependencyFragment();
        if(arguments != null){
            addEditDependencyFragment.setArguments(arguments);
        }
        return addEditDependencyFragment;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mCallback = (AddEditDependencyListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(getActivity().getLocalClassName() + " must implements ListDepedencyListener");
        }
    }

    @SuppressLint("LongLogTag")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_addeditdependency, container, false);

        tilName = rootView.findViewById(R.id.tilName);
        tilShortName = rootView.findViewById(R.id.tilShortName);
        tilDescription = rootView.findViewById(R.id.tilDescription);

        fab = rootView.findViewById(R.id.fab);
        edtName = rootView.findViewById(R.id.edtName);
        edtName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tilShortName = rootView.findViewById(R.id.tilShortName);
        edtShortName = rootView.findViewById(R.id.edtShortName);
        edtShortName.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilShortName.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tilDescription = rootView.findViewById(R.id.tilDescription);
        edtDescription = rootView.findViewById(R.id.edtDescription);
        edtDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                tilDescription.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        //Por defecto está en ADD_MODE
        addEditMode = new AddEdit();
        if(getArguments() != null)
            addEditMode.setMode(AddEdit.EDIT_MODE);

        Log.d(TAG, "onCreateView");
        return rootView;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(addEditMode.getMode() == AddEdit.ADD_MODE)
                    presenter.saveDependency(
                            tilName.getEditText().getText().toString(),
                            tilShortName.getEditText().getText().toString(),
                            tilDescription.getEditText().getText().toString());
                if(addEditMode.getMode() == AddEdit.EDIT_MODE){
                    Dependency dependency = getArguments().getParcelable(Dependency.TAG);
                    presenter.editDependency(dependency, tilDescription.getEditText().getText().toString());
                }
            }
        });
    }

    @Override
    public void setPresenter(BasePresenter presenter) {
        this.presenter = (AddEditDependencyContract.Presenter) presenter;
    }
    @Override
    public void navigateToListDependency() {
        mCallback.listDependency();
    }

    @Override
    public void setNameEmptyError() {
        tilName.setError(getResources().getString(R.string.errorDependencyNameEmptyError));
    }
    @Override
    public void setShortNameEmptyError() {
        tilShortName.setError(getResources().getString(R.string.errorDependencyShortNameEmptyError));
    }
    @Override
    public void setShortNameLengthError() {
        tilShortName.setError(getResources().getString(R.string.errorDependencyShortNameLengthError));
    }
    @Override
    public void setDescriptionEmptyError() {
        tilDescription.setError(getResources().getString(R.string.errorDependencyDescriptionEmptyError));
    }
    @Override
    public void setValidateDependencyError() {

    }
}
