package dkproparent;

import dkproparent.algorithm.HashText;
import dkproparent.algorithm.PdfContentExtractor;

import opencalais.OpenCalaisImpl;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.rmi.server.UnicastRemoteObject;


public class DKProparentImpl extends UnicastRemoteObject implements DKProparent {

    public DKProparentImpl() throws Exception {
    }

    public String getText(String url) throws Exception {

            PdfContentExtractor pdfx = new PdfContentExtractor();

            OpenCalaisImpl openCalaisImpl = new OpenCalaisImpl();
            String text = pdfx.extractText(url);
            HashText hashText = new HashText();
            String hashSHA = hashText.textHasher(text);
            if ( !openCalaisImpl.getTag(text).equals(null)){
            String tags = openCalaisImpl.getTag(text);
            JSONObject jsonObject = new JSONObject(tags);
            String docId = jsonObject.getJSONObject("doc").getJSONObject("info").getString("docId");
            JSONObject jsonTags = new JSONObject();
            String tagsName=" ";
           try {
               for (int i = 1; i < 11; i++) {
                   tagsName = jsonObject.getJSONObject(docId + "/SocialTag/" + i).getString("name");
                   jsonTags.put("tag" + i, tagsName);
               }
           }catch (JSONException e){
            System.out.println("tags ended");
        }
            jsonTags.put("hashkey", hashSHA);
            return jsonTags.toString();}
            else {
                return null;
            }


    }
}