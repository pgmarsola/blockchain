package SHA256.src.com.globalsoftwaresupport;

import java.security.MessageDigest;

public class SHA256Helper {
    
    public static String hash(String data){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(data.getBytes("UTF-8"));
            
            //precisamos transformar os bytes em hexadecimal
            StringBuffer hexadecimalString = new StringBuffer();

            for(int i=0; i<hash.length; ++i){
                String hexadecimal = Integer.toHexString(0xff & hash[i]);
                hexadecimalString.append(hexadecimal);
            }
            
            return hexadecimalString.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        
    }

}
