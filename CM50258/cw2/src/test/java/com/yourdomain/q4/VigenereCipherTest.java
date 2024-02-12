package com.yourdomain.q4;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.InputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.Collectors;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Path;

@FunctionalInterface
interface Assertion {
    void check(String textPath, String keyPath);
}

public class VigenereCipherTest {

    private Cipher cipher = new VigenereCipher();

    private void testWithFiles(String text, String key, Assertion assertion) throws Exception {
        // Create temporary files
        Path textTempFile = Files.createTempFile(null, ".txt");
        Path keyTempFile = Files.createTempFile(null, ".txt");

        try {
            // Write test data to the temporary files
            Files.write(textTempFile, text.getBytes());
            Files.write(keyTempFile, key.getBytes());

            assertion.check(textTempFile.toString(), keyTempFile.toString());
        } finally {
            // Cleanup: Delete temporary files
            Files.deleteIfExists(textTempFile);
            Files.deleteIfExists(keyTempFile);
        }
    }

    @Test
    public void testEncryption() throws Exception {
        String key = "LEMON";
        String originalText = "ATTACKATDAWN";
        String expectedEncryptedText = "LXFOPVEFRNHR";

        testWithFiles(originalText, key,
            (textPath, keyPath) -> {
                assertEquals("Encryption failed", expectedEncryptedText, cipher.encrypt(textPath, keyPath));
            });
    }

    @Test
    public void testEncryptionRepeat() throws Exception {
        String key = "BAC";
        String originalText = "A".repeat(3 * 100000);
        String expectedEncryptedText = "BAC".repeat(100000);

        testWithFiles(originalText, key,
            (textPath, keyPath) -> {
                assertEquals("Encryption failed", expectedEncryptedText, cipher.encrypt(textPath, keyPath));
            });
    }

    @Test
    public void testDecryptionRepeat() throws Exception {
        String key = "BAC";
        String encryptedText = "A".repeat(3 * 100000);
        String expectedDecryptedText = "ZAY".repeat(100000);

        testWithFiles(encryptedText, key,
            (textPath, keyPath) -> {
                assertEquals("Decryption failed", expectedDecryptedText, cipher.decrypt(textPath, keyPath));
            });
    }

    @Test
    public void testEncryptionWithEmptyKey() throws Exception {
        String key = "";
        String originalText = "ATTACKATDAWN";

        testWithFiles(originalText, key,
            (textPath, keyPath) -> {
                assertEquals("Encryption failed", null, cipher.encrypt(textPath, keyPath));
            });
    }

    @Test
    public void testEncryptionWithShortKey() throws Exception {
        String key = "B";
        String originalText = "ATTACKATDAWN";
        String expectedEncryptedText = "BUUBDLBUEBXO";

        testWithFiles(originalText, key,
            (textPath, keyPath) -> {
                assertEquals("Encryption failed", expectedEncryptedText, cipher.encrypt(textPath, keyPath));
            });
    }

    @Test
    public void testDecryption() throws Exception {
        String key = "LEMON";
        String encryptedText = "LXFOPVEFRNHR";
        String expectedDecryptedText = "ATTACKATDAWN";

        testWithFiles(encryptedText, key,
            (textPath, keyPath) -> {
                assertEquals("Decryption failed", expectedDecryptedText, cipher.decrypt(textPath, keyPath));
            });
    }

    @Test
    public void testDecryptionWithEmptyKey() throws Exception {
        String key = "";
        String encryptedText = "ATTACKATDAWN";

        testWithFiles(encryptedText, key,
            (textPath, keyPath) -> {
                assertEquals("Decryption failed", null, cipher.decrypt(textPath, keyPath));
            });
    }

    @Test
    public void testDecryptionWithShortKey() throws Exception {
        String key = "B";
        String encryptedText = "BUUBDLBUEBXO";
        String expectedDecryptedText = "ATTACKATDAWN";

        testWithFiles(encryptedText, key,
            (textPath, keyPath) -> {
                assertEquals("Decryption failed", expectedDecryptedText, cipher.decrypt(textPath, keyPath));
            });
    }

    private String readFile(String filename) throws Exception {
        InputStream is = getClass().getClassLoader().getResourceAsStream("com/yourdomain/q4/" + filename);
        if (is == null) {
            throw new FileNotFoundException("File not found: " + filename);
        }
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
            return reader.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }

    @Test
    public void testEncryptFromFiles() throws Exception {
        String originalText = readFile("decrypt_check.txt");
        String key = readFile("key_check.txt");
        String expectedEncryptedText = readFile("encrypt_check.txt");

        testWithFiles(originalText, key,
            (textPath, keyPath) -> {
                assertEquals(expectedEncryptedText, cipher.encrypt(textPath, keyPath));
            });
    }

    @Test
    public void testDecryptFromFiles() throws Exception {
        String encryptedText = readFile("encrypt_check.txt");
        String key = readFile("key_check.txt");
        String expectedDecryptedText = readFile("decrypt_check.txt");

        testWithFiles(encryptedText, key,
            (textPath, keyPath) -> {
                assertEquals("Decryption failed", expectedDecryptedText.toUpperCase(), cipher.decrypt(textPath, keyPath));
            });
    }
}