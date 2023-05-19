public class Algoritmo10 {

    // BEGIN: ed8c6549bwf9 (optimized)
    public int[] multiplicacionHindu(int[] num1, int[] num2) {
        int[] resultado = new int[num1.length + num2.length];

        for (int i = 0; i < num1.length; i++) {
            for (int j = 0; j < num2.length; j++) {
                int producto = num1[i] * num2[j];
                int posicion1 = i + j;
                int posicion2 = posicion1 + 1;
                resultado[posicion1] += producto / 10;
                resultado[posicion2] += producto % 10;
            }
        }

        for (int i = resultado.length - 1; i > 0; i--) {
            resultado[i - 1] += resultado[i] / 10;
            resultado[i] %= 10;
        }

        return resultado;
    }
    // END: ed8c6549bwf9 (optimized)

}
