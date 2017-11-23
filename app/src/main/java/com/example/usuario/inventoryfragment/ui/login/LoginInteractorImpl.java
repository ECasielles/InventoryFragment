package com.example.usuario.inventoryfragment.ui.login;

import android.text.TextUtils;

import com.example.usuario.inventoryfragment.data.db.repository.UserRepository;
import com.example.usuario.inventoryfragment.utils.CommonUtils;

/**
 * Clase interactor del presentador de la vista Login.
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 * @see LoginInteractor
 * @see LoginInteractor.OnLoginFinishedListener
 *
 */
public class LoginInteractorImpl {

    //Las clases interactor no tienen contrato con nadie, se les pasa
    //por parámetro una interfaz
    public void validateCredentials(String user, String password,
                                    LoginInteractor.OnLoginFinishedListener onLoginFinishedListener) {
        //Realiza todas las comprobaciones
        if (TextUtils.isEmpty(password))
            onLoginFinishedListener.onPasswordEmptyError();
        else if (TextUtils.isEmpty(user))
            onLoginFinishedListener.onUserEmptyError();
        else if (!CommonUtils.isPasswordValid(password))
            onLoginFinishedListener.ontPasswordError();
        else if (UserRepository.getInstance().validateCredentials(user, password))
            onLoginFinishedListener.onSuccess();
    }
}
