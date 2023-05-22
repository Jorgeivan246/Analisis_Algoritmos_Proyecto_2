import java.util.ArrayList;

public class Algoritmo15 {

    Funciones funciones = new Funciones();

    public int[] multplicar(int[] x, int[] y) {

        ArrayList<Integer> resultado = new ArrayList<Integer>();
        for (int i = 0; i < x.length + y.length; i++) {
            resultado.add(0);
        }

        resultado = divideVenceras2(funciones.convertirToArrayList(x), funciones.convertirToArrayList(y), resultado);
        return funciones.convertirArrayListToArreglo(resultado);
    }

    private ArrayList<Integer> divideVenceras2(ArrayList<Integer> num1,
            ArrayList<Integer> num2, ArrayList<Integer> resultado) {
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

        ArrayList<Integer> r = algoritmo2.multiplicar(funciones.sumar(w, x), funciones.sumar(y, z));
        ArrayList<Integer> p = algoritmo2.multiplicar(w, y);
        ArrayList<Integer> aux1 = algoritmo2.multiplicar(p, exponencial1);
        ArrayList<Integer> q = algoritmo2.multiplicar(x, z);

        ArrayList<Integer> aux2 = funciones.restar(funciones.restar(r, p), q);
        aux2 = algoritmo2.multiplicar(aux2, exponencial2);

        p = funciones.removerCerosSlice(p);
        r = funciones.removerCerosSlice(r);
        q = funciones.removerCerosSlice(q);
        aux2 = funciones.removerCerosSlice(aux2);
        aux1 = funciones.removerCerosSlice(aux1);

        resultado = funciones.sumar(resultado, aux1);
        resultado = funciones.sumar(resultado, aux2);
        resultado = funciones.sumar(resultado, q);

        return resultado;
    }
}
