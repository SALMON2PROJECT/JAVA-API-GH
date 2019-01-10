package dkproparent;

import java.rmi.Remote;


public interface DKProparent extends Remote  {
     String getText(String url)throws Exception;

}