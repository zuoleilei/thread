package threadClassLoader;

public class MainThreadClassLoader {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getContextClassLoader());
    }

}
