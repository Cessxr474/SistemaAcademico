/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistemaacademico;

public class Nota {

    private int id;
    private String nombreEstudiante;
    private String asignatura;
    private double valor;

    public Nota() {
    }

    public Nota(int id, String nombreEstudiante, String asignatura, double valor) {
        this.id = id;
        this.nombreEstudiante = nombreEstudiante;
        this.asignatura = asignatura;
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               " | Estudiante: " + nombreEstudiante +
               " | Asignatura: " + asignatura +
               " | Nota: " + valor;
    }
}