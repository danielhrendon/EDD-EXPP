/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrisokas;

import java.awt.Color;
import java.awt.event.*;

import javax.swing.*;

/**
 *
 * @author Daniel
 */

class Muñeca extends JFrame {
    JLabel lblCantidad, lblPosicion;
    JTextField txtCantidad, txtPosicion;
    JButton btnCrear, btnModificar, btnVaciar, btnSalir;
    JTextArea areaTexto;
    Pila lg;

    public Muñeca() {
        setTitle("MATRIOSKAS");
        setLayout(null);
        setSize(600, 800);
        init();
        this.setResizable(false);
    }

    public void init() {
        lblCantidad = new JLabel("Ingresa el tamaño de la pila:");
        lblCantidad.setBounds(100, 10, 400, 80);
        lblCantidad.setFont(new java.awt.Font("Arial", 1, 14));
        lblCantidad.setForeground(new java.awt.Color(200, 0, 0));

        txtCantidad = new JTextField();
        txtCantidad.setBounds(310, 38, 100, 30);
        txtCantidad.setBackground(Color.yellow);
        txtCantidad.setForeground(Color.black);
        txtCantidad.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(c >= '0' && c <= '9')) {
                    evt.consume();
                }
                if (txtCantidad.getText().length() > 1) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "No digites más de un número.");
                    txtCantidad.setText("");
                }
            }
        });

        lblPosicion = new JLabel("Ingresa el elemento a eliminar:");
        lblPosicion.setBounds(90, 120, 400, 80);
        lblPosicion.setFont(new java.awt.Font("Arial", 1, 14));
        lblPosicion.setForeground(new java.awt.Color(200, 0, 0));

        txtPosicion = new JTextField();
        txtPosicion.setBounds(310, 148, 100, 30);
        txtPosicion.setBackground(Color.yellow);
        txtPosicion.setForeground(Color.black);
        txtPosicion.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                char c = evt.getKeyChar();
                if (!(c >= '0' && c <= '9')) {
                    evt.consume();
                }
                if (txtPosicion.getText().length() > 1) {
                    evt.consume();
                    JOptionPane.showMessageDialog(null, "No digites más de un número.");
                    txtPosicion.setText("");
                }
            }
        });

        areaTexto = new JTextArea();
        areaTexto.setEnabled(false);
        areaTexto.setForeground(new java.awt.Color(0,0, 0));
        areaTexto.setBackground(new java.awt.Color(245,0, 0));
        JScrollPane scroll = new JScrollPane(areaTexto);
        scroll.setBackground(Color.green);
        scroll.setForeground(Color.green);
        scroll.setBounds(45, 300, 500, 350);

        btnCrear = new JButton("C R E A R");
        btnCrear.setBounds(300, 75, 100, 30);
        btnCrear.setForeground(Color.white);
        btnCrear.setBackground(Color.red);
        btnCrear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                if (txtCantidad.getText().trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Digita un número");
                    return;
                }
                try {
                    int tamanio = Integer.parseInt(txtCantidad.getText());
                    if (tamanio < 1 || tamanio > 60) {
                        JOptionPane.showMessageDialog(null, "Por favor, digita un número entre 1 y 60.");
                        txtCantidad.setText("");
                        return;
                    }
                    lg = new Pila(tamanio);
                    for (int i = 1; i <= tamanio; i++) {
                        lg.Insertar(i);
                    }
                    actualizarTexto();
                } catch (NumberFormatException ex) {
                    areaTexto.setText("");
                }
            }
        });

        btnModificar = new JButton("E L I M I N A R");
        btnModificar.setBounds(300, 200, 125, 30);
        btnModificar.setForeground(Color.white);
        btnModificar.setBackground(Color.blue);
        btnModificar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                String posicion = txtPosicion.getText();
                if (posicion == null || posicion.trim().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "El elemento NO es valido.");
                    return;
                }
                try {
                    int pos = Integer.parseInt(posicion);
                    int datoEliminado = lg.Eliminar(pos);
                    if (datoEliminado != -1) {
                        actualizarTexto();
                    } else {
                        JOptionPane.showMessageDialog(null, "El elemento esta fuera de rango.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "El elemento NO es valido.");
                }
            }
        });
        btnVaciar = new JButton("V A C I A R");
        btnVaciar.setBounds(300, 250, 100, 30);
        btnVaciar.setForeground(Color.white);
        btnVaciar.setBackground(Color.gray);
        btnVaciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                lg.Vaciar();
                actualizarTexto();
                areaTexto.setText("La PILA se ha vaciado. \n");
            }
        });
        
        btnSalir = new JButton("S A L I R");
        btnSalir.setBounds(250,700, 100, 50);
        btnSalir.setForeground(Color.white);
        btnSalir.setBackground(Color.red);
        btnSalir.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ev3){
                    System.exit(0);
                }
        });

        add(lblCantidad);
        add(txtCantidad);
        add(lblPosicion);
        add(txtPosicion);
        add(btnCrear);
        add(btnModificar);
        add(btnVaciar);
        add(btnSalir);
        add(scroll);
    }
    private void actualizarTexto() {
        for (int i = 0; i < lg.cima; i++) {
            areaTexto.append("\n INDICE: " + (i+1) + "     MATRIOSKA: " + lg.vectorPila[i] + "\n");
        }
    }
}