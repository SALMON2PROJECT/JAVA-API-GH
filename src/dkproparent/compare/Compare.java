package dkproparent.compare;



import java.rmi.Remote;


public interface Compare  extends Remote {
    public double compareMethod(String[] token1, String[] tokens2) throws Exception;
}
