package threadHook;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.PosixFilePermission;
import java.nio.file.attribute.PosixFilePermissions;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class PreventDuplicated {
    private final static String LOCK_PATH="D:\\";
    private final static String LOCK_FILE=".lock";
    private final static String PERMISSIONS="rw----------";
    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            System.out.println("the program received kill SIGNAL.");
            getLockFile().toFile().delete();
        } ));
        checkRunning();
        for(;;) {
            try {
                TimeUnit.MILLISECONDS.sleep(1);
                System.out.println("program is runing");
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
    private static Path getLockFile() {
        return Paths.get(LOCK_PATH,LOCK_FILE);
        
    }
    private static void checkRunning() throws IOException
    {
        Path path=getLockFile();
        if(path.toFile().exists()) 
            throw new RuntimeException("the progarm already running.");
           // Set<PosixFilePermission> perms =PosixFilePermissions.fromString(PERMISSIONS);
            Files.createFile(path);
        
    }

}
