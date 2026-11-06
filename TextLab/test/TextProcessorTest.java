import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextProcessorTest {
    TextProcessor myTextProcessor;


    @Test
    public void testThatGetOriginalTextReturnsOriginalText(){
        String text = "This is a test";
        myTextProcessor = new TextProcessor(text);

        assertEquals(text, myTextProcessor.getOriginal());
    }

    @Test
    public void testThatGetEditedTextReturnsGivenTextIfUnedited(){
        String text = "This is a test";
        myTextProcessor = new TextProcessor(text);

        assertEquals(text, myTextProcessor.getEdited());
    }

    @Test
    public void testCharacterCountWithWhiteSpace(){
        String text = "This is a test";
        myTextProcessor = new TextProcessor(text);

        assertEquals(14, myTextProcessor.characterCountWithWhiteSpace());
    }

    @Test
    public void testCharacterCountWithoutWhiteSpace(){
        String text = "This is a t  est";
        myTextProcessor = new TextProcessor(text);

        assertEquals(11, myTextProcessor.characterCountWithoutWhiteSpace());
    }

    @Test
    public void testWordCount(){
        String text = "This is a test";
        myTextProcessor = new TextProcessor(text);

        assertEquals(4, myTextProcessor.wordCount());
    }
    @Test
    public void testWordCount2(){
        String text = "  This   is a test   ";
        myTextProcessor = new TextProcessor(text);

        assertEquals(4, myTextProcessor.wordCount());
    }

    @ParameterizedTest
    @CsvSource({
            "'Hello.', 1",
            "'Hello Mr Vee! How are you?', 2",
            "'Hello. How are you? I am fine!', 3",
            "'Hello', 1",
            "'', 0",
            "'   ', 0",
            "'Hello!!!', 1",
            "'What?! Really!', 2",
            "'Hello... How are you?', 2",
            "'!!!', 0",
            "'12345.', 1",
            "'I have 2 books. You have 3.', 2",
            "'Hello. 12345! Goodbye?', 3"
    })
    void shouldCountSentences(String text, int expectedCount) {
        myTextProcessor = new TextProcessor(text);
        int actualCount = myTextProcessor.sentenceCount();

        assertEquals(expectedCount, actualCount);

    }

    @ParameterizedTest
    @CsvSource({
            "'Hello Vee', 'Hello Vee'",
            "'   Hello Vee   ', 'Hello Vee'",
            "'Hello     Vee', 'Hello Vee'",
            "'   Hello     Vee   ', 'Hello Vee'",
            "'Hello my love', 'Hello my love'",
            "'  ..,Hello my love   ', '..,Hello my love'",
            "'Hello     my     love', 'Hello my love'",
            "'   Hello     my     love   ', 'Hello my love'",
            "'   Hello     Vee, my     love   ', 'Hello Vee, my love'",
            "'Hello     Vee,    I    love    you', 'Hello Vee, I love you'",
            "'   Hello     my    love,   how   are   you?   ', 'Hello my love, how are you?'"
    })
    void testThatCleanTextRemovesExcessSpaces(String text, String expected) {
        TextProcessor textProcessor = new TextProcessor(text);
        String actual = textProcessor.cleanText();

        assertEquals(expected, actual);
    }


    }
