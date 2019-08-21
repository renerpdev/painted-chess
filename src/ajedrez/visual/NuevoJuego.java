/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ajedrez.visual;

import ajedrez.visual.game_interface.Interfaz;
import ajedrez.code.util.Sound;
import ajedrez.code.util.Util;
import com.sun.java.swing.plaf.windows.WindowsLookAndFeel;
import java.awt.Toolkit;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import net.sourceforge.napkinlaf.NapkinLookAndFeel;

/**
 *
 * @author Rene
 */
public class NuevoJuego extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public NuevoJuego() {
        Sound.init();
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/ajedrez/images/app_icon.png")));
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        
        
        jCheckBox1.setVisible(false);
        jCheckBox2.setVisible(false);
        
        
        casillasClaras.setBackground(Util.carmelita);
        casillasOscuras.setBackground(Util.marron);
        casillasAmenazadas.setBackground(Util.killing);
        casillasVacias.setBackground(Util.walking);
        casillasAmenazadas3.setBackground(Util.seleccion);

        jLabel2.setText(Util.idioma[7]);
        jLabel8.setText(Util.idioma[7]);
        jLabel4.setText(Util.idioma[5]);
        jLabel5.setText(Util.idioma[6]);
        jLabel10.setText(Util.idioma[37]);
        jLabel11.setText(Util.idioma[38]);
        jLabel12.setText(Util.idioma[39]);
        jCheckBox1.setText(Util.idioma[10]);
        jCheckBox2.setText(Util.idioma[10]);
        jCheckBox3.setText(Util.idioma[78]);
        jCheckBox4.setText(Util.idioma[15]);
        jLabel1.setText(Util.idioma[1]);
        setTitle(Util.idioma[60]);
        jButton3.setText(Util.idioma[9]);
        m.setValue(15);
//        setChangeListener_MIN(m);
        pack();
    }

    void setNewGame() {
        if (nombre1.getText().length() <= 12 && nombre2.getText().length() <= 12) {
            if (!nombre1.getText().equals("") && !nombre2.getText().equals("")) {
                if (!nombre1.getText().equals(nombre2.getText())) {
                    if (!casillasClaras.getBackground().equals(casillasOscuras.getBackground()) && !casillasClaras.getBackground().equals(casillasAmenazadas.getBackground())
                            && !casillasClaras.getBackground().equals(casillasVacias.getBackground()) && !casillasClaras.getBackground().equals(casillasAmenazadas3.getBackground())
                            && !casillasOscuras.getBackground().equals(casillasAmenazadas.getBackground()) && !casillasOscuras.getBackground().equals(casillasVacias.getBackground())
                            && !casillasOscuras.getBackground().equals(casillasAmenazadas3.getBackground())
                            && !casillasAmenazadas.getBackground().equals(casillasVacias.getBackground()) && !casillasAmenazadas.getBackground().equals(casillasAmenazadas3.getBackground())) {
                        int minutes = (int) m.getValue();
                        int hor = 0;
                        int min = minutes;
                        if (minutes > 59) {
                            hor = 1;
                            min = minutes - 60;
                        }
                        if (minutes >= 1 && minutes <= 90) {

                            Util.carmelita = casillasClaras.getBackground();
                            Util.walking = casillasVacias.getBackground();
                            Util.killing = casillasAmenazadas.getBackground();
                            Util.marron = casillasOscuras.getBackground();
                            Util.seleccion = casillasAmenazadas3.getBackground();
                            Util.mostrarPosibleJugada = jCheckBox4.isSelected();
                            Util.tableroInvertido = jCheckBox3.isSelected();
                            Util.min = min;
                            Util.hour = hor;
                            dispose();
                            try {
                                UIManager.setLookAndFeel(new WindowsLookAndFeel());
                                new Interfaz(nombre1.getText(), nombre2.getText(), jCheckBox1.isSelected(), jCheckBox2.isSelected());
                            } catch (UnsupportedLookAndFeelException ex) {
                            }

                        } else {
                            Util.showError(Util.idioma[75], Util.idioma[74]);
                        }

                    } else {
                        Util.showWarning(Util.idioma[11]);
                    }
                } else {
                    Util.showWarning(Util.idioma[12]);
                }
            } else {
                Util.showWarning(Util.idioma[13]);
            }
        } else {
            Util.showWarning(Util.idioma[84]);

        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        nombre1 = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jColorChooser1 = new javax.swing.JColorChooser();
        jButton3 = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        nombre2 = new javax.swing.JTextField();
        jCheckBox2 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        casillasClaras = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        casillasOscuras = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        casillasAmenazadas = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        casillasVacias = new javax.swing.JPanel();
        jButton8 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();
        casillasAmenazadas3 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        m = new javax.swing.JSpinner();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Menu de Inicio");
        setResizable(false);
        setType(java.awt.Window.Type.POPUP);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel1.setFocusable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("Llene los datos del juego:");
        jLabel1.setFocusable(false);
        jPanel1.add(jLabel1);

        getContentPane().add(jPanel1, java.awt.BorderLayout.PAGE_START);

        jPanel2.setBackground(new java.awt.Color(102, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setFocusable(false);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, Util.idioma[2], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel3.setFocusable(false);
        jPanel3.setOpaque(false);

        jLabel2.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Nombre:");
        jLabel2.setFocusable(false);

        nombre1.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        nombre1.setForeground(new java.awt.Color(255, 255, 255));
        nombre1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombre1.setNextFocusableComponent(nombre2);
        nombre1.setOpaque(false);
        nombre1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombre1KeyPressed(evt);
            }
        });

        jCheckBox1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox1.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox1.setText("PC");
        jCheckBox1.setFocusable(false);
        jCheckBox1.setOpaque(false);
        jCheckBox1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox1MouseClicked(evt);
            }
        });
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(nombre1, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jCheckBox1)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox1)
                .addContainerGap())
        );

        jPanel2.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 200, 70));

        jColorChooser1.setFocusable(false);
        jColorChooser1.setOpaque(false);
        jPanel2.add(jColorChooser1, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 10, 420, 258));

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/Window.png"))); // NOI18N
        jButton3.setText("Finalizar");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setNextFocusableComponent(nombre1);
        jButton3.setOpaque(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 490, -1, -1));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, Util.idioma[3], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel5.setFocusable(false);
        jPanel5.setOpaque(false);

        jLabel8.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Nombre:");
        jLabel8.setFocusable(false);

        nombre2.setFont(new java.awt.Font("Segoe UI", 1, 11)); // NOI18N
        nombre2.setForeground(new java.awt.Color(255, 255, 255));
        nombre2.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        nombre2.setNextFocusableComponent(jButton3);
        nombre2.setOpaque(false);
        nombre2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nombre2KeyPressed(evt);
            }
        });

        jCheckBox2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox2.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox2.setText("PC");
        jCheckBox2.setFocusable(false);
        jCheckBox2.setOpaque(false);
        jCheckBox2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox2MouseClicked(evt);
            }
        });
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addComponent(nombre2, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jCheckBox2)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nombre2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jCheckBox2)
                .addContainerGap())
        );

        jPanel2.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 200, 70));

        jLabel6.setText("________________________________________________________________________________");
        jLabel6.setEnabled(false);
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 470, -1, -1));

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, Util.idioma[4], javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(204, 204, 204))); // NOI18N
        jPanel4.setFocusable(false);
        jPanel4.setOpaque(false);

        casillasClaras.setBackground(new java.awt.Color(255, 255, 255));
        casillasClaras.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casillasClaras.setFocusable(false);

        javax.swing.GroupLayout casillasClarasLayout = new javax.swing.GroupLayout(casillasClaras);
        casillasClaras.setLayout(casillasClarasLayout);
        casillasClarasLayout.setHorizontalGroup(
            casillasClarasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        casillasClarasLayout.setVerticalGroup(
            casillasClarasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Casillas Claras:");
        jLabel4.setFocusable(false);

        jButton5.setText(Util.idioma[76]);
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.setFocusable(false);
        jButton5.setOpaque(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText(Util.idioma[76]);
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.setFocusable(false);
        jButton6.setOpaque(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Casillas Oscuras:");
        jLabel5.setFocusable(false);

        casillasOscuras.setBackground(new java.awt.Color(255, 255, 255));
        casillasOscuras.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casillasOscuras.setFocusable(false);

        javax.swing.GroupLayout casillasOscurasLayout = new javax.swing.GroupLayout(casillasOscuras);
        casillasOscuras.setLayout(casillasOscurasLayout);
        casillasOscurasLayout.setHorizontalGroup(
            casillasOscurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        casillasOscurasLayout.setVerticalGroup(
            casillasOscurasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jLabel10.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Casilla amenazada:");
        jLabel10.setFocusable(false);

        casillasAmenazadas.setBackground(new java.awt.Color(255, 255, 255));
        casillasAmenazadas.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casillasAmenazadas.setFocusable(false);

        javax.swing.GroupLayout casillasAmenazadasLayout = new javax.swing.GroupLayout(casillasAmenazadas);
        casillasAmenazadas.setLayout(casillasAmenazadasLayout);
        casillasAmenazadasLayout.setHorizontalGroup(
            casillasAmenazadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        casillasAmenazadasLayout.setVerticalGroup(
            casillasAmenazadasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jButton7.setText(Util.idioma[76]);
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.setFocusable(false);
        jButton7.setOpaque(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Casilla Vacía:");
        jLabel11.setFocusable(false);

        casillasVacias.setBackground(new java.awt.Color(255, 255, 255));
        casillasVacias.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casillasVacias.setFocusable(false);

        javax.swing.GroupLayout casillasVaciasLayout = new javax.swing.GroupLayout(casillasVacias);
        casillasVacias.setLayout(casillasVaciasLayout);
        casillasVaciasLayout.setHorizontalGroup(
            casillasVaciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        casillasVaciasLayout.setVerticalGroup(
            casillasVaciasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jButton8.setText(Util.idioma[76]);
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.setFocusable(false);
        jButton8.setOpaque(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 3, 10)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Casilla Seleccionada:");
        jLabel12.setFocusable(false);

        casillasAmenazadas3.setBackground(new java.awt.Color(255, 255, 255));
        casillasAmenazadas3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        casillasAmenazadas3.setFocusable(false);

        javax.swing.GroupLayout casillasAmenazadas3Layout = new javax.swing.GroupLayout(casillasAmenazadas3);
        casillasAmenazadas3.setLayout(casillasAmenazadas3Layout);
        casillasAmenazadas3Layout.setHorizontalGroup(
            casillasAmenazadas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 48, Short.MAX_VALUE)
        );
        casillasAmenazadas3Layout.setVerticalGroup(
            casillasAmenazadas3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 39, Short.MAX_VALUE)
        );

        jButton9.setText(Util.idioma[76]);
        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.setFocusable(false);
        jButton9.setOpaque(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel4)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(casillasClaras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(casillasAmenazadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(casillasAmenazadas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jButton7)
                                        .addGap(0, 135, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel11)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(casillasVacias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addComponent(jButton5)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jLabel5)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(casillasOscuras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton6)
                            .addComponent(jButton8)))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addComponent(jButton9)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(casillasClaras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jButton6)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jButton5))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(casillasOscuras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10)
                            .addComponent(casillasAmenazadas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jButton7)
                                    .addComponent(jButton8)))
                            .addComponent(jLabel11)
                            .addComponent(casillasVacias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel12)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton9)
                        .addComponent(casillasAmenazadas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(27, Short.MAX_VALUE))
        );

        jPanel2.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(12, 272, 640, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText(Util.idioma[77]);
        jLabel7.setFocusable(false);
        jPanel2.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, -1, -1));

        m.setModel(new javax.swing.SpinnerNumberModel(1, 1, 90, 1));
        m.setFocusable(false);
        m.setOpaque(false);
        jPanel2.add(m, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 210, 40, -1));

        jCheckBox3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox3.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox3.setText("Invertir tablero");
        jCheckBox3.setFocusable(false);
        jCheckBox3.setOpaque(false);
        jCheckBox3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox3MouseClicked(evt);
            }
        });
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox3ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jCheckBox4.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jCheckBox4.setForeground(new java.awt.Color(255, 255, 255));
        jCheckBox4.setSelected(true);
        jCheckBox4.setText("Mostrar posibles jugadas");
        jCheckBox4.setFocusable(false);
        jCheckBox4.setOpaque(false);
        jCheckBox4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jCheckBox4MouseClicked(evt);
            }
        });
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox4ActionPerformed(evt);
            }
        });
        jPanel2.add(jCheckBox4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 170, -1, -1));

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ajedrez/images/House.png"))); // NOI18N
        jButton1.setText(Util.idioma[81]);
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.setFocusable(false);
        jButton1.setOpaque(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 490, -1, -1));

        getContentPane().add(jPanel2, java.awt.BorderLayout.PAGE_END);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // TODO add your handling code here:
        casillasAmenazadas3.setBackground(jColorChooser1.getColor());
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // TODO add your handling code here:
        casillasVacias.setBackground(jColorChooser1.getColor());
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        casillasAmenazadas.setBackground(jColorChooser1.getColor());
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jCheckBox3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox3ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox3.isSelected()) {
            jCheckBox3.setSelected(true);
        } else {
            jCheckBox3.setSelected(false);
        }
    }//GEN-LAST:event_jCheckBox3ActionPerformed

    private void jCheckBox3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox3MouseClicked

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        casillasOscuras.setBackground(jColorChooser1.getColor());
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        casillasClaras.setBackground(jColorChooser1.getColor());
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jCheckBox2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox2ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox2.isSelected()) {
            jCheckBox2.setSelected(true);
            nombre2.setText("PC2");
            nombre2.setEnabled(false);

        } else {
            jCheckBox2.setSelected(false);
            nombre2.setText("");
            nombre2.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox2ActionPerformed

    private void jCheckBox2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox2MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        setNewGame();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        if (jCheckBox1.isSelected()) {
            jCheckBox1.setSelected(true);
            nombre1.setText("PC1");
            nombre1.setEnabled(false);

        } else {
            jCheckBox1.setSelected(false);
            nombre1.setText("");
            nombre1.setEnabled(true);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void jCheckBox1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox1MouseClicked

    private void jCheckBox4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jCheckBox4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4MouseClicked

    private void jCheckBox4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jCheckBox4ActionPerformed

    private void nombre2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre2KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            setNewGame();
        } else if (evt.getKeyCode() != 8 && evt.getKeyCode() != 127) {
            char c = evt.getKeyChar();
            String t = nombre2.getText();
            if (t.length() > 11) {
                nombre2.setText(t.substring(0, 11));
            }
        }
    }//GEN-LAST:event_nombre2KeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            dispose();
            UIManager.setLookAndFeel(new NapkinLookAndFeel());
            new StartMenu();
        } catch (UnsupportedLookAndFeelException ex) {
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nombre1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nombre1KeyPressed
        // TODO add your handling code here:
        if (evt.getKeyCode() == 10) {
            setNewGame();
        } else if (evt.getKeyCode() != 8 && evt.getKeyCode() != 127) {
            char c = evt.getKeyChar();
            String t = nombre1.getText();
            if (t.length() > 11) {
                nombre1.setText(t.substring(0, 11));
            }
        }
    }//GEN-LAST:event_nombre1KeyPressed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        if (Util.showQuestion(Util.idioma[92], Util.idioma[28]) == 0) {
            System.exit(0);

        }
    }//GEN-LAST:event_formWindowClosing

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NuevoJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NuevoJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NuevoJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NuevoJuego.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NuevoJuego().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel casillasAmenazadas;
    private javax.swing.JPanel casillasAmenazadas3;
    private javax.swing.JPanel casillasClaras;
    private javax.swing.JPanel casillasOscuras;
    private javax.swing.JPanel casillasVacias;
    private javax.swing.JButton jButton1;
    public javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    public javax.swing.JCheckBox jCheckBox3;
    public javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JColorChooser jColorChooser1;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JSpinner m;
    private javax.swing.JTextField nombre1;
    private javax.swing.JTextField nombre2;
    // End of variables declaration//GEN-END:variables
}
