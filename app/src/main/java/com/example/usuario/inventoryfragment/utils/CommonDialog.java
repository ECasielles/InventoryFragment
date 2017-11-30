package com.example.usuario.inventoryfragment.utils;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.ui.dependency.contract.ListDependencyContract;

/**
 * Created by usuario on 30/11/17.
 */

public class CommonDialog {
    public static final String MESSAGE = "message";
    public static final String TITLE = "title";

    /**
     * Cuadro de diálogo genérico que sirve para cualquier Fragment o Presenter.
     * @param bundle
     * @param context
     * @param presenter
     * @return
     */
    public static Dialog showConfirmDialog(final Bundle bundle, Context context, final ListDependencyContract.Presenter presenter){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(bundle.getString(CommonDialog.MESSAGE))
                .setTitle(bundle.getString(CommonDialog.TITLE))
                .setPositiveButton(R.string.btnOk, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //NOS PASAMOS POR EL FORRO EL MVPI
                        presenter.deleteItem((Dependency) bundle.getParcelable(Dependency.TAG));
                    }
                })
                .setNegativeButton(R.string.btnCancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Usamos cancel en lugar de dismiss, porque dismiss no elimina
                        dialogInterface.cancel();
                    }
                });
        return builder.create();
    }

}
