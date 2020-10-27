package agendaDeContactos;

import java.util.Scanner;

class Agenda {

    //Variables de instancia
    private int numeroDeContactos;
    private Contacto[] contacto;

    //Constructor
    Agenda(int cantidad) {
	numeroDeContactos = 0;
	contacto = new Contacto[cantidad];
	System.out.println
	    ("Se ha creado una agenda con capacidad para "+cantidad+
	     " contactos.\n");
    }

    //Métodos
    private void contactoCreado() {
	numeroDeContactos++;
	System.out.println("Un cotacto ha sido creado con éxito.\n");
    }

    /**
     * Añade un contacto a la lista de cotactos.
     */
    void addContacto(Contacto contacto) {
	this.contacto[numeroDeContactos] = contacto;
	contactoCreado();
    }

    /**
     * Añade un contacto solicitando al usuario los datos por teclado.
     */
    void addContacto() {
	Scanner entrada = new Scanner(System.in).useDelimiter("\n");
	
	contacto[numeroDeContactos] = new Contacto();

	System.out.print("Ingrese el nombre del contacto: ");
	contacto[numeroDeContactos].setNombre(entrada.next());
	
	System.out.print("Ingrese los apellidos del contacto: ");
	contacto[numeroDeContactos].setApellido(entrada.next());
	
	System.out.print("Ingrese el email del contacto: ");
	contacto[numeroDeContactos].setEmail(entrada.next());

	System.out.print("Ingrese el número de teléfono del contacto: ");
	contacto[numeroDeContactos].setTelefono(entrada.next());
	
	System.out.print("Ingrese la dirección del contacto: ");
	contacto[numeroDeContactos].setDireccion(entrada.next());
	
	System.out.print("¿Qué tipo de contacto es? (personal, empresa, etc.) ");
	contacto[numeroDeContactos].setTipoContacto(entrada.next());
	
	System.out.println();
	contactoCreado();
    }

    void mostrarContacto(int i) {
	System.out.println
	    (i+1+". "+contacto[i].getNombre()+" "+contacto[i].getApellido()+"\n"+
	     "    Telefono: "+contacto[i].getTelefono()+'\n'+
	     "    Email: "+contacto[i].getEmail()+'\n'+
	     "    Dirección: "+contacto[i].getDireccion()+'\n'+
	     "    Tipo de contacto: "+contacto[i].getTipoContacto());
	System.out.println();
    }

    void listarContactos() {
	System.out.println("Lista de contactos:\n");
	if (numeroDeContactos == 0) {
	    System.out.println("    La agenda está vacía.\n");
	}
	for (int i = 0; i < numeroDeContactos; i++) {
	    mostrarContacto(i);
	}
    }

    private void contactoEliminado() {
	System.out.println("Un contacto ha sido eliminado con éxito.\n");
	numeroDeContactos--;
    }

    /**
     * Elimina el contacto i de la agenda y desplaza todos los contactos desde i+1
     * hasta numeroDeContactos-1 un lugar hacia atrás para cubrir el espacio que
     * deja i.
     */
    void eliminarContacto(int i) {
	contacto[i] = null;
	for ( ; i < numeroDeContactos - 1; i++) {
	    contacto[i] = contacto[i+1];
	}
	System.out.println();
	contactoEliminado();
    }

    void buscarPorNombre(String nombre) {
	int contador = 0;
	for (int i = 0; i < numeroDeContactos; i++) {
	    if (contacto[i].getNombre().toLowerCase().
		contains(nombre.toLowerCase())) {
		mostrarContacto(i);
		contador++;
	    }
	}
	if (contador == 0) {
	    System.out.println
		("\n    No hay ningun contacto que coincida con ese nombre.\n");
	}
    }

    private void contactoEditado() {
	System.out.println("Un contacto ha sido editado con éxito.\n");
    }

    void editarContacto(int i) {
	Scanner entrada = new Scanner(System.in).useDelimiter("\n");
	
	System.out.println("El contacto seleccionado es: ");
	mostrarContacto(i);
	System.out.print("¿Es correcto? S/N ");
	String respuesta = entrada.next().toLowerCase();
	if (respuesta.equals("n")) {
	    System.out.println();
	    return;
	    }
	
	System.out.print("Ingrese el nuevo nombre del contacto: ");
	contacto[i].setNombre(entrada.next());
	
	System.out.print("Ingrese los nuevos apellidos del contacto: ");
	contacto[i].setApellido(entrada.next());
	
	System.out.print("Ingrese el nuevo email del contacto: ");
	contacto[i].setEmail(entrada.next());

	System.out.print("Ingrese el nuevo número de teléfono del contacto: ");
	contacto[i].setTelefono(entrada.next());
	
	System.out.print("Ingrese la nueva dirección del contacto: ");
	contacto[i].setDireccion(entrada.next());
	
	System.out.print("¿Qué tipo de contacto es? (personal, empresa, etc.) ");
	contacto[i].setTipoContacto(entrada.next());
	
	System.out.println();
	contactoEditado();
    }
}
