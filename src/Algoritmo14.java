import java.util.ArrayList;

public class Algoritmo14 {

    public int[] multplicar(int[] x, int[] y) {

        ArrayList<Integer> resultado = new ArrayList<Integer>();
        for (int i = 0; i < x.length + y.length; i++) {
            resultado.add(0);
        }

        resultado = divideVenceras1(convertirToArrayList(x), convertirToArrayList(y), resultado);
        return convertirArrayListToArreglo(resultado);
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

        int n = (int) Math.pow(10, num1.size());
        int m = (int) Math.pow(10, num1.size() / 2);

        ArrayList<Integer> exponencial1 = intToArrayList(n);
        ArrayList<Integer> exponencial2 = intToArrayList(m);

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

        result1 = removerCerosSlice(result1);
        result2 = removerCerosSlice(result2);
        result3 = removerCerosSlice(result3);
        result4 = removerCerosSlice(result4);

        resultado = sumar(resultado, result1);
        resultado = sumar(resultado, result2);
        resultado = sumar(resultado, result3);
        resultado = sumar(resultado, result4);

        return resultado;
    }

    public static ArrayList<Integer> removerCerosSlice(ArrayList<Integer> n) {
        int tope = 0;
        for (int i = 0; i < n.size(); i++) {
            if (n.get(i) != 0) {
                tope = i;
                i = n.size() - 1;
            }
        }
        return new ArrayList<Integer>(n.subList(tope, n.size()));
    }

    public static ArrayList<Integer> sumar(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        int acarreo = 0;
        int i = arr1.size() - 1;
        int j = arr2.size() - 1;

        while (i >= 0 || j >= 0 || acarreo > 0) {
            int suma = acarreo;
            if (i >= 0) {
                suma += arr1.get(i);
                i--;
            }
            if (j >= 0) {
                suma += arr2.get(j);
                j--;
            }
            resultado.add(0, suma % 10);
            acarreo = suma / 10;
        }

        return resultado;
    }

    private ArrayList<Integer> intToArrayList(int n) {
        ArrayList<Integer> arreglo = new ArrayList<Integer>();
        while (n > 0) {
            arreglo.add(n % 10);
            n /= 10;
        }
        return invertir(arreglo);
    }

    private ArrayList<Integer> invertir(ArrayList<Integer> x) {
        ArrayList<Integer> arreglo = new ArrayList<Integer>();
        for (int i = x.size() - 1; i >= 0; i--) {
            arreglo.add(x.get(i));
        }
        return arreglo;
    }

    private int[] convertirArrayListToArreglo(ArrayList<Integer> resultado) {
        int[] arreglo = new int[resultado.size()];
        for (int i = 0; i < resultado.size(); i++) {
            arreglo[i] = resultado.get(i);
        }
        return arreglo;
    }

    private ArrayList<Integer> convertirToArrayList(int[] x) {
        ArrayList<Integer> arreglo = new ArrayList<Integer>();
        for (int i = x.length - 1; i >= 0; i--) {
            arreglo.add(x[i]);
        }
        return arreglo;
    }

}
