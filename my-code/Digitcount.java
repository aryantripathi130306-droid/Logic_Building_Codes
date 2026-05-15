class Digitcount {
    public static void main(String[] args){
        int num=1212;
        int count1=0;
        int count2=0;
        while(num>0){
            int rem=num%10;
            if(rem%2==0){
                count1++;
            }
            else{
                count2++;
            }
            num=num/10;
        }
        System.out.println("Even digit count: "+count1);
        System.out.println("Odd digit count: "+count2);

    }
}