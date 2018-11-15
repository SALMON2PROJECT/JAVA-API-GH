package dkproparent;

import dkproparent.algorithm.PdfContentExtractor;
import dkproparent.algorithm.WordNGramJaccardMeasure;
import dkpro.similarity.algorithms.api.TextSimilarityMeasure;
import opencalais.OpenCalaisImpl;

import java.rmi.server.UnicastRemoteObject;

/**
 * Created by pooya_hy on 11/1/2018.
 */
public class DKProparentImpl extends UnicastRemoteObject implements DKProparent{

    public DKProparentImpl() throws Exception{}
    public String getText(String url) throws Exception {
        PdfContentExtractor pdfx = new PdfContentExtractor() ;
        OpenCalaisImpl openCalaisImpl=new OpenCalaisImpl();

      return openCalaisImpl.getTag(pdfx.extractText(url));
        //        String url = "http://www.better-fundraising-ideas.com/support-files/the-best-snail-jokes.pdf";
/*
        TextSimilarityMeasure measure = new WordNGramJaccardMeasure(1);    // Use word trigrams

        String[] tokens1 = "Petrinets Process mining ".split("");
        String[] tokens2 = "computation , mathematical modeling languages".split("");

        double score = measure.getSimilarity(tokens1, tokens2);
        System.out.println("Similarity: " + "%" + (score * 100));
        return "Similarity: " + "%" + (score * 100);*/
    }
}
