import java.util.ArrayList;

public class Algoritmo3 {

    public int[] multiplicar(int[] a, int[] b) {
        int[] resultado = new int[a.length + b.length];
        for (int i = 0; i < resultado.length; i++) {
            resultado[i] = 0;
        }
        multiplicarAux(a, b, resultado, a.length - 1, b.length - 1);
        return resultado;
    }

    private void multiplicarAux(int[] a, int[] b, int[] resultado, int i, int j) {
        if (i < 0 || j < 0) {
            return;
        }
        multiplicarAux(a, b, resultado, i - 1, j);
        multiplicarAux(a, b, resultado, i, j - 1);
        int producto = a[i] * b[j];
        int indice = i + j + 1;
        resultado[indice] += producto;
        int valor = resultado[indice];
        int cociente = valor / 10;
        int resto = valor % 10;
        resultado[indice] = resto;
        if (indice > 0) {
            resultado[indice - 1] += cociente;
        }
    }

/**
    public int[] multiplicar(int[] a, int[] b) {
        // Crear un ArrayList para almacenar el resultado
        int[] resultado = new int[a.length + b.length];
        // Inicializar el resultado con ceros
        for (int i = 0; i < resultado.length; i++) {
            resultado[i]=0;
        }
        // Llamar a la función auxiliar recursiva con los índices iniciales
        multiplicarAux(a, b, resultado, a.length - 1, b.length - 1);

        // Devolver el resultado
        return resultado;
    }

    // Función auxiliar recursiva que recibe dos ArrayList de Integer, otro ArrayList de Integer para el resultado y dos índices para los dígitos a multiplicar
    private void multiplicarAux(int[] a, int[] b, int[] resultado, int i, int j) {
        // Caso base: si alguno de los índices es negativo, terminar la recursión
        if (i < 0 || j < 0) {
            return;
        }
        int producto = a[i] * b[j];
        int indice = i + j + 1;


        resultado[indice]=resultado[indice]+producto;
        // Ajustar los acarreos


        int valor = resultado[indice];
        int cociente = valor / 10;
        int resto = valor % 10;
        resultado[indice]= resto;
        if (indice > 0) {
            resultado[indice - 1]= resultado[indice - 1] + cociente;
        }
        // Llamar a la función auxiliar recursiva con los índices anteriores
        if(j == 0){
            j = b.length - 1;
            multiplicarAux(a, b, resultado, i - 1, j);
        } else {
            multiplicarAux(a, b, resultado, i, j - 1);
        }
    }

 **/
}
