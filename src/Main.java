import java.io.*;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static String url = "https://script.google.com/macros/s/AKfycbzh_b_YyI2rFMjclr0rETUQhbgg4PczRm1_-ROBvazwsnBu-vpJFVVv6M9QSlszxQjCBA/exec?";

    public static ArrayList<Integer> nDigitosLeer = new ArrayList();

    public static ArrayList<Integer> nDigitosLeer2 = new ArrayList();

    public static ArrayList<Integer> nDigitosLeer3 = new ArrayList();

    public static void main(String[] args) throws IOException {


        nDigitosLeer2.add(15);
        nDigitosLeer2.add(20);
        nDigitosLeer2.add(25);
        nDigitosLeer2.add(30);
        nDigitosLeer2.add(35);
        nDigitosLeer2.add(40);
        nDigitosLeer2.add(45);
        nDigitosLeer2.add(50);

        nDigitosLeer.add(50000);
        nDigitosLeer.add(100000);
        nDigitosLeer.add(150000);
        nDigitosLeer.add(200000);
        nDigitosLeer.add(250000);
        nDigitosLeer.add(300000);
        nDigitosLeer.add(350000);
        nDigitosLeer.add(370000);

        nDigitosLeer3.add(11000);
        nDigitosLeer3.add(12000);
        nDigitosLeer3.add(14000);
        nDigitosLeer3.add(16000);
        nDigitosLeer3.add(18000);
        nDigitosLeer3.add(20000);
        nDigitosLeer3.add(22000);
        nDigitosLeer3.add(25000);

         enviarDatosAlServidor();
     //   probarAlgoritmo();

    }

    private static void probarAlgoritmo() throws IOException {
        Algoritmo2 algo11 = new Algoritmo2();

        // generarNumero(5);
        ArrayList<Integer> numero1 = new ArrayList<Integer>();
        ArrayList<Integer> result = new ArrayList<Integer>();

        int[] result3 = null;
        int[] result4 = null;
        numero1 = leerArchivo2(400000);

        // result3 = leerArchivo1(400000);

        result = algo11.multiplicar(numero1, numero1);

        // result.forEach(elemento -> System.out.print(elemento + " "));
        System.out.println(Arrays.toString(result4));

    }

    public static void enviarDatosAlServidor() throws IOException {

        ArrayList<Integer> numero3 = new ArrayList<>();

        int[] result = null;

        ArrayList<Integer> result2 = new ArrayList<>();

        Algoritmo1 algo1 = new Algoritmo1();

        Algoritmo2 algo2 = new Algoritmo2();

        Algoritmo3 algo3 = new Algoritmo3();

        Algoritmo4 algo4 = new Algoritmo4();

        Algoritmo5 algo5 = new Algoritmo5();

        Algoritmo6 algo6 = new Algoritmo6();

        Algoritmo7 algo7 = new Algoritmo7();

        Algoritmo8 algo8 = new Algoritmo8();

        Algoritmo9 algo9 = new Algoritmo9();

        Algoritmo10 algo10 = new Algoritmo10();

        Algoritmo11 algo11 = new Algoritmo11();

        Algoritmo12 algo12 = new Algoritmo12();

        Algoritmo13 algo13 = new Algoritmo13();

        Algoritmo14 algo14 = new Algoritmo14();

        Algoritmo15 algo15 = new Algoritmo15();

        double tiempoInicial = 0.0;
        double tiempoTotal = 0.0;
        double tiempoFinal = 0.0;

        int[] numero = null;

        ArrayList<Object> algoritmos = new ArrayList<>();

        algoritmos.add(algo1);

        int fila = 9;

        int columna = 4;

        String direccion = "";

        long nDigitos = 0;

        for (int i = 0; i < 14; i++) {

            for (int l = 0; l < nDigitosLeer.size(); l++) {

                switch (i) {

                    case 0:
                        numero = leerArchivo1(nDigitosLeer.get(l));

                        tiempoInicial = System.nanoTime();
                        algo1.multiplicar(numero, numero);
                        tiempoFinal = System.nanoTime();
                        tiempoTotal = (tiempoFinal - tiempoInicial) / 1_000_000.0;
                        nDigitos = nDigitosLeer.get(l);
                        break;
                    case 1:


                        numero3 = leerArchivo2(nDigitosLeer.get(l));
                        tiempoInicial = System.nanoTime();
                         algo2.multiplicar(numero3, numero3);
                        tiempoFinal = System.nanoTime();
                        tiempoTotal = (tiempoFinal - tiempoInicial) / 1_000_000.0;
                        nDigitos = nDigitosLeer.get(l);
                        break;

                    case 2:
                        numero = leerArchivo1((nDigitosLeer2.get(l)));
                        tiempoInicial = System.nanoTime();
                        result = algo3.multiplicar(numero, numero);
                        tiempoFinal = System.nanoTime();
                        tiempoTotal = (tiempoFinal - tiempoInicial) / 1_000_000.0;;
                        nDigitos = nDigitosLeer2.get(l);

                        break;
                    case 3:
                        System.out.println("Entro al caso 4");
                        numero3 = leerArchivo2((nDigitosLeer2.get(l)));
                        tiempoInicial = System.nanoTime();
                        algo4.multiplicar(numero3, numero3);
                        tiempoFinal = System.nanoTime();
                        tiempoTotal = (tiempoFinal - tiempoInicial) / 1_000_000.0;
                        nDigitos = nDigitosLeer2.get(l);
                        break;

                    case 4:
                        System.out.println("Entro en el 5");
                        numero = leerArchivo1(nDigitosLeer.get(l));

                        tiempoInicial = System.nanoTime();
                        result = algo5.multiplicar(numero, numero);
                        tiempoFinal = System.nanoTime();
                        tiempoTotal = (tiempoFinal - tiempoInicial) / 1_000_000.0;
                        nDigitos = nDigitosLeer.get(l);

                        break;
                    case 5:

                        numero3 = leerArchivo2((nDigitosLeer.get(l)));

                        System.out.println("Entra al case 6");
                        tiempoInicial = System.nanoTime();
                        result2 = algo6.multiplicar(numero3, numero3);
                        tiempoFinal = System.nanoTime();
                        tiempoTotal = (tiempoFinal - tiempoInicial) / 1_000_000.0;
                        nDigitos = nDigitosLeer.get(l);
                        break;
                    case 6:

                        numero = leerArchivo1((nDigitosLeer2.get(l)));

                        System.out.println("Entra al case 7");
                        tiempoInicial = System.nanoTime();
                        result = algo7.multiplicar(numero, numero);
                        tiempoFinal = System.nanoTime();
                        tiempoTotal = (tiempoFinal - tiempoInicial) / 1_000_000.0;
                        nDigitos = nDigitosLeer2.get(l);
                        break;

                    case 7:
                        System.out.println("Entra al case 8");
                        numero3 = leerArchivo2((nDigitosLeer2.get(l)));

                        tiempoInicial = System.nanoTime();
                        result2 = algo8.multiplicar(numero3, numero3);
                        tiempoFinal = System.nanoTime();
                        tiempoTotal = (tiempoFinal - tiempoInicial) / 1_000_000.0;
                        nDigitos = nDigitosLeer2.get(l);

                        break;
                    case 8:
                        numero = leerArchivo1((nDigitosLeer.get(l)));

                        System.out.println("Entra al case 9");
                        tiempoInicial = System.nanoTime();
                        result = algo9.multiplicar(numero, numero);
                        tiempoFinal = System.nanoTime();
                        tiempoTotal = (tiempoFinal - tiempoInicial) / 1_000_000.0;
                        nDigitos = nDigitosLeer.get(l);
                        break;
                    case 9:
                        System.out.println("Entra al case 10");
                        numero = leerArchivo1((nDigitosLeer.get(l)));

                        tiempoInicial = System.nanoTime();
                        result = algo10.multiplicar(numero, numero);
                        tiempoFinal = System.nanoTime();
                        tiempoTotal = (tiempoFinal - tiempoInicial) / 1_000_000.0;
                        nDigitos = nDigitosLeer.get(l);

                        break;

                    case 10:
                        numero = leerArchivo1((nDigitosLeer3.get(l)));

                        System.out.println("Entra al case 11");
                        tiempoInicial = System.nanoTime();
                        result = algo11.multiplicar(numero, numero);
                        tiempoFinal = System.nanoTime();
                        tiempoTotal = (tiempoFinal - tiempoInicial) / 1_000_000.0;
                        nDigitos = nDigitosLeer.get(l);

                        break;

                    case 11:
                        numero = leerArchivo1((nDigitosLeer.get(l)));

                        System.out.println("Entra al case 12");
                        tiempoInicial = System.nanoTime();
                        result = algo12.multiplicar(numero, numero);
                        tiempoFinal = System.nanoTime();
                        tiempoTotal = (tiempoFinal - tiempoInicial) / 1_000_000.0;
                        nDigitos = nDigitosLeer.get(l);

                        break;

                    case 12:
                        numero = leerArchivo1((nDigitosLeer.get(l)));

                        System.out.println("Entra al case 13");
                        tiempoInicial = System.nanoTime();
                        result = algo13.multiplicar(numero, numero);
                        tiempoFinal = System.nanoTime();
                        tiempoTotal = (tiempoFinal - tiempoInicial) / 1_000_000.0;
                        nDigitos = nDigitosLeer.get(l);

                        break;

                    case 13:
                        numero = leerArchivo1((nDigitosLeer.get(l)));

                        System.out.println("Entra al case 14");
                        tiempoInicial = System.nanoTime();
                        result = algo14.multplicar(numero, numero);
                        tiempoFinal = System.nanoTime();
                        tiempoTotal = (tiempoFinal - tiempoInicial) / 1_000_000.0;
                        nDigitos = nDigitosLeer.get(l);

                        break;

                    case 14:
                        numero = leerArchivo1((nDigitosLeer.get(l)));

                        System.out.println("Entra al case 14");
                        tiempoInicial = System.nanoTime();
                        result = algo15.multplicar(numero, numero);
                        tiempoFinal = System.nanoTime();
                        tiempoTotal = (tiempoFinal - tiempoInicial) / 1_000_000.0;
                        nDigitos = nDigitosLeer.get(l);

                        break;

                }
                direccion = url + "fi=" + fila + "&" + "co=" + columna + "&" + "ti=" + tiempoTotal + "&" + "ci="
                        + nDigitos;

                System.out.println("Se envio " + direccion);

                URL urlObject = new URL(direccion);
                HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
                connection.setRequestMethod("GET");

                int responseCode = connection.getResponseCode();
                if (responseCode == HttpURLConnection.HTTP_OK) {
                    System.out.println("La solicitud se envió correctamente.");
                } else {
                    System.out.println("Error al enviar la solicitud. Código de respuesta: " + responseCode);
                }

                connection.disconnect();
                columna = columna + 2;
            }
            columna = 4;
            fila++;

        }

    }

    private static String arregloToStrin(int[] multiplicacionHindu) {
        String result = "";
        for (int i = 0; i < multiplicacionHindu.length; i++) {
            result = result + multiplicacionHindu[i];
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

    public static BigInteger[] leerBig(int cantidadCifras) {
        String rutaArchivo = "src/numeroPrueba/numero_" + cantidadCifras + "_cifras" + ".txt";
        BigInteger[] numeroArreglo = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
            String linea = reader.readLine();
            BigInteger numero = new BigInteger(linea);
            int length = linea.length();
            numeroArreglo = new BigInteger[length];
            for (int i = 0; i < length; i++) {
                numeroArreglo[i] = numero.mod(BigInteger.TEN);
                numero = numero.divide(BigInteger.TEN);
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer archivo.");
            e.printStackTrace();
        }
        return numeroArreglo;
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