package opencalais;


import java.rmi.Remote;


public interface OpenCalais extends Remote {

     String getTag(String text) throws Exception;
}