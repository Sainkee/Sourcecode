public class nknight {

    public static void main(String[] args) {

        int n = 3;

        int[][] board = new int[n][n];

        System.out.println(solve(0, 0, board, n));

    }

    public static int solve(int r, int c, int[][] board, int knights) {

        int count = 0;
        if (knights == 0) {
            printingPress(board);
            System.out.println();
            return 1;
        }

        if (c >= board[0].length) {
            return solve(r + 1, 0, board, knights);
        }

        if (r >= board.length) {
            return 0;
        }

        if (issafe(board, r, c)) {
            board[r][c] = 1;
            count += solve(r, c + 1, board, knights - 1);
            board[r][c] = 0;

        }

        count += solve(r, c + 1, board, knights);
        return count;

    }

    public static boolean issafe(int[][] board, int r, int c) {
        // for upper
        if (inzone(board, r - 2, c - 1) && board[r - 2][c - 1] == 1)
            return false;
        if (inzone(board, r - 2, c + 1) && board[r - 2][c + 1] == 1)
            return false;
        if (inzone(board, r + 2, c - 1) && board[r + 2][c - 1] == 1)
            return false;
        if (inzone(board, r + 2, c + 1) && board[r + 2][c + 1] == 1)
            return false;
        if (inzone(board, r - 1, c - 2) && board[r - 1][c - 2] == 1)
            return false;
        if (inzone(board, r - 1, c + 2) && board[r - 1][c + 2] == 1)
            return false;
        if (inzone(board, r + 1, c - 2) && board[r + 1][c - 2] == 1)
            return false;
        if (inzone(board, r + 1, c + 2) && board[r + 1][c + 2] == 1)
            return false;

        return true;

    };

    public static boolean inzone(int[][] board, int r, int c) {
        return (r >= 0 && r < board.length && c >= 0 && c < board[0].length);
    }

    public static void printingPress(int[][] board) {
        for (int[] r : board) {
            for (int c : r) {
                if (c == 1) {
                    System.out.print("k ");

                } else {
                    System.out.print(". ");

                }
            }
            System.out.println();
        }
    }
}
