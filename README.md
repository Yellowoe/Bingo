# BingoJava
 TareaProgramada1 

Sistema de Juego de Bingo
Este es un sistema de juego de bingo en el que se controlan diferentes hilos para gestionar a los diferentes jugadores.


Para jugar seguir los pasos:
1. Run File en  servidor.java
2. Elegir el modo de juego
3. Run File en ventanaCliente.java
4. Presionar pedir carton
5. segun el modo de juego al completar los espacios correspondientes para ganar debes presionar Bingo y el sistema te dira si ganaste o debes seguir jugando.


El código base del proyecto fue proporcionado por pablonoguera, profesor de Sistemas Operativos.



Se modificaron las clases Cliente, flujo, FrmServidor,servidor,VentanaCliente.

En el FrmServidor se agrego un comboBox para elejir modo de juego.

La funcionalidad  de modo de juego se basa en:
// Función para verificar si todas las esquinas están marcadas

    private boolean verificarCuatroEsquinas(int[][] matrix) {
        return numerosMarcados.contains(matrix[0][0])
                && numerosMarcados.contains(matrix[0][4])
                && numerosMarcados.contains(matrix[4][0])
                && numerosMarcados.contains(matrix[4][4]);
    }

// Función para verificar si los números en forma de L están marcados
    private boolean verificarL(int[][] matrix) {
        return numerosMarcados.contains(matrix[0][0])
                && numerosMarcados.contains(matrix[1][0])
                && numerosMarcados.contains(matrix[2][0])
                && numerosMarcados.contains(matrix[3][0])
                && numerosMarcados.contains(matrix[4][0])
                && numerosMarcados.contains(matrix[4][1])
                && numerosMarcados.contains(matrix[4][2])
                && numerosMarcados.contains(matrix[4][3])
                && numerosMarcados.contains(matrix[4][4]);
    }

// Función para verificar si todos los números del cartón han sido marcados
    private boolean verificarCartonCompleto(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i != 2 || j != 2 && !numerosMarcados.contains(matrix[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }