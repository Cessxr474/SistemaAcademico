
package sistemaacademico;

/**
 *
 * @author cesar
 */
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
    
    public static void registrarAsignatura(){
        System.out.println("Ingrese el codigo de la asignatura: ");
        String codigo= leer.nextLine();
        System.out.println("Ingrese el nombre de la asignatura: ");
        String nombre = leer.nextLine();
        System.out.println("Ingrese la cantidad de creditos de la asignatura: ");
        int creditos = leer.nextInt();
        System.out.println("Ingrese el nombre del docente que dicta la asignatura: ");
        String docente = leer.nextLine();
        
      Asignatura asig = new Asignatura(codigo, nombre, creditos, docente);
      asignaturas.add(asig);
      
        System.out.println("Asigantura registrada con exito");
    }
    
    public static void buscarAsignatura(){
        System.out.println("Ingrese el codigo de la asignatura que quiere buscar: ");
        String cod = leer.nextLine();
        
        for (Asignatura l : asignaturas) {
            if(l.getCodigo().equals(cod)){
                System.out.println("La asignatura es: "+l.getNombre()+"Dictada por el docente: "+l.getDocente());
            } else {
                System.out.println("No se ha encontrado la asignatura: ");
            }
        }
    }
    
    public static void eliminarAsignatura(){
        boolean eliminado=false;
        System.out.println("Digite el codigo de la asignatura que desea eliminar: ");
        String codi= leer.nextLine();
        
        for (Asignatura e : asignaturas) {
            if(e.getCodigo().equals(e)){
            asignaturas.remove(e);
            eliminado=true;
            break;
            }
        }
        
        if(eliminado==true){
            System.out.println("La asignatura se ha eliminado correctamente: ");
        } else{
            System.out.println("No se ha encontrado el codigo de la asignatura que quiere eliminar");
        }
    }
}

    
