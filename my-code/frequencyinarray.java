public class frequencyinarray {
    public static void main(String[] args){
        int[] arr={1,2,2,3,3,3,4,4,4,4};
        int[] freq = new int[5];
        for(int i=0;i<arr.length;i++){
            freq[arr[i]]++;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]>0){
                System.out.println("Element: " + i + ", Frequency: " + freq[i]);
            }
        }
    }
}
