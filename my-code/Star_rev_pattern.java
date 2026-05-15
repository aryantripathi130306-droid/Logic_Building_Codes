public class Star_rev_pattern {
    public static void main(String[] args){
        int n=5;
        for(int i=1;i<=n;i++){
            for(int j=0;j<=n;j++){
              if(i+j<=n){  
                System.out.print("*");
              }
            }
            System.out.println();
        }
    }
}

