public class diagonalsuminarray {
    public static void main(String[] args){
        int[][] arr={
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        int primarySum=0;
        int secondarySum=0;
        for(int i=0;i<arr.length;i++){
            primarySum += arr[i][i];
            secondarySum += arr[i][arr.length-1-i];
        }
        System.out.println("Primary diagonal sum: " + primarySum);
        System.out.println("Secondary diagonal sum: " + secondarySum);
    }
}
