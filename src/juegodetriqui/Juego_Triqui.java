/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package juegodetriqui;

import java.util.Scanner;

/**
 *
 * @author SG701-21
 */
public class Juego_Triqui {

    /**
     * @param args the command line arguments
     */
    //Atributos
    private static Scanner scan;

    public static void main(String[] args) {
        // TODO code application logic here
        //INicializacion
        scan = new Scanner(System.in);

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
            
        } while (jugadas<10);
        
    
    }

}