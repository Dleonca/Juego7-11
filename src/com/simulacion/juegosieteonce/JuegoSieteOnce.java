/*
Hay un famoso juego llamado 7 – 11, el cual requiere que el jugador lance dos 
dados una o más veces hasta tomar la decisión de que se gana o se pierde el juego.

El juego se gana si en el primer lanzamiento los dados suman 7 u 11, o aparece
un 4, 5, 6, 8, 9 o 10 en el primer lanzamiento y la misma suma reaparece antes 
de que aparezca un 7. Por otra parte, el juego se pierde si en el primer lanzamiento
los dados suman 2, 3 o 12, o aparece un 4, 5, 6, 8, 9 o 10 en el primer lanzamiento 
y luego sale un 7 antes de que se repita el primer lanzamiento. Si el valor de la
apuesta es de $1, y la ganancia cada vez que se gana un juego es $1,
elabore una 
simulación que permita calcular la probabilidad de quiebra (llegar a $0 en caja) 
si la cantidad inicial disponible es de $20. Puede asumir también que el juego
termina cuando se logran acumular $50 en caja. Use el lenguaje de programación que 
le resulte más conveniente.

Nota: La probabilidad de quiebra se obtiene mediante
la relación entre el número de intentos en donde se alcanza la quiebra y el número
total de intentos. En este contexto, un intento es un número X de juegos 
(lanzamiento de los dados) que conducen a la quiebra o a una ganancia de $50.
Por ejemplo, en un intento puedo requerir 10 juegos para llegar a la quiebra, y
en otro requerir 5 juegos para llegar a la ganancia de $50. La probabilidad se 
calcula con los intentos.
 */
package com.simulacion.juegosieteonce;

import java.util.Random;

/**
 *
 * @author DanielaLeo
 */
public class JuegoSieteOnce {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int plata = 20;
        int apuesta = 1;
        int numeroIntentos = 0;
        int countGanados = 0;
        int countPerdidos = 0;
        int suma;
        int suma2;
        int dado1 = -1;
        int dado2 = -1;
        int dado1i2 = -1 ;
        int dado2i2 = -1 ;
       
        Random aleatorio1 = new Random();
        Random aleatorio2 = new Random();
        int numeroDeJuegos = 25;

        for (int i = 0; i < numeroDeJuegos; i++) {
            System.out.println("Iniciando... el juego numero: " + i);
            while (plata > 0 & plata < 50) {
                //lanzar los dados primer intento
                dado1 = aleatorio1.nextInt(1, 7);
                dado2 = aleatorio1.nextInt(1, 7);
                suma = dado1 + dado2;

                System.out.println("dado 1: " + dado1);
                System.out.println("dado 2: " + dado2);
                System.out.println("suma 1:" + suma);
                //si gana con un intento
                if (suma == 7 || suma == 11) {
                    System.out.println("intento ganado");
                    plata = plata + 1;
                    System.out.println("dinero: " + plata);
                    System.out.println("fin-----------------------------------------------");
                }
                //si pierde con un intento
                if (suma == 2 || suma == 3 || suma == 12) {
                    System.out.println("intento perdido");
                    plata = plata - 1;
                    System.out.println("dinero: " + plata);
                     System.out.println("fin-----------------------------------------------");
                }
               boolean continuar = true;
                // dos intentos
                if (suma == 4 || suma == 5 || suma == 6 || suma == 8 || suma == 9 || suma == 10) {
                    //lanzar los dados segundo intento
                   
                    while (continuar) {
                        dado1i2 = aleatorio2.nextInt(1, 7);
                        dado2i2 = aleatorio2.nextInt(1, 7);
                        suma2 = dado1i2 + dado2i2;
                        if (suma2 == suma) {
                            System.out.println("dado 1 intento 2: " + dado1i2);
                            System.out.println("dado 2 intento 2: " + dado2i2);
                            System.out.println("intento ganado");
                            plata = plata + 1;
                            System.out.println("dinero: " + plata);
                            continuar = false;
                            System.out.println("fin-----------------------------------------------");
                        }else
                        if (suma2 == 7) {
                            System.out.println("dado 1 intento 2: " + dado1i2);
                            System.out.println("dado 2 intento 2: " + dado2i2);
                            System.out.println("intento perdido");
                            plata = plata - 1;
                            System.out.println("dinero: " + plata);
                            continuar = false;
                            System.out.println("fin-----------------------------------------------");
                        }else{
                           continuar = true;
                        }
                        
                    }

                }

            }
            if (plata == 0) {
                System.out.println("Usted ha quedado en las ruinas");
                countPerdidos = countPerdidos + 1;
            }
            if (plata == 50) {
                System.out.println("Usted ha ganado este juego ¡FELICITACIONES!");
                countGanados = countGanados + 1;
            }
            plata = 20;
        }
        double probabilidadQuiebra ;
        System.out.println("juegos ganados: " + countGanados);
        System.out.println("juegos Perdidos: " + countPerdidos);
        if (countPerdidos==0){
            System.out.println("no hay juegos perdidos");
        }else{
         probabilidadQuiebra = (double) numeroDeJuegos / countPerdidos;
        System.out.println("probabilidad: " + probabilidadQuiebra);
        }
    }
}
