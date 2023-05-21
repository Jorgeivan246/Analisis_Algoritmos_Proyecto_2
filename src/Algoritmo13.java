public class Algoritmo13 {

    /**
     * Multiplica dos números grandes representados como cadenas de caracteres.
     * @param num1 El primer número a multiplicar.
     * @param num2 El segundo número a multiplicar.
     * @return El resultado de la multiplicación como una cadena de caracteres.
     */
    public String multiplicarUsandoCadenas(String num1, String num2) {
        // Obtener la longitud de las cadenas
        int n1 = num1.length();
        int n2 = num2.length();

        // Crear un arreglo para almacenar el resultado de la multiplicación
        int[] resultado = new int[n1 + n2];

        // Invertir las cadenas para facilitar el cálculo
        num1 = invertirCadena(num1);
        num2 = invertirCadena(num2);

        // Realizar la multiplicación dígito a dígito
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                // Obtener los dígitos de los números
                int digito1 = num1.charAt(i) - '0';
                int digito2 = num2.charAt(j) - '0';
                // Multiplicar los dígitos y sumar el resultado al arreglo
                resultado[i+j] += digito1 * digito2;
            }
        }

        // Acomodar los números mayores a 9
        int acarreo = 0;
        for (int i = 0; i < n1+n2; i++) {
            resultado[i] += acarreo;
            acarreo = resultado[i] / 10;
            resultado[i] %= 10;
        }

        // Eliminar los ceros no significativos al final
        int k = n1 + n2 - 1;
        while (k > 0 && resultado[k] == 0) {
            k--;
        }

        // Construir el resultado final invirtiendo los dígitos
        StringBuilder builder = new StringBuilder();
        for (int i = k; i >= 0; i--) {
            builder.append(resultado[i]);
        }

        return builder.toString();
    }

    /**
     * Invierte una cadena de caracteres.
     * @param s La cadena a invertir.
     * @return La cadena invertida.
     */
    public String invertirCadena(String s) {
        char[] runas = s.toCharArray();
        int n = runas.length;
        for (int i = 0; i < n/2; i++) {
            char temp = runas[i];
            runas[i] = runas[n-i-1];
            runas[n-i-1] = temp;
        }
        return new String(runas);
    }
}