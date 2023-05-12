import java.util.ArrayList;

public class Algoritmo8 {

    public ArrayList<Integer> multiplicar(ArrayList<Integer> numero1, ArrayList<Integer> numero2, ArrayList<Integer> resultado) {

        return multiplicarAux(numero1, numero2, resultado, 0, 0);
    }

    /* Este método realiza la multiplicación inglesa de dos números representados como ArrayList de enteros de forma recursiva y dinámica.
     * Recibe como parámetros el numero1, el numero2 y el resultado inicializado en ceros como un ArrayList de enteros.
     * También recibe el index1 y el index2 que son índices auxiliares para recorrer los ArrayList del numero1 y el numero2. Deben iniciar en 0.
     * Devuelve el resultado como un ArrayList de enteros.
     */
    private ArrayList<Integer> multiplicarAux(ArrayList<Integer> numero1, ArrayList<Integer> numero2, ArrayList<Integer> resultado, int index1, int index2) {
        //Si ya se recorrieron todos los dígitos del numero1.
        if (index1 >= numero2.size()) {
            return resultado;
        }

        //Si ya se recorrieron todos los dígitos del numero2.
        if (index2 >= numero1.size() - 1) {
            //Se multiplica el dígito del numero2 por el dígito del numero1 y se suma al resultado en la posición correspondiente
            resultado.set(index1 + index2 + 1, resultado.get(index1 + index2 + 1) + numero2.get(index1) * numero1.get(index2));

            //Se llama al método recursivamente con el siguiente dígito del numero2 y el primero del numero1
            multiplicarAux(numero1, numero2, resultado, index1 + 1, 0);

            //Se pasa el acarreo al dígito anterior si el resultado es mayor que 9
            return getIntegers(resultado, index1, index2);
        }

        //Se multiplica el dígito del numero2 por el dígito del numero1 y se suma al resultado en la posición correspondiente
        resultado.set(index1 + index2 + 1, resultado.get(index1 + index2 + 1) + numero2.get(index1) * numero1.get(index2));

        //Se llama al método recursivamente con el mismo dígito del numero2 y el siguiente del numero1
        multiplicarAux(numero1, numero2, resultado, index1, index2 + 1);

        //Se pasa el acarreo al dígito anterior si el resultado es mayor que 9
        return getIntegers(resultado, index1, index2);
    }

    /* Este método verifica si el resultado de la multiplicación tiene algún dígito mayor que 9 y lo ajusta pasando el acarreo al dígito anterior.
     * Recibe como parámetros el resultado como un ArrayList de enteros y los índices auxiliares del numero1 y el numero2.
     * Devuelve el resultado ajustado como un ArrayList de enteros.
     */
    private ArrayList<Integer> getIntegers(ArrayList<Integer> resultado, int index1, int index2) {
        //Si el resultado en la posición actual es mayor que 9
        if (resultado.get(index1 + index2 + 1) > 9) {
            //Se suma el acarreo al dígito anterior
            resultado.set(index1 + index2, resultado.get(index1 + index2) + resultado.get(index1 + index2 + 1) / 10);
            //Se queda con el residuo en la posición actual
            resultado.set(index1 + index2 + 1, resultado.get(index1 + index2 + 1) % 10);
        }

        return resultado;
    }

}
