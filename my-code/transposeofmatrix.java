public class transposeofmatrix {
    public static void main(String[] args){
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[][] transpose = new int[cols][rows];
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                transpose[j][i] = matrix[i][j];
            }
        }
        
        System.out.println("Original Matrix:");
        printMatrix(matrix);
        
        System.out.println("Transposed Matrix:");
        printMatrix(transpose);
    }
    
    public static void printMatrix(int[][] mat){
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
