package Demo.com.uab;


public class EncryptionTester {

    public static void main(String[] args) throws Exception {
    	String encryptedFilePath = "C:\\Users\\saima\\eclipse-workspace\\com.uab\\src\\main\\java\\Demo\\com\\uab\\message.txt";
    	String decryptedFilePath = "C:\\Users\\saima\\eclipse-workspace\\com.uab\\src\\main\\java\\Demo\\com\\uab\\decrypted.txt";
        String inputFilePath = "C:\\Users\\saima\\eclipse-workspace\\com.uab\\src\\main\\java\\Demo\\com\\uab\\encryptMe.txt";
        String outputFilePath = "C:\\Users\\saima\\eclipse-workspace\\com.uab\\src\\main\\java\\Demo\\com\\uab\\newEncrypted.txt";

        int shift = 1; // Says how much you would like to shift

        Encrypter enc = new Encrypter(shift);

        enc.encrypt(inputFilePath, outputFilePath);
        enc.decrypt(encryptedFilePath, decryptedFilePath);

    }


}
