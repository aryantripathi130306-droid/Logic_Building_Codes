class student{
    String name;
    int age;
}
public class studentclass {
    public static void main(String[] args){
        student s1=new student();
        s1.name="John";
        s1.age=20;
        System.out.println("Name: "+s1.name);
        System.out.println("Age: "+s1.age);
    }
}
