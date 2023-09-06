package org.example;

import org.example.entities.*;
import org.example.crud.*;
import org.example.utils.*;

public class Main {

    public static void main(String[] args) {

        MigrationUtil migrationUtil = new MigrationUtil();
        migrationUtil.migration();

        ClientCrudService clientService = new ClientCrudService();

        clientService.createClient(new Client("Sasha"));
        clientService.createClient(new Client("Anna"));
        clientService.createClient(new Client("Sophia"));
        clientService.createClient(new Client("Olga"));
        clientService.createClient(new Client("Emma"));

        System.out.println(clientService.getClientById(4L));
        clientService.updateClientById(5L, "Viktor");
        clientService.deleteClientById(2L);
        clientService.getAll().forEach(System.out::println);

        PlanetCrudService planetService = new PlanetCrudService();

        planetService.createPlanet(new Planet("MARS", "Mars"));
        planetService.createPlanet(new Planet("ERTH", "Earth"));
        planetService.createPlanet(new Planet("JUP7", "Jupiter"));

        System.out.println(planetService.getPlanetById("JUP7"));
        planetService.updatePlanetById("MARS", "New Mars");
        planetService.deletePlanetById("MARS");
        planetService.getAllPlanet().forEach(System.out::println);

        HibernateUtil.getInstance().close();
    }
}