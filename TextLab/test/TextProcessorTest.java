import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TextProcessorTest {
    TextProcessor myTextProcessor;


    @Test
    public void testThatGetOriginalTextReturnsOriginalText(){
        String text = "This is a test";
        myTextProcessor = new TextProcessor(text);

        assertEquals(text, TextProcessor.getOriginal());
    }

    @Test
    public void testThatGetEditedTextReturnsGivenTextIfUnedited(){
        String text = "This is a test";
        myTextProcessor = new TextProcessor(text);

        assertEquals(text, TextProcessor.getEdited());
    }

    @Test
    public void testCharacterCountWithWhiteSpace(){
        String text = "This is a test";
        myTextProcessor = new TextProcessor(text);

        assertEquals(14, TextProcessor.characterCountWithWhiteSpace());
    }

    @Test
    public void testCharacterCountWithoutWhiteSpace(){
        String text = "This is a t  est";
        myTextProcessor = new TextProcessor(text);

        assertEquals(11, TextProcessor.characterCountWithoutWhiteSpace());
    }

    @Test
    public void testWordCount(){
        String text = "This is a test";
        myTextProcessor = new TextProcessor(text);

        assertEquals(4, TextProcessor.wordCount());
    }
    @Test
    public void testWordCount2(){
        String text = "  This   is a test   ";
        myTextProcessor = new TextProcessor(text);

        assertEquals(4, TextProcessor.wordCount());
    }

}
