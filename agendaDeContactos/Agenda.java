package agendaDeContactos;

import java.util.Scanner;

class Agenda {

    //Variables de instancia
    private Contacto[] contacto;

    //Constructor
    Agenda(int cantidad) {
        contacto = new Contacto[cantidad];
        System.out.println("Se ha creado una agenda con capacidad para "+cantidad+" contactos.\n");
    }

    /////////////
    // Métodos //
    /////////////

    /**
    * Busca una posición disponible para agregar un contacto. Si la agenda está
    * llena, el método lanza una excepción que contiene un mensaje diciendo que
    * la agenda está llena.
    * */
    private int posDisponible() throws Exception {
        int i;
        for (i = 0; i < contacto.length; i++) {
            if (contacto[i] == null) {
                return i;
            }
        }
        throw new Exception("La agenda está llena");
    }

    /**
    * Añade un contacto a la lista de cotactos.
    */
    void addContacto(Contacto nuevoContacto) {
        int i;
        try {
            i = posDisponible();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        contacto[i] = nuevoContacto;
        System.out.println("Un cotacto ha sido agregado a la agenda.\n");
    }

    void addContacto() {
        int i;
        try {
            i = posDisponible();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        Scanner entrada = new Scanner(System.in);
        String nombre, apellidos, email, telefono, direccion, tipoContacto;
        System.out.print("Ingrese el nombre del nuevo contacto: ");
        nombre = entrada.nextLine();
        System.out.print("Ingrese los apellidos del nuevo contacto: ");
        apellidos = entrada.nextLine();
        System.out.print("Ingrese el email del nuevo contacto: ");
        email = entrada.nextLine();
        System.out.print("Ingrese el telefono del nuevo contacto: ");
        telefono = entrada.nextLine();
        System.out.print("Ingrese la dirección del nuevo contacto: ");
        direccion = entrada.nextLine();
        System.out.print("¿Qué tipo de contacto es? ");
        tipoContacto = entrada.nextLine();
        Contacto nuevoContacto = new Contacto(nombre, apellidos, email, telefono, direccion, tipoContacto);
        contacto[i] = nuevoContacto;
        System.out.println("\nUn cotacto ha sido agregado a la agenda.\n");
        entrada.close();
    }

    void mostrarContacto(int i) {
        System.out.println(
        contacto[i].getNombre()+" "+contacto[i].getApellido()+"\n"+
        "    id: "+i+"\n"+
        "    Telefono: "+contacto[i].getTelefono()+"\n"+
        "    Email: "+contacto[i].getEmail()+"\n"+
        "    Dirección: "+contacto[i].getDireccion()+"\n"+
        "    Tipo de contacto: "+contacto[i].getTipoContacto()+"\n");
    }

    void listarContactos() {
        System.out.println("Lista de contactos:\n");
        if (contacto[0] == null) {
            System.out.println("---> La agenda está vacía.\n");
            return;
        }
        for (int i = 0; i < contacto.length && contacto[i] != null; i++) {
            mostrarContacto(i);
        }
    }

    void eliminarContacto() {
        if (contacto[0] == null) {
            System.out.println("---> La agenda está vacía.\n");
            return;
        }
        System.out.print("Ingrese el id del contacto a eliminar: ");
        Scanner entrada = new Scanner(System.in);
        int i = entrada.nextInt();
        entrada.close();
        try {
            if (contacto[i] == null) {
                System.out.println("---> No existe un contacto con ese id.\n");
                return;
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("---> No existe un contacto con ese id.\n");
            return;
        }
        int j;//Índice del último contacto en la lista
        try {
            j = posDisponible() - 1;
        } catch (Exception e) {
            j = contacto.length - 1;
        }
        contacto[i] = contacto[j];
        contacto[j] = null;
        System.out.println("\nSe ha eliminado un contacto.\n");
    }

    void buscarPorNombre() {
        System.out.print("Ingrese el nombre del contacto que busca: ");
        Scanner entrada = new Scanner(System.in);
        String nombre = entrada.nextLine();
        entrada.close();
        int contador = 0;
        for (int i = 0; i < contacto.length && contacto[i] != null; i++) {
            if (contacto[i].getNombre().toLowerCase().contains(nombre.toLowerCase())) {
                mostrarContacto(i);
                contador++;
            }
        }
        if (contador == 0) {
            System.out.println("---> No se encontró ninguna coincidencia.");
        }
    }
}
