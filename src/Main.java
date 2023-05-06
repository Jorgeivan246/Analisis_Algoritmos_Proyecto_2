import java.io.*;
import java.math.BigInteger;

public class Main {

   public static void main(String[] args) {

       MultiplicadorDeNumeros[] algoritmos = {
               new Algoritmo1(),


       };

       generarNumero(10000);

       int[] numero = leerArchivo(10000);
       int[] numero2 = leerArchivo(10000);

       int[] result=null;

       for (MultiplicadorDeNumeros algoritmo : algoritmos) {
           result=algoritmo.multiplicar(numero, numero2);
           for (int i = 0; i < result.length; i++) {
               System.out.print(""+result[i]);
           }

       }




    }


    public static int[] convertBigIntegerToArray(BigInteger bigInt) {
        String str = bigInt.toString();
        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = Character.getNumericValue(str.charAt(i));
        }
        return result;
    }

    public  static void generarNumero(int limiteNumero)
    {
        String numeroAEscribir="";

        for (int i = 0; i <limiteNumero ; i++) {
            numeroAEscribir=numeroAEscribir+"8";
        }
        BigInteger bigInt=new BigInteger(numeroAEscribir);
        generarArchivo(bigInt);

    }

    public static int[] leerArchivo(int cantidadCifras) {

       String rutaArchivo="src/numeroPrueba/numero_"+cantidadCifras+"_cifras"+".txt";
        BigInteger numero = null;

        int[] numeroArreglo=null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
            String linea = reader.readLine();
            numero = new BigInteger(linea);

            numeroArreglo=convertBigIntegerToArray(numero);
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer archivo.");
            e.printStackTrace();
        }
        return numeroArreglo;
    }

    public static void generarArchivo(BigInteger numero) {

        int cantidadCifras = numero.toString().length();


        String rutaArchivo="src/numeroPrueba/numero_"+cantidadCifras+"_cifras"+".txt";
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(rutaArchivo));
            writer.write(numero.toString());
            writer.close();
            System.out.println("Archivo generado exitosamente.");
        } catch (IOException e) {
            System.out.println("Error al generar archivo.");
            e.printStackTrace();
        }
    }

}