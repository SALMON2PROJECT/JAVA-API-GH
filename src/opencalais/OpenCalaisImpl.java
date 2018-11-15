package opencalais;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.RemoteException;
import java.rmi.server.RMIClientSocketFactory;
import java.rmi.server.RMIServerSocketFactory;
import java.rmi.server.UnicastRemoteObject;

/**
 * Created by pooya_hy on 11/1/2018.
 */
public class OpenCalaisImpl extends UnicastRemoteObject implements OpenCalais {

    public OpenCalaisImpl() throws Exception{}

    public String getTag(String text) throws Exception {
        System.out.println(text);
        URL url = new URL("https://api.thomsonreuters.com/permid/calais");
        URLConnection connection = url.openConnection();
        HttpURLConnection http = (HttpURLConnection)connection;
        http.setDoOutput(true);
        http.setRequestMethod("POST");
        http.setRequestProperty("x-ag-access-token", "6PMN2W0VO5ytiAHGFimNXVHhwZRDnIgI");
        http.setRequestProperty("Accept", "application/json");
        http.setRequestProperty("outputFormat", "application/json");
        http.setRequestProperty("Content-Type", "text/raw");

        DataOutputStream wr = new DataOutputStream(connection.getOutputStream());
        wr.writeBytes(text);

        BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String line;
        StringBuilder content = new StringBuilder();

        while ((line = in.readLine()) != null) {
            content.append(line);
            content.append(System.lineSeparator());
        }

        System.out.println(content.toString());
    return content.toString();
    }
}
