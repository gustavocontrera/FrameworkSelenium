package ejerciciosVarios;

// Programa Java para ilustrar bucle for mejorado
public class PruebaBucle01
{
    public static void main(String args[])
    {
        String array[] = {"Ron", "Harry", "Hermoine"};

        //mejorado para for
        for (String x:array)
        {
            System.out.println(x);
        }

        //bucle for para la misma función
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
}
