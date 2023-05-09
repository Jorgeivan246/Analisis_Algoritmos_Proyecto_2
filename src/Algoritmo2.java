import java.util.ArrayList;

public class Algoritmo2 {

    // Función que recibe dos ArrayList de Integer y devuelve otro ArrayList de Integer con el resultado de la multiplicación americana
    public  ArrayList<Integer> multiplicar(ArrayList<Integer> a, ArrayList<Integer> b) {
        // Crear un ArrayList para almacenar el resultado
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        // Inicializar el resultado con ceros
        for (int i = 0; i < a.size() + b.size(); i++) {
            resultado.add(0);
        }
        // Recorrer los dígitos del primer número de derecha a izquierda
        for (int i = a.size() - 1; i >= 0; i--) {
            // Recorrer los dígitos del segundo número de derecha a izquierda
            for (int j = b.size() - 1; j >= 0; j--) {
                // Multiplicar los dígitos y sumar el resultado al correspondiente índice del resultado
                int producto = a.get(i) * b.get(j);
                int indice = i + j + 1;
                resultado.set(indice, resultado.get(indice) + producto);
            }
        }
        
        // Recorrer el resultado de derecha a izquierda para ajustar los acarreos
        for (int i = resultado.size() - 1; i > 0; i--) {
            // Dividir el valor por 10 y guardar el cociente en el índice actual y el resto en el índice anterior
            int valor = resultado.get(i);
            int cociente = valor / 10;
            int resto = valor % 10;
            resultado.set(i, resto);
            resultado.set(i - 1, resultado.get(i - 1) + cociente);
        }

        // Devolver el resultado
        return resultado;
    }

    // Función para mostrar un ArrayList de Integer como un número


}