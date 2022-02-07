import java.util.Scanner;

class MatrixTranspose{
    static int[][] transpose(int mat[][]){
        int r = mat.length, c = mat[0].length;
        int[][] arr = new int[c][r];
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++)
                arr[j][i] = mat[i][j];
        }
        return arr;
    }

    static int[][] matrixInput(String matName){
        Scanner s = new Scanner(System.in);
        System.out.print("Press 'Enter' again to end input.\nEnter Matrix "+matName+".\n");
        boolean reading = true;
        int rows = 0, cols = 0;
        int[][] buffer = new int[256][256];
        while(reading){
            System.out.print("> ");
            String input = s.nextLine();
            if(input == ""){
                reading = false;
                break;
            }
            String[] line = input.split("\s");
            cols = (cols > line.length) ? cols : line.length;
            for(int i=0; i<line.length; i++)
                buffer[rows][i] = Integer.parseInt(line[i]);
            rows++;
        }
        s.close();
        int[][] retArr = new int[rows][cols];
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++)
                retArr[i][j] = buffer[i][j];
        }
        return retArr;
    }

    static void matrixShow(int[][] mat, String matName){
        int r = mat.length, c = mat[0].length;
        System.out.printf("%s - %d x %d\n", matName, r, c);
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++)
                System.out.print(mat[i][j]+" ");
            System.out.println();
        }
    }

    public static void main(String args[]){
        int[][] mat = matrixInput("A");
        matrixShow(mat, "Original Matrix");
        int[][] transp = transpose(mat);
        matrixShow(transp, "Transposed Matrix");
    }
}