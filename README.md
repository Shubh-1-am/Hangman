# Hangman

Hangman is a classic word guessing game where the player tries to guess a secret word by guessing letters one at a time. If the player misses six times, the game is over.

## How to play

To play Hangman, follow these steps:

1. Clone or download this repository.
2. Navigate to the directory where you downloaded the files and compile the `Hangman.java` file using the `javac` command.
3. Run the `Hangman` class using the `java` command.
4. The game will select a random word from a pre-defined list of words and display a series of underscores to represent the letters of the word.
5. Guess a letter by typing it into the console and pressing `Enter`.
6. If the letter is in the word, the underscores will be replaced with the correctly guessed letter. If the letter is not in the word, the game will display a part of the hangman's gallows and decrease the number of misses remaining.
7. Continue guessing letters until either the word is fully revealed or the player runs out of misses.

## Tips

- Keep track of the letters you have already guessed to avoid repeating guesses.
- Try to guess consonants first, as they are more common in English words.
- Pay attention to the length of the word and any patterns that emerge as you guess letters.


