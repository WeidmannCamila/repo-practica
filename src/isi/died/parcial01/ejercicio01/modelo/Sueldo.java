package isi.died.parcial01.ejercicio01.modelo;

import java.time.LocalDate;

public class Sueldo {



    private Integer numero;
    private LocalDate localDate;
    private int month = localDate.getMonthValue();
    private double total;
    private Empleado empleado;


    public Sueldo(Integer numero, LocalDate localDate, int month, double total, Empleado empleado) {
        this.numero = numero;
        this.localDate = localDate;
        this.month = month;
        this.total = total;
        this.empleado = empleado;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public LocalDate getLocalDate() {
        return localDate;
    }

    public void setLocalDate(LocalDate localDate) {
        this.localDate = localDate;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

}
