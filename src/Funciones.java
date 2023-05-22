import java.util.ArrayList;
import java.util.Collections;

public class Funciones {

    public ArrayList<Integer> removerCerosSlice(ArrayList<Integer> n) {
        int tope = 0;
        for (int i = 0; i < n.size(); i++) {
            if (n.get(i) != 0) {
                tope = i;
                i = n.size() - 1;
            }
        }
        return new ArrayList<Integer>(n.subList(tope, n.size()));
    }

    public ArrayList<Integer> restar(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
        ArrayList<Integer> resultado = new ArrayList<Integer>();

        if(arr1.size() > arr2.size()){
            while(arr1.size() > arr2.size()){
                arr2.add(0, 0);
            }
        }else if(arr1.size() < arr2.size()){
            while(arr1.size() < arr2.size()){
                arr1.add(0, 0);
            }
        }

        for (int i = arr1.size() - 1; i >= 0; i--) {
            if (arr1.get(i) < arr2.get(i)) {
                arr1.set(i - 1, arr1.get(i - 1) - 1);
                arr1.set(i, arr1.get(i) + 10);
            }
            resultado.add(0, arr1.get(i) - arr2.get(i));
        }
        return resultado;
    }

    public ArrayList<Integer> sumar(ArrayList<Integer> arr1, ArrayList<Integer> arr2) {
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

    public int[] convertirArrayListToArreglo(ArrayList<Integer> resultado) {
        int[] arreglo = new int[resultado.size()];
        for (int i = 0; i < resultado.size(); i++) {
            arreglo[i] = resultado.get(i);
        }
        return arreglo;
    }

    public ArrayList<Integer> convertirToArrayList(int[] x) {
        ArrayList<Integer> arreglo = new ArrayList<Integer>();
        for (int i = x.length - 1; i >= 0; i--) {
            arreglo.add(x[i]);
        }
        return arreglo;
    }

    public ArrayList<Integer> potencia(int n, int m) {
        ArrayList<Integer> resultado = new ArrayList<Integer>();
        resultado.add(1);

        for (int i = 0; i < m; i++) {
            int acarreo = 0;
            for (int j = 0; j < resultado.size(); j++) {
                int producto = resultado.get(j) * n + acarreo;
                resultado.set(j, producto % 10);
                acarreo = producto / 10;
            }
            while (acarreo > 0) {
                resultado.add(acarreo % 10);
                acarreo /= 10;
            }
        }

        // Eliminar ceros sobrantes al principio del resultado
        while (resultado.size() > 1 && resultado.get(resultado.size() - 1) == 0) {
            resultado.remove(resultado.size() - 1);
        }

        // Invertir el resultado para que quede en orden correcto
        Collections.reverse(resultado);

        return resultado;
    }
    
}
