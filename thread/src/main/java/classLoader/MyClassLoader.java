package classLoader;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MyClassLoader extends ClassLoader {
    //定义默认的class 存放路径
    private final static Path DEFAULT_CLASS_DIR = Paths.get("D:","classloader1");
    
    private final Path classDir;
    public MyClassLoader() {
        super();
        this.classDir = DEFAULT_CLASS_DIR;
    }
    MyClassLoader(String classDir){
        super();
        this.classDir =Paths.get(classDir);
    }
    MyClassLoader(String classDir,ClassLoader parent){
        super(parent);
        this.classDir =Paths.get(classDir);
    }
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        // TODO Auto-generated method stub
        byte[] classBytes = this.readClassBytes(name);
        if(null == classBytes || classBytes.length == 0) {
            throw new ClassNotFoundException("can not load the class"+name);
        }
        return this.defineClass(name,classBytes, 0,classBytes.length);
    }
    private byte[] readClassBytes(String name) throws ClassNotFoundException {
        // TODO Auto-generated method stub
        String classPath = name.replace(".", "/");
        Path classFullPath = classDir.resolve(Paths.get(classPath+".class"));
        if(!classFullPath.toFile().exists()) {
            throw new ClassNotFoundException("The class"+name+"not found.");
        }
        try(ByteArrayOutputStream baos = new ByteArrayOutputStream()){
            Files.copy(classFullPath, baos);
            return baos.toByteArray();
        }catch(IOException e){
            throw new ClassNotFoundException("load the class"+name+"occurerroe.",e);
        }
         
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return  "My classLoader";
    }
}
