package opencalais;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Remote;


public interface OpenCalais extends Remote {

     String getTag(String text) throws Exception;
}