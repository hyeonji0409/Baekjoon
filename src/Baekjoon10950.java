import java.util.Scanner;

public class Baekjoon10950 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int a, b;
        int t = scan.nextInt();

        for(int i = 0; i<t;i++){
            a = scan.nextInt();
            b = scan.nextInt();
            System.out.println(a+b);
        }
    }
}
