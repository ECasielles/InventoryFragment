package com.example.usuario.inventoryfragment.data.db.repository;

import com.example.usuario.inventoryfragment.data.db.model.Dependency;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

/**
 * Clase repositorio que genera los datos Dependency
 * como ArrayList de objetos Dependency
 * con un elemento único gracias al patrón singleton que
 * garantiza que la instancia de datos sea única y pública
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 * @see ArrayList
 * @see Dependency
 */

public class DependencyRepository {

    /*DECLARACIÓN*/
    private ArrayList<Dependency> dependencies;
    private static DependencyRepository dependencyRepository;

    /*INICIALIZACIÓN*/
    //De esta forma inicializa los atributos de ámbito estático o de clase
    //Es la forma alternativa aunque puede ser costoso y se puede evitar
    static {
        dependencyRepository = new DependencyRepository();
    }
    /**
     * Constructor privado que garantiza una instancia única de la clase
     */
    private DependencyRepository() {
        this.dependencies = new ArrayList<>();
        initialize();
    }

    /*MÉTODOS*/

    /**
     * Inicializa la estructura de datos DependencyRepository
     */
    private void initialize() {
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "aaa", "1CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "bbb", "2CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "ccc", "1CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "ddd", "2CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "eee", "1CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "fff", "2CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "ggg", "1CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "hhh", "2CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "iii", "1CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "AAA", "2CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "BBB", "1CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "111", "2CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "222", "1CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "333", "2CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "%%%", "1CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "$$$", "2CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(1, "1º Ciclo Formativo Grado Superior",
                "===", "1CFGS Desarrollo de Aplicaciones Multiplataforma"));
        addDependency(new Dependency(2, "2º Ciclo Formativo Grado Superior",
                "???", "2CFGS Desarrollo de Aplicaciones Multiplataforma"));
    }
    /**
     * Accesor de la clase DependencyRepository
     * @return Devuelve la instancia de la clase como objeto DependencyRepository
     */
    public static DependencyRepository getInstance(){
        //Nunca va a valer null si no se hace inicialización estática
        if (dependencyRepository == null)
            dependencyRepository = new DependencyRepository();
        return dependencyRepository;
    }
    /**
     * Método que añade una dependencia
     * @param dependency Dependencia de clase Dependency
     */
    public void addDependency(Dependency dependency) {
        dependency.set_ID(dependencies.size());
        dependencies.add(dependency);
    }
    /**
     * Devuelve la referencia al objeto
     * @return referencia al objeto ArrayList
     */
    public ArrayList<Dependency> getDependencies() {
        //Devuelve el arrayList ordenado usando el Comparable
        Collections.sort(dependencies);
        //Si quiero que sort use Comparator, se lo paso por segundo parámetro
        Collections.sort(dependencies, new Dependency.DependencyOrderByShortName());
        return dependencies;
    }

    public void editDependency(Dependency dependency, String description) {
        for (Dependency tempDependency : dependencies)
            if(tempDependency.getName().equals(dependency.getName()))
                dependency.setDescription(description);
    }

    //Recorrer con foreach si es sólo para lectura
    public boolean exists(Dependency dependency) {
        return dependencies.contains(dependency);
    }
    //public boolean deleteDependency(Dependency dependency) { return dependencies.remove(dependency) };
    public boolean deleteDependency(Dependency dependency) {
        //No se puede eliminar el objeto directamente por lo que para eliminar
        //de la colección NO PUEDO USAR FOREACH PORQUE LA RECORRE EN MODO LECTURA
        //Foreach usa Iterator por lo que creamos el nuestro
        //De esta forma recuperamos el puntero Iterator de la colección
        Iterator<Dependency> iterator = dependencies.iterator();
        while(iterator.hasNext())
            if(iterator.next().getName().equals(dependency.getName())) {
                iterator.remove();
                break;
            }
        return false;
    }

    public boolean exists(String name, String shortname) {
        Iterator<Dependency> iterator = dependencies.iterator();
        while(iterator.hasNext())
            if(iterator.next().getName().equals(name)) {
                iterator.remove();
                break;
            }
        return false;
    }
}
