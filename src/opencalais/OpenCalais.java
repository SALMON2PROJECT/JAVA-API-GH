package opencalais;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.rmi.Remote;

/**
 * Created by pooya_hy on 11/1/2018.
 */
public interface OpenCalais extends Remote {

    public String getTag(String text) throws Exception;
}
