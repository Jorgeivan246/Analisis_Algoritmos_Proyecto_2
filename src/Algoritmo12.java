public class Algoritmo12 {
    /**
     * Calcula el producto de dos números enteros utilizando el algoritmo de
     * Karatsuba.
     * 
     * @param x el primer número entero
     * @param y el segundo número entero
     * @return el producto de los dos números enteros
     */
    private long karatsuba(long x, long y) {
        // Caso base: si x o y tienen un solo dígito, se calcula el producto
        // directamente
        if (x < 10 || y < 10) {
            return x * y;
        }

        // Se calcula el número de dígitos de los números x e y
        int m = Math.max(Long.toString(x).length(), Long.toString(y).length()) / 2;

        // Se dividen los números x e y en dos partes de m dígitos cada uno
        long a = x / (long) Math.pow(10, m);
        long b = x % (long) Math.pow(10, m);
        long c = y / (long) Math.pow(10, m);
        long d = y % (long) Math.pow(10, m);

        // Se calculan los productos parciales utilizando recursión
        long ac = karatsuba(a, c);
        long bd = karatsuba(b, d);
        long abcd = karatsuba(a + b, c + d);

        // Se aplica la fórmula de Karatsuba para combinar los productos parciales
        return ac * (long) Math.pow(10, 2 * m) + (abcd - ac - bd) * (long) Math.pow(10, m) + bd;
    }

    public int[] multiplicar(int[] x, int[] y){

        long a=convertirALong(x);
        long b=convertirALong(x);
        long resultado = karatsuba(a, b);
        return convertirAArray(resultado);
    }

    private int[] convertirAArray(long resultado) {
        String numero = Long.toString(resultado);
        int[] resultadoArray = new int[numero.length()];
        for (int i = 0; i < numero.length(); i++) {
            resultadoArray[i] = Integer.parseInt(numero.substring(i, i+1));
        }
        return resultadoArray;
    }

    public long convertirALong(int[] arr) {
        long result = 0;
        for (int i = 0; i < arr.length; i++) {
            result = result * 10 + arr[i];
        }
        return result;
    }



    
}
