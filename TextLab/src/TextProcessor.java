import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessor {

    private static String originalText;
    private static String editedText;

    public TextProcessor(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        else{
            this.originalText =  text;
            this.editedText = text;
        }
    }

    public static String getOriginal() {
        return originalText;
    }

    public  static String getEdited()   {
        return editedText;
    }

    public static int characterCountWithWhiteSpace() {
        return editedText.length();
    }

    public static int characterCountWithoutWhiteSpace() {
            int count = editedText.replaceAll("\\s", "").length();
            return count;
//            int count = 0;
//            for (char character : editedText.toCharArray()) {
//                if (!Character.isWhitespace(character)) count++;
//            }
//            return count;
    }



}
