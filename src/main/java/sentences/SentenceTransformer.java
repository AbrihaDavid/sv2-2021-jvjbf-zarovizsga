package sentences;

public class SentenceTransformer {

    public String shortenSentence(String sentence){

        if (!Character.isUpperCase(sentence.charAt(0))){
            throw new IllegalArgumentException("Must start with capital letter!");
        }

        if (!(sentence.endsWith(".") || sentence.endsWith("?") || sentence.endsWith("!"))){
            throw new IllegalArgumentException("Must end with . ! or ?");
        }

        String[] temp = sentence.split(" ");
        StringBuilder sb = new StringBuilder();

        if(temp.length >= 5){
            return sb.append(temp[0]).append(" ... ").append(temp[temp.length-1]).toString();
        }

        return sentence;
    }
}
