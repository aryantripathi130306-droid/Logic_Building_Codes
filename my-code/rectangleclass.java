class rectangle{
    int length;
    int breadth;

    int area(){
        return length * breadth;
    }
}

public class rectangleclass{
    public static void main(String[] args){
        rectangle rect = new rectangle();
        rect.length = 5;
        rect.breadth = 3;
        System.out.println("Area: " + rect.area());
    }
}
