import java.math.BigInteger;
import java.util.ArrayList;

public class Algoritmo3 {

    public int[] multiplicar(int[] a, int[] b) {
        // Crear un ArrayList para almacenar el resultado
        int[] resultado = new int[a.length + b.length];
        // Inicializar el resultado con ceros

        // Llamar a la función auxiliar recursiva con los índices iniciales
        resultado=multiplicarAux(a, b, resultado, 0 , 0 ,resultado.length-1);

        // Devolver el resultado
        return resultado;
    }

    private int[] multiplicarAux(int[] a, int[] b, int[] resultado, int i, int j,int k) {

        if(i<a.length)
        {
            if(j<b.length)
            {
                resultado[i+j+1]+= a[j]* b[i];
                return    multiplicarAux( a,  b,  resultado,  i,  j+1,resultado.length-1);
            }else{
                return  multiplicarAux( a,  b,  resultado,  i+1,  0,resultado.length-1);
            }
        }
        if(k>0) {
            resultado[k - 1] += resultado[k] / 10;
            resultado[k] %= 10;
            return multiplicarAux(a, b, resultado, i, j, k-1);

        }
        return resultado;
    }
}

