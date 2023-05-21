import java.util.ArrayList;
import java.util.List;

public class Algoritmo11 {

    public static int[] multi(int[] numero1, int []numero2) {

        int a=convertirArregloANumero(numero1), b=convertirArregloANumero(numero2);

        List<Integer> powersOf2 = new ArrayList<>();
        List<Integer> multiplesOfB = new ArrayList<>();
        powersOf2.add(1);
        multiplesOfB.add(b);
        while (powersOf2.get(powersOf2.size() - 1) < a) {
            powersOf2.add(powersOf2.get(powersOf2.size() - 1) * 2);
            multiplesOfB.add(multiplesOfB.get(multiplesOfB.size() - 1) * 2);
        }
        int result = 0;
        for (int i = powersOf2.size() - 1; i >= 0; i--) {
            if (powersOf2.get(i) <= a) {
                a -= powersOf2.get(i);
                result += multiplesOfB.get(i);
            }
        }


        return convertirNumeroAArreglo(result);
    }

    public static int convertirArregloANumero(int[] arreglo) {
        int numero = 0;

        for (int i = 0; i < arreglo.length; i++) {
            numero = numero * 10 + arreglo[i];
        }

        return numero;
    }

    public static int[] convertirNumeroAArreglo(int numero) {
        int longitud = obtenerLongitud(numero);
        int[] arreglo = new int[longitud];

        for (int i = longitud - 1; i >= 0; i--) {
            arreglo[i] = numero % 10;
            numero /= 10;
        }

        return arreglo;
    }

    public static int obtenerLongitud(int numero) {
        if (numero == 0) {
            return 1;
        }

        int longitud = 0;
        while (numero != 0) {
            longitud++;
            numero /= 10;
        }

        return longitud;
    }
}
