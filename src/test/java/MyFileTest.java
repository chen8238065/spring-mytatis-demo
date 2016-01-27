import org.junit.Test;

import java.io.File;

/**
 * Created by chen on 16-1-23.
 */
public class MyFileTest {
    @Test
    public void fileExist(){
        File file=new File("/home/chen/.m2/repository/mysql/mysql-connector-java/5.1.34/mysql-connector-java-5.1.347.jar");
        if(!file.exists()) {
            System.out.println("not Exist");
        }
        else{
            System.out.println("Exist");
        }
    }
}
