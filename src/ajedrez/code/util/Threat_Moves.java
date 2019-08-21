/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.code.util;

import ajedrez.code.game.Casilla;
import ajedrez.code.game.Controlador;
import ajedrez.code.game.piezas.Rey;
import ajedrez.code.game.piezas.Pieza;
import java.io.Serializable;
import java.util.LinkedList;

/**
 *
 * @author Rene
 */
public class Threat_Moves {

    Controlador controlador;

    public Threat_Moves(Controlador controlador) {
        this.controlador = controlador;
    }

   public void getAmenazasPeon(int i, int j, Pieza pp) {

        if (!Util.tableroInvertido) {

            if (pp.color.equals(Util.blancas)) {//si es un peon blanco

                if (controlador.isOnBoard(i - 1, j - 1)) {
                    Casilla c = controlador.tablero.casillas[i - 1][j - 1];
                    if (c.pieza == null) {//si no tiene pieza
                        c.tieneAmenaza = true;
                    } else {
                        Pieza p = c.pieza;
                        if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                            if (p instanceof Rey) {
                                Rey r = (Rey) p;
                                controlador.piezasAtacandoAlRey++;
                                controlador.tablero.casillas[i][j].estaEnElJake = true;
                                r.estaEnjake = true;
                            }
                        } else {
                            if (!(p instanceof Rey)) {
                                c.tieneAmenaza = true;
                            }
                        }

                    }

                }

                if (controlador.isOnBoard(i - 1, j + 1)) {
                    Casilla c = controlador.tablero.casillas[i - 1][j + 1];
                    if (c.pieza == null) {//si no tiene pieza
                        c.tieneAmenaza = true;
                    } else {
                        Pieza p = c.pieza;
                        if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                            if (p instanceof Rey) {
                                Rey r = (Rey) p;
                                controlador.piezasAtacandoAlRey++;
                                controlador.tablero.casillas[i][j].estaEnElJake = true;
                                r.estaEnjake = true;
                            }
                        } else {
                            if (!(p instanceof Rey)) {
                                c.tieneAmenaza = true;
                            }
                        }
                    }
                }
            } else {//si es un peon negro
                if (controlador.isOnBoard(i + 1, j - 1)) {
                    Casilla c = controlador.tablero.casillas[i + 1][j - 1];
                    if (c.pieza == null) {//si no tiene pieza
                        c.tieneAmenaza = true;
                    } else {
                        Pieza p = c.pieza;
                        if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                            if (p instanceof Rey) {
                                Rey r = (Rey) p;
                                controlador.piezasAtacandoAlRey++;
                                controlador.tablero.casillas[i][j].estaEnElJake = true;
                                r.estaEnjake = true;
                            }
                        } else {
                            if (!(p instanceof Rey)) {
                                c.tieneAmenaza = true;
                            }
                        }
                    }

                }
                if (controlador.isOnBoard(i + 1, j + 1)) {
                    Casilla c = controlador.tablero.casillas[i + 1][j + 1];
                    if (c.pieza == null) {//si no tiene pieza
                        c.tieneAmenaza = true;
                    } else {
                        Pieza p = c.pieza;
                        if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                            if (p instanceof Rey) {
                                Rey r = (Rey) p;
                                controlador.piezasAtacandoAlRey++;
                                controlador.tablero.casillas[i][j].estaEnElJake = true;
                                r.estaEnjake = true;
                            }
                        } else {
                            if (!(p instanceof Rey)) {
                                c.tieneAmenaza = true;
                            }
                        }
                    }
                }
            }
        }//si el tablero esta invertido
        else{
            if (pp.color.equals(Util.blancas)) {//si es un peon blanco

                if (controlador.isOnBoard(i + 1, j - 1)) {
                    Casilla c = controlador.tablero.casillas[i + 1][j - 1];
                    if (c.pieza == null) {//si no tiene pieza
                        c.tieneAmenaza = true;
                    } else {
                        Pieza p = c.pieza;
                        if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                            if (p instanceof Rey) {
                                Rey r = (Rey) p;
                                controlador.piezasAtacandoAlRey++;
                                controlador.tablero.casillas[i][j].estaEnElJake = true;
                                r.estaEnjake = true;
                            }
                        } else {
                            if (!(p instanceof Rey)) {
                                c.tieneAmenaza = true;
                            }
                        }

                    }

                }

                if (controlador.isOnBoard(i + 1, j + 1)) {
                    Casilla c = controlador.tablero.casillas[i + 1][j + 1];
                    if (c.pieza == null) {//si no tiene pieza
                        c.tieneAmenaza = true;
                    } else {
                        Pieza p = c.pieza;
                        if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                            if (p instanceof Rey) {
                                Rey r = (Rey) p;
                                controlador.piezasAtacandoAlRey++;
                                controlador.tablero.casillas[i][j].estaEnElJake = true;
                                r.estaEnjake = true;
                            }
                        } else {
                            if (!(p instanceof Rey)) {
                                c.tieneAmenaza = true;
                            }
                        }
                    }
                }
            } else {//si es un peon negro
                if (controlador.isOnBoard(i - 1, j - 1)) {
                    Casilla c = controlador.tablero.casillas[i - 1][j - 1];
                    if (c.pieza == null) {//si no tiene pieza
                        c.tieneAmenaza = true;
                    } else {
                        Pieza p = c.pieza;
                        if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                            if (p instanceof Rey) {
                                Rey r = (Rey) p;
                                controlador.piezasAtacandoAlRey++;
                                controlador.tablero.casillas[i][j].estaEnElJake = true;
                                r.estaEnjake = true;
                            }
                        } else {
                            if (!(p instanceof Rey)) {
                                c.tieneAmenaza = true;
                            }
                        }
                    }

                }
                if (controlador.isOnBoard(i - 1, j + 1)) {
                    Casilla c = controlador.tablero.casillas[i - 1][j + 1];
                    if (c.pieza == null) {//si no tiene pieza
                        c.tieneAmenaza = true;
                    } else {
                        Pieza p = c.pieza;
                        if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                            if (p instanceof Rey) {
                                Rey r = (Rey) p;
                                controlador.piezasAtacandoAlRey++;
                                controlador.tablero.casillas[i][j].estaEnElJake = true;
                                r.estaEnjake = true;
                            }
                        } else {
                            if (!(p instanceof Rey)) {
                                c.tieneAmenaza = true;
                            }
                        }
                    }
                }
            }
        }

    }

   public void getAmenazasDama(int i, int j, Pieza pp) {
        LinkedList<Coordenada> lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasDOWN(i, j, pp, lc);
        lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasUP(i, j, pp, lc);
        lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasRIGHT(i, j, pp, lc);
        lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasLEFT(i, j, pp, lc);
        lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasDL(i, j, pp, lc);
        lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasDR(i, j, pp, lc);
        lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasUL(i, j, pp, lc);
        lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasUR(i, j, pp, lc);
    }

  public  void getAmenazasAlfil(int i, int j, Pieza pp) {
        LinkedList<Coordenada> lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasDL(i, j, pp, lc);
        lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasDR(i, j, pp, lc);
        lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasUL(i, j, pp, lc);
        lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasUR(i, j, pp, lc);
    }

 public   void getAmenazasTorre(int i, int j, Pieza pp) {
        LinkedList<Coordenada> lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasDOWN(i, j, pp, lc);
        lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasUP(i, j, pp, lc);
        lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasRIGHT(i, j, pp, lc);
        lc = new LinkedList<>();
        lc.add(new Coordenada(i, j));
        getAmenazasLEFT(i, j, pp, lc);
    }

  public  void getAmenazasRey(int i, int j) {
        if (controlador.isOnBoard(i - 1, j - 1)) {
            Casilla c = controlador.tablero.casillas[i - 1][j - 1];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            }
        }
        if (controlador.isOnBoard(i - 1, j + 1)) {
            Casilla c = controlador.tablero.casillas[i - 1][j + 1];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            }
        }

        if (controlador.isOnBoard(i, j - 1)) {
            Casilla c = controlador.tablero.casillas[i][j - 1];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            }
        }
        if (controlador.isOnBoard(i - 1, j)) {
            Casilla c = controlador.tablero.casillas[i - 1][j];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            }
        }

        if (controlador.isOnBoard(i + 1, j)) {
            Casilla c = controlador.tablero.casillas[i + 1][j];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            }
        }
        if (controlador.isOnBoard(i, j + 1)) {
            Casilla c = controlador.tablero.casillas[i][j + 1];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            }
        }

        if (controlador.isOnBoard(i + 1, j - 1)) {
            Casilla c = controlador.tablero.casillas[i + 1][j - 1];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            }
        }
        if (controlador.isOnBoard(i + 1, j + 1)) {
            Casilla c = controlador.tablero.casillas[i + 1][j + 1];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            }
        }
    }

  public  void getAmenazasCaballo(int i, int j, Pieza pp) {
        if (controlador.isOnBoard(i - 2, j - 1)) {
            Casilla c = controlador.tablero.casillas[i - 2][j - 1];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        controlador.piezasAtacandoAlRey++;
                        controlador.tablero.casillas[i][j].estaEnElJake = true;
                        r.estaEnjake = true;
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }
        }
        if (controlador.isOnBoard(i + 1, j + 2)) {
            Casilla c = controlador.tablero.casillas[i + 1][j + 2];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        r.estaEnjake = true;
                        controlador.piezasAtacandoAlRey++;
                        controlador.tablero.casillas[i][j].estaEnElJake = true;
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }
        }

        if (controlador.isOnBoard(i + 2, j + 1)) {
            Casilla c = controlador.tablero.casillas[i + 2][j + 1];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        r.estaEnjake = true;
                        controlador.piezasAtacandoAlRey++;
                        controlador.tablero.casillas[i][j].estaEnElJake = true;
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }
        }
        if (controlador.isOnBoard(i + 1, j - 2)) {
            Casilla c = controlador.tablero.casillas[i + 1][j - 2];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        controlador.piezasAtacandoAlRey++;
                        controlador.tablero.casillas[i][j].estaEnElJake = true;
                        r.estaEnjake = true;
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }
        }

        if (controlador.isOnBoard(i - 2, j + 1)) {
            Casilla c = controlador.tablero.casillas[i - 2][j + 1];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        controlador.piezasAtacandoAlRey++;
                        controlador.tablero.casillas[i][j].estaEnElJake = true;
                        r.estaEnjake = true;
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }
        }
        if (controlador.isOnBoard(i - 1, j + 2)) {
            Casilla c = controlador.tablero.casillas[i - 1][j + 2];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        controlador.piezasAtacandoAlRey++;
                        controlador.tablero.casillas[i][j].estaEnElJake = true;
                        r.estaEnjake = true;
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }
        }

        if (controlador.isOnBoard(i + 2, j - 1)) {
            Casilla c = controlador.tablero.casillas[i + 2][j - 1];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        controlador.piezasAtacandoAlRey++;
                        controlador.tablero.casillas[i][j].estaEnElJake = true;
                        r.estaEnjake = true;
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }
        }
        if (controlador.isOnBoard(i - 1, j - 2)) {
            Casilla c = controlador.tablero.casillas[i - 1][j - 2];
            if (c.pieza == null) {//si no tiene pieza
                c.tieneAmenaza = true;
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        controlador.piezasAtacandoAlRey++;
                        controlador.tablero.casillas[i][j].estaEnElJake = true;
                        r.estaEnjake = true;
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }

        }
    }

  public  void getAmenazasUP(int i, int j, Pieza pp, LinkedList<Coordenada> li) {
        i--;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            if (c.pieza == null) {//si no tiene pieza
                li.add(new Coordenada(i, j));
                c.tieneAmenaza = true;
                getAmenazasUP(i, j, pp, li);
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        controlador.piezasAtacandoAlRey++;
                        if (controlador.isOnBoard(i - 1, j)) {
                            controlador.tablero.casillas[i - 1][j].tieneAmenaza = true;
                        }
                        controlador.caminoDelJake.addAll(li);
                        r.estaEnjake = true;
                    } else {

                        Casilla cc = findJake_UP(i, j, pp);

                        if (cc != null) {
                            Coordenada cor = controlador.tablero.getCoordenada(pp.casilla);
                            pp.casilla.tapandoJake = true;
                            setCasillasTapandoJake_UP(cor.i, cor.j, cc);
                        }
                        li.removeAll(li);
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }
        }
    }

  public  void getAmenazasDOWN(int i, int j, Pieza pp, LinkedList<Coordenada> li) {
        i++;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            if (c.pieza == null) {//si no tiene pieza
                li.add(new Coordenada(i, j));
                c.tieneAmenaza = true;
                getAmenazasDOWN(i, j, pp, li);
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        controlador.piezasAtacandoAlRey++;
                        if (controlador.isOnBoard(i + 1, j)) {
                            controlador.tablero.casillas[i + 1][j].tieneAmenaza = true;
                        }
                        controlador.caminoDelJake.addAll(li);
                        r.estaEnjake = true;
                    } else {
                        Casilla cc = findJake_DOWN(i, j, pp);
                        if (cc != null) {
                            Coordenada cor = controlador.tablero.getCoordenada(pp.casilla);
                            pp.casilla.tapandoJake = true;
                            setCasillasTapandoJake_DOWN(cor.i, cor.j, cc);
                        }
                        li.removeAll(li);
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }
        }
    }

 public   void getAmenazasRIGHT(int i, int j, Pieza pp, LinkedList<Coordenada> li) {
        j++;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            if (c.pieza == null) {//si no tiene pieza
                li.add(new Coordenada(i, j));
                c.tieneAmenaza = true;
                getAmenazasRIGHT(i, j, pp, li);
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        controlador.piezasAtacandoAlRey++;
                        if (controlador.isOnBoard(i, j + 1)) {
                            controlador.tablero.casillas[i][j + 1].tieneAmenaza = true;
                        }
                        controlador.caminoDelJake.addAll(li);
                        r.estaEnjake = true;
                    } else {
                        Casilla cc = findJake_RIGHT(i, j, pp);
                        if (cc != null) {
                            Coordenada cor = controlador.tablero.getCoordenada(pp.casilla);
                            pp.casilla.tapandoJake = true;
                            setCasillasTapandoJake_RIGHT(cor.i, cor.j, cc);
                        }
                        li.removeAll(li);
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }
        }
    }

 public   void getAmenazasLEFT(int i, int j, Pieza pp, LinkedList<Coordenada> li) {
        j--;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            if (c.pieza == null) {//si no tiene pieza
                li.add(new Coordenada(i, j));
                c.tieneAmenaza = true;
                getAmenazasLEFT(i, j, pp, li);
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        controlador.piezasAtacandoAlRey++;
                        if (controlador.isOnBoard(i, j - 1)) {
                            controlador.tablero.casillas[i][j - 1].tieneAmenaza = true;
                        }
                        controlador.caminoDelJake.addAll(li);
                        r.estaEnjake = true;
                    } else {
                        Casilla cc = findJake_LEFT(i, j, pp);
                        if (cc != null) {
                            Coordenada cor = controlador.tablero.getCoordenada(pp.casilla);
                            pp.casilla.tapandoJake = true;
                            setCasillasTapandoJake_LEFT(cor.i, cor.j, cc);
                        }
                        li.removeAll(li);
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }
        }
    }

    void getAmenazasUL(int i, int j, Pieza pp, LinkedList<Coordenada> li) {
        j--;
        i--;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            if (c.pieza == null) {//si no tiene pieza
                li.add(new Coordenada(i, j));
                c.tieneAmenaza = true;
                getAmenazasUL(i, j, pp, li);
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo                    
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        controlador.piezasAtacandoAlRey++;
                        if (controlador.isOnBoard(i - 1, j - 1)) {
                            controlador.tablero.casillas[i - 1][j - 1].tieneAmenaza = true;
                        }
                        controlador.caminoDelJake.addAll(li);
                        r.estaEnjake = true;
                    } else {
                        Casilla cc = findJake_UL(i, j, pp);
                        if (cc != null) {
                            Coordenada cor = controlador.tablero.getCoordenada(pp.casilla);
                            pp.casilla.tapandoJake = true;
                            setCasillasTapandoJake_UL(cor.i, cor.j, cc);
                        }
                        li.removeAll(li);
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }
        }
    }

    void getAmenazasUR(int i, int j, Pieza pp, LinkedList<Coordenada> li) {
        j++;
        i--;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            if (c.pieza == null) {//si no tiene pieza
                li.add(new Coordenada(i, j));
                c.tieneAmenaza = true;
                getAmenazasUR(i, j, pp, li);
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        controlador.piezasAtacandoAlRey++;
                        if (controlador.isOnBoard(i - 1, j + 1)) {
                            controlador.tablero.casillas[i - 1][j + 1].tieneAmenaza = true;
                        }
                        controlador.caminoDelJake.addAll(li);
                        r.estaEnjake = true;
                    } else {
                        Casilla cc = findJake_UR(i, j, pp);
                        if (cc != null) {
                            Coordenada cor = controlador.tablero.getCoordenada(pp.casilla);
                            pp.casilla.tapandoJake = true;
                            setCasillasTapandoJake_UR(cor.i, cor.j, cc);
                        }
                        li.removeAll(li);
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }
        }
    }

    void getAmenazasDL(int i, int j, Pieza pp, LinkedList<Coordenada> li) {
        i++;
        j--;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            if (c.pieza == null) {//si no tiene pieza
                li.add(new Coordenada(i, j));
                c.tieneAmenaza = true;
                getAmenazasDL(i, j, pp, li);
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        controlador.piezasAtacandoAlRey++;
                        if (controlador.isOnBoard(i + 1, j - 1)) {
                            controlador.tablero.casillas[i + 1][j - 1].tieneAmenaza = true;
                        }
                        controlador.caminoDelJake.addAll(li);
                        r.estaEnjake = true;
                    } else {
                        Casilla cc = findJake_DL(i, j, pp);
                        if (cc != null) {
                            Coordenada cor = controlador.tablero.getCoordenada(pp.casilla);
                            pp.casilla.tapandoJake = true;
                            setCasillasTapandoJake_DL(cor.i, cor.j, cc);
                        }
                        li.removeAll(li);
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }
        }
    }

    void getAmenazasDR(int i, int j, Pieza pp, LinkedList<Coordenada> li) {
        i++;
        j++;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            if (c.pieza == null) {//si no tiene pieza
                li.add(new Coordenada(i, j));
                c.tieneAmenaza = true;
                getAmenazasDR(i, j, pp, li);
            } else {
                Pieza p = c.pieza;
                if (!pp.color.equals(p.color)) {//si el color de la pieza de la casilla no es igual a la q utilizo
                    if (p instanceof Rey) {
                        Rey r = (Rey) p;
                        controlador.piezasAtacandoAlRey++;
                        if (controlador.isOnBoard(i + 1, j + 1)) {
                            controlador.tablero.casillas[i + 1][j + 1].tieneAmenaza = true;
                        }
                        controlador.caminoDelJake.addAll(li);
                        r.estaEnjake = true;
                    } else {
                        Casilla cc = findJake_DR(i, j, pp);
                        if (cc != null) {
                            Coordenada cor = controlador.tablero.getCoordenada(pp.casilla);
                            pp.casilla.tapandoJake = true;
                            setCasillasTapandoJake_DR(cor.i, cor.j, cc);
                        }
                        li.removeAll(li);
                    }
                } else {
                    if (!(p instanceof Rey)) {
                        c.tieneAmenaza = true;
                    }
                }
            }
        }
    }

    //casilla q tapan el jake
    Casilla findJake_UP(int i, int j, Pieza pp) {
        i--;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.pieza;

            if (p != null) {//si tine pieza
                if (!pp.color.equals(p.color)) {
                    if (p instanceof Rey) {
                        return c;
                    }
                }

            } else {
                return findJake_UP(i, j, pp);
            }

        }

        return null;

    }

    Casilla findJake_DOWN(int i, int j, Pieza pp) {
        i++;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.pieza;

            if (p != null) {//si tine pieza
                if (!pp.color.equals(p.color)) {
                    if (p instanceof Rey) {
                        return c;
                    }
                }
            } else {
                return findJake_DOWN(i, j, pp);
            }
        }

        return null;

    }

    Casilla findJake_LEFT(int i, int j, Pieza pp) {
        j--;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.pieza;

            if (p != null) {//si tine pieza
                if (!pp.color.equals(p.color)) {
                    if (p instanceof Rey) {
                        return c;
                    }
                }

            } else {
                return findJake_LEFT(i, j, pp);
            }

        }

        return null;

    }

    Casilla findJake_RIGHT(int i, int j, Pieza pp) {
        j++;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.pieza;

            if (p != null) {//si tine pieza
                if (!pp.color.equals(p.color)) {
                    if (p instanceof Rey) {
                        return c;
                    }
                }

            } else {
                return findJake_RIGHT(i, j, pp);
            }

        }

        return null;

    }

    Casilla findJake_UL(int i, int j, Pieza pp) {
        i--;
        j--;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.pieza;

            if (p != null) {//si tine pieza
                if (!pp.color.equals(p.color)) {
                    if (p instanceof Rey) {
                        return c;
                    }
                }

            } else {
                return findJake_UL(i, j, pp);
            }

        }

        return null;

    }

    Casilla findJake_UR(int i, int j, Pieza pp) {
        i--;
        j++;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.pieza;

            if (p != null) {//si tine pieza
                if (!pp.color.equals(p.color)) {
                    if (p instanceof Rey) {
                        return c;
                    }
                }

            } else {
                return findJake_UR(i, j, pp);
            }

        }

        return null;

    }

    Casilla findJake_DL(int i, int j, Pieza pp) {
        i++;
        j--;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.pieza;

            if (p != null) {//si tine pieza
                if (!pp.color.equals(p.color)) {
                    if (p instanceof Rey) {
                        return c;
                    }

                }
            } else {
                return findJake_DL(i, j, pp);
            }
        }

        return null;

    }

    Casilla findJake_DR(int i, int j, Pieza pp) {
        i++;
        j++;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.pieza;

            if (p != null) {//si tine pieza
                if (!pp.color.equals(p.color)) {
                    if (p instanceof Rey) {
                        return c;
                    }
                }
            } else {
                return findJake_DR(i, j, pp);
            }

        }

        return null;

    }

    void setCasillasTapandoJake_UP(int i_ini, int j_ini, Casilla fin) {
        i_ini--;
        if (controlador.isOnBoard(i_ini, j_ini)) {
            Casilla temp = controlador.tablero.casillas[i_ini][j_ini];
            temp.tapandoJake = true;
            if (!temp.equals(fin)) {
                setCasillasTapandoJake_UP(i_ini, j_ini, fin);
            }
        }

    }

    void setCasillasTapandoJake_DOWN(int i_ini, int j_ini, Casilla fin) {
        i_ini++;
        if (controlador.isOnBoard(i_ini, j_ini)) {
            Casilla temp = controlador.tablero.casillas[i_ini][j_ini];
            temp.tapandoJake = true;
            if (!temp.equals(fin)) {
                setCasillasTapandoJake_DOWN(i_ini, j_ini, fin);
            }
        }

    }

    void setCasillasTapandoJake_RIGHT(int i_ini, int j_ini, Casilla fin) {
        j_ini++;
        if (controlador.isOnBoard(i_ini, j_ini)) {
            Casilla temp = controlador.tablero.casillas[i_ini][j_ini];
            temp.tapandoJake = true;
            if (!temp.equals(fin)) {
                setCasillasTapandoJake_RIGHT(i_ini, j_ini, fin);
            }
        }

    }

    void setCasillasTapandoJake_LEFT(int i_ini, int j_ini, Casilla fin) {
        j_ini--;
        if (controlador.isOnBoard(i_ini, j_ini)) {
            Casilla temp = controlador.tablero.casillas[i_ini][j_ini];
            temp.tapandoJake = true;
            if (!temp.equals(fin)) {
                setCasillasTapandoJake_LEFT(i_ini, j_ini, fin);
            }
        }

    }

    void setCasillasTapandoJake_UR(int i_ini, int j_ini, Casilla fin) {
        i_ini--;
        j_ini++;
        if (controlador.isOnBoard(i_ini, j_ini)) {
            Casilla temp = controlador.tablero.casillas[i_ini][j_ini];
            temp.tapandoJake = true;
            if (!temp.equals(fin)) {
                setCasillasTapandoJake_UR(i_ini, j_ini, fin);
            }
        }

    }

    void setCasillasTapandoJake_UL(int i_ini, int j_ini, Casilla fin) {
        i_ini--;
        j_ini--;
        if (controlador.isOnBoard(i_ini, j_ini)) {
            Casilla temp = controlador.tablero.casillas[i_ini][j_ini];
            temp.tapandoJake = true;
            if (!temp.equals(fin)) {
                setCasillasTapandoJake_UL(i_ini, j_ini, fin);
            }
        }

    }

    void setCasillasTapandoJake_DR(int i_ini, int j_ini, Casilla fin) {
        i_ini++;
        j_ini++;
        if (controlador.isOnBoard(i_ini, j_ini)) {
            Casilla temp = controlador.tablero.casillas[i_ini][j_ini];
            temp.tapandoJake = true;
            if (!temp.equals(fin)) {
                setCasillasTapandoJake_DR(i_ini, j_ini, fin);
            }
        }

    }

    void setCasillasTapandoJake_DL(int i_ini, int j_ini, Casilla fin) {
        i_ini++;
        j_ini--;
        if (controlador.isOnBoard(i_ini, j_ini)) {
            Casilla temp = controlador.tablero.casillas[i_ini][j_ini];
            temp.tapandoJake = true;
            if (!temp.equals(fin)) {
                setCasillasTapandoJake_DL(i_ini, j_ini, fin);
            }
        }

    }

}
