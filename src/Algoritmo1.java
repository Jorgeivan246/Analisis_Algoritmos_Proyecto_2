public class Algoritmo1 {

    public int[] multiplicar(int[] numero1, int[] numero2) {
        int tam = numero1.length + numero2.length;
        int[] resultado = new int [tam];
        for (int i=0; i< numero2.length; i++)
        {

            for(int j=0; j< numero1.length; j++)
            {

                resultado[i+j+1]+= numero1[j]* numero2[i];

            }

        }
        for (int k=tam-1; k>0; k--)
        {

            resultado[k-1]+= resultado[k]/10;
            resultado [k]%=10;

        }
        return resultado;
        
        
    }
}
