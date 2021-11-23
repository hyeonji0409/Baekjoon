import java.util.Scanner;

public class Baekjoon11021 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        int t = scan.nextInt();
        int a, b;

        for(int i = 0; i<t; i++){
            a = scan.nextInt();
            b = scan.nextInt();
            System.out.print("Case #"+(i+1)+": ");
            System.out.println((a+b));
        }
    }
}
