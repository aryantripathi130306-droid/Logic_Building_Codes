public class Numbertypeanalyzer {
    public static void main(String[] args){
        int num= 10;
        if(num%2==0 && num%3==0){
            System.out.println("Special number");
        }
        if(num%2==0){
            System.out.println("Even number");
        }
        if(num%3==0){
            System.out.println("Three");
        }
        else{
            System.out.println("Normal number");
        }
    }
    
}
