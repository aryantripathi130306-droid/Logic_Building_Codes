public class Secondlargest {
    public static void main(String[] args){
        int a=10,b=20,c=30;
        if((a>b && a<c) || (a>c && a<b)){
            System.out.println("The second largest number is: "+a);
        }
        else if((b>a && b<c) || (b>c && b<a)){
            System.out.println("The second largest number is: "+b);
        }
        else{
            System.out.println("The second largest number is: "+c);
        }
    }
}
