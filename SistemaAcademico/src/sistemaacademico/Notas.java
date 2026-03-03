package sistemaacademico;

public class Notas {
    // Atributos que relacionan las clases existentes
    private Estudiante alumno;
    private Asignatura materia;
    private double valor;

    // Constructor
    public Notas(Estudiante alumno, Asignatura materia, double valor) {
        this.alumno = alumno;
        this.materia = materia;
        this.valor = valor;
    }

    // Getters y Setters
    public Estudiante getAlumno() { return alumno; }
    public void setAlumno(Estudiante alumno) { this.alumno = alumno; }

    public Asignatura getMateria() { return materia; }
    public void setMateria(Asignatura materia) { this.materia = materia; }

    public double getValor() { return valor; }
    public void setValor(double valor) { this.valor = valor; }
}
