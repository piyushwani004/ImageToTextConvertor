/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package imagetotextconvertor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

/**
 *
 * @author Admin
 */
public class ImgToPDF {

    public void imgToPdf(String path) {
        try {
            File pdffile = new File(path);
            PDDocument docu = PDDocument.load(pdffile);
            PDFTextStripper pdfdocu = new PDFTextStripper();
            String text = pdfdocu.getText(docu);
            File file = new File("PdfToText.txt");
            boolean result;
            try {
                result = file.createNewFile();  //creates a new file  
                FileOutputStream fos = new FileOutputStream(file);
                if (result) // test if successfully created a new file  
                {
                    System.out.println("file created " + file.getCanonicalPath());
                    byte[] b = text.getBytes();
                    fos.write(b);
                } else {
                    System.out.println("File already exist at location: " + file.getCanonicalPath());
                    byte[] b = text.getBytes();
                    fos.write(b);
                }
            } catch (IOException e) {
                //prints exception if any  
            }
        } catch (IOException e) {

        }
    }
}
