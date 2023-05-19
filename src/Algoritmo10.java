public class Algoritmo10 {

    /**
     * Realiza la multiplicación de dos números enteros utilizando el algoritmo de
     * la multiplicación hindú.
     * 
     * @param num1 el primer número entero
     * @param num2 el segundo número entero
     * @return un arreglo de enteros que representa el producto de los dos números
     */
    public int[] multiplicacionHindu(int[] num1, int[] num2) {
        // Se crea un arreglo de enteros para almacenar el resultado de la
        // multiplicación
        int[] resultado = new int[num1.length + num2.length];

        // Se realiza la multiplicación de los dígitos de los dos números
        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                int producto = num1[i] * num2[j];
                int posicion1 = i + j;
                int posicion2 = posicion1 + 1;
                resultado[posicion1] += producto / 10;
                resultado[posicion2] += producto % 10;
            }
        }

        // Se realiza el acarreo de los dígitos del resultado
        for (int i = resultado.length - 1; i > 0; i--) {
            resultado[i - 1] += resultado[i] / 10;
            resultado[i] %= 10;
        }

        // Se devuelve el resultado de la multiplicación
        return resultado;
    }
}
