class countnumdiv2 {
    public static void main(String[] args){
        int n=10;
        int count=0;
        for(int i=1; i<=n; i++){
            if(i%2==0 && i%3!=0){
                count++;
            }
        }
        System.out.println(count);
    }
}