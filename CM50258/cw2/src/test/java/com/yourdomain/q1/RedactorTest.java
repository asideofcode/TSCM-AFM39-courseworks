package com.yourdomain.q1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.Test;

public class RedactorTest {
    @Test
    public void testRedactBasic() {
        String input = "The quick brown fox jumps over the lazy dog!";
        String[] redactWords = {"Fox", "jumps", "dog"};
        String expected = "The quick brown *** ***** over the lazy ***!";

        assertEquals(expected, Redactor.redact(input, redactWords));
    }

    @Test
    public void testRedactWithSpecialWords() {
        String input = "The quick brown f$ox jumps over the lazy dog!";
        String[] redactWords = {"F$ox", "jumps", "dog"};
        String expected = "The quick brown **** ***** over the lazy ***!";

        assertEquals(expected, Redactor.redact(input, redactWords));
    }

    // @Test
    // public void testRedactWithHyphenatedWords() {
    //     String input = "The high-quality cross-reference is helpful.";
    //     String[] redactWords = {"high-quality", "cross-reference"};
    //     String expected = "The ************ ************ is helpful.";

    //     assertEquals(expected, Redactor.redact(input, redactWords));
    // }

    // @Test
    // public void testRedactWithApostrophes() {
    //     String input = "Chris' cat chased Chris's mouse.";
    //     String[] redactWords = {"Chris'"};
    //     String expected = "***** cat chased Chris's mouse.";

    //     assertEquals(expected, Redactor.redact(input, redactWords));
    // }

    @Test
    public void testRedactPerformance() {
        StringBuilder inputBuilder = new StringBuilder();
        String redactableWord = "fox";
        for (int i = 0; i < 100000; i++) {
            inputBuilder.append("The quick brown ").append(redactableWord).append(" ");
        }
        String input = inputBuilder.toString().trim();

        String[] redactWords = {redactableWord};
        String expected = input.replaceAll(redactableWord, "*".repeat(redactableWord.length()));

        assertEquals(expected, Redactor.redact(input, redactWords));
    }

    @Test
    public void testRedactWithNonLetterCharacters() {
        String input = "There are 2 foxes and 3 dogs in the yard!";
        String[] redactWords = {"2", "3"};
        String expected = "There are * foxes and * dogs in the yard!";

        assertEquals(expected, Redactor.redact(input, redactWords));
    }

    @Test
    public void testRedactWithRedactableWordsContainingSpaces() {
        String input = "The quick brown fox jumps over the lazy dog!";
        String[] redactWords = {"quick brown", "the lazy"};
        String expected = "The *********** fox jumps over ******** dog!";

        assertEquals(expected, Redactor.redact(input, redactWords));
    }

    // @Test
    // public void testRedactWithRedactableWordsStartingEndingWithSpaces() {
    //     String input = "The quick brown fox jumps over the lazy dog!";
    //     String[] redactWords = {" quick ", " dog "};
    //     String expected = "The ***** brown fox jumps over the lazy *****!";

    //     assertEquals(expected, Redactor.redact(input, redactWords));
    // }

    @Test
    public void testRedactCaseInsensitiveMatching() {
        String input = "The Quick brown foX jumps over the lazy Dog!";
        String[] redactWords = {"fox", "jumps", "dog"};
        String expected = "The Quick brown *** ***** over the lazy ***!";

        assertEquals(expected, Redactor.redact(input, redactWords));
    }

    
    @Test
    public void testRedactCaseInsensitive() {
        String input = "The quick brown FOX jumps over the LAZY DOG!";
        String[] redactWords = {"fox", "jUMPs", "DoG"};
        String expected = "The quick brown *** ***** over the LAZY ***!";

        assertEquals(expected, Redactor.redact(input, redactWords));
    }
    
    @Test
    public void testRedactPartialWord() {
        String input = "The password is secret.";
        String[] redactWords = {"pass"};
        String expected = "The password is secret.";

        assertEquals(expected, Redactor.redact(input, redactWords));
    }
    
    @Test
    public void testRedactEmptyRedactWords() {
        String input = "The quick brown fox jumps over the lazy dog!";
        String[] redactWords = {};
        String expected = "The quick brown fox jumps over the lazy dog!";

        assertEquals(expected, Redactor.redact(input, redactWords));
    }
  
    @Test
    public void testRedactWithNoMatches() {
        String input = "The quick brown fox jumps over the lazy dog!";
        String[] redactWords = {"cat", "runs", "mouse"};
        String expected = "The quick brown fox jumps over the lazy dog!";

        assertEquals(expected, Redactor.redact(input, redactWords));
    }

    @Test
    public void testRedactWithEmptyInput() {
        String input = "";
        String[] redactWords = {"fox", "jumps", "dog"};
        String expected = "";

        assertEquals(expected, Redactor.redact(input, redactWords));
    }

    @Test
    public void testRedactNullInput() {
        String[] redactWords = {"fox"};

        assertThrows(NullPointerException.class, () -> Redactor.redact(null, redactWords));
    }
    
    @Test
    public void testRedactNullRedactWords() {
        String input = "The quick brown fox jumps over the lazy dog!";

        assertThrows(NullPointerException.class, () -> Redactor.redact(input, null));
    }
}
