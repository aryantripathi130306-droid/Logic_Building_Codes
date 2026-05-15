public class seriessum {
    public static void main(String[] args){
        int n=5;//1+11+111+1111+11111
        int sum=0;
        int term=0;
        for(int i=1;i<=n;i++){
            term = term * 10 + 1;
            sum += term;
        }
        System.out.println("Sum of series: " + sum);
    }
}
