public class palindrome {
    public static void main(String[] args){
        int num=121;
        int rev=0;
        int temp=num;
        while(num>0){
            int rem=num%10;
            rev=rev*10+rem;
            num=num/10;
        }
        if(temp==rev){
            System.out.println(temp+" is a palindrome number");
        }
        else{
            System.out.println(temp+" is not a palindrome number");
        }
    }
}
