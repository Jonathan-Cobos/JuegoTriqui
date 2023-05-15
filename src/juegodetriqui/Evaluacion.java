/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegodetriqui;

/**
 *
 * @author Acer
 */
public class Evaluacion {
    private int ocupadas;
    private int  marcajugador;
      private int  posicionlibre1;
        private int posicionlibre2;
     private int poosicionlibre3;

    public Evaluacion() {
    }

    public Evaluacion(int libres, int marcajugador, int posicionlibre1, int posicionlibre2, int poosicionlibre3) {
        this.ocupadas =0;
        this.marcajugador = 0;
        this.posicionlibre1 = 0;
        this.posicionlibre2 = 0;
        this.poosicionlibre3 = 0;
    }

//get y set

    public int getOcupadas() {
        return ocupadas;
    }

    public void setOcupadas(int libres) {
        this.ocupadas = libres;
    }


    public int getMarcajugador() {
        return marcajugador;
    }

    public void setMarcajugador(int marcajugador) {
        this.marcajugador = marcajugador;
    }

    public int getPosicionlibre1() {
        return posicionlibre1;
    }

    public void setPosicionlibre1(int posicionlibre1) {
        this.posicionlibre1 = posicionlibre1;
    }

    public int getPosicionlibre2() {
        return posicionlibre2;
    }

    public void setPosicionlibre2(int posicionlibre2) {
        this.posicionlibre2 = posicionlibre2;
    }

    public int getPoosicionlibre3() {
        return poosicionlibre3;
    }

    public void setPoosicionlibre3(int poosicionlibre3) {
        this.poosicionlibre3 = poosicionlibre3;
    }
   //to string

    @Override
    public String toString() {
        return "Evaluacion{" + "libres=" + ocupadas + ", marcajugador=" + marcajugador + ", posicionlibre1=" + posicionlibre1 + ", posicionlibre2=" + posicionlibre2 + ", poosicionlibre3=" + poosicionlibre3 + '}';
    }
    













}

