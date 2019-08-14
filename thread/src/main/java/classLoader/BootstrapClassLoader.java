package classLoader;

import org.apache.catalina.core.ApplicationContext;

/**
 * @author issuser
 *
 */
public class BootstrapClassLoader {
    /**
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("bootstarp:" +String.class.getClassLoader());
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(ApplicationContext.class.getClassLoader());
    }

}
