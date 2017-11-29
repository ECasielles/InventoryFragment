package com.example.usuario.inventoryfragment.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by usuario on 13/11/17.
 */
public final class CommonUtils {

    /**
     * Comprueba que la contraseña tenga los siguientes requisitos:
     *  Debe contener al menos un dígito
     *  Debe contener al menos un carácter en mayúsculas
     *  Debe contener al menos un carácter en minúsculas
     *  Debe contener una longitud mínima de 6 caracteres
     * @param password contraseña
     * @return True si la contraseña cumple el patrón.
     */
    public static boolean isPasswordValid(String password){
        Pattern pattern;
        Matcher matcher;
        /**
         * ^               # Inicio de la cadena
         (?=.*[0-9])       # Al menos un dígito
         (?=.*[a-z])       # Al menos una minúscula
         (?=.*[A-Z])       # Al menos una mayúscula
         .{6,20}           # Longitud mínima 6 y máxima 20
         $                 # Fin de la cadena
         */
        final String PASSWORD_PATTERN = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{6,20}$";
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

}
