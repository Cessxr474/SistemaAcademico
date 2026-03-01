
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


// aqui se crearon los metodos de la clase estudiante (registrar estudiante, buscar, mostrar, actualizar, y eliminar)
public static void registrarEstudiante() {
        System.out.println("\n--- REGISTRO DE ESTUDIANTE ---");
        System.out.print("Ingrese el código: ");
        String cod = leer.nextInt();
        leer.nextLine(); 

        System.out.print("Ingrese el nombre: ");
        String nom = leer.nextLine();

        System.out.print("Ingrese el apellido: ");
        String ape = leer.nextLine();

        System.out.print("Ingrese la edad: ");
        int edad = leer.nextInt();

        System.out.print("Ingrese el semestre: ");
        int sem = leer.nextInt();
        leer.nextLine(); 

   
        Estudiante nuevo = new Estudiante(cod, nom, ape, edad, sem);
        
     
        estudiantes.add(nuevo);
        
        System.out.println("¡Estudiante registrado con éxito!");
    }

public static void mostrarEstudiantes() {
        if (estudiantes.isEmpty()) {
            System.out.println("No hay estudiantes en el sistema.");
        } else {
            System.out.println("\n--- LISTADO GENERAL ---");
            for (Estudiante e : estudiantes) {
                System.out.println("ID: " + e.getCodigo() + " | Nombre: " + e.getNombre() + " " + e.getApellido());
            }
        }
    }
public static void actualizarEstudiante() {
    System.out.print("Ingrese el código del estudiante a modificar: ");
    String id = leer.nextInt();
    leer.nextLine();
    for (Estudiante e : estudiantes) {
        if (e.getCodigo() == id) {
            System.out.print("Nuevo nombre: ");
            e.setNombre(leer.nextLine()); 
            System.out.println("¡Datos actualizados!");
            return;
        }
    }
    System.out.println("Estudiante no encontrado.");
}
public static void eliminarEstudiante() {
    System.out.print("Ingrese el código del estudiante a eliminar: ");
    int id = leer.nextInt();
    for (int i = 0; i < estudiantes.size(); i++) {
        if (estudiantes.get(i).getCodigo() == id) {
            estudiantes.remove(i);
            System.out.println("¡Estudiante eliminado!");
            return;
        }
    }
    System.out.println("No se encontró el código.");
}
public static void buscarEstudiante() {
    System.out.println("\n--- BUSCAR ESTUDIANTE ---");
    System.out.print("Ingrese el código del estudiante a buscar: ");
    String idBuscado = leer.nextInt();
    leer.nextLine(); 

    boolean encontrado = false;

    for (Estudiante e : estudiantes) {
        if (e.getCodigo() == idBuscado) {
            System.out.println("\n¡Estudiante encontrado!");
            System.out.println("Código: " + e.getCodigo());
            System.out.println("Nombre: " + e.getNombre());
            System.out.println("Apellido: " + e.getApellido());
            System.out.println("Edad: " + e.getEdad());
            System.out.println("Semestre: " + e.getSemestre());
            encontrado = true;
            break; 
        }
    }
    if (!encontrado) {
        System.out.println("Error: No se encontró ningún estudiante con el código " + idBuscado);
    }
}
}