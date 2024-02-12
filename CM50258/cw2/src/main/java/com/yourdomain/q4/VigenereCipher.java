package com.yourdomain.q4;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// Implements the Vigenere Cipher for encryption and decryption of text files.
public class VigenereCipher implements Cipher {
    // Encrypts the content of a file using a key from another file.
    @Override
    public String encrypt(String message_filename, String key_filename) {
        // Validates input file names.
        if (message_filename == null || key_filename == null || message_filename.isEmpty() || key_filename.isEmpty()) {
            return null;
        }

        // Reads the message and key from their respective files.
        String text = readFile(message_filename);
        String key = readFile(key_filename);

        if (text == null || key == null || key.isEmpty()) {
            return null;
        }

        if (text.isEmpty()) {
            return text;
        }

        // Encrypts the message using the Vigenere Cipher algorithm.
        StringBuilder result = new StringBuilder();
        key = generateKey(text, key).toUpperCase();
        text = text.toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character >= 'A' && character <= 'Z') {
                result.append((char) ((character + key.charAt(i) - 2 * 'A') % 26 + 'A'));
            } else {
                result.append(character);
            }
        }
        return result.toString();
    }

    // Decrypts the content of a file using a key from another file.
    @Override
    public String decrypt(String message_filename, String key_filename) {
        // Validates input file names.
        if (message_filename == null || key_filename == null || message_filename.isEmpty() || key_filename.isEmpty()) {
            return null;
        }

        // Reads the message and key from their respective files.
        String text = readFile(message_filename);
        String key = readFile(key_filename);

        if (text == null || key == null || key.isEmpty()) {
            return null;
        }

        if (text.isEmpty()) {
            return text;
        }

        // Decrypts the message using the Vigenere Cipher algorithm.
        StringBuilder result = new StringBuilder();
        key = generateKey(text, key).toUpperCase();
        text = text.toUpperCase();

        for (int i = 0; i < text.length(); i++) {
            char character = text.charAt(i);
            if (character >= 'A' && character <= 'Z') {
                result.append((char) ((character - key.charAt(i) + 26) % 26 + 'A'));
            } else {
                result.append(character);
            }
        }

        // Returns the decrypted message as a String.
        return result.toString();
    }

    // Generates a repeating key to match the length of the text to be encrypted/decrypted.
    private String generateKey(String text, String key) {
        StringBuilder newKey = new StringBuilder(key);
        int keyLength = key.length();

        for (int i = 0, n = text.length(); i < n - keyLength; i++) {
            newKey.append(key.charAt(i % keyLength));
        }

        return newKey.toString();
    }

    // Reads the content of a file and returns it as a String.
    private String readFile(String filePath) {
        // Attempts to read the file content.
        // Returns the file content as a String or null if an error occurs.
        try {
            return new String(Files.readAllBytes(Paths.get(filePath)));
        } catch(IOException ex){
            return null;
        }
    }
}
