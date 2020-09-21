/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagetotextconvertor;

import com.asprise.ocr.Ocr;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Admin
 */
public class ImgToText {

    public void ImgToTextConvert(String path) throws IOException {
        Ocr.setUp(); // one time setup
        Ocr ocr = new Ocr(); // create a new OCR engine
        ocr.startEngine("eng", Ocr.SPEED_FASTEST); // English
        String s = ocr.recognize(new File[]{new File(path)},
                Ocr.RECOGNIZE_TYPE_ALL, Ocr.OUTPUT_FORMAT_PLAINTEXT); // PLAINTEXT | XML | PDF | RTF
        System.out.print("Result: " + s);
        File file = new File("Text.txt");
        boolean result;
        try {
            result = file.createNewFile();  //creates a new file  
            FileOutputStream fos = new FileOutputStream(file);
            if (result) // test if successfully created a new file  
            {
                System.out.println("file created " + file.getCanonicalPath());
                byte[] b = s.getBytes();
                fos.write(b);
            } else {
                System.out.println("File already exist at location: " + file.getCanonicalPath());
                byte[] b = s.getBytes();
                fos.write(b);
            }
        } catch (IOException e) {
            e.printStackTrace();    //prints exception if any  
        }
        ocr.stopEngine();
    }
}
