Implement an algorithm in Java which given a String as input, redacts all words from a given set of “redactable” words (an array of Strings), and returns the result as a String. For example, given the String:

    _The quick brown fox jumps over the lazy dog!_

and the redactable set of words:

    _Fox, jumps, dog_

the output String should be:

    _The quick brown \*\*\* \*\*\*\*\* over the lazy \*\*\*!_

Rules:

-   Your implementation must use the `public static String redact(...)` method signature
-   You are **not** allowed to import any libraries or fully-qualified names of additional classes for this question
-   The number of stars in the redacted text is the **same** as the number of letters in the word that has been redacted
-   Capitalization of redacted words is ignored (i.e., "the" in the redacted words list would redact "The", "THE" etc.)
-   Only whole words that match one of the redacted words should be redacted, e.g., given the redacted word "_pass",_ the word "_password"_ would not be redacted.
-   Hyphenated words and words with apostrophes (e.g. Chris' or Chris's) will not be tested.
-   Capitalization of unredacted words in the input text should be maintained in the output text.
