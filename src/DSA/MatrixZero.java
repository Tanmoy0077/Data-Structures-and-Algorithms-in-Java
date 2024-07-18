package DSA;

public class MatrixZero {
    public static void main(String[] args) {
        int n=3, m=3;
        boolean flag = false;
        int[][] arr = {{1,1,1}, {1,0,1},{1,1,1}};
        
        // Check if the 1st row contains any 0
        for(int j=0;j<m;j++){
            if(arr[0][j] == 0){
                flag = true;
                break;
            }
        }
        // Mark the rows and columns 
        for (int i=1;i<n;i++) {
            for(int j=0;j<m;j++){
                if(arr[i][j] == 0){
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }
        // Set all the marked rows as 0 except the 1st
        for(int i=1;i<n;i++){
            if(arr[i][0] == 0){
                for(int j=1;j<m;j++){
                    arr[i][j] = 0;
                }
            }
        }
        // Set all the marked columns as 0
        for(int j=0;j<m;j++){
            if(arr[0][j] == 0){
                for(int i=1;i<n;i++)
                    arr[i][j] = 0;
            }
        }
        // Set 0 in the 1st row
        if(flag){
            for(int j=0;j<m;j++){
                arr[0][j] = 0;
            }
        }

        for (int i=0;i<n;i++) {
            for(int j=0;j<m;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
        
    }
}
