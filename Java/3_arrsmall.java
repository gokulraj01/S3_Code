import java.util.Scanner;

class SecSmall{
    static int[] getArr(){
        Scanner s = new Scanner(System.in);
        System.out.print("Enter array: ");
        String[] line = s.nextLine().split("\s");
        s.close();
        int len = line.length;
        int[] retArr = new int[len];
        for(int i=0; i<len; i++)
            retArr[i] = Integer.parseInt(line[i]);
        return retArr;
    }

    static void showArr(int[] arr, String title){
        System.out.print(title);
        for(int e: arr)
            System.out.print(e+" ");
        System.out.println();
    }

    static int secMin(int[] arr){
        int min = arr[0], min2 = Integer.MAX_VALUE;
        for(int i=1; i<arr.length; i++){
            if(arr[i] < min){
                min2 = min;
                min = arr[i];
            }
            else if(arr[i] < min2 && arr[i] != min)
                min2 = arr[i];
        }
        return min2;
    }

    public static void main(String args[]){
        int[] arr = getArr();
        System.out.println(secMin(arr));
    }
}