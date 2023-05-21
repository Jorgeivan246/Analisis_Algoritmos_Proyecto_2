public class Algoritmo7 {

    public int[] multiplicar(int[] num1, int[] num2) {

        int[] resultado = new int[num1.length + num2.length];


        int k=0;
        int j=0;


        resultado=mutiplicarAux1(num2,num1,k,j,resultado);

        resultado=multiplicacionAux2(resultado,resultado.length-1);


        return resultado;
    }

    public int[] multiplicacionAux2(int[] resultado,int i)
    {

        if(i>0)
        {
            resultado[i - 1] = resultado[i - 1] + resultado[i ]/ 10;

            resultado[i] = (resultado[i] % 10);
            multiplicacionAux2(resultado, i-1);
        }else{
            return resultado;
        }
       return  resultado;
    }

    public int[]  mutiplicarAux1(int[] num2,int[] num1,int i,int j,int[] resultado) {

        if(i<num2.length)
        {
            if(j<num1.length)
            {
                resultado[i + j + 1] = resultado[i + j + 1] + num1[j] * num2[i];
               return mutiplicarAux1(num2,num1,i,j+1,resultado);
            }
            j=0;

            return mutiplicarAux1(num2,num1,i+1,0,resultado);
        }else{
            return resultado;
        }

    }

}