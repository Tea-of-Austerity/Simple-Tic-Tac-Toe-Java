import java.util.Scanner;
import java.util.Arrays;

class Main {
    // implement me
    private static void rotate(int[] arr, int steps) {
        int[] newArr = new int[arr.length];
            for (int i=0;i<arr.length;i++){
                newArr[i] = arr[(i+arr.length+steps)%arr.length];
            }
            for (int i=0; i<arr.length;i++){
                arr[i]=newArr[i];
            }
        }
    }

    // do not change code below
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int steps = Integer.parseInt(scanner.nextLine());

        rotate(arr, steps);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}

//0 1 2 3 4 5
//5 0 1 2 3 4 5
//4 5 1 2 3 4 5