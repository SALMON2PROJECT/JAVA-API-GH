package dkproparent.algorithm;

import java.security.MessageDigest;

/**
 * Created by Aprin on 11/20/2018.
 */
public class HashText {
public String textHasher(String text){
    try {

        MessageDigest md=MessageDigest.getInstance("SHA-256");
        md.update(text.getBytes());
        byte byteData[]=md.digest();
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<byteData.length;i++){
            sb.append(Integer.toString((byteData[i]&0xff)+0x100,16).substring(1));}
        return sb.toString();

    }catch (Exception e){
        System.out.println("SHA has an Exception");
        e.printStackTrace();

    }
    return null;

}
}
