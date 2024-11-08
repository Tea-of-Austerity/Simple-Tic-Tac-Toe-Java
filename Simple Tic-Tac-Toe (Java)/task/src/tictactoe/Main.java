import java.util.Scanner;
import java.util.Arrays;
//package tictactoe;

public class Main {
    public static void main(String[] args) {
        //Scanner scanner = new Scanner(System.in);
        //String input = scanner.nextLine();
        char[] inputArr = new char[9];
        /*for (int i = 0; i < input.length(); i++) {
            inputArr[i] = input.charAt(i);
        }*/
        for (int i = 0; i < 9; i++) {
            inputArr[i] = ' ';
        }

        char[][] input2D = new char[3][3];
        int k = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                input2D[i][j] = inputArr[k];
                k++;
            }
        }

        outputLoop(input2D);

        boolean flag = true;
        boolean playerOne = true;
        int iNew = -2;
        int jNew = -2;
        while(flag){
            Scanner sc = new Scanner(System.in);
            if(sc.hasNextInt()){
                iNew = sc.nextInt();
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }
            if(sc.hasNextInt()){
                jNew = sc.nextInt();
            } else {
                System.out.println("You should enter numbers!");
                continue;
            }
            if(jNew <1 || iNew<1 || jNew>3 || iNew>3){
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            else if (input2D[iNew-1][jNew-1] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }
            else{
                input2D[iNew - 1][jNew - 1] = playerOne? 'X': 'O';
                outputLoop(input2D);
                playerOne = !playerOne;
                if(notFininished(input2D, ' ')) {
                    if (winCondition(input2D, 'X')) {
                        outputResult(input2D);
                        flag = false;
                        //break;
                    } else if (winCondition(input2D, 'O')) {
                        outputResult(input2D);
                        flag = false;
                        //break;
                    }
                }else{
                    outputResult(input2D);
                    flag = false;
                    //break;
                }
            }
            sc.close();
        }

        //outputResult(input2D);
    }
    public static void outputLoop(char[][] input2D){
        String headerFooter = """
                ---------
                """;
        String boardState = """
                | %s %s %s |
                """;
        String output="";
        output+= headerFooter;

        for (int i = 0; i<3; i++){
            String result = (String.format(boardState, input2D[i][0],input2D[i][1],input2D[i][2]));
            output+= result;
        }
        output+=headerFooter;

        System.out.printf(output);
    }
    public static boolean winCondition(char[][] input2D, char player){
        boolean result = false;
        for (int i=0;i<input2D.length;i++){
            if(input2D[i][0]==player&& input2D[i][1]==player && input2D[i][2]==player){
                result = true;
            }
            else if(input2D[0][i]==player&& input2D[1][i]==player && input2D[2][i]==player){
                result = true;
            }
        }
        if(input2D[0][0]==player&& input2D[1][1]==player && input2D[2][2]==player){
            result = true;
        }
        else if(input2D[0][2]==player&& input2D[1][1]==player && input2D[2][0]==player){
            result = true;
        }
        return result;
    }
    public static boolean badCondition(boolean X, boolean Y){
        if (X && Y){
            return true;
        }
        return false;
    }
    public static boolean notFininished(char[][] input2D, char empty){
        boolean done = false;
        for (int i = 0; i<input2D.length;i++){
            for (int j = 0; j<input2D[i].length;j++){
                if(input2D[i][j] == empty) {
                    done = true;
                    break;
                }
            }
        }
        return done;
    }
    public static boolean badCondition(char[][] input2D) {
        int sumX = 0;
        int sumO = 0;
        for (int i = 0; i < input2D.length; i++) {
            for (int j = 0; j < input2D[1].length; j++) {
                if (input2D[i][j] == 'X') {
                    sumX++;
                } else if (input2D[i][j] == 'O') {
                    sumO++;
                }
            }
        }
        if ((sumX -sumO<0) || (sumX-sumO>1)) {
            return true;
        }
        return false;
    }
    public static void outputResult(char[][] input2D){
        if (badCondition(winCondition(input2D, 'X'), winCondition(input2D, 'O'))) {
            System.out.println("Impossible");
        } else if (winCondition(input2D, 'X')) {
            System.out.println("X wins");
        } else if (winCondition(input2D, 'O')) {
            System.out.println("O wins");
        } else if (badCondition(input2D)) {
            System.out.println("Impossible");
        } else if (notFininished(input2D, ' ')) {
            System.out.println("Game not finished");
        }else{
            System.out.println("Draw");
        }
    }
}


//_O_X__X_X