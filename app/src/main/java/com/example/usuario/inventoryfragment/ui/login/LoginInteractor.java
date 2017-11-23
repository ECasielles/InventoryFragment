package com.example.usuario.inventoryfragment.ui.login;

/**
 * Interfaz del interactor de la vista Login. Contiene
 * la interfaz OnLoginFinishedListener
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 *
 */

public interface LoginInteractor {

    void validateCredentials(String user, String password);

    interface OnLoginFinishedListener {
        void onUserEmptyError();
        void onPasswordEmptyError();
        void ontPasswordError();
        void onSuccess();
    }
}
