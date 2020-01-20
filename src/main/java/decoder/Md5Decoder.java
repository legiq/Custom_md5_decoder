package decoder;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Md5Decoder {

    public void decode() throws IOException {

        String checksum = "b34c070177ecb7ab98912a84962885a3"; // target hash code
        /**
         * encoding format: md5([login][password][salt])
         * login = admin
         * salt = supersalt
         * main target is finding which one of 1000000 passwords is encoded
         */
        String s1 = "admin";
        String s2 = "supersalt";

        File file = new File("src/test/resources/10-million-password-list-top-1000000.txt");
        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);
        String line = reader.readLine();
        String currentPass = s1 + line + s2;

        while (line != null) {
            String md5Hex = DigestUtils.md5Hex(currentPass);
            if (checksum.equalsIgnoreCase(md5Hex)) {
                System.out.println("**************"+line+"**************");
                reader.close();
                break;
            }
            line = reader.readLine();
            currentPass = s1 + line + s2;
        }
        reader.close();
    }
}
