import java.lang.reflect.Array;
import java.util.ArrayList;

public class Algoritmo14 {

    public ArrayList<Integer> DivideVenceras1(ArrayList<Integer> num1, ArrayList<Integer> num2, ArrayList<Integer> resultado){

        boolean digitosFlag = false;
        Algoritmo2 algoritmo2 = new Algoritmo2();

        //El numero con mayor numero de digitos si es un numero impar se le agrega un 0 al inicio
        if(num1.size()> num2.size()){
            if(num1.size()%2 != 0){
                num1.add(0,0);
            }
        } else if(num1.size()< num2.size()){
            if(num2.size()%2 != 0){
                num2.add(0,0);
            }
        }

        if(num1.size()> num2.size()){
             while(num1.size() > num2.size()){
                num2.add(0,0);
            }
        } else if(num1.size()< num2.size()){
            while(num1.size() < num2.size()){
                num1.add(0,0);
            }
        }

        int mitad1 = num1.size()/2;
        int mitad2 = num2.size()/2;

        //Se crea una nueva variable que asigna la mitad del número 1
        ArrayList<Integer> w = new ArrayList<Integer>(num1.subList(0, mitad1));
        ArrayList<Integer> x = new ArrayList<Integer>(num1.subList(mitad1, num1.size()));

        //Se crea una nueva variable que asigna la mitad del número 2
        ArrayList<Integer> y = new ArrayList<Integer>(num2.subList(0, mitad2));
        ArrayList<Integer> z = new ArrayList<Integer>(num2.subList(mitad2, num2.size()));

        ArrayList<Integer> result1 = algoritmo2.multiplicar(w, y);
        ArrayList<Integer> result2 = algoritmo2.multiplicar(w, z);
        ArrayList<Integer> result3 = algoritmo2.multiplicar(x, y);
        ArrayList<Integer> result4 = algoritmo2.multiplicar(x, z);


        return null;
    }
        
}
