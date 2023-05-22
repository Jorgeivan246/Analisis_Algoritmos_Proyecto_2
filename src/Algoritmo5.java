import java.util.ArrayList;

public class Algoritmo5 {

    public int[] multiplicar(int[] num1, int[] num2) {

        int[] resultado = new int[num1.length + num2.length];
        // Inicializar el resultado con ceros
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = 0;
        }

        // Se recorren los dígitos del num2 de derecha a izquierda
        for (int i = 0; i < num2.length; i++) {
            // Se recorren los dígitos del num1 de derecha a izquierda
            for (int j = 0; j < num1.length; j++) {
                // Se multiplica el dígito del num2 por el dígito del num1 y se suma al
                // resultado en la posición correspondiente
                resultado[i + j + 1] = resultado[i + j + 1] + num1[j] * num2[i];
            }
        }

        // Se recorren los dígitos del resultado de derecha a izquierda
        for (int i = resultado.length - 1; i > 0; i--) {
            // Se pasa el acarreo al dígito anterior si el resultado es mayor que 9
            resultado[i - 1] = resultado[i - 1] + resultado[i] / 10;
            // Se queda con el residuo si el resultado es mayor que 9
            resultado[i] = (resultado[i] % 10);
        }

        return resultado;
    }
}
