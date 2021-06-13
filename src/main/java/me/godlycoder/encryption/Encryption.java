package me.godlycoder.encryption;

import lombok.Setter;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

public class Encryption {
    private static final String ALGORITHM = "AES";
    @Setter
    private static byte[] keyValue = "****************".getBytes();

    public static String encrypt(String data) {
        String value = "";
        try {
            Key key = generateKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] encVal = cipher.doFinal(data.getBytes());
            value = new String(Base64.getEncoder().encode(encVal));
        }catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }

    public static String decrypt(String data) {
        String value = "";
        try {
            Key key = generateKey();
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] decryptedValue = cipher.doFinal(Base64.getDecoder().decode(data));
            value = new String(decryptedValue);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return value;
    }
    private static Key generateKey() {
        return new SecretKeySpec(keyValue, ALGORITHM);
    }
}
