class circle{
    int radius;
    int area(){
        return (int)(3.14*radius*radius);
    }
}

public class circleclass{
    public static void main(String[] args) {
        circle ar = new circle();
        ar.radius = 5;
        System.out.println("Area: " + ar.area());
    }
}
