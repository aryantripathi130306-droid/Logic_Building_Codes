public class Search_Element {
    public static void main(String[] args) {
        int arr[]={10,20,30,40,50};
        int element=30;
        boolean found=false;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==element){
                found=true;
                break;
            }
        }
        if(found){
            System.out.println("Element found in the array.");
        }else{
            System.out.println("Element not found in the array.");
        }
    }
    
}
