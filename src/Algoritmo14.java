import java.util.ArrayList;

public class Algoritmo14 {

    Funciones funciones = new Funciones();

    public int[] multplicar(int[] x, int[] y) {

        ArrayList<Integer> resultado = new ArrayList<Integer>();
        for (int i = 0; i < x.length + y.length; i++) {
            resultado.add(0);
        }

        resultado = divideVenceras1(funciones.convertirToArrayList(x), funciones.convertirToArrayList(y), resultado);
        return funciones.convertirArrayListToArreglo(resultado);
    }

    private ArrayList<Integer> divideVenceras1(ArrayList<Integer> num1, ArrayList<Integer> num2,
            ArrayList<Integer> resultado) {

        Algoritmo2 algoritmo2 = new Algoritmo2();

        // El numero con mayor numero de digitos si es un numero impar se le agrega un 0
        // al inicio
        if (num1.size() > num2.size()) {
            if (num1.size() % 2 != 0) {
                num1.add(0, 0);
            }
        } else if (num1.size() < num2.size()) {
            if (num2.size() % 2 != 0) {
                num2.add(0, 0);
            }
        }

        if (num1.size() > num2.size()) {
            while (num1.size() > num2.size()) {
                num2.add(0, 0);
            }
        } else if (num1.size() < num2.size()) {
            while (num1.size() < num2.size()) {
                num1.add(0, 0);
            }
        }

        ArrayList<Integer> exponencial1 = funciones.potencia(10, num1.size());
        ArrayList<Integer> exponencial2 = funciones.potencia(10, num1.size() / 2);

        // Se agrega cada digito del numero n y m a las variables exponencial1 y
        // exponencial2
        int mitad1 = num1.size() / 2;
        int mitad2 = num2.size() / 2;

        // Se crea una nueva variable que asigna la mitad del número 1
        ArrayList<Integer> w = new ArrayList<Integer>(num1.subList(0, mitad1));
        ArrayList<Integer> x = new ArrayList<Integer>(num1.subList(mitad1, num1.size()));

        // Se crea una nueva variable que asigna la mitad del número 2
        ArrayList<Integer> y = new ArrayList<Integer>(num2.subList(0, mitad2));
        ArrayList<Integer> z = new ArrayList<Integer>(num2.subList(mitad2, num2.size()));

        ArrayList<Integer> result1 = algoritmo2.multiplicar(w, y);
        result1 = algoritmo2.multiplicar(result1, exponencial1);

        ArrayList<Integer> result2 = algoritmo2.multiplicar(w, z);
        result2 = algoritmo2.multiplicar(result2, exponencial2);

        ArrayList<Integer> result3 = algoritmo2.multiplicar(x, y);
        result3 = algoritmo2.multiplicar(result3, exponencial2);

        ArrayList<Integer> result4 = algoritmo2.multiplicar(x, z);

        result1 = funciones.removerCerosSlice(result1);
        result2 = funciones.removerCerosSlice(result2);
        result3 = funciones.removerCerosSlice(result3);
        result4 = funciones.removerCerosSlice(result4);

        resultado = funciones.sumar(resultado, result1);
        resultado = funciones.sumar(resultado, result2);
        resultado = funciones.sumar(resultado, result3);
        resultado = funciones.sumar(resultado, result4);

        return resultado;
    }
}
