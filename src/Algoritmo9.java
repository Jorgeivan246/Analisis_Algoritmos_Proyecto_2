import java.math.BigInteger;

public class Algoritmo9 {

    public int[] Multi_Rusa(int []a, int []b){

        BigInteger i=convertirNumero(a);
        BigInteger j=convertirNumero(b);
        BigInteger aux = new BigInteger("2");
        BigInteger aux2 = new BigInteger("0");
        BigInteger c =new BigInteger("0");

        int[] result=null;
        while(i.intValue()!=0){
            if(i.intValue() %2 != 0){
                c=   c.add(j);
            }
            i=i.divide(aux);
            j=j.multiply(aux);

        }
        result=bigIntegerToIntArray(c);
        return result;
    }
    public int[] bigIntegerToIntArray(BigInteger number) {
        String numberString = number.toString();
        int[] result = new int[numberString.length()];

        for (int i = 0; i < numberString.length(); i++) {
            result[i] = Character.getNumericValue(numberString.charAt(i));
        }

        return result;
    }
    public BigInteger convertirNumero(int[] numeros) {
        StringBuilder numeroString = new StringBuilder();

        for (int i = 0; i < numeros.length; i++) {
            numeroString.append(numeros[i]);
        }

        return new BigInteger(numeroString.toString());
    }
  

}
