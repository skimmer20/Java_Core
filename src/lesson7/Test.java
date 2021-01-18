package lesson7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author yuriismac on 1/16/21.
 * @project Java_Core_tasks
 */
public class Test {
    public static void main(String[] args) throws IOException {
        File file = new File("test.txt");

        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            fileOutputStream.write("Hello Java!".getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        /*try {
            FileInputStream fileInputStream = new FileInputStream("test.txt");
            int read;
            byte[] buffer = new byte [1024];
            while ((read = fileInputStream.read()) != -1) {
                System.out.print((char) read);
            }
            *//*for (int i = 0; i < buffer.length; i++) {
                if (buffer[i] != 0){
                    System.out.print((char) buffer[i]);
                }
            }*//*
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }*/
        PrintWriter printWriter = new PrintWriter(new FileWriter("test.txt"));
        printWriter.println("Hello Jack");
        printWriter.println("Hello Monica");
        printWriter.println("How are you?");
        printWriter.close();

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
            String s;
            while ((s = bufferedReader.readLine()) != null){
                System.out.println(s);
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
}
