package dkproparent.algorithm;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;


import java.io.*;

import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

public class PdfContentExtractor {
    public String extractText(String pdfUrl){
        try {


            URL url = new URL(pdfUrl);
            try {


                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {


                    InputStream is = urlConnection.getInputStream();




                    try {
                        PDDocument document = PDDocument.load(is);
                        PDFTextStripper pdfStripper = new PDFTextStripper();
                        String text = pdfStripper.getText(document);
                        String result=text.substring(0,2000);
                        System.out.println(result);
                        urlConnection.disconnect();
                        is.close();
                        urlConnection.disconnect();
                        document.close();
                        return result;


                    } catch (Exception e) {
                        System.out.println("PDFDocument or PDFTextStriper has exception");
                        return null;
                    }
                } catch (ConnectException e) {

                    System.out.println("Connection faild or null value");
                    return null;
                }
            } catch (NullPointerException e) {
                System.out.println("NullPointerException caught");
                return null;
            }
        }catch (IOException e){
            System.out.println("IOException caught");
            return null;
        }

    }

}
