Implement a [Vigenère cipher](http://libproxy.bath.ac.uk/login?qurl=https%3A%2F%2Fen.wikipedia.org%2Fwiki%2FVigen%25C3%25A8re_cipher) in Java to encrypt a message of any length. A Vigenère cipher is an example of a polyalphabetic substitution cipher. To encrypt a message, you first choose a keyword to use and then trim or repeat it until it is the same length as the message you wish to encode. For example, if you choose the keyword LEMON and the message ATTACKATDAWN, you would have:
```
Message:  A T T A C K A T D A W N

Key:      L E M O N L E M O N L E
```

Next, each letter of the repeated keyword corresponds to the cipher alphabet (i.e. row) used to code each letter of the message based on the Vigenère square below. The letter in the original text is then replaced by the letter in the corresponding index of the cipher alphabet. That is, for the first two letters of the message example above, 'A' is coded as 'L' i.e. the 1st index of the cipher alphabet 'L', and 'T' is coded as 'X' i.e. the 20th index of cipher alphabet 'E' etc. Repeating these steps the fully coded message is - LXFOPVEFRNHR.

Vigenère square:

```
A B C D E F G H I J K L M N O P Q R S T U V W X Y Z
B C D E F G H I J K L M N O P Q R S T U V W X Y Z A
C D E F G H I J K L M N O P Q R S T U V W X Y Z A B
D E F G H I J K L M N O P Q R S T U V W X Y Z A B C
E F G H I J K L M N O P Q R S T U V W X Y Z A B C D
F G H I J K L M N O P Q R S T U V W X Y Z A B C D E
G H I J K L M N O P Q R S T U V W X Y Z A B C D E F
H I J K L M N O P Q R S T U V W X Y Z A B C D E F G
I J K L M N O P Q R S T U V W X Y Z A B C D E F G H
J K L M N O P Q R S T U V W X Y Z A B C D E F G H I
K L M N O P Q R S T U V W X Y Z A B C D E F G H I J
L M N O P Q R S T U V W X Y Z A B C D E F G H I J K
M N O P Q R S T U V W X Y Z A B C D E F G H I J K L
N O P Q R S T U V W X Y Z A B C D E F G H I J K L M
O P Q R S T U V W X Y Z A B C D E F G H I J K L M N
P Q R S T U V W X Y Z A B C D E F G H I J K L M N O
Q R S T U V W X Y Z A B C D E F G H I J K L M N O P
R S T U V W X Y Z A B C D E F G H I J K L M N O P Q
S T U V W X Y Z A B C D E F G H I J K L M N O P Q R
T U V W X Y Z A B C D E F G H I J K L M N O P Q R S
U V W X Y Z A B C D E F G H I J K L M N O P Q R S T
V W X Y Z A B C D E F G H I J K L M N O P Q R S T U
W X Y Z A B C D E F G H I J K L M N O P Q R S T U V
X Y Z A B C D E F G H I J K L M N O P Q R S T U V W
Y Z A B C D E F G H I J K L M N O P Q R S T U V W X
Z A B C D E F G H I J K L M N O P Q R S T U V W X Y
```
Rules:

-   Your class should be called `VigenereCipher` and should use the Cipher interface ([available here](https://moodle.bath.ac.uk/pluginfile.php/937279/question/questiontext/1499011/4/2776228/Cipher.java?time=1648401880542))
-   You should use the Vigenère square above to encrypt and decrypt the messages using a given key (both retrieved from a file).
-   Encrypted messages should be in capital letters to obfuscate the message from anyone intercepting them
-   Decrypted messages should also be in capital letters
-   If the character is a letter of the alphabet it should be encrypted based on the above
-   If the character is not in the alphabet then it should remain unchanged

Here are some test files to test your code with (used in the prechecks):

-   [encrypt\_check.txt](https://moodle.bath.ac.uk/pluginfile.php/937279/question/questiontext/1499011/4/2776228/encrypt_check.txt)
-   [decrypt\_check.txt](https://moodle.bath.ac.uk/pluginfile.php/937279/question/questiontext/1499011/4/2776228/decrypt_check.txt)
-   [key\_check.txt](https://moodle.bath.ac.uk/pluginfile.php/937279/question/questiontext/1499011/4/2776228/key_check.txt)
