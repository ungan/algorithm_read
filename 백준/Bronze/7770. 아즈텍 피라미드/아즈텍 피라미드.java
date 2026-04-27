
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int b = scanner.nextInt();
        int c = 1;
        int c2 = 2;
        int i=1;
        int a=1;
        int cnt=0;

        if(b==0)
        {
            //System.out.println("0");
            cnt =0;
            b=0;
        }
        if(b==1)
        {
            //System.out.println(a);
            cnt = 1;
            b=0;
        }
        b = b-1;

        while(true)
        {
            if(b <= 0)
                break;
            if(i > 1)
            {
                //System.out.println("i : " + i + "c : " + c);
                a=(c*c)+(c2*c2);
                b = b-a;
                //System.out.println(a + " " + b);
                if(b < 0)
                {
                    break;
                }
                //System.out.println(a);
                c = c+1;
                c2 = c2+1;
            }

            i++;
            cnt++;
        }

        System.out.println(cnt);



        scanner.close();
    }
}