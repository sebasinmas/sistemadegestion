package com.sebastianb;

import java.util.*;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static final PersonajeRepository repo = new PersonajeRepository();

    public static void main(String[] args) {
        System.out.println("Bienvenido al sistema de gestión de personajes de Mortal Kombat");
        while (true) {
            mostrarMenu();
            int opcion = leerOpcion();
            switch (opcion) {
                case 1 -> agregarPersonaje();
                case 2 -> listarPersonajes();
                case 3 -> editarPersonaje();
                case 4 -> eliminarPersonaje();
                case 5 -> salir();
                default -> System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\nMenú:");
        System.out.println("1. Agregar personaje");
        System.out.println("2. Listar personajes");
        System.out.println("3. Editar personaje");
        System.out.println("4. Eliminar personaje");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static int leerOpcion() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    private static void agregarPersonaje() {
        System.out.println("\nAgregar nuevo personaje");
        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Salud máxima: ");
        int saludMaxima = Integer.parseInt(scanner.nextLine());

        System.out.print("Nivel de poder (BAJO, MEDIO, ALTO): ");
        Poder poder = null;
        while (poder == null) {
            try {
                poder = Poder.valueOf(scanner.nextLine().trim().toUpperCase());
            } catch (Exception e) {
                System.out.print("Valor inválido. Ingrese BAJO, MEDIO o ALTO: ");
            }
        }

        System.out.print("Lista de poderes (separados por coma): ");
        String poderesStr = scanner.nextLine();
        List<String> listaDePoderes = new ArrayList<>();
        if (!poderesStr.isBlank()) {
            for (String p : poderesStr.split(",")) {
                listaDePoderes.add(p.trim());
            }
        }

        Personaje nuevo = new Personaje(nombre, saludMaxima, poder, listaDePoderes);
        repo.agregar(nuevo);
        System.out.println("Personaje agregado:\n" + nuevo);
    }

    private static void listarPersonajes() {
        System.out.println("\nLista de personajes:");
        List<Personaje> personajes = repo.listar();
        if (personajes.isEmpty()) {
            System.out.println("No hay personajes registrados.");
        } else {
            for (Personaje p : personajes) {
                System.out.println("ID: " + p.getId() + " | " + p);
            }
        }
    }

    private static void editarPersonaje() {
        System.out.println("\nEditar personaje");
        listarPersonajes();
        System.out.print("Ingrese el ID del personaje a editar: ");
        long id = Long.parseLong(scanner.nextLine());
        Personaje personaje = repo.getPersonajeById(id);
        if (personaje == null) {
            System.out.println("No se encontró un personaje con ese ID.");
            return;
        }

        System.out.print("Nuevo nombre (dejar vacío para no cambiar): ");
        String nombre = scanner.nextLine();
        System.out.print("Nueva salud máxima (dejar vacío para no cambiar): ");
        String saludStr = scanner.nextLine();
        System.out.print("Nuevo nivel de poder (BAJO, MEDIO, ALTO, dejar vacío para no cambiar): ");
        String poderStr = scanner.nextLine();
        System.out.print("Nueva lista de poderes (separados por coma, dejar vacío para no cambiar): ");
        String poderesStr = scanner.nextLine();

        PersonajeUpdateDTO dto = new PersonajeUpdateDTO();
        if (!nombre.isBlank()) dto.setNombre(nombre);
        if (!saludStr.isBlank()) dto.setSaludMaxima(Integer.parseInt(saludStr));
        if (!poderStr.isBlank()) dto.setNivelDePoder(Poder.valueOf(poderStr.trim().toUpperCase()));
        if (!poderesStr.isBlank()) {
            List<String> lista = new ArrayList<>();
            for (String p : poderesStr.split(",")) lista.add(p.trim());
            dto.setListaDePoderes(lista);
        }

        repo.editarPorId(id, dto);
        System.out.println("Personaje editado:\n" + repo.getPersonajeById(id));
    }

    private static void eliminarPersonaje() {
        System.out.println("\nEliminar personaje");
        listarPersonajes();
        System.out.print("Ingrese el ID del personaje a eliminar: ");
        long id = Long.parseLong(scanner.nextLine());
        Personaje personaje = repo.getPersonajeById(id);
        if (personaje == null) {
            System.out.println("No se encontró un personaje con ese ID.");
            return;
        }
        repo.delPersonajeById(id);
        System.out.println("Personaje eliminado.");
    }

    private static void salir() {
        System.out.println("Gracias por usar el sistema. ¡Hasta la próxima!");
        System.exit(0);
    }
}