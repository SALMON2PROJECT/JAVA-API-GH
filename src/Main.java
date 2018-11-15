

import dkproparent.DKProparentImpl;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class Main {
    public static void main(String args[]) throws Exception {

        LocateRegistry.createRegistry(1099);
        DKProparentImpl dkProparentImpl=new DKProparentImpl();
        Naming.rebind("dkproparent",dkProparentImpl);

        // PdfContentExtractor.extractText(url);
    }
}


