
package sistemaacademico;


public class SistemaAcademico {
    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    static ArrayList<Nota> notas = new ArrayList<>();
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        
    }
    public static void mostrarMenu() {
        int opcion = 0;
    do {
        System.out.println("Registro academico");
        System.out.println("1. Registrar Estudiante");
        System.out.println("2. mostrar Estudiantes");
        System.out.println("3. Registrar Asignatura");
        System.out.println("4. Registrar Nota");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
        
        opcion = leer.nextInt();
        switch (opcion) {
            case 1: registrarEstudiante(); break;
            case 2: mostrarEstudiantes(); break;
            case 3: /* registra estudiante */ break;
            case 4: /* registrar asignatura */ break;
            case 5: System.out.println("Saliendo..."); break;
            default: System.out.println("Opción no válida.");
        }
    } while (opcion != 5);
}
}


