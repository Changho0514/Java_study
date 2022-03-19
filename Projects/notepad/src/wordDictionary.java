import java.util.HashMap;

public class wordDictionary {
    private HashMap<String, String> words = new HashMap<>();

        public void addWord(String english, String korean) {
            words.put(english.toLowerCase(), korean);
        }

        public String find(String english) {
            words.get(english.toLowerCase());
            for (String key : words.keySet()) {
                if (english.toLowerCase().equals(words.get(key).toLowerCase())) {
                    String translated = words.get(key);
                }
            }
            return translated;
    }
}
