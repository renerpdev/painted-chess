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

/**
 *
 * @author Rene
 */
public class CanWalk {

    Controlador controlador;

    public CanWalk(Controlador controlador) {
        this.controlador = controlador;
    }

  public  void canWalk_PEON(int i, int j, Pieza p) {
        CROSS_UPDOWN_FORWARD_Peon(i, j, p);
        CROSS_UPDOWN_BACKWARD_Peon(i, j, p);
        UP_Peon(i, j, p);
    }

  public  void canWalk_REY(int i, int j, Pieza p) {
        DOWN_Rey(i, j, p);
        FORWARD_Rey(i, j, p);
        BACKWARD_Rey(i, j, p);
        UP_Rey(i, j, p);
        CROSS_DOWN_FORWARD_Rey(i, j, p);
        CROSS_UP_FORWARD_Rey(i, j, p);
        CROSS_DOWN_BACKWARD_Rey(i, j, p);
        CROSS_UP_BACKWARD_Rey(i, j, p);

    }

  public  void canWalk_DAMA(int i, int j, Pieza pp) {
        CROSS_UP_FORWARD(i, j, pp);
        CROSS_UP_BACKWARD(i, j, pp);
        CROSS_DOWN_FORWARD(i, j, pp);
        CROSS_DOWN_BACKWARD(i, j, pp);
        DOWN(i, j, pp);
        FORWARD(i, j, pp);
        UP(i, j, pp);
        BACKWARD(i, j, pp);
    }

  public  void canWalk_ALFIL(int i, int j, Pieza pp) {
        CROSS_UP_FORWARD(i, j, pp);
        CROSS_UP_BACKWARD(i, j, pp);
        CROSS_DOWN_FORWARD(i, j, pp);
        CROSS_DOWN_BACKWARD(i, j, pp);
    }

   public void canWalk_CABALLO(int i, int j, Pieza p) {
        UP_LEFT_Caballo(i, j, p);
        UP_RIGHT_Caballo(i, j, p);
        DOWN_LEFT_Caballo(i, j, p);
        DOWN_RIGHT_Caballo(i, j, p);
        FORWARD_UP_Caballo(i, j, p);
        FORWARD_DOWN_Caballo(i, j, p);
        BACKWARD_UP_Caballo(i, j, p);
        BACKWARD_DOWN_Caballo(i, j, p);
    }

  public  void canWalk_TORRE(int i, int j, Pieza pp) {
        DOWN(i, j, pp);
        FORWARD(i, j, pp);
        UP(i, j, pp);
        BACKWARD(i, j, pp);
    }

    //-----------PEON---------------
    void CROSS_UPDOWN_FORWARD_Peon(int i, int j, Pieza pp) {

        j++;
        if (!Util.tableroInvertido) {
            if (pp.color.equals(Util.blancas)) {
                i--;
            } else {
                i++;
            }
        } else {
            if (pp.color.equals(Util.blancas)) {
                i++;
            } else {
                i--;
            }
        }
        if (controlador.isOnBoard(i, j)) {
            Pieza p = controlador.tablero.casillas[i][j].getPieza();

            if (p != null) {//si tiene una pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    Casilla cc = controlador.tablero.casillas[i][j];
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (pp.casilla.tapandoJake) {//si la jugada esta tapand un jake
                            if (cc.tapandoJake) {
                                if (!(p instanceof Rey)) {
                                    pp.puedeCaminar = true;
                                }
                            }

                        } else {
                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }

                    } else {//si esta en jake

                        if (cc.estaEnElJake && controlador.piezasAtacandoAlRey < 2) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }
                    }

                }

            }
        }

    }

    void CROSS_UPDOWN_BACKWARD_Peon(int i, int j, Pieza pp) {
        j--;
        if (!Util.tableroInvertido) {
            if (pp.color.equals(Util.blancas)) {
                i--;
            } else {
                i++;
            }
        } else {
            if (pp.color.equals(Util.blancas)) {
                i++;
            } else {
                i--;
            }
        }
        if (controlador.isOnBoard(i, j)) {
            Pieza p = controlador.tablero.casillas[i][j].getPieza();
            if (p != null) {//si tiene una pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    Casilla cc = controlador.tablero.casillas[i][j];
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (pp.casilla.tapandoJake) {//si la jugada esta tapand un jake
                            if (cc.tapandoJake) {

                                if (!(p instanceof Rey)) {
                                    pp.puedeCaminar = true;
                                }
                            }

                        } else {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }
                    } else {//si esta en jake

                        if (cc.estaEnElJake && controlador.piezasAtacandoAlRey < 2) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }
                    }

                }

            }
        }

    }

    void UP_Peon(int i, int j, Pieza pp) {
        Pieza p = controlador.tablero.casillas[i][j].getPieza();
        if (p.casillaInicio.id.equals(pp.casilla.id)) {//si esta en la casilla inicio
            Casilla cp = null;
            if (!Util.tableroInvertido) {
                if (pp.color.equals(Util.blancas)) {
                    i--;
                } else {
                    i++;
                }
            } else {
                if (pp.color.equals(Util.blancas)) {
                    i++;
                } else {
                    i--;
                }
            }

            Casilla c = controlador.tablero.casillas[i][j];
            cp = c;
            if (!Util.tableroInvertido) {
                if (pp.color.equals(Util.blancas)) {
                    i--;
                } else {
                    i++;
                }
            } else {
                if (pp.color.equals(Util.blancas)) {
                    i++;
                } else {
                    i--;
                }
            }
            Casilla cc = controlador.tablero.casillas[i][j];
            if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                if (!pp.casilla.tapandoJake) {//si la jugada no esta tapand un jake
                    if (c.getComponentCount() == 0) {
                        pp.puedeCaminar = true;

                    }
                    if (cc.getComponentCount() == 0 && c.getComponentCount() == 0) {
                        pp.puedeCaminar = true;
                    }
                } else {
                    if (c.getComponentCount() == 0 && c.tapandoJake) {
                        pp.puedeCaminar = true;

                    }
                    if (cc.getComponentCount() == 0 && cc.tapandoJake && c.getComponentCount() == 0) {
                        pp.puedeCaminar = true;
                    }
                }

            } else {//si esta en jake
                if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                    if (c.getComponentCount() == 0) {
                        pp.puedeCaminar = true;

                    }
                }
                if (cc.estaEnElJake && controlador.piezasAtacandoAlRey < 2) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                    if (cc.getComponentCount() == 0) {
                        pp.puedeCaminar = true;
                    }
                }
            }

        } else {//si esta en otra casilla del tablero
            Pieza pie = pp;
            if (!Util.tableroInvertido) {
                if (controlador.casillaPeonAlpasoN != null && i == 3 && pie.color.equals(Util.blancas)) {//si existe la jugada 'peon al paso' para las blancas
                    Casilla c1 = null, c2 = null;
                    if (controlador.isOnBoard(i - 1, j - 1)) {
                        c1 = controlador.tablero.casillas[i - 1][j - 1];
                    }
                    if (controlador.isOnBoard(i - 1, j + 1)) {
                        c2 = controlador.tablero.casillas[i - 1][j + 1];
                    }
                    if (c1 != null && c1.id.equals(controlador.casillaPeonAlpasoN.id)) {
                        if (!pp.casilla.tapandoJake) {
                            pp.puedeCaminar = true;
                        }
                    } else if (c2 != null && c2.id.equals(controlador.casillaPeonAlpasoN.id)) {
                        if (!pp.casilla.tapandoJake) {
                            pp.puedeCaminar = true;
                        }
                    }

                } else if (controlador.casillaPeonAlpasoB != null && i == 4 && pie.color.equals(Util.negras)) {//si existe la jugada 'peon al paso' para las negras
                    Casilla c1 = null, c2 = null;
                    if (controlador.isOnBoard(i + 1, j - 1)) {
                        c1 = controlador.tablero.casillas[i + 1][j - 1];
                    }
                    if (controlador.isOnBoard(i + 1, j + 1)) {
                        c2 = controlador.tablero.casillas[i + 1][j + 1];
                    }
                    if (c1 != null && c1.id.equals(controlador.casillaPeonAlpasoB.id)) {
                        if (!pp.casilla.tapandoJake) {
                            pp.puedeCaminar = true;
                        }

                    } else if (c2 != null && c2.id.equals(controlador.casillaPeonAlpasoB.id)) {
                        if (!pp.casilla.tapandoJake) {
                            pp.puedeCaminar = true;
                        }
                    }
                }
            } else {
                if (controlador.casillaPeonAlpasoN != null && i == 4 && pie.color.equals(Util.blancas)) {//si existe la jugada 'peon al paso' para las blancas
                    Casilla c1 = null, c2 = null;
                    if (controlador.isOnBoard(i + 1, j - 1)) {
                        c1 = controlador.tablero.casillas[i + 1][j - 1];
                    }
                    if (controlador.isOnBoard(i + 1, j + 1)) {
                        c2 = controlador.tablero.casillas[i + 1][j + 1];
                    }
                    if (c1 != null && c1.id.equals(controlador.casillaPeonAlpasoN.id)) {
                        if (!pp.casilla.tapandoJake) {
                            pp.puedeCaminar = true;
                        }
                    } else if (c2 != null && c2.id.equals(controlador.casillaPeonAlpasoN.id)) {
                        if (!pp.casilla.tapandoJake) {
                            pp.puedeCaminar = true;
                        }
                    }

                } else if (controlador.casillaPeonAlpasoB != null && i == 3 && pie.color.equals(Util.negras)) {//si existe la jugada 'peon al paso' para las negras
                    Casilla c1 = null, c2 = null;
                    if (controlador.isOnBoard(i - 1, j - 1)) {
                        c1 = controlador.tablero.casillas[i - 1][j - 1];
                    }
                    if (controlador.isOnBoard(i - 1, j + 1)) {
                        c2 = controlador.tablero.casillas[i - 1][j + 1];
                    }
                    if (c1 != null && c1.id.equals(controlador.casillaPeonAlpasoB.id)) {
                        if (!pp.casilla.tapandoJake) {
                            pp.puedeCaminar = true;
                        }

                    } else if (c2 != null && c2.id.equals(controlador.casillaPeonAlpasoB.id)) {
                        if (!pp.casilla.tapandoJake) {
                            pp.puedeCaminar = true;
                        }
                    }
                }
            }

            if (!Util.tableroInvertido) {
                if (pie.color.equals(Util.blancas)) {
                    i--;
                } else {
                    i++;
                }
            } else {
                if (pie.color.equals(Util.blancas)) {
                    i++;
                } else {
                    i--;
                }
            }

            if (controlador.isOnBoard(i, j)) {
                Casilla c = controlador.tablero.casillas[i][j];
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (c.getComponentCount() == 0) {
                        if (pp.casilla.tapandoJake) {
                            if (c.tapandoJake) {
                                pp.puedeCaminar = true;
                            }
                        } else {
                            pp.puedeCaminar = true;
                        }

                    }
                } else {//si esta en jake
                    if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        if (c.getComponentCount() == 0) {
                            pp.puedeCaminar = true;
                        }
                    }

                }

            }

        }

    }

    //-------------------------DAMA--------------------
    void UP(int i, int j, Pieza pp) {
        i--;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = controlador.tablero.casillas[i][j].getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (pp.casilla.tapandoJake) {
                        if (c.tapandoJake) {
                            pp.puedeCaminar = true;
                            return;
                        }

                    } else {
                        pp.puedeCaminar = true;
                        return;
                    }

                } else {
                    if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                        return;
                    }
                }

                UP(i, j, pp);//me muevo hacia arriba
            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (pp.casilla.tapandoJake) {
                            if (c.tapandoJake) {
                                pp.puedeCaminar = true;
                            }

                        } else {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;

                            }
                        }
                    } else {
                        if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }

                    }

                }
            }
        }

    }

    void DOWN(int i, int j, Pieza pp) {
        i++;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = controlador.tablero.casillas[i][j].getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (pp.casilla.tapandoJake) {
                        if (c.tapandoJake) {
                            pp.puedeCaminar = true;
                            return;
                        }

                    } else {
                        pp.puedeCaminar = true;
                        return;
                    }

                } else {
                    if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                        return;
                    }
                }

                DOWN(i, j, pp);//me muevo hacia arriba
            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (pp.casilla.tapandoJake) {
                            if (c.tapandoJake) {
                                pp.puedeCaminar = true;

                            }

                        } else {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;

                            }
                        }
                    } else {
                        if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;

                            }
                        }

                    }

                }
            }
        }

    }

    void BACKWARD(int i, int j, Pieza pp) {
        j--;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = controlador.tablero.casillas[i][j].getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (pp.casilla.tapandoJake) {
                        if (c.tapandoJake) {
                            pp.puedeCaminar = true;
                            return;
                        }

                    } else {
                        pp.puedeCaminar = true;
                        return;
                    }

                } else {
                    if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                        return;
                    }
                }

                BACKWARD(i, j, pp);//me muevo hacia arriba
            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (pp.casilla.tapandoJake) {
                            if (c.tapandoJake) {
                                pp.puedeCaminar = true;

                            }

                        } else {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;

                            }
                        }
                    } else {
                        if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;

                            }
                        }

                    }

                }
            }
        }

    }

    void FORWARD(int i, int j, Pieza pp) {
        j++;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = controlador.tablero.casillas[i][j].getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (pp.casilla.tapandoJake) {
                        if (c.tapandoJake) {
                            pp.puedeCaminar = true;
                            return;
                        }

                    } else {
                        pp.puedeCaminar = true;
                        return;
                    }

                } else {
                    if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                        return;
                    }
                }

                FORWARD(i, j, pp);//me muevo hacia arriba
            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (pp.casilla.tapandoJake) {
                            if (c.tapandoJake) {
                                pp.puedeCaminar = true;

                            }

                        } else {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;

                            }
                        }
                    } else {
                        if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;

                            }
                        }

                    }

                }
            }
        }

    }

    void CROSS_UP_FORWARD(int i, int j, Pieza pp) {
        j++;
        i--;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = controlador.tablero.casillas[i][j].getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (pp.casilla.tapandoJake) {
                        if (c.tapandoJake) {
                            pp.puedeCaminar = true;
                            return;
                        }

                    } else {
                        pp.puedeCaminar = true;
                        return;
                    }

                } else {
                    if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                        return;
                    }
                }

                CROSS_UP_FORWARD(i, j, pp);//me muevo hacia arriba
            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (pp.casilla.tapandoJake) {
                            if (c.tapandoJake) {
                                pp.puedeCaminar = true;

                            }

                        } else {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;

                            }
                        }
                    } else {
                        if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;

                            }
                        }

                    }

                }
            }
        }

    }

    void CROSS_UP_BACKWARD(int i, int j, Pieza pp) {
        j--;
        i--;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = controlador.tablero.casillas[i][j].getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (pp.casilla.tapandoJake) {
                        if (c.tapandoJake) {
                            pp.puedeCaminar = true;
                            return;
                        }

                    } else {
                        pp.puedeCaminar = true;
                        return;
                    }

                } else {
                    if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                        return;
                    }
                }

                CROSS_UP_BACKWARD(i, j, pp);//me muevo hacia arriba
            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (pp.casilla.tapandoJake) {
                            if (c.tapandoJake) {
                                pp.puedeCaminar = true;
                                return;
                            }

                        } else {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;

                            }
                        }
                    } else {
                        if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;

                            }
                        }

                    }

                }
            }
        }

    }

    void CROSS_DOWN_FORWARD(int i, int j, Pieza pp) {
        j++;
        i++;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = controlador.tablero.casillas[i][j].getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (pp.casilla.tapandoJake) {
                        if (c.tapandoJake) {
                            pp.puedeCaminar = true;
                            return;
                        }

                    } else {
                        pp.puedeCaminar = true;
                        return;
                    }

                } else {
                    if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                        return;
                    }
                }

                CROSS_DOWN_FORWARD(i, j, pp);//me muevo hacia arriba
            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (pp.casilla.tapandoJake) {
                            if (c.tapandoJake) {
                                pp.puedeCaminar = true;
                                return;
                            }

                        } else {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;

                            }
                        }
                    } else {
                        if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;

                            }
                        }

                    }

                }
            }
        }

    }

    void CROSS_DOWN_BACKWARD(int i, int j, Pieza pp) {
        j--;
        i++;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = controlador.tablero.casillas[i][j].getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (pp.casilla.tapandoJake) {
                        if (c.tapandoJake) {
                            pp.puedeCaminar = true;
                            return;
                        }

                    } else {
                        pp.puedeCaminar = true;
                        return;
                    }

                } else {
                    if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                        return;
                    }
                }

                CROSS_DOWN_BACKWARD(i, j, pp);//me muevo hacia arriba
            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (pp.casilla.tapandoJake) {
                            if (c.tapandoJake) {
                                pp.puedeCaminar = true;
                                return;
                            }

                        } else {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;

                            }
                        }
                    } else {
                        if (controlador.jugadorActual.rey.estaEnjake && controlador.piezasAtacandoAlRey < 2 && c.estaEnElJake && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;

                            }
                        }

                    }

                }
            }
        }

    }

    //----------------------REY-------------------
    void UP_Rey(int i, int j, Pieza pp) {
        i--;
        int ii = i;
        if (!hayRey(ii - 1, j, pp) && !hayRey(ii - 1, j - 1, pp) && !hayRey(ii - 1, j + 1, pp)) {
            if (controlador.isOnBoard(i, j)) {
                Pieza p = controlador.tablero.casillas[i][j].getPieza();
                if (p == null) {//si no tiene una pieza
                    if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                        pp.puedeCaminar = true;

                    }
                } else {//si tiene pieza
                    if (!p.color.equals(pp.color)) {//si son de color diferente
                        if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                            pp.puedeCaminar = true;

                        }

                    }

                }
            }
        }
    }

    void DOWN_Rey(int i, int j, Pieza pp) {
        i++;
        int ii = i;
        if (!hayRey(ii + 1, j, pp) && !hayRey(ii + 1, j - 1, pp) && !hayRey(ii + 1, j + 1, pp)) {
            if (controlador.isOnBoard(i, j)) {
                Pieza p = controlador.tablero.casillas[i][j].getPieza();
                if (p == null) {//si no tiene una pieza
                    if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                        pp.puedeCaminar = true;

                    }
                } else {//si tiene pieza
                    if (!p.color.equals(pp.color)) {//si son de color diferente
                        if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                            pp.puedeCaminar = true;

                        }
                    }
                }

            }

        }
    }

    void FORWARD_Rey(int i, int j, Pieza pp) {
        j++;
        int jj = j;
        if (!hayRey(i, j + 1, pp) && !hayRey(i + 1, j + 1, pp) && !hayRey(i - 1, j + 1, pp)) {
            if (controlador.isOnBoard(i, j)) {
                Pieza p = controlador.tablero.casillas[i][j].getPieza();
                if (p == null) {//si no tiene una pieza
                    if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                        pp.puedeCaminar = true;

                    }
                } else {//si tiene pieza
                    if (!p.color.equals(pp.color)) {//si son de color diferente
                        if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                            pp.puedeCaminar = true;

                        }
                    }
                }

            }
        }
    }

    void BACKWARD_Rey(int i, int j, Pieza pp) {
        j--;
        int jj = j;
        if (!hayRey(i, j - 1, pp) && !hayRey(i + 1, j - 1, pp) && !hayRey(i - 1, j - 1, pp)) {

            if (controlador.isOnBoard(i, j)) {
                Pieza p = controlador.tablero.casillas[i][j].getPieza();
                if (p == null) {//si no tiene una pieza
                    if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                        pp.puedeCaminar = true;

                    }

                } else {//si tiene pieza
                    if (!p.color.equals(pp.color)) {//si son de color diferente
                        if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                            pp.puedeCaminar = true;

                        }
                    }
                }

            }
        }
    }

    void CROSS_UP_BACKWARD_Rey(int i, int j, Pieza pp) {
        int ii = i, jj = j;
        j--;
        i--;
        if (!hayRey(ii - 2, jj - 2, pp) && !hayRey(ii - 2, jj, pp) && !hayRey(ii - 2, jj - 1, pp) && !hayRey(ii - 1, jj - 2, pp) && !hayRey(ii, jj - 2, pp)) {
            if (controlador.isOnBoard(i, j)) {
                Pieza p = controlador.tablero.casillas[i][j].getPieza();
                if (p == null) {//si no tiene una pieza
                    if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                        pp.puedeCaminar = true;

                    }

                } else {//si tiene pieza
                    if (!p.color.equals(pp.color)) {//si son de color diferente
                        if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                            pp.puedeCaminar = true;

                        }
                    }
                }

            }

        }
    }

    void CROSS_UP_FORWARD_Rey(int i, int j, Pieza pp) {
        int ii = i, jj = j;
        j++;
        i--;
        if (!hayRey(ii - 2, jj + 2, pp) && !hayRey(ii - 2, jj, pp) && !hayRey(ii - 2, jj + 1, pp) && !hayRey(ii - 1, jj + 2, pp) && !hayRey(ii, jj + 2, pp)) {
            if (controlador.isOnBoard(i, j)) {
                Pieza p = controlador.tablero.casillas[i][j].getPieza();
                if (p == null) {//si no tiene una pieza
                    if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                        pp.puedeCaminar = true;
                    }

                } else {//si tiene pieza
                    if (!p.color.equals(pp.color)) {//si son de color diferente
                        if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                            pp.puedeCaminar = true;
                        }
                    }
                }

            }
        }
    }

    void CROSS_DOWN_BACKWARD_Rey(int i, int j, Pieza pp) {
        int ii = i, jj = j;
        j--;
        i++;
        if (!hayRey(ii, jj - 2, pp) && !hayRey(ii + 1, jj - 2, pp) && !hayRey(ii + 2, jj + 2, pp) && !hayRey(ii + 2, jj - 1, pp) && !hayRey(ii + 2, jj, pp)) {
            if (controlador.isOnBoard(i, j)) {
                Pieza p = controlador.tablero.casillas[i][j].getPieza();
                if (p == null) {//si no tiene una pieza
                    if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                        pp.puedeCaminar = true;
                    }
                } else {//si tiene pieza
                    if (!p.color.equals(pp.color)) {//si son de color diferente
                        if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                            pp.puedeCaminar = true;
                        }
                    }
                }

            }
        }
    }

    void CROSS_DOWN_FORWARD_Rey(int i, int j, Pieza pp) {
        int ii = i, jj = j;
        j++;
        i++;
        if (!hayRey(ii + 2, jj, pp) && !hayRey(ii + 2, jj + 1, pp) && !hayRey(ii + 2, jj + 2, pp) && !hayRey(ii + 1, jj + 2, pp) && !hayRey(ii, jj + 2, pp)) {
            if (controlador.isOnBoard(i, j)) {
                Pieza p = controlador.tablero.casillas[i][j].getPieza();
                if (p == null) {//si no tiene una pieza
                    if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                        pp.puedeCaminar = true;
                    }
                } else {//si tiene pieza
                    if (!p.color.equals(pp.color)) {//si son de color diferente
                        if (!controlador.tablero.casillas[i][j].tieneAmenaza) {
                            pp.puedeCaminar = true;
                        }
                    }
                }

            }
        }

    }

    boolean hayRey(int i, int j, Pieza pp) {
        if (controlador.isOnBoard(i, j)) {
            Pieza p = controlador.tablero.casillas[i][j].getPieza();
            if (p != null) {//si tiene una pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (p instanceof Rey) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //-------------------CABALLO--------------------
    void UP_LEFT_Caballo(int i, int j, Pieza pp) {
        j--;
        i -= 2;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (!pp.casilla.tapandoJake) {
                        pp.puedeCaminar = true;
                    }

                } else {
                    if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                    }
                }

            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake

                        if (!(p instanceof Rey)) {
                            pp.puedeCaminar = true;
                        }
                    } else {
                        if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }

                    }

                }
            }
        }

    }

    void FORWARD_DOWN_Caballo(int i, int j, Pieza pp) {
        j += 2;
        i++;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (!pp.casilla.tapandoJake) {
                        pp.puedeCaminar = true;
                    }

                } else {
                    if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                    }
                }

            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (!pp.casilla.tapandoJake) {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }
                    } else {
                        if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }

                    }

                }
            }
        }

    }

    void DOWN_RIGHT_Caballo(int i, int j, Pieza pp) {
        j++;
        i += 2;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (!pp.casilla.tapandoJake) {
                        pp.puedeCaminar = true;
                    }

                } else {
                    if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                    }
                }

            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (!pp.casilla.tapandoJake) {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }
                    } else {
                        if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }

                    }

                }
            }
        }

    }

    void BACKWARD_DOWN_Caballo(int i, int j, Pieza pp) {
        j -= 2;
        i++;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (!pp.casilla.tapandoJake) {
                        pp.puedeCaminar = true;
                    }

                } else {
                    if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                    }
                }

            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (!pp.casilla.tapandoJake) {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }
                    } else {
                        if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }

                    }

                }
            }
        }

    }

    void UP_RIGHT_Caballo(int i, int j, Pieza pp) {
        j++;
        i -= 2;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (!pp.casilla.tapandoJake) {
                        pp.puedeCaminar = true;
                    }

                } else {
                    if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                    }
                }

            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (!pp.casilla.tapandoJake) {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }
                    } else {
                        if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }

                    }

                }
            }
        }

    }

    void FORWARD_UP_Caballo(int i, int j, Pieza pp) {
        j += 2;
        i--;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (!pp.casilla.tapandoJake) {
                        pp.puedeCaminar = true;
                    }

                } else {
                    if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                    }
                }

            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (!pp.casilla.tapandoJake) {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }
                    } else {
                        if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }

                    }

                }
            }
        }

    }

    void DOWN_LEFT_Caballo(int i, int j, Pieza pp) {
        j--;
        i += 2;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (!pp.casilla.tapandoJake) {
                        pp.puedeCaminar = true;
                    }

                } else {
                    if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                    }
                }

            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (!pp.casilla.tapandoJake) {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }
                    } else {
                        if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }

                    }

                }
            }
        }

    }

    void BACKWARD_UP_Caballo(int i, int j, Pieza pp) {
        j -= 2;
        i--;
        if (controlador.isOnBoard(i, j)) {
            Casilla c = controlador.tablero.casillas[i][j];
            Pieza p = c.getPieza();
            if (p == null) {//si no tiene una pieza
                if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                    if (!pp.casilla.tapandoJake) {
                        pp.puedeCaminar = true;
                    }

                } else {
                    if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza
                        pp.puedeCaminar = true;
                    }
                }

            } else {//si tiene pieza
                if (!p.color.equals(pp.color)) {//si son de color diferente
                    if (!controlador.jugadorActual.rey.estaEnjake) {//si el rey no esta en jake
                        if (!pp.casilla.tapandoJake) {

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }
                    } else {
                        if (c.estaEnElJake && controlador.piezasAtacandoAlRey < 2 && !pp.casilla.tapandoJake) {//si la casilla a la que me muevo tapa el jake y no ataca mas de una pieza

                            if (!(p instanceof Rey)) {
                                pp.puedeCaminar = true;
                            }
                        }

                    }

                }
            }
        }
    }
}
