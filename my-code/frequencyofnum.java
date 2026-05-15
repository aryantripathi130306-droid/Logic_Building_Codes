public class frequencyofnum {
    public static void main(String[] args){
        int num=1223334444;
        int[] freq = new int[10];
        while(num!=0){
            int rem=num%10;
            freq[rem]++;
            num /= 10;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                System.out.println("Digit: " + i + ", Frequency: " + freq[i]);
            }
        }
    }
}
