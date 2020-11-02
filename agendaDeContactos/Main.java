package agendaDeContactos;

import java.util.Scanner;

class Main {
    private static Scanner entrada;

    public static void main(String[] args) {

        Contacto contac1 = new Contacto("Carlos David",
        "Posada Soto",
        "carlangas@correo.com",
        "3127289032",
        "cll 30 sur # 54-94",
        "personal");

        Contacto contac2 = new Contacto("Isabel Cristina",
        "Ramírez Correa",
        "isabelc@correo.com",
        "3127789034",
        "cll 10 # 56-13, garage",
        "personal");

        Contacto contac3 = new Contacto("Sebastián",
        "Gómez Ardila",
        "sgomez@correo.com",
        "3225052356",
        "cll 100 # 34-23",
        "empresa");
        Agenda agenda = new Agenda(10);

        agenda.addContacto(contac1);
        agenda.addContacto(contac2);
        agenda.addContacto(contac3);

        mostrarMenu();
        entrada = new Scanner(System.in);
        int opcion;
        boolean entrar = true;
        while (entrar) {
            System.out.print(">>> ");
            opcion = entrada.nextInt();

            switch (opcion) {
                case 1:
                agenda.addContacto();
                break;
                case 2:
                agenda.listarContactos();
                break;
                case 3:
                agenda.eliminarContacto();
                break;
                case 4:
                agenda.buscarPorNombre();
                break;
                case 5:
                mostrarMenu();
                break;
                default:
                System.out.println("Hasta luego. :D");
                entrar = false;
                break;
            }
        }
    }

    private static void mostrarMenu() {
        System.out.print(
        "**************************\n"+
        "*          MENÚ          *\n"+
        "**************************\n\n"+
        "Ingrese:\n"+
        "   1 para crear un contacto.\n"+
        "   2 para listar los contactos.\n"+
        "   3 para eliminar un contacto.\n"+
        "   4 para buscar por nombre.\n"+
        "   5 para volver a mostrar este menú.\n"+
        "   Cualquier otro número para salir.\n\n");
    }
}
