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
                        String result=text.substring(0,3000);
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
            // font exteption https://par.nsf.gov/servlets/purl/10060314
    }
//    public static void main(String args[]) throws Exception {
//
//        PdfContentExtractor pdfex = new PdfContentExtractor();
//        //String string1 = pdfex.extractText( "https://par.nsf.gov/servlets/purl/10060314" );
//        String string1 = pdfex.extractText( "https://salmonpdfshare.files.wordpress.com/2019/01/4329-articletext-23388-1-10-20161219.pdf" );
//        System.out.println(string1);
//
//    }
}
