import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessor {

    private final String originalText;
    private String editedText;

    public TextProcessor(String text) {
        if (text == null) {
            throw new IllegalArgumentException("Text cannot be null");
        }
        else{
            this.originalText =  text;
            this.editedText = text;
        }
    }
    public void setEditedText(String text) {
        this.editedText = text;
    }

    public String getOriginal() {
        return originalText;
    }

    public String getEdited()   {
        return editedText;
    }

    public int characterCountWithWhiteSpace() {
        return editedText.length();
    }

    public int characterCountWithoutWhiteSpace() {
        return editedText.replaceAll("\\s", "").length();
//            int count = 0;
//            for (char character : editedText.toCharArray()) {
//                if (!Character.isWhitespace(character)) count++;
//            }
//            return count;
    }

    public int wordCount() {
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
        if (editedText.isBlank()) {
            editedText = "";
            return editedText;
        }
        String[] splitText = editedText.trim().split("\\s+");
        StringBuilder builder = new StringBuilder();
        for (int index = 0; index < splitText.length; index++) {
            if (index > 0) builder.append(' ');
            builder.append(splitText[index]);
        }
        editedText =  builder.toString();
        return editedText;
    }

    public int wordFrequency() {
        if (editedText.isBlank()) return 0;
        Pattern pattern = Pattern.compile(
                "\\b" + Pattern.quote(editedText) + "\\b",
                Pattern.CASE_INSENSITIVE | Pattern.UNICODE_CASE
        );
        Matcher m = pattern.matcher(editedText);
        int count = 0;
        while (m.find()) count++;
        return count;
    }

}