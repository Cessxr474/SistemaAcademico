
package sistemaacademico;


import java.util.ArrayList;
import java.util.Scanner;

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
        boolean encontrado =false;
        
        for (Asignatura l : asignaturas) {
            if(l.getCodigo().equals(cod)){
                System.out.println(l);
                encontrado=true;
                break;
            } 
        }
        
        if(encontrado==true){
            System.out.println("No se encontró la asignatura ");
        }
    }
    
    public static void eliminarAsignatura(){
        boolean eliminado=false;
        System.out.println("Digite el codigo de la asignatura que desea eliminar: ");
        String codi= leer.nextLine();
        
        for (Asignatura e : asignaturas) {
            if(e.getCodigo().equals(codi)){
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
    
    public static void actualizarAsignatura(){
        System.out.println("Ingrese el codigo de la asignatura que quiere modificar o actualizar: ");
        String codi= leer.nextLine();
        
        for (Asignatura e : asignaturas) {
            if(e.getCodigo().equals(codi)){
                System.out.println("Ingrese el nuevo nombre de la asignatura: ");
                String name= leer.nextLine();
                e.setNombre(name);
                
                System.out.println("Ingrese el nombre del docente: ");
                String doc= leer.nextLine();
                e.setDocente(doc);
                
                System.out.println("Ingrese el nuevo nombre de la asignatura: ");
                int credi= leer.nextInt();
                leer.nextLine();
                e.setCreditos(credi);
                
                System.out.println("Asignatura actualizada correctamente: ");
            } else{
                System.out.println("No se a podido encontrar la asignatura que quiere actualizar");
            }
        }
    }
    
    public static void listarAsignatura(){
        if(asignaturas.isEmpty()){
            System.out.println("No hay asignaturas registradas.");
        } else{
            StringBuilder sb = new StringBuilder();
            for (Asignatura a : asignaturas) {
                sb.append("Nombre: ").append(a.getNombre()).append("\n");
                sb.append("Codigo: ").append(a.getCodigo()).append("\n");
                sb.append("Creditos: ").append(a.getCreditos()).append("\n");
                sb.append("Docente: ").append(a.getDocente()).append("\n");
                sb.append("------------------\n"); // separador
                   
            }
            System.out.println(sb);
        }
    }
}

    
