package com.example.usuario.inventoryfragment.ui.login;

/**
 * Contrato de la clase Presentador de las vistas Login
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 */
public interface LoginPresenter {

    void validateCredentials(String user, String password);

    void onDestroy();
}
