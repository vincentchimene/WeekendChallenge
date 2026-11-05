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

    public static int wordCount() {
        if (editedText.isBlank()) return 0;

        Pattern pattern = Pattern.compile("[\\p{L}\\p{N}]+");
        Matcher matcher = pattern.matcher(editedText);
        int count = 0;
        while (matcher.find()) {
            count++;
        }
        return count;
    }


    public int sentenceCount() {
        if (editedText.isBlank()) return 0;

        String[] parts = editedText.split("[.!?]+");
        int count = 0;
        for (String part : parts) {
            if (part.matches(".*[\\p{L}\\p{N}].*")) {
                count++;
            }
        }
        return count;
    }

    public String cleanText(){
        String[] splitText = editedText.trim().split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < splitText.length; index++) {
            if (index > 0) builder.append(' ');
            builder.append(splitText[index]);
        }
        editedText =  builder.toString();
        return editedText;
    }

}