package dkproparent.compare;

import dkpro.similarity.algorithms.api.SimilarityException;
import dkpro.similarity.algorithms.api.TextSimilarityMeasure;
//import dkproparent.algorithm.WordNGramJaccardMeasure;
//import org.dkpro.similarity.algorithms.lexical.string.CosineSimilarity;
//import dkpro.similarity.algorithms.lexical.string.CosineSimilarity;
import org.dkpro.similarity.algorithms.lexical.string.CosineSimilarity;
//import dkpro.similarity.algorithms.lexical.string.CosineSimilarity;
import java.rmi.server.UnicastRemoteObject;


public class CompareImpl extends UnicastRemoteObject implements Compare{
    public CompareImpl()throws Exception{}
    public double compareMethod(String[] token1, String[] tokens2) throws SimilarityException, org.dkpro.similarity.algorithms.api.SimilarityException {
        CosineSimilarity measure =  new CosineSimilarity();
        //TextSimilarityMeasure measure = new WordNGramJaccardMeasure(1);
        //TextSimilarityMeasure measure = new WordNGramJaccardMeasure(1);
       /* String str=token1.toString().replaceAll("\\n"," ");
        System.out.println(str);*/
        double score = measure.getSimilarity(token1, tokens2);
        /*System.out.println(token1);*/
        score=score*100;
        return score;
    }
    /*public static void main(String[] args) throws Exception {
        CompareImpl compare=new CompareImpl();
        double dl=compare.compareMethod("Algorithm configuration methods optimize the performance of a parameterized heuristic algorithm on a given distribution of problem instances Recent work introduced an algorithm configuration procedure (“Structured Procrastination”) that provably achieves near optimal performance with high probability and with nearly minimal runtime in the worst case. It also offers an anytime property: it keeps tightening its optimality guarantees the longer it is run. Unfortunately, Structured Procrastination is not adaptive to characteristics of the parameterized algorithm: it treats every inpu like the worst case. Follow-up work (“Leaps andBounds”) achieves adaptivity but trades away the anytime property. This paper introduces a new algorithm configuration method, “Structured Procrastination with Confidence”, that preserves the near-optimality and anytime properties of Structured Procrastination while adding adaptivity. In particular, the new algorithm will perform dramatically faster in settings where many algorithm configurations perform poorly; we show empirically that such settings arise frequently in practice.".split(""),"In a resource-constrained, contested environment, computing resources need to be aware of possible size, weight and power (SWaP) restrictions. SWaP-aware computational efficiency depends upon optimization of computational resources and intelligent time versus efficiency tradeoffs in decision making. In this paper we address the complexity of various optimization strategies related to low SWaP computing. Due to these restrictions, only small subset of less complicated and fast computable algorithms can be used for tactical, adaptive computing Keywords: Optimization, Complexity, Algorithms, Tactical Computing Platforms".split(""));
        //double dl=compare.compareMethod("Semantic Web Information science Knowledge engineering Artificial intelligence Knowledge representation Technical communication Ontology ".split(""),"Semantic Web Information science Knowledge representation Technical communication Knowledge engineering Ontology Annotation Web Ontology Language Upper ontology ".split(""));
        //double dl=compare.compareMethod(("sausage hotdog").split(" "),("hotdog sausage").split(" "));
        System.out.println(dl);
    }
*/

}




