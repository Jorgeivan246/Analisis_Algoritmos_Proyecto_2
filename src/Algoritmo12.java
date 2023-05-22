import java.math.BigInteger;

public class Algoritmo12 {



    /**
     * Calcula el producto de dos números enteros utilizando el algoritmo de
     * Karatsuba.
     * 
     * @param x el primer número entero
     * @param y el segundo número entero
     * @return el producto de los dos números enteros
     */
    public BigInteger karatsuba(BigInteger x, BigInteger y) {
        // Caso base: si x o y tienen un solo dígito, se calcula el producto
        // directamente
        if (x.compareTo(BigInteger.TEN) == -1 || y.compareTo(BigInteger.TEN) == -1) {
            return x.multiply(y);
        }

        // Se calcula el número de dígitos de los números x e y
        int m = Math.max(x.toString().length(), y.toString().length()) / 2;

        // Se dividen los números x e y en dos partes de m dígitos cada uno
        BigInteger a = x.divide(BigInteger.TEN.pow(m));
        BigInteger b = x.mod(BigInteger.TEN.pow(m));
        BigInteger c = y.divide(BigInteger.TEN.pow(m));
        BigInteger d = y.mod(BigInteger.TEN.pow(m));

        // Se calculan los productos parciales utilizando recursión
        BigInteger ac = karatsuba(a, c);
        BigInteger bd = karatsuba(b, d);
        BigInteger abcd = karatsuba(a.add(b), c.add(d));

        // Se aplica la fórmula de Karatsuba para combinar los productos parciales
        return ac.multiply(BigInteger.TEN.pow(2 * m)).add((abcd.subtract(ac).subtract(bd)).multiply(BigInteger.TEN.pow(m))).add(bd);
    }
    public  BigInteger convertirBig(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return new BigInteger(sb.toString());
    }

    public int[] multiplicar(int[] x, int[] y){

        BigInteger a=convertirBig(x);
        BigInteger b=convertirBig(x);
        BigInteger resultado = karatsuba(a, b);
        return convertirAArray(resultado);
    }

    public static int[] convertirAArray(BigInteger bigInt) {
        String str = bigInt.toString();
        int[] arr = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            arr[i] = Character.getNumericValue(str.charAt(i));
        }
        return arr;
    }
/**
 *
 *
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



    **/
}
