import com.dropbox.core.v2.DbxClientV2;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyThread extends Thread {

    private DbxClientV2 client;
    private BufferedImage image;

    public MyThread(DbxClientV2 client, BufferedImage image)
    {
        this.client = client;
        this.image = image;
    }

    @Override
    public void run() {
        try {
            //TODO: convert BufferedImage to InputStream
            // using ByteArrayInputStream and ByteArrayOutputStream
            ByteArrayOutputStream os = new ByteArrayOutputStream();
            ImageIO.write(image, "png", os);                          // Passing: ​(RenderedImage im, String formatName, OutputStream output)
            InputStream in =  new ByteArrayInputStream(os.toByteArray());
            //TODO: filename in format 20210209_201215.png
            SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd_HHmmss");
            Date date = new Date();
            String newDate = formatter.format(date);
            client.files().uploadBuilder("/"+newDate+".png")
                    .uploadAndFinish(in);
                    }
        catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
