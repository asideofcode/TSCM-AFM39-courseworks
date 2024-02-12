package com.yourdomain.q1;

// Provides functionality to redact specified words in a given string.
public class Redactor {
    // Redacts all occurrences of the specified words in a given content string using regular expressions.
    public static String redact(String content, String[] redactWords) {
        for (String word : redactWords) {
            // Characters to be escaped: . * + ? ^ $ ( ) [ ] { } | \
            String escapedWord = word.replaceAll("([.*+?^$()\\[\\]{}|\\\\])", "\\\\$1");
            content = content.replaceAll("(?i)\\b" + escapedWord + "\\b", "*".repeat(word.length()));
        }
        return content;
    }
    
    // Redacts all occurrences of the specified words in a given content string without using regular expressions.
    public static String redactManual(String content, String[] redactWords) {
        StringBuilder redactedContent = new StringBuilder(content);

        for (String word : redactWords) {
            int index = 0;

            while (index != -1) {
                index = content.toLowerCase().indexOf(word.toLowerCase(), index);

                if (index != -1) {
                    // Check for word boundaries
                    boolean isStartOfWord = index == 0 || !Character.isLetterOrDigit(content.charAt(index - 1));
                    boolean isEndOfWord = index + word.length() == content.length() || !Character.isLetterOrDigit(content.charAt(index + word.length()));

                    if (isStartOfWord && isEndOfWord) {
                        String replacement = "*".repeat(word.length());
                        redactedContent.replace(index, index + word.length(), replacement);
                        index += replacement.length(); // Move index forward by the length of the replacement
                    } else {
                        index++; // Move index forward to continue search
                    }
                }
            }
        }

        return redactedContent.toString();
    }
}
