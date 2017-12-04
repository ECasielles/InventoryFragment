package com.example.usuario.inventoryfragment.ui.inventory;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.data.prefs.AppPreferencesHelper;

import java.util.ArrayList;

/**
 * Clase singleton (hereda de Application) que contiene los datos.
 * Inicializa la instancia de preferencias.
 *
 * @author Enrique Casielles
 * @version 2.0
 * @see android.app.Application
 * @see AppPreferencesHelper
 */
public class InventoryApplication extends Application {

    public static final String PREF_NAME = "preferences";

    private AppPreferencesHelper appPreferencesHelper;
    private static InventoryApplication context;

    public InventoryApplication() {
        context = this;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appPreferencesHelper = AppPreferencesHelper.getInstance();
    }

    public AppPreferencesHelper getAppPreferencesHelper() {
        return appPreferencesHelper;
    }

    public static InventoryApplication getContext() {
        return context;
    }

}
