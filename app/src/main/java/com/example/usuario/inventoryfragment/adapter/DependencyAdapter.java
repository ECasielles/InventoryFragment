package com.example.usuario.inventoryfragment.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.usuario.inventoryfragment.R;
import com.example.usuario.inventoryfragment.data.db.model.Dependency;
import com.example.usuario.inventoryfragment.data.db.repository.DependencyRepository;
import com.github.ivbaranov.mli.MaterialLetterIcon;

import java.util.ArrayList;

/**
 * Clase Adapter que maneja dependencias
 *
 * @author Enrique Casielles Lapeira
 * @version 2.0
 * @see ArrayList
 * @see ArrayAdapter
 * @see Dependency
 * @see DependencyRepository
 */
public class DependencyAdapter extends ArrayAdapter<Dependency>{
    /**
     * Constructor de DependencyAdapter. Se crea una copia del ArrayList de
     * DependencyRepository para que la copia local del Adapter se pueda modificar
     * sin modificar el repositorio.
     * @param context Contexto de la actividad.
     */
    public DependencyAdapter(@NonNull Context context) {
        super(context, R.layout.item_dependency, DependencyRepository.getInstance().getDependencies());
        //Ordena por nombre corto usando Comparator
        //Al heredar de lista, se puede llamar directamente al método sort
        //y evita usar notifyDatasetChanged() cuando cambien los datos porque
        //ya está sincronizado con la copia local (patrón OO interno). En Internet no
        //suele haber ejemplos como este.
        sort(new Dependency.DependencyOrderByShortName());
    }

    /**
     * Construye e infla la vista de cada elemento del ArrayList
     *
     * @param position Posición del elemento
     * @param convertView Objeto View que reutilizar cuando haya desplazamiento
     * @param parent Layout contenedor del elemento
     * @return
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        DependencyHolder dependencyHolder;
        View view = convertView;

        //Se realiza las N primeras veces por cada elemento hasta que el N-ésimo llene la pantalla
        if(convertView == null) {
            //1. Obtener el servicio del sistema en el contexto con LayoutInflater
            //De esta forma accedo directamente al servicio específico
            //LayoutInflater inflater = LayoutInflater.from(getContext());

            //Forma no recomendada, porque se obliga al contexto a venir de una actividad
            //LayoutInflater inflater = ((Activity) getContext()).getLayoutInflater();

            //Accede de forma genérica al servicio del sistema para que infle la vista del objeto vista
            LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);


            //2. Inflar la vista. Crea en memoria el objeto View con todos los widget de item_dependency.xml
            //Con null indica que no hay que introducirlo en un nuevo padre
            view = inflater.inflate(R.layout.item_dependency, null);
            dependencyHolder = new DependencyHolder();


            //3. Inicializar las variables a los objetos ya creados de los widget del xml.
            dependencyHolder.mliIcon = (MaterialLetterIcon) view.findViewById(R.id.mliIcon);
            dependencyHolder.txvName = (TextView) view.findViewById(R.id.txvElementName);
            dependencyHolder.txvShortName = (TextView) view.findViewById(R.id.txvElementShortName);


            //3.5. Guardar la referencia del objeto como Tag.
            //El Tag es un objeto comodín donde guardo la referencia al objeto
            //De esta forma no se pierde tampoco la referencia a cada objeto creado
            view.setTag(dependencyHolder);

        } else {
            dependencyHolder = (DependencyHolder) view.getTag();
        }

        //4. Mostrar los datos del ArrayList mediante position.
        dependencyHolder.mliIcon.setLetter(getItem(position).getShortname().substring(0, 1));
        dependencyHolder.txvName.setText(getItem(position).getName());
        dependencyHolder.txvShortName.setText(getItem(position).getShortname());

        return view;
    }

    class DependencyHolder {
        MaterialLetterIcon mliIcon;
        TextView txvName, txvShortName;
    }

}
