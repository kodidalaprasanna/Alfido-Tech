import java.util.*;
import java.lang.*;
public class NGG
{
    public static void main(String[] args)
    {
        Random r= new Random();
        int ans = r.nextInt(100)+1;
        int k = 100;
        Scanner sc = new Scanner(System.in);
        System.out.println("thought number below 100");
        while(k > 0)
        {
            System.out.println("guess: ");
            int g=sc.nextInt();
            if(g== ans)
            {
                System.out.println(" guessed correctly!!!");
                break;
            }
            else if (g < ans)
            {
                System.out.println("low");
            }
            else
            System.out.println("high");
        }
    }
}