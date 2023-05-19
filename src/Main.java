import java.io.*;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Main {

    public static String direccion="https://script.google.com/macros/s/AKfycbz2AMqwtsuZptPKbuOr9PkLb4KfF_vDphXzxf3BPg-h2z1M5h5teaNe6DeHsXOCKe_dUw/exec?";

   public static void main(String[] args) throws IOException {


       generarNumero(10000);



       enviarDatosAlServidor();





    }

    public static void enviarDatosAlServidor() throws IOException {
        int[] numero = leerArchivo1(10000);
        int[] numero2 = leerArchivo1(10000);

        ArrayList<Integer> numero3 = leerArchivo2(10000);
        ArrayList<Integer> numero4 = leerArchivo2(10000);

        int[] result=null;

        ArrayList<Integer> result2 = new ArrayList<>();


        Algoritmo1 algo1 = new Algoritmo1();

        Algoritmo2 algo2 = new Algoritmo2();



        ArrayList<Object> algoritmos = new ArrayList<>();

        algoritmos.add(algo1);

        int k=0;

        int j=0;


        for (int i = 0; i <12 ; i++) {

            switch(i)
            {
                case 0:
                    long tiempoInicial = System.currentTimeMillis();
                    result = algo1.multiplicar(numero, numero2);
                    long tiempoFinal = System.currentTimeMillis();
                    long tiempoTotal = tiempoFinal - tiempoInicial;

                    direccion=direccion+"id="+i+"co="+j;
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
                case 1:
                    result2=algo2.multiplicar(numero3,numero4);
                    break;

                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;

            }

        }


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

    public  static void generarNumero(int limiteNumero)
    {
        String numeroAEscribir="";

        for (int i = 0; i <limiteNumero ; i++) {
            numeroAEscribir=numeroAEscribir+"8";
        }
        BigInteger bigInt=new BigInteger(numeroAEscribir);
        generarArchivo(bigInt);

    }

    public static int[] leerArchivo1(int cantidadCifras) {

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

    public static ArrayList<Integer> leerArchivo2(int cantidadCifras) {

        String rutaArchivo="src/numeroPrueba/numero_"+cantidadCifras+"_cifras"+".txt";
        BigInteger numero = null;

        ArrayList<Integer> result = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(rutaArchivo));
            String linea = reader.readLine();
            numero = new BigInteger(linea);

            result=convertBigIntegerToArrayList(numero);
            reader.close();
        } catch (IOException e) {
            System.out.println("Error al leer archivo.");
            e.printStackTrace();
        }
        return result;
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