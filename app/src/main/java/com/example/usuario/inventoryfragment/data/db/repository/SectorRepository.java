package com.example.usuario.inventoryfragment.data.db.repository;

import com.example.usuario.inventoryfragment.data.db.model.Sector;

import java.util.ArrayList;

/**
 * Almacena las distintas secciones donde guardar elementos del inventario
 *
 * @author Enrique Casielles Lapeira
 * @version 1.0
 * @see Sector
 */
public class SectorRepository {

    /*DECLARACIÓN*/
    private ArrayList<Sector> sectors;
    private static SectorRepository sectorRepository;

    /*INICIALIZACIÓN*/
    //De esta forma inicializa los atributos de ámbito estático o de clase
    //Es la forma alternativa aunque puede ser costoso y se puede evitar
    static { sectorRepository = new SectorRepository(); }

    /**
     * Constructor privado que garantiza una instancia única de la clase
     */
    private SectorRepository() {
        this.sectors = new ArrayList<>();
        initialize();
    }

    /*MÉTODOS*/

    /**
     * Inicializa la estructura de datos DependencyRepository
     */
    private void initialize() {
        addSector(new Sector(1, "Armario Izquierda del aula de DAM1", "ArmIzqDAM1",
                "Armario del aula de DAM1 que se encuentra a la izquierda de la puerta",
                1, true, true));
        addSector(new Sector(2, "Armario Izquierda del aula de DAM2", "ArmIzqDAM2",
                "Armario del aula de DAM2 que se encuentra a la izquierda de la puerta",
                2, true, false));
        addSector(new Sector(1, "Armario Izquierda del aula de DAM1", "ArmIzqDAM1",
                "Armario del aula de DAM1 que se encuentra a la izquierda de la puerta",
                1, true, true));
        addSector(new Sector(2, "Armario Izquierda del aula de DAM2", "ArmIzqDAM2",
                "Armario del aula de DAM2 que se encuentra a la izquierda de la puerta",
                2, true, false));
        addSector(new Sector(1, "Armario Izquierda del aula de DAM1", "ArmIzqDAM1",
                "Armario del aula de DAM1 que se encuentra a la izquierda de la puerta",
                1, true, true));
        addSector(new Sector(2, "Armario Izquierda del aula de DAM2", "ArmIzqDAM2",
                "Armario del aula de DAM2 que se encuentra a la izquierda de la puerta",
                2, true, false));
        addSector(new Sector(1, "Armario Izquierda del aula de DAM1", "ArmIzqDAM1",
                "Armario del aula de DAM1 que se encuentra a la izquierda de la puerta",
                1, true, true));
        addSector(new Sector(2, "Armario Izquierda del aula de DAM2", "ArmIzqDAM2",
                "Armario del aula de DAM2 que se encuentra a la izquierda de la puerta",
                2, true, false));
        addSector(new Sector(1, "Armario Izquierda del aula de DAM1", "ArmIzqDAM1",
                "Armario del aula de DAM1 que se encuentra a la izquierda de la puerta",
                1, true, true));
        addSector(new Sector(2, "Armario Izquierda del aula de DAM2", "ArmIzqDAM2",
                "Armario del aula de DAM2 que se encuentra a la izquierda de la puerta",
                2, true, false));
        addSector(new Sector(1, "Armario Izquierda del aula de DAM1", "ArmIzqDAM1",
                "Armario del aula de DAM1 que se encuentra a la izquierda de la puerta",
                1, true, true));
        addSector(new Sector(2, "Armario Izquierda del aula de DAM2", "ArmIzqDAM2",
                "Armario del aula de DAM2 que se encuentra a la izquierda de la puerta",
                2, true, false));
        addSector(new Sector(1, "Armario Izquierda del aula de DAM1", "ArmIzqDAM1",
                "Armario del aula de DAM1 que se encuentra a la izquierda de la puerta",
                1, true, true));
        addSector(new Sector(2, "Armario Izquierda del aula de DAM2", "ArmIzqDAM2",
                "Armario del aula de DAM2 que se encuentra a la izquierda de la puerta",
                2, true, false));
    }
    /**
     * Accesor de la clase SectorRepository
     * @return Devuelve la instancia de la clase como objeto SectorRepository
     */
    public static SectorRepository getInstance(){
        //Nunca va a valer null si no se hace inicialización estática
        if(sectorRepository == null)
            sectorRepository = new SectorRepository();
        return sectorRepository;
    }
    /**
     * Método que añade un nuevo sector
     * @param sector Objeto de clase Sector
     */
    private void addSector(Sector sector) {
        sectors.add(sector);
    }
    /**
     * Devuelve la referencia al objeto
     * @return referencia al objeto ArrayList
     */
    public ArrayList<Sector> getSectors() {
        return sectors;
    }

}
