import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class test {
    static StringBuilder sb;
    static boolean isCheck = true;
    static String[] args;
     public static void main(String[] args) throws Exception {
        test.args = args;
        sb = new StringBuilder();

      Scanner sc = new Scanner(System.in);
       System.out.println("Введите режим 1 или 2");
      int numb = sc.nextInt();
        sc.close();
      if (numb ==1){
         System.out.println("Для завершения работы введите \"end\"");
          BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String text = br.readLine();
            if(text.equals("end")){br.close();break;}
            sb.append(text);
            run();
            }
        }
      if (numb ==2){
            for (int j = 0; j < 1000&&isCheck; j++) {
            createSb(20, 100);
            run();
            }
        }
      sc.close();
    }

    public static void readConsole(){
        Scanner sc = new Scanner(System.in);
          sb.append(sc.nextLine());
    }
    
    public static void createSb(int sizeOfList,int sizeOfValue, boolean sign){
        sb = new StringBuilder();
        for (int i = 0; i < sizeOfList; i++) {
        int b = sign? (int)(Math.random()*10)>5? 1:-1:1;
            sb.append((int) (Math.random() * sizeOfValue)*b).append('\n');

        }
    }
    public static void createSb(int sizeOfList,int sizeOfValue){
        createSb(sizeOfList,sizeOfValue,false);
    }
    public static void run() throws Exception {

            newClass.substitutionOutAndIn(sb.toString());
            Solution.main(args);
            String text = newClass.returnText();

            newClass.substitutionOutAndIn(sb.toString());
            TrueSolution.main(args);
            String text1 = newClass.returnText();

            theCheck(text, text1);
    }
    public static void theCheck(String a,String b){
        a = a.trim();
        b = b.trim();
        if(a.equals(b)){
          /*  System.out.println("все верно");
            System.out.printf("%s\n<-вывод первый\n%s<-вывод второй\n поток ввода-> %s"
            ,a,b, sb.toString().replaceAll("\n",", "));*/
        }else {
            System.out.println("Ошибка");
            System.out.printf("%s<-вывод первый\n%s<-вывод второй(мой)\n поток ввода-> %s"
            ,a,b, sb.toString().replaceAll("\n",", "));
            System.out.println();
            System.out.println();
            isCheck = false;

        }
    }

}

