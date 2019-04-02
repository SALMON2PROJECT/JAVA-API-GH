

import dkproparent.DKProparentImpl;

import dkproparent.compare.CompareImpl;
import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;


public class Main {
    public static void main(String args[]) throws Exception {

        LocateRegistry.createRegistry(1099);
        DKProparentImpl dkProparentImpl=new DKProparentImpl();
        CompareImpl compare=new CompareImpl();



        //String[] tokens1 = "Semantic Web annotation brings two benefits, improved information retrieval which needed also for recommender systems and enhanced interoperability. Information retrieval is enhanced by the ability to perform searches, which exploit the ontology to make inferences about data from multiple resources. Semantic annotation recognizes the concepts and relationships among concepts in target. Semantic annotation play role in (KM) knowledge management, share and organize recourses it helps search engines to filter many ambiguities of homonyms terms and that can be happen in the non-semantical query. e.g. Polish can be the name of the country or as a verb means shining. ".split("");
        //String[] tokens2 = " An intelligent, document-centric KM process of the type we propose must handle three classes of data: ontologies, documents and annotations. As illustrated in Figure. 4, these need to be supported by new kinds of KM tools. [5] Semantic search tools are required to connect and utilize the information in annotations and documents. Ontology support tools must assist users in maintaining and developing knowledge models to meet changing requirements. Lastly, tools are needed to facilitate the annotation of materials, which can detect changes of the ontologies to existing annotations. Annotation tools will need to give feedback to the ontology maintenance process when required. [5]. Above centric KM in Figure 4. express seven requirements for semantic annotation tool according to ".split("");


        Naming.rebind("compare",compare);
        Naming.rebind("dkproparent",dkProparentImpl);




    }
}


