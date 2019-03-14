package opencalais;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.server.UnicastRemoteObject;

public class OpenCalaisImpl extends UnicastRemoteObject implements OpenCalais {

    public OpenCalaisImpl() throws Exception {
    }

    public String getTag(String text) throws Exception {
        try {


            URL url = new URL("https://api.thomsonreuters.com/permid/calais");
            URLConnection connection = url.openConnection();
            HttpURLConnection http = (HttpURLConnection) connection;
            http.setDoOutput(true);
            http.setRequestMethod("POST");
//            http.setRequestProperty("x-ag-access-token", "6PMN2W0VO5ytiAHGFimNXVHhwZRDnIgI");
            http.setRequestProperty("x-ag-access-token", "n8QX26DfE57XvevlyqV9Cq01qccZPVAI");
            http.setRequestProperty("Accept", "application/json");
            http.setRequestProperty("outputFormat", "application/json");
            http.setRequestProperty("Content-Type", "text/raw");

            DataOutputStream wr = new DataOutputStream(connection.getOutputStream());

            JSONObject jsonObject=new JSONObject(text);
            String txt=jsonObject.getString("txt");


            wr.writeBytes(txt);

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            StringBuilder content = new StringBuilder();

            while ((line = in.readLine()) != null) {
                content.append(line);
                content.append(System.lineSeparator());
            }


            return content.toString();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("====================================");
            System.out.println("calais has an Exception");
            System.out.println("====================================");
            return null;
        }
    }

}
