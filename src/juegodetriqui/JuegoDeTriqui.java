/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegodetriqui;

import java.util.Scanner;
/**
 *
 * @author Acer
 */
public class JuegoDeTriqui {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    //INicializacion
       Scanner scan = new Scanner(System.in);

        Jugador unJugador = new Jugador();
        Tablero miTablero = new Tablero();
        unJugador.setMiTablero(miTablero);
        unJugador.getMiTablero().seleccionarMarca();
        //Hacer jugada
        int jugadas=0;
        do {
            System.out.println("JUGADOR. Indique el numero de la casilla ");
            int pos = scan.nextInt();
            unJugador.getMiTablero().jugar(pos, unJugador.getMiTablero().getMarca());
            jugadas++;
            unJugador.getMiTablero().jugarMaquina();
            jugadas++;
            unJugador.getMiTablero().mostrarTablero();
            miTablero.ganador();
            
        } while (jugadas<10);
        
    
    }

}