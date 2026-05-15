class largestdigit{
    public static void main(String[] args){
        int num=28967;
        int largest=0;
        while(num!=0){
            int rem=num%10;
            if(rem>largest){
                largest =rem;
            }
            num /= 10;
        }
        System.out.println("Largest digit: " + largest); 
    }
}
