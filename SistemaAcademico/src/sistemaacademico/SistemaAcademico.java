package sistemaacademico;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaAcademico {
    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<Asignatura> asignaturas = new ArrayList<>();
    static ArrayList<Notas> notas = new ArrayList<>();
    static Scanner leer = new Scanner(System.in);

    public static void main(String[] args) {
        mostrarMenu(); // ✅ FIX 1: Llamar al menú desde main
    }

    public static void mostrarMenu() {
        int opcion = 0;
        do {
            System.out.println("\n=============================");
            System.out.println("     SISTEMA ACADEMICO       ");
            System.out.println("=============================");
            System.out.println("--- ESTUDIANTES ---");
            System.out.println(" 1. Registrar Estudiante");
            System.out.println(" 2. Mostrar Estudiantes");
            System.out.println(" 3. Buscar Estudiante");
            System.out.println(" 4. Actualizar Estudiante");
            System.out.println(" 5. Eliminar Estudiante");
            System.out.println("--- ASIGNATURAS ---");
            System.out.println(" 6. Registrar Asignatura");
            System.out.println(" 7. Listar Asignaturas");
            System.out.println(" 8. Buscar Asignatura");
            System.out.println(" 9. Actualizar Asignatura");
            System.out.println("10. Eliminar Asignatura");
            System.out.println("--- NOTAS ---");
            System.out.println("11. Registrar Nota");
            System.out.println("12. Mostrar Notas");
            System.out.println("13. Buscar Notas de Estudiante");
            System.out.println("14. Actualizar Nota");
            System.out.println("15. Eliminar Nota");
            System.out.println("=============================");
            System.out.println(" 0. Salir");
            System.out.println("=============================");
            System.out.print("Seleccione una opcion: ");

            opcion = leer.nextInt();
            leer.nextLine();
            switch (opcion) {
                case 1:  registrarEstudiante(); break;
                case 2:  mostrarEstudiantes(); break;
                case 3:  buscarEstudiante(); break;
                case 4:  actualizarEstudiante(); break;
                case 5:  eliminarEstudiante(); break;
                case 6:  registrarAsignatura(); break;
                case 7:  listarAsignatura(); break;
                case 8:  buscarAsignatura(); break;
                case 9:  actualizarAsignatura(); break;
                case 10: eliminarAsignatura(); break;
                case 11: registrarNota(); break;
                case 12: mostrarNotas(); break;
                case 13: buscarNotaEstudiante(); break;
                case 14: actualizarNota(); break;
                case 15: eliminarNota(); break;
                case 0:  System.out.println("Saliendo..."); break;
                default: System.out.println("Opcion no valida.");
            }
        } while (opcion != 0);
    }

    // ===================== ASIGNATURA =====================

    public static void registrarAsignatura() {
        System.out.print("Ingrese el codigo de la asignatura: ");
        String codigo = leer.nextLine();
        System.out.print("Ingrese el nombre de la asignatura: ");
        String nombre = leer.nextLine();
        System.out.print("Ingrese la cantidad de creditos: ");
        int creditos = leer.nextInt();
        leer.nextLine();
        System.out.print("Ingrese el nombre del docente: ");
        String docente = leer.nextLine();

        asignaturas.add(new Asignatura(codigo, nombre, creditos, docente));
        System.out.println("Asignatura registrada con exito.");
    }

    public static void buscarAsignatura() {
        System.out.print("Ingrese el codigo de la asignatura a buscar: ");
        String cod = leer.nextLine();
        boolean encontrado = false;

        for (Asignatura l : asignaturas) {
            if (l.getCodigo().equals(cod)) {
                System.out.println(l);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) { // ✅ FIX 4: lógica invertida corregida
            System.out.println("No se encontro la asignatura.");
        }
    }

    public static void eliminarAsignatura() {
        System.out.print("Digite el codigo de la asignatura a eliminar: ");
        String codi = leer.nextLine();
        boolean eliminado = false;

        for (Asignatura e : asignaturas) {
            if (e.getCodigo().equals(codi)) {
                asignaturas.remove(e);
                eliminado = true;
                break;
            }
        }

        if (eliminado) {
            System.out.println("Asignatura eliminada correctamente.");
        } else {
            System.out.println("No se encontro la asignatura.");
        }
    }

    public static void actualizarAsignatura() {
        System.out.print("Ingrese el codigo de la asignatura a actualizar: ");
        String codi = leer.nextLine();
        boolean encontrado = false;

        for (Asignatura e : asignaturas) {
            if (e.getCodigo().equals(codi)) {
                System.out.print("Nuevo nombre: ");
                e.setNombre(leer.nextLine());
                System.out.print("Nuevo docente: ");
                e.setDocente(leer.nextLine());
                System.out.print("Nuevos creditos: ");
                e.setCreditos(leer.nextInt());
                leer.nextLine();
                System.out.println("Asignatura actualizada correctamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontro la asignatura.");
        }
    }

    public static void listarAsignatura() {
        if (asignaturas.isEmpty()) {
            System.out.println("No hay asignaturas registradas.");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Asignatura a : asignaturas) {
                sb.append("Nombre: ").append(a.getNombre()).append("\n");
                sb.append("Codigo: ").append(a.getCodigo()).append("\n");
                sb.append("Creditos: ").append(a.getCreditos()).append("\n");
                sb.append("Docente: ").append(a.getDocente()).append("\n");
                sb.append("------------------\n");
            }
            System.out.println(sb);
        }
    }

    // ===================== ESTUDIANTE =====================

    public static void registrarEstudiante() {
        System.out.println("REGISTRO DE ESTUDIANTE");
        System.out.print("Ingrese el codigo: ");
        String cod = leer.nextLine(); // ✅ FIX 5: eliminado leer.nextLine() extra

        System.out.print("Ingrese el nombre: ");
        String nom = leer.nextLine();

        System.out.print("Ingrese el apellido: ");
        String ape = leer.nextLine();

        System.out.print("Ingrese la edad: ");
        int edad = leer.nextInt();

        System.out.print("Ingrese el semestre: ");
        int sem = leer.nextInt();
        leer.nextLine();

        estudiantes.add(new Estudiante(cod, nom, ape, edad, sem));
        System.out.println("Estudiante registrado con exito!");
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
        System.out.print("Ingrese el codigo del estudiante a modificar: ");
        String id = leer.nextLine();
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equals(id)) { // ✅ FIX 6: .equals() en vez de ==
                System.out.print("Nuevo nombre: ");
                e.setNombre(leer.nextLine());
                System.out.println("Datos actualizados!");
                return;
            }
        }
        System.out.println("Estudiante no encontrado.");
    }

    public static void eliminarEstudiante() {
        System.out.print("Ingrese el codigo del estudiante a eliminar: ");
        String id = leer.nextLine();
        for (int i = 0; i < estudiantes.size(); i++) {
            if (estudiantes.get(i).getCodigo().equals(id)) { // ✅ FIX 7: .equals()
                estudiantes.remove(i);
                System.out.println("Estudiante eliminado!");
                return;
            }
        }
        System.out.println("No se encontro el codigo.");
    }

    public static void buscarEstudiante() {
        System.out.println("\n--- BUSCAR ESTUDIANTE ---");
        System.out.print("Ingrese el codigo del estudiante: ");
        String idBuscado = leer.nextLine(); // ✅ FIX 8: eliminado leer.nextLine() extra
        boolean encontrado = false;

        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equals(idBuscado)) { // ✅ FIX 9: .equals()
                System.out.println("Estudiante encontrado!");
                System.out.println("Codigo: " + e.getCodigo());
                System.out.println("Nombre: " + e.getNombre());
                System.out.println("Apellido: " + e.getApellido());
                System.out.println("Edad: " + e.getEdad());
                System.out.println("Semestre: " + e.getSemestre());
                encontrado = true;
                break;
            }
        }
        if (!encontrado) {
            System.out.println("No se encontro el estudiante con codigo: " + idBuscado);
        }
    }

    // ===================== NOTAS =====================

    public static void registrarNota() {
        System.out.println("\n--- REGISTRAR NOTA ---");
        System.out.print("ID del Estudiante: ");
        String idEst = leer.nextLine();
        Estudiante est = buscarEstudiantePorId(idEst);

        System.out.print("Codigo de Asignatura: ");
        String codAsig = leer.nextLine();
        Asignatura asig = buscarAsignaturaPorCod(codAsig);

        if (est != null && asig != null) {
            System.out.print("Valor de la nota: ");
            double valor = leer.nextDouble();
            leer.nextLine();
            notas.add(new Notas(est, asig, valor));
            System.out.println("Nota guardada.");
        } else {
            System.out.println("Error: Estudiante o Asignatura no existen.");
        }
    }

    public static void mostrarNotas() {
        System.out.println("\n--- LISTADO DE NOTAS ---");
        if (notas.isEmpty()) {
            System.out.println("No hay notas registradas.");
        } else {
            for (Notas n : notas) {
                System.out.println("Estudiante: " + n.getAlumno().getNombre() +
                        " | Materia: " + n.getMateria().getNombre() +
                        " | Nota: " + n.getValor());
            }
        }
    }

    public static void buscarNotaEstudiante() {
        System.out.print("Ingrese ID del estudiante a consultar: ");
        String id = leer.nextLine();
        for (Notas n : notas) {
            if (n.getAlumno().getCodigo().equals(id)) {
                System.out.println("Materia: " + n.getMateria().getNombre() + " -> " + n.getValor());
            }
        }
    }

    public static void actualizarNota() {
        System.out.print("ID del estudiante: ");
        String idEst = leer.nextLine();
        System.out.print("Codigo de la materia: ");
        String codMat = leer.nextLine();

        for (Notas n : notas) {
            if (n.getAlumno().getCodigo().equals(idEst) && n.getMateria().getCodigo().equals(codMat)) {
                System.out.print("Nueva nota: ");
                n.setValor(leer.nextDouble());
                leer.nextLine();
                System.out.println("Nota actualizada.");
                return;
            }
        }
        System.out.println("No se encontro el registro.");
    }

    public static void eliminarNota() {
        System.out.print("ID del estudiante: ");
        String idEst = leer.nextLine();
        System.out.print("Codigo de la materia: ");
        String codMat = leer.nextLine();

        for (int i = 0; i < notas.size(); i++) {
            Notas n = notas.get(i);
            if (n.getAlumno().getCodigo().equals(idEst) && n.getMateria().getCodigo().equals(codMat)) {
                notas.remove(i);
                System.out.println("Nota eliminada.");
                return;
            }
        }
        System.out.println("Registro no encontrado.");
    }

    // ===================== AUXILIARES =====================

    public static Estudiante buscarEstudiantePorId(String id) {
        for (Estudiante e : estudiantes) {
            if (e.getCodigo().equals(id)) return e;
        }
        return null;
    }

    public static Asignatura buscarAsignaturaPorCod(String cod) {
        for (Asignatura a : asignaturas) {
            if (a.getCodigo().equals(cod)) return a;
        }
        return null;
    }
}


