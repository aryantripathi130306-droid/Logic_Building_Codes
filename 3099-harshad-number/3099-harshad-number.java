class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int original =x;
        int sum=0;
        while (x>0){
            sum=sum+x%10;
            x=x/10;
        }
        if(original%sum==0){
            return sum;
        }else{
            return -1;
        }
    }
    public static void main(String[] args){
        Solution obj = new Solution();
        int x= 18;
        System.out.println(obj.sumOfTheDigitsOfHarshadNumber(x));
        int y=19;
        System.out.println(obj.sumOfTheDigitsOfHarshadNumber(y));
    }
}