import java.util.ArrayList;

public class Algoritmo6 {

    //Este método realiza la multiplicación inglesa iterativa de dos números representados como listas simples.
    //Recibe como parámetros el num1, el num2 y el resultado inicializado en ceros como un ArrayList de enteros.
    //Devuelve el resultado como un ArrayList de enteros.
    public ArrayList<Integer> multiplicar(ArrayList<Integer>  num1, ArrayList<Integer>  num2, ArrayList<Integer> resultado) {

        //Se recorren los dígitos del num2 de derecha a izquierda
        for (int i = 0; i < num2.size(); i++) {
            //Se recorren los dígitos del num1 de derecha a izquierda
            for (int j = 0; j < num1.size(); j++) {
                //Se multiplica el dígito del num2 por el dígito del num1 y se suma al resultado en la posición correspondiente
                resultado.set(i + j + 1, resultado.get(i + j + 1) + num1.get(j) * num2.get(i));
            }
        }

        //Se recorren los dígitos del resultado de derecha a izquierda
        for (int i = resultado.size() - 1; i > 0; i--) {
            //Se pasa el acarreo al dígito anterior si el resultado es mayor que 9
            resultado.set(i - 1, resultado.get(i - 1) + resultado.get(i) / 10);
            //Se queda con el residuo si el resultado es mayor que 9
            resultado.set(i, resultado.get(i) % 10);
        }

        return resultado;
    }

}
