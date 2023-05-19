import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {


        generarNumero(10000);

        int[] numero = leerArchivo1(10);
        int[] numero2 = leerArchivo1(100);

        ArrayList<Integer> numero3 = leerArchivo2(10);
        ArrayList<Integer> numero4 = leerArchivo2(10);

        int[] result = null;

        Algoritmo8 algo6 = new Algoritmo8();
        Algoritmo2 algo2 = new Algoritmo2();
        Algoritmo10 algo10 = new Algoritmo10();

//        ArrayList<Integer> result2 = inicializarArrayList(numero3.size() + numero4.size());

//        result2 = algo6.multiplicar(numero3, numero4, result2);

//        imprimirArryList(result2);

//       result2=algo2.multiplicar(numero3,numero4);

        String resultado = arregloToStrin(algo10.multiplicacionHindu(numero, numero2)) ;

        System.out.println("El resultado de la multiplicacion hindu es: "+resultado);



    }

    private static String arregloToStrin(int[] multiplicacionHindu) {
        String result="";
        for (int i = 0; i < multiplicacionHindu.length; i++) {
            result=result+multiplicacionHindu[i];
        }
        return result;
    }

    public static ArrayList<Integer> convertBigIntegerToArrayList(BigInteger bigInt) {
        String str = bigInt.toString();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            result.add(Character.getNumericValue(str.charAt(i)));
        }
        return result;
    }

    public static int[] convertBigIntegerToArray(BigInteger bigInt) {
        String str = bigInt.toString();
        int[] result = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            result[i] = Character.getNumericValue(str.charAt(i));
        }
        return result;
    }

    public static void generarNumero(int limiteNumero) {
        String numeroAEscribir = "";

        for (int i = 0; i < limiteNumero; i++) {
            numeroAEscribir = numeroAEscribir + "8";
        }
        BigInteger bigInt = new BigInteger(numeroAEscribir);
        generarArchivo(bigInt);

    }

    public static int[] leerArchivo1(int cantidadCifras) {

        String rutaArchivo = "src/numeroPrueba/numero_" + cantidadCifras + "_cifras" + ".txt";
        BigInteger numero = null;

        int[] numeroArreglo = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
            String linea = reader.readLine();
            numero = new BigInteger(linea);

            numeroArreglo = convertBigIntegerToArray(numero);
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer archivo.");
            e.printStackTrace();
        }
        return numeroArreglo;
    }

    public static ArrayList<Integer> leerArchivo2(int cantidadCifras) {

        String rutaArchivo = "src/numeroPrueba/numero_" + cantidadCifras + "_cifras" + ".txt";
        BigInteger numero = null;

        ArrayList<Integer> result = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
            String linea = reader.readLine();
            numero = new BigInteger(linea);

            result = convertBigIntegerToArrayList(numero);
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer archivo.");
            e.printStackTrace();
        }
        return result;
    }

    public static void generarArchivo(BigInteger numero) {

        int cantidadCifras = numero.toString().length();


        String rutaArchivo = "src/numeroPrueba/numero_" + cantidadCifras + "_cifras" + ".txt";
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

    private static void imprimirArryList(ArrayList<Integer> result2) {
        for (Integer integer : result2) {

            System.out.print(" " + integer);
        }
    }

    private static ArrayList<Integer> inicializarArrayList(int cantidadCifras) {
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < cantidadCifras; i++) {
            result.add(0);
        }
        return result;
    }

}