public class sumseries {
    public static void main(String[] args){
        int n=10;// 1-2+3-4+5-6+7-8+9-10
        int sum=0;
        int sub=0;
        for(int i=1;i<=n;i++){
            if(i%2==0){
                sub=sub-i;
            }
            else{
                sum=sum+i;
            }
        }
        System.out.println(sum+sub);  
    }
}
