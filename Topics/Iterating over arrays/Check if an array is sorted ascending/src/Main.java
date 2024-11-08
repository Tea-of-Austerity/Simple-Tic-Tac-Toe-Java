import java.util.Scanner;
class Main {
    public static void main(String[] args) {
        // put your code here
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();
        int[] arr = new int[size];
        for (int i=0;i<size;i++){
            arr[i]=scanner.nextInt();
        }
        boolean descend = true;
            for(int i=1;i<size;i++){
                if(arr[i-1]>arr[i]){
                    descend = false;
                    break;
                }
            }
        if (descend){
            System.out.println(true);
        }
        else{
            System.out.println(false);
        }
    }
}