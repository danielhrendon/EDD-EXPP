/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrisokas;

import javax.swing.*;

/**
 *
 * @author Daniel
 */
class Pila {
    int vectorPila[];
    int cima;

    public Pila(int tamaño) {
        vectorPila = new int[tamaño];
        cima = 0;
    }

    public void Insertar(int dato) {
        vectorPila[cima] = dato;
        cima++;
    }

    public int Eliminar(int posicion) {
        int eliminar = -1;
        if (posicion < 1 || posicion > cima) {
            return eliminar;
        } else {
            cima--;
            eliminar = vectorPila[posicion - 1];
            for (int i = posicion - 1; i < cima; i++) {
                vectorPila[i] = vectorPila[i + 1];
            }
        }
        return eliminar;
    }
    
    public void Vaciar() {
        cima = 0;
    }
}