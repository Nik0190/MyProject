import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Locale;

public class newClass {
    static PrintStream consoleStream = System.out;
    static ByteArrayOutputStream outputStream;

    public static void substitutionOut(){
        outputStream  = new ByteArrayOutputStream();
        PrintStream myStream = new PrintStream(outputStream);
        System.setOut(myStream);
    }

    /**
     *
     * @return возвращает поток Out  и выводит тест
     */
    public static String returnText(){
        System.setOut(consoleStream);
        return outputStream.toString();
    }

    public static void substitutionIn(String text){
        InputStream is = new ByteArrayInputStream(text.getBytes());
        System.setIn(is);
    }
    public static void substitutionOutAndIn(String text){
        substitutionOut();
        substitutionIn(text);
    }
}
