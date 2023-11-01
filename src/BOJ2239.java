import java.util.Scanner;

public class BOJ2239 {
    public static int[][] sudoku = new int[9][9];

    public static boolean linear_check(int y, int x, int k) {
        for (int i = 0; i < 9; i++) {
            if (sudoku[i][x] == k) {
                return false;
            }
        }
        for (int j = 0; j < 9; j++) {
            if (sudoku[y][j] == k) {
                return false;
            }
        }
        return true;
    }

    public static boolean square_check(int y, int x, int k) {
        for (int i = y - y % 3; i < y - y % 3 + 3; i++) {
            for (int j = x - x % 3; j < x - x % 3 + 3; j++) {
                if (sudoku[i][j] == k) {
                    return false;
                }
            }
        }

        return true;
    }

    public static boolean solve(int y) {
        for (int i = y; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (sudoku[i][j] == 0) {
                    for (int k = 1; k <= 9; k++) {
                        if (linear_check(i, j, k) && square_check(i, j, k)) {
                            sudoku[i][j] = k;
                            if (solve(i)) {
                                return true;
                            }
                            sudoku[i][j] = 0;
                        }
                    }
                    if (sudoku[i][j] == 0) {
                        return false;
                    }
                }
                else if (i == 8 && j == 8) { // 완성되었을 경우 탈출
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 9; i++) {
            String num = sc.next();
            for (int j = 0; j < 9; j++) {
                sudoku[i][j] = Character.getNumericValue(num.charAt(j));
            }
        }
        solve(0);
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoku[i][j]);
            }
            System.out.print('\n');
        }
    }
}
