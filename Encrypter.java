package Demo.com.uab;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Encrypter {

    private int shift;
    private String encrypted;

    /**
     * Default Constructor
     */
    public Encrypter() {
        this.shift = 1;
        this.encrypted = "";
    }

    /**
     * Non-default Constructor
     * @param s - custom shift amount
     */
    public Encrypter(int s) {
        this.shift = s;
        this.encrypted = "";
    }

    /**
     * Encrypts the content of a file and writes the result to another file.
     *
     * @param inputFilePath      the path to the file containing the text to be encrypted
     * @param encryptedFilePath the path to the file where the encrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void encrypt(String inputFilePath, String encryptedFilePath) throws Exception {
        //TODO: Call the read method, encrypt the file contents, and then write to new file
    	String plain = readFile(inputFilePath);
        String cipher = caesarCipher(plain, shift);
        writeFile(cipher, encryptedFilePath);
    }

    /**
     * Decrypts the content of an encrypted file and writes the result to another file.
     *
     * @param messageFilePath    the path to the file containing the encrypted text
     * @param decryptedFilePath the path to the file where the decrypted text will be written
     * @throws Exception if an error occurs while reading or writing the files
     */
    public void decrypt(String messageFilePath, String decryptedFilePath) throws Exception {
        //TODO: Call the read method, decrypt the file contents, and then write to new file
    	String cipher = readFile(messageFilePath);
        String plain = caesarCipher(cipher, -shift);
        writeFile(plain, decryptedFilePath);
    }

    /**
     * Reads the content of a file and returns it as a string.
     *
     * @param filePath the path to the file to be read
     * @return the content of the file as a string
     * @throws Exception if an error occurs while reading the file
     */
    private static String readFile(String filePath) throws Exception {
    	
        String message = "";
        try (Scanner scanner = new Scanner(new File(filePath))) {
            while (scanner.hasNextLine()) {
                message += scanner.nextLine() + "\n";
            }
        }
        
        return message.trim();
    }

    /**
     * Writes data to a file.
     *
     * @param data     the data to be written to the file
     * @param filePath the path to the file where the data will be written
     */
    private static void writeFile(String data, String filePath) {
    	
        try (FileOutputStream fileStream = new FileOutputStream(filePath);
             PrintWriter outFS = new PrintWriter(fileStream)) {
            outFS.print(data);
        } 
        catch (IOException e) {
            System.err.println("Error writing to file");
        }
        
    }

    
    private static String caesarCipher(String text, int shift) {
    	
        String res = "";
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char b = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char) ((c - b + shift + 26) % 26 + b);
            }
            res = res+c;
        }
        return res;
    }


    /**
     * Returns a string representation of the encrypted text.
     *
     * @return the encrypted text
     */
    @Override
    public String toString() {
        return encrypted;
    }
}
