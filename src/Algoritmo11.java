import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Algoritmo11 {

    public int[] multiplicacion_egipcia(int[] k, int[] l) {
        BigInteger a = convertirArregloANumeroBig(k);
        BigInteger b = convertirArregloANumeroBig(l);
        List<BigInteger> potencias_2 = new ArrayList<>();
        List<BigInteger> multiplos_de_b = new ArrayList<>();
        potencias_2.add(BigInteger.ONE);
        multiplos_de_b.add(b);
        while (potencias_2.get(potencias_2.size() - 1).compareTo(a) < 0) {
            potencias_2.add(potencias_2.get(potencias_2.size() - 1).multiply(BigInteger.TWO));
            multiplos_de_b.add(multiplos_de_b.get(multiplos_de_b.size() - 1).multiply(BigInteger.TWO));
        }
        BigInteger result = BigInteger.ZERO;
        for (int i = potencias_2.size() - 1; i >= 0; i--) {
            if (potencias_2.get(i).compareTo(a) <= 0) {
                a = a.subtract(potencias_2.get(i));
                result = result.add(multiplos_de_b.get(i));
            }
        }
       // return bigIntegerToIntArray(result);

        return null;
    }
    public int[] bigIntegerToIntArray(BigInteger bigInt) {
        String bigIntStr = bigInt.toString();
        int[] intArray = new int[bigIntStr.length()];
        for (int i = 0; i < bigIntStr.length(); i++) {
            intArray[i] = Character.getNumericValue(bigIntStr.charAt(i));
        }
        return intArray;
    }

    private BigInteger convertirArregloANumeroBig(int[] arr) {
        BigInteger num = BigInteger.ZERO;
        for (int i = 0; i < arr.length; i++) {
            num = num.multiply(BigInteger.TEN).add(BigInteger.valueOf(arr[i]));
        }
        return num;
    }
}
