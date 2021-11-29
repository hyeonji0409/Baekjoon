import java.util.Scanner;

public class Baekjoon10952 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int a, b;

        while(true){
            a = scan.nextInt();
            b = scan.nextInt();

            if(a == 0 && b == 0){
                break;
            }
            else{
                System.out.println((a+b));
            }
        }
    }
}
