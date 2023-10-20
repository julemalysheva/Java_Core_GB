package lesson2.task01;

public class Main {
    public static void main(String[] args) {
        String originalText = "Hello, World!";
        int key = 3;
        boolean encrypt = true;

        System.out.println("Original Text: " + originalText);

        String encryptedText = CaesarCipher.caesarCipher(originalText, key, encrypt);
        System.out.println("Encrypted Text: " + encryptedText);

        String decryptedText = CaesarCipher.caesarCipher(encryptedText, key, !encrypt);
        System.out.println("Decrypted Text: " + decryptedText);
    }
}
