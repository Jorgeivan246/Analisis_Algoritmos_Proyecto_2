import java.util.ArrayList;

public class Algoritmo4 {



    // Función que recibe dos ArrayList de Integer y devuelve otro ArrayList de Integer con el resultado de la multiplicación americana recursiva
    public ArrayList<Integer> multiplicar(ArrayList<Integer> a, ArrayList<Integer> b) {
        // Crear un ArrayList para almacenar el resultado
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        // Inicializar el resultado con ceros
        for (int i = 0; i < a.size() + b.size(); i++) {
            resultado.add(0);
        }
        // Llamar a la función auxiliar recursiva con los índices iniciales
        multiplicarAux(a, b, resultado, a.size() - 1, b.size() - 1);

        // Devolver el resultado
        return resultado;
    }

    // Función auxiliar recursiva que recibe dos ArrayList de Integer, otro ArrayList de Integer para el resultado y dos índices para los dígitos a multiplicar
    private void multiplicarAux(ArrayList<Integer> a, ArrayList<Integer> b, ArrayList<Integer> resultado, int i, int j) {
        // Caso base: si alguno de los índices es negativo, terminar la recursión
        if (i < 0 || j < 0) {
            return;
        }
        int producto = a.get(i) * b.get(j);
        int indice = i + j + 1;
        resultado.set(indice, resultado.get(indice) + producto);
        // Ajustar los acarreos
        int valor = resultado.get(indice);
        int cociente = valor / 10;
        int resto = valor % 10;
        resultado.set(indice, resto);
        if (indice > 0) {
            resultado.set(indice - 1, resultado.get(indice - 1) + cociente);
        }
        // Llamar a la función auxiliar recursiva con los índices anteriores
        if(j == 0){
            j = b.size() - 1;
            multiplicarAux(a, b, resultado, i - 1, j);
        } else {
            multiplicarAux(a, b, resultado, i, j - 1);
        }
    }
}
