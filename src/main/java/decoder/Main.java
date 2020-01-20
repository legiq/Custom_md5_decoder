package decoder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Md5Decoder decoder = new Md5Decoder();
        try {
            decoder.decode();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
