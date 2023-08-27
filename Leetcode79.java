//Q: WORD SEARCH GAME

public class Leetcode79 {

    static boolean dfs(char[][] board, int i, int j, String word, int count){
        if (count == word.length()) return true;

        if (i == -1 || i == board.length || j == -1 || j == board[0].length || board[i][j] != word.charAt(count)) return false;

        char temp = board[i][j];
        board[i][j] = '*';

        boolean result = dfs(board,i-1,j,word,count+1)
                || dfs(board,i+1,j,word,count+1)
                || dfs(board,i,j-1,word,count+1)
                || dfs(board,i,j+1,word,count+1);
            board[i][j] = temp;

        return result;
    }

    public static void main(String[] args) {
        char [][] board = {{'d','e','l','f'},
                           {'e','r','o','y'},
                           {'e','t','n','w'},
                           {'a','b','c','d'}};

        String word = "elon";

        int v=0;
        for (int i = 0; i < board.length; i++){
            for (int j =0; j< board[i].length; j++){
                if ((board[i][j] == word.charAt(0)) &&(dfs(board, i, j, word,0))){
                    System.out.println("True : Word is in the board");
                    v = 1;
                    break;}
            }
        }
        if (v==0) System.out.println("False : Word is not in the board");
    }
}
