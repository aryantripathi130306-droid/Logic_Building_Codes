public class Count_even_number {
    public static void main(String[] args) {
        int arr[]={99,89,79,69,59,49,39,29,19,9};
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]%2==0){
                count++;
            }
        }
        System.out.println("The count of even numbers is: "+count);
    }
}
