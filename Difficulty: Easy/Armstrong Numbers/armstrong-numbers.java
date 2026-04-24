// User function Template for Java
class Solution {
    static boolean armstrongNumber(int n) {
        // code here
        int num=n;
        int count =0;
        int temp=n;
        while(temp>0){
            count++;
            temp=temp/10;
        }
        int sum=0;
        temp=n;
        while(temp>0){
            int rem=temp%10;
            int p=1;
            for(int i=0;i<count;i++){
                p=p*rem;
            }
            sum=sum+p;
            temp=temp/10;
        }
        return sum == num;
    }
}