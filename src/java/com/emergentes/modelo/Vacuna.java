
package com.emergentes.modelo;

public class Vacuna 
{
    private int id;
    private String nombre,vacuna;
    private double talla,peso;
   
    public Vacuna() 
    {
        id=0;
        peso=0.0;
        talla =0.0;
        nombre="";
        vacuna="";
    }

    public Vacuna(int id, String nombre, double peso, double talla,String vacuna) {
        this.id = id;
        this.nombre = nombre;
        this.vacuna = vacuna;
        this.talla = talla;
        this.peso = peso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public double getTalla() {
        return talla;
    }

    public void setTalla(double talla) {
        this.talla = talla;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

   
    
}
