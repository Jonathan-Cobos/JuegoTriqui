/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package juegodetriqui;

import java.util.Scanner;

/**
 *
 * @author SG701-21
 */
public class Tablero {

    //Declaracion atributos
    private Casilla SI;
    private Casilla SC;
    private Casilla SD;
    private Casilla MI;
    private Casilla MC;
    private Casilla MD;
    private Casilla II;
    private Casilla IC;
    private Casilla ID;
    private String marca;

    //Constructo
    public Tablero() {
        System.out.println("Creando tablero");
        SI = new Casilla(Casilla.SUPERIOR_IZQUIERDA);
        SC = new Casilla(Casilla.SUPERIOR_CENTRO);
        SD = new Casilla(Casilla.SUPERIOR_DERECHA);
        MI = new Casilla(Casilla.MEDIO_IZQUIERDA);
        MC = new Casilla(Casilla.MEDIO_CENTRO);
        MD = new Casilla(Casilla.MEDIO_DERECHA);
        II = new Casilla(Casilla.INFERIOR_IZQUIERDA);
        IC = new Casilla(Casilla.INFERIOR_CENTRO);
        ID = new Casilla(Casilla.INFERIOR_DERECHA);
        this.marca = " ";

    }

    public Tablero(Casilla SI, Casilla SC, Casilla SD, Casilla MI, Casilla MC, Casilla MD, Casilla II, Casilla IC, Casilla ID, String marca) {
        this.SI = SI;
        this.SC = SC;
        this.SD = SD;
        this.MI = MI;
        this.MC = MC;
        this.MD = MD;
        this.II = II;
        this.IC = IC;
        this.ID = ID;
        this.marca = marca;
    }

    //Metodos get y set 
    public Casilla getSI() {
        return SI;
    }

    public void setSI(Casilla SI) {
        this.SI = SI;
    }

    public Casilla getSC() {
        return SC;
    }

    public void setSC(Casilla SC) {
        this.SC = SC;
    }

    public Casilla getSD() {
        return SD;
    }

    public void setSD(Casilla SD) {
        this.SD = SD;
    }

    public Casilla getMI() {
        return MI;
    }

    public void setMI(Casilla MI) {
        this.MI = MI;
    }

    public Casilla getMC() {
        return MC;
    }

    public void setMC(Casilla MC) {
        this.MC = MC;
    }

    public Casilla getMD() {
        return MD;
    }

    public void setMD(Casilla MD) {
        this.MD = MD;
    }

    public Casilla getII() {
        return II;
    }

    public void setII(Casilla II) {
        this.II = II;
    }

    public Casilla getIC() {
        return IC;
    }

    public void setIC(Casilla IC) {
        this.IC = IC;
    }

    public Casilla getID() {
        return ID;
    }

    public void setID(Casilla ID) {
        this.ID = ID;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    //Metodo mostrar tablero
    public void mostrarTablero() {
        System.out.println("+-+-+-+");
        System.out.println("|" + SI.getMarca() + "|" + SC.getMarca() + "|" + SD.getMarca() + "|");
        System.out.println("+-+-+-+");
        System.out.println("|" + MI.getMarca() + "|" + MC.getMarca() + "|" + MD.getMarca() + "|");
        System.out.println("+-+-+-+");
        System.out.println("|" + II.getMarca() + "|" + IC.getMarca() + "|" + ID.getMarca() + "|");
        System.out.println("+-+-+-+");

    }

    public void seleccionarMarca() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Seleccione una marca (X - O");
        String valor = scan.next();
        if (valor.equals("X") || valor.equals("O")) {
            this.marca = valor;
        }
        this.marca = "X";
    }

    //Jugar triqui
    public boolean jugar(int posicion, String simbolo) {
        System.out.println("pos " + posicion + " marca " + simbolo);
        switch (posicion) {
            case 1:
                SI.setMarca(simbolo);
                break;
            case 2:
                SC.setMarca(simbolo);
                break;
            case 3:
                SD.setMarca(simbolo);
                break;
            case 4:
                MI.setMarca(simbolo);
                break;
            case 5:
                MC.setMarca(simbolo);
                break;
            case 6:
                MD.setMarca(simbolo);
                break;
            case 7:
                II.setMarca(simbolo);
                break;
            case 8:
                IC.setMarca(simbolo);
                break;
            case 9:
                ID.setMarca(simbolo);
                break;
            default:
                throw new AssertionError();
        }
        return true;
    }

    //Retornar marca del jugador aplicacion
    public String getMarcaAplicacion() {
        if (this.marca.equals("X")) {
            return "O";
        }
        return "X";
    }

    public boolean jugarMaquina() {
        boolean yaMarco = false;
        int ocupacion1, ocupacion2, ocupacion3,
                ocupacion4, ocupacion5, ocupacion6, ocupacion7, ocupacion8 = 0;
        ocupacion7 = evaluarDiagonal(1);
        ocupacion8 = evaluarDiagonal(1);
        ocupacion1 = evaluarFila(1);
        ocupacion2 = evaluarFila(2);
        ocupacion3 = evaluarFila(3);
        ocupacion4 = evaluarCol(1);
        ocupacion5 = evaluarCol(2);
        ocupacion6 = evaluarCol(3);

        if (ocupacion1 == 2) {
            System.out.println("Ocupacion fila 1 en 2");
            jugarFila(1);
        } else if (ocupacion2 == 2) {
            System.out.println("Ocupacion fila 2 en 2");
            jugarFila(2);
        } else if (ocupacion3 == 2) {
            System.out.println("Ocupacion fila 3 en 2");
            jugarFila(3);
        } else if (ocupacion4 == 2) {
            System.out.println("Ocupacion col 1 en 2");
            jugarCol(1);
        } else if (ocupacion5 == 2) {
            System.out.println("Ocupacion col 2 en 2");
            jugarCol(2);
        } else if (ocupacion6 == 2) {
            System.out.println("Ocupacion col 3 en 2");
            jugarCol(3);
        } else {
            System.out.println("Buscando primera libre");
            for (int i = 1; i < 9 && !yaMarco; i++) {

                switch (i) {
                    case 1:
                        if (SI.getMarca().equals(" ")) {
                            SI.setMarca(getMarcaAplicacion());
                            yaMarco = true;
                            System.out.println("Maquina marca " + SI.getMarca());
                        }
                        break;
                    case 2:
                        if (SC.getMarca().equals(" ")) {
                            SC.setMarca(getMarcaAplicacion());
                            yaMarco = true;
                            System.out.println("Maquina marca " + SC.getMarca());
                        }
                        break;
                    case 3:
                        if (SD.getMarca().equals(" ")) {
                            SD.setMarca(getMarcaAplicacion());
                            yaMarco = true;
                            System.out.println("Maquina marca " + SD.getMarca());
                        }
                        break;
                    case 4:
                        if (MI.getMarca().equals(" ")) {
                            MI.setMarca(getMarcaAplicacion());
                            yaMarco = true;
                            System.out.println("Maquina marca " + MI.getMarca());
                        }
                        break;
                    case 5:
                        if (MC.getMarca().equals(" ")) {
                            MC.setMarca(getMarcaAplicacion());
                            yaMarco = true;
                            System.out.println("Maquina marca " + MC.getMarca());
                        }
                        break;
                    case 6:
                        if (MD.getMarca().equals(" ")) {
                            MD.setMarca(getMarcaAplicacion());

                            yaMarco = true;
                            System.out.println("Maquina marca " + MD.getMarca());
                        }
                        break;
                    case 7:
                        if (II.getMarca().equals(" ")) {
                            II.setMarca(getMarcaAplicacion());
                            yaMarco = true;
                            System.out.println("Maquina marca " + II.getMarca());
                        }
                        break;
                    case 8:
                        if (IC.getMarca().equals(" ")) {
                            IC.setMarca(getMarcaAplicacion());
                            yaMarco = true;
                            System.out.println("Maquina marca " + IC.getMarca());
                        }
                        break;
                    case 9:
                        if (ID.getMarca().equals(" ")) {
                            ID.setMarca(getMarcaAplicacion());
                            yaMarco = true;
                            System.out.println("Maquina marca " + ID.getMarca());
                        }
                        break;
                    default:
                        throw new AssertionError();
                }
            }
        }
        return true;

    }

    public int evaluarFila(int fila) {
        int cont = 0;
        int marcajugador = 0;

        switch (fila) {
            case 1:
                if (!SI.getMarca().equals(" ")) {
                    cont++;
                    if (SI.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }

                }
                if (!SC.getMarca().equals(" ")) {
                    cont++;
                    if (SC.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }

                }
                if (!SD.getMarca().equals(" ")) {
                    cont++;
                    if (SD.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }

                }
                break;
            case 2:
                if (!MI.getMarca().equals(" ")) {
                    cont++;
                    if (MI.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                if (!MC.getMarca().equals(" ")) {
                    cont++;
                    if (MC.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                if (!MD.getMarca().equals(" ")) {
                    cont++;
                    if (MD.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                break;
            case 3:
                if (!II.getMarca().equals(" ")) {
                    cont++;
                    if (II.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                if (!IC.getMarca().equals(" ")) {
                    cont++;
                    if (IC.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                if (!ID.getMarca().equals(" ")) {
                    cont++;
                    if (ID.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                break;

            default:
                throw new AssertionError();
        }

        System.out.println("ocupadas hay " + cont);

        return marcajugador;
    }

    public boolean jugarFila(int fila) {

        switch (fila) {
            case 1:
                if (SI.getMarca().equals(" ")) {
                    System.out.println("SI libre");
                    SI.setMarca(getMarcaAplicacion());
                }
                if (SC.getMarca().equals(" ")) {
                    System.out.println("SC libre");
                    SC.setMarca(getMarcaAplicacion());
                }
                if (SD.getMarca().equals(" ")) {
                    System.out.println("SD libre");
                    SD.setMarca(getMarcaAplicacion());
                }
                break;
            case 2:
                if (MI.getMarca().equals(" ")) {
                    System.out.println("MI libre");
                    MI.setMarca(getMarcaAplicacion());
                }
                if (MC.getMarca().equals(" ")) {
                    System.out.println("MC libre");
                    MC.setMarca(getMarcaAplicacion());
                }
                if (MD.getMarca().equals(" ")) {
                    System.out.println("MD libre");
                    MD.setMarca(getMarcaAplicacion());
                }
                break;
            case 3:
                if (II.getMarca().equals(" ")) {
                    System.out.println("II libre");
                    II.setMarca(getMarcaAplicacion());
                }
                if (IC.getMarca().equals(" ")) {
                    System.out.println("IC libre");
                    IC.setMarca(getMarcaAplicacion());
                }
                if (ID.getMarca().equals(" ")) {
                    System.out.println("ID libre");
                    ID.setMarca(getMarcaAplicacion());
                }
                break;

            default:
                throw new AssertionError();
        }
        return true;
    }

    public int evaluarCol(int col) {
        int cont = 0;
        int marcajugador = 0;
        switch (col) {
            case 1:
                if (!SI.getMarca().equals(" ")) {
                    cont++;
                    if (SI.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                if (!MI.getMarca().equals(" ")) {
                    cont++;
                    if (MI.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                if (!II.getMarca().equals(" ")) {
                    cont++;
                    if (II.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                break;
            case 2:
                if (!SC.getMarca().equals(" ")) {
                    cont++;
                    if (SC.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                if (!MC.getMarca().equals(" ")) {
                    cont++;
                    if (MC.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                if (!IC.getMarca().equals(" ")) {
                    cont++;
                    if (IC.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                break;
            case 3:
                if (!SD.getMarca().equals(" ")) {
                    cont++;
                    if (SD.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                if (!MD.getMarca().equals(" ")) {
                    cont++;
                    if (MD.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                if (!ID.getMarca().equals(" ")) {
                    cont++;
                    if (ID.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                break;

            default:
                throw new AssertionError();
        }

        return marcajugador;
    }

    public boolean jugarCol(int col) {

        switch (col) {
            case 1:
                if (SI.getMarca().equals(" ")) {
                    System.out.println("Col: SI libre");
                    SI.setMarca(getMarcaAplicacion());
                }
                if (MI.getMarca().equals(" ")) {
                    System.out.println("Col: MI libre");
                    MI.setMarca(getMarcaAplicacion());
                }
                if (II.getMarca().equals(" ")) {
                    System.out.println("Col: II libre");
                    II.setMarca(getMarcaAplicacion());
                }
                break;
            case 2:
                if (SC.getMarca().equals(" ")) {
                    System.out.println("Col: SC libre");
                    SC.setMarca(getMarcaAplicacion());
                }
                if (MC.getMarca().equals(" ")) {
                    System.out.println("Col: MC libre");
                    MC.setMarca(getMarcaAplicacion());
                }
                if (IC.getMarca().equals(" ")) {
                    System.out.println("Col IC libre");
                    IC.setMarca(getMarcaAplicacion());
                }
                break;
            case 3:
                if (SD.getMarca().equals(" ")) {
                    System.out.println("Col: SD libre");
                    II.setMarca(getMarcaAplicacion());
                }
                if (MD.getMarca().equals(" ")) {
                    System.out.println("Col: MD libre");
                    MD.setMarca(getMarcaAplicacion());
                }
                if (ID.getMarca().equals(" ")) {
                    System.out.println("Col: ID libre");
                    ID.setMarca(getMarcaAplicacion());
                }
                break;

            default:
                throw new AssertionError();
        }
        return true;
    }

    public int evaluarDiagonal(int diagonal) {
        int cont = 0;
        int marcajugador = 0;

        switch (diagonal) {
            case 1:
                if (!SI.getMarca().equals(" ")) {
                    cont++;
                    if (SI.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }

                }
                if (!MC.getMarca().equals(" ")) {
                    cont++;
                    if (MC.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }

                }
                if (!ID.getMarca().equals(" ")) {
                    cont++;
                    if (ID.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }

                }
                break;
            case 2:
                if (!SD.getMarca().equals(" ")) {
                    cont++;
                    if (SD.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                if (!MC.getMarca().equals(" ")) {
                    cont++;
                    if (MC.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                if (!II.getMarca().equals(" ")) {
                    cont++;
                    if (II.getMarca().equals(this.marca)) {
                        marcajugador++;
                    }
                }
                break;

            default:
                throw new AssertionError();
        }

        return marcajugador;
    }

    public boolean jugarDiagonal(int diagonal) {

        switch (diagonal) {
            case 1:
                if (SI.getMarca().equals(" ")) {
                    System.out.println("SI libre");
                    SI.setMarca(getMarcaAplicacion());
                }
                if (MC.getMarca().equals(" ")) {
                    System.out.println("MC libre");
                    MC.setMarca(getMarcaAplicacion());
                }
                if (ID.getMarca().equals(" ")) {
                    System.out.println("ID libre");
                    ID.setMarca(getMarcaAplicacion());
                }
                break;
            case 2:
                if (SD.getMarca().equals(" ")) {
                    System.out.println("SD libre");
                    SD.setMarca(getMarcaAplicacion());
                }
                if (MC.getMarca().equals(" ")) {
                    System.out.println("MC libre");
                    MC.setMarca(getMarcaAplicacion());
                }
                if (II.getMarca().equals(" ")) {
                    System.out.println("II libre");
                    II.setMarca(getMarcaAplicacion());
                }
                break;

            default:
                throw new AssertionError();
        }
        return true;
    }

    //ganador
    public void ganador() {
        if (SI.getMarca() == SC.getMarca() && SI.getMarca() == SD.getMarca()) 
            System.out.println("hay un ganador");
            else 
                        if (MI.getMarca() == MC.getMarca() && MI.getMarca() == MD.getMarca()) 
                            System.out.println("hay un ganador");
                        else 
                            if (II.getMarca() == IC.getMarca() && II.getMarca() == ID.getMarca()) 
                                System.out.println("hay un ganador");
                             //
                            else 
                                if (SI.getMarca() == MI.getMarca() && MI.getMarca() == II.getMarca()) 
                                    System.out.println("hay un ganador");
                                 else 
                                    if (SC.getMarca() == MC.getMarca() && SC.getMarca() == IC.getMarca()) 
                                        System.out.println("hay un ganador");
                                    else 
                                        if (SD.getMarca() == MD.getMarca() && SD.getMarca() == ID.getMarca()) 
                                            System.out.println("hay un ganador");
                                         //
                                        else 
                                            if (SI.getMarca() == MC.getMarca() && SI.getMarca() == ID.getMarca()) 
                                                System.out.println("hay un ganador");
                                             else 
                                                if (SD.getMarca() == MC.getMarca() && SD.getMarca() == II.getMarca()) 
                                                    System.out.println("hay un ganador");
        else 
                                                    System.out.println("siguiente jugada");
                                                
    }
//
                                            }
