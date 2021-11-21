
//https://www.cnblogs.com/lz87/p/7493966.html
//https://leetcode.com/discuss/interview-question/945902/pinterest-online-assessment-snake-exit
// Do not remove these imports. You may add others if you wish.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SnakeExit {

    private static int[] directionX = {-1, 0, 1, 0};
    private static int[] directionY = {0, 1, 0, -1};

    static int[] findExit(char[][] board, int row, int col) {

        int result[] = new int[2];

        boolean visited[][] = new boolean[board.length][board[0].length];
        visited[row][col] = true;

        Queue<Coordinate> path = new LinkedList<>();
        path.add(new Coordinate(row, col));

        int minimumDist = Integer.MAX_VALUE;
        int currentDist = 1;

        while (!path.isEmpty()) {
            int size = path.size();
            for (int i = 0; i < size; i++) {
                Coordinate currPoint = path.poll();
                for (int j = 0; j < 4; j++) {
                    int r = currPoint.row + directionX[j];
                    int c = currPoint.col + directionY[j];

                    if (isInside(board, r, c) && !visited[r][c]) {
                        if (isExit(r, c, board)) {
                            if (minimumDist == Integer.MAX_VALUE) {
                                minimumDist = currentDist;
                                result[0] = r;
                                result[1] = c;
                            } else if (currentDist < minimumDist) {
                                minimumDist = currentDist;
                                if (r != result[0]) {
                                    if (r < result[0]) {
                                        result[0] = r;
                                        result[1] = c;
                                    }
                                } else {
                                    if (c < result[1]) {
                                        result[0] = r;
                                        result[1] = c;
                                    }
                                }
                            }
                        } else if (board[r][c] != '+') {
                            path.add(new Coordinate(r, c));
                            visited[r][c] = true;
                        }
                    }
                }
            }
            currentDist++;
        }

        if (minimumDist != Integer.MAX_VALUE) {
            return result;
        } else {
            return new int[]{-1, -1};
        }
    }

    private static boolean isInside(char board[][], int row, int col) {
        return (row >= 0 && row < board.length) && (col >= 0 && col < board[0].length);
    }

    private static boolean isExit(int x, int y, char board[][]) {
        if (((x == board.length - 1) || (x == 0) || (y == board[0].length - 1) || (y == 0)) && board[x][y] == '0') {
            return true;
        }
        return false;
    }

    // DO NOT MODIFY MAIN()
    public static void main(String[] args) {
        String arg0 = "";
        List<String> input_strings = new ArrayList<String>();

        String line;
        boolean first_arg = true;
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while ((line = br.readLine()) != null) {
                if (line.equals("")) {
                    continue;
                }

                if (first_arg) {
                    arg0 = line;
                    first_arg = false;
                } else {
                    input_strings.add(line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String[] tokens;
        char[][] board = new char[input_strings.size()][];
        for (int i = 0; i < input_strings.size(); i++) {
            tokens = input_strings.get(i).split(" ");
            board[i] = new char[tokens.length];
            for (int j = 0; j < tokens.length; j++) {
                board[i][j] = tokens[j].charAt(0);
            }
        }
        tokens = arg0.split(" ");
        int row = Integer.parseInt(tokens[0]);
        int col = Integer.parseInt(tokens[1]);

        int[] result = findExit(board, row, col);
        System.out.println(result[0] + " " + result[1]);

    }

    private static class Coordinate {
        int row;
        int col;

        Coordinate(int r, int c) {
            this.row = r;
            this.col = c;
        }
    }
}