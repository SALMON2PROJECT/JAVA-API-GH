package dkproparent.algorithm;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.text.PDFTextStripper;
import org.json.JSONObject;

import java.io.*;

import java.net.ConnectException;
import java.net.HttpURLConnection;
import java.net.URL;

public class PdfContentExtractor {


    public String extractText(String pdfUrl) {
        try {
            URL url = new URL(pdfUrl);
            try {
                HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
                try {
                    InputStream is = urlConnection.getInputStream();
                    try {
                        PDDocument document = PDDocument.load(is);
                        PDDocumentInformation info = document.getDocumentInformation();
                        /**
                         *  Text
                         **/
                        PDFTextStripper pdfStripper = new PDFTextStripper();

                        /**
                         *  Title from manual metadata
                         **/
                        String title = info.getTitle();
                       // System.out.println(title);
                        System.out.println("* * * * * * * * * * * *\n");
                        /**
                         *  Key from manual metadata
                         **/
                        String keyWords = info.getKeywords();
                        System.out.println(keyWords);
                        System.out.println("* * * * * * * * * * * *\n");
                        /**
                         *  Text
                         **/
                        String text = pdfStripper.getText(document);
                        String filteredText = text.substring(0, 6000);
                        System.out.println("* * * * * * * * * * * *\n");
                        JSONObject jsonObject=new JSONObject();
                        /*jsonObject.put("words",keyWords);
                        jsonObject.put("title",title);*/
                        jsonObject.put("txt",filteredText+keyWords+title);
                        System.out.println("* * * * * * * * * * * *\n");
                        System.out.println(filteredText);
                        urlConnection.disconnect();
                        is.close();// Buffer will be disconnect again
                        urlConnection.disconnect();// avoids redundancy in RAM
                        document.close();
                        return jsonObject.toString();
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
        } catch (IOException e) {
            System.out.println("IOException caught");
            return null;
        }
    }
}
