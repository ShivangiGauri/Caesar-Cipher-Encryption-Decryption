import java.util.Scanner;

public class CaesarCipher {

    // Method to encrypt the text
    public static String encrypt(String text, int shift) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char charToEncrypt = text.charAt(i);
            if (Character.isUpperCase(charToEncrypt)) {
                char encryptedChar = (char) (((charToEncrypt - 'A' + shift + 26) % 26) + 'A');
                result.append(encryptedChar);
            } else if (Character.isLowerCase(charToEncrypt)) {
                char encryptedChar = (char) (((charToEncrypt - 'a' + shift + 26) % 26) + 'a');
                result.append(encryptedChar);
            } else {
                result.append(charToEncrypt); // Keep non-alphabetic characters unchanged
            }
        }

        return result.toString();
    }

    // Method to decrypt the text
    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift);
    }

    // Example usage
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose an option:");
        System.out.println("1. Encrypt");
        System.out.println("2. Decrypt");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        if (choice == 1)
        {
            System.out.println("Enter the text to encrypt:");
            String plaintext = scanner.nextLine();
            System.out.println("Enter the shift value:");
            int shift = scanner.nextInt();
            String ciphertext = encrypt(plaintext, shift);
            System.out.println("Encrypted: " + ciphertext);
        }
        else if (choice == 2)
        {
            System.out.println("Enter the text to decrypt:");
            String ciphertext = scanner.nextLine();
            for (int shift = 0; shift <=25; shift++)
            {
                String decryptedText = decrypt(ciphertext, shift);
                System.out.println("Decrypted Message with " + shift + " as Shift key : " + decryptedText);
            }
        }
        else
        {
            System.out.println("Invalid choice. Please choose 1 or 2.");
        }

        scanner.close();
    }
}
