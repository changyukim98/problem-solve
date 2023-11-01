import java.util.Scanner;

public class BOJ2754 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        String rating = sc.next();

        if (rating.equals("A+")) {
            System.out.println("4.3");
        }
        else if (rating.equals("A0")) {
            System.out.println("4.0");
        }
        else if (rating.equals("A-")) {
            System.out.println("3.7");
        }
        else if (rating.equals("B+")) {
            System.out.println("3.3");
        }
        else if (rating.equals("B0")) {
            System.out.println("3.0");
        }
        else if (rating.equals("B-")) {
            System.out.println("2.7");
        }
        else if (rating.equals("C+")) {
            System.out.println("2.3");
        }
        else if (rating.equals("C0")) {
            System.out.println("2.0");
        }
        else if (rating.equals("C-")) {
            System.out.println("1.7");
        }
        else if (rating.equals("D+")) {
            System.out.println("1.3");
        }
        else if (rating.equals("D0")) {
            System.out.println("1.0");
        }
        else if (rating.equals("D-")) {
            System.out.println("0.7");
        }
        else if (rating.equals("F")) {
            System.out.println("0.0");
        }
    }
}
