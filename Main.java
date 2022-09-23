import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.v2.DbxClientV2;
import com.dropbox.core.v2.files.FileMetadata;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Main {
    public static void main (String[] args) throws AWTException {
        String ACCESS_TOKEN = "nMO7T3lNWZYAAAAAAAAAAcknTtNBDFIKECOSjbVcJcmbtQLDXptdYx6cGvuHe5qr";

        DbxRequestConfig config = DbxRequestConfig.newBuilder("dropbox/java-tutorial").build();
        DbxClientV2 client = new DbxClientV2(config, ACCESS_TOKEN);

        try{
        InputStream in =  new  FileInputStream ( "C:/Users/Fermer/Desktop/picture.png " );
        client.files().uploadBuilder ( "/hieraechy.png" )
                .uploadAndFinish (in);
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        for(int i =0;i<5;i++)
        {
            BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));

            MyThread thread = new MyThread(client, image);
            thread.start();


            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }


    }
}
