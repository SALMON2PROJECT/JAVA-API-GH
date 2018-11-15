package dkproparent.algorithm;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class PdfContentExtractor {

    // TODO: When you have your own Premium account credentials, put them down here:
    private static final String CLIENT_ID = "FREE_TRIAL_ACCOUNT";
    private static final String CLIENT_SECRET = "PUBLIC_SECRET";
    private static final String ENDPOINT = "https://api.whatsmate.net/v1/pdf/extract?url=";

    /**
     * Entry Point
     */
    public  String extractText(String pdfUrl) throws Exception {
        URL url = new URL(ENDPOINT + pdfUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setDoOutput(true);
        conn.setRequestMethod("GET");
        conn.setRequestProperty("X-WM-CLIENT-ID", CLIENT_ID);
        conn.setRequestProperty("X-WM-CLIENT-SECRET", CLIENT_SECRET);
        int statusCode = conn.getResponseCode();
        System.out.println("Status Code: " + statusCode);
        InputStream is = null;
        if (statusCode == 200) {
            is = conn.getInputStream();
            System.out.println("PDF text is shown below");
            System.out.println("=======================");
        } else {
            is = conn.getErrorStream();
            System.err.println("Something is wrong:");
        }
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        int ascii=br.read();
        String content=" ";
        while (ascii!=-1){
            content+=(char)ascii;
            ascii=br.read();
        }

        System.out.println(content);
//        String output;
//        StringBuilder content=new StringBuilder();
//        while ((output = br.readLine()) != null) {
//            System.out.println(output);
//        }
        conn.disconnect();
        return content;

    }
}