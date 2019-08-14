package test;

public class Test {
   
    public static int a=0;
    public static int b;
    public static Test test =new Test();
    public Test() {
        // TODO Auto-generated constructor stub
         a++;
         b++;
    }
    public static void main(String[] args) {
        System.out.println(a  +" and " + b);
    }

}
