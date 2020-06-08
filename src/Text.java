public class Text {
    private Sentence[] sentences;

    public Text(Sentence[] sentences) {
        this.sentences = sentences;
    }

    public Text(String textString) {
        String[] sentencesstr = textString.split("(?<=[?!.]) ");
        sentences = new Sentence[sentencesstr.length];
        for (int i = 0; i < sentencesstr.length; i++) {
            sentences[i] = new Sentence(sentencesstr[i]);
        }
    }

    @Override
    public String toString() {
        StringBuilder textString = new StringBuilder();
        for (int i = 0; i < sentences.length; i++) {
            textString.append(sentences[i].toString() + (i != sentences.length - 1 ? " " : ""));
        }
        return textString.toString();
    }

    public int[] find_word_entrances() {
        int word_entrances[] = new int[sentences.length];
        int word_entrances_sorted[] = new int[sentences.length];

        for (int i = 0; i < sentences.length; i++) {
            word_entrances[i] = sentences[i].find_word_entrances();
            word_entrances_sorted[i] = sentences[i].find_word_entrances();
        }
        boolean sorted = false;
        int temp;
        while (!sorted) {
            sorted = true;
            for (int i = 0; i < word_entrances_sorted.length - 1; i++) {
                if (word_entrances_sorted[i] > word_entrances_sorted[i + 1]) {
                    temp = word_entrances_sorted[i];
                    word_entrances_sorted[i] = word_entrances_sorted[i + 1];
                    word_entrances_sorted[i + 1] = temp;
                    sorted = false;
                }
            }
        }
        int[][] turnre = new int[2][sentences.length];
        turnre[0] = word_entrances;
        turnre[1] = word_entrances_sorted;
        for (int i = 0; i < sentences.length; i++){
            for (int j = 0; j < sentences.length; j++){
                if (word_entrances_sorted[i] == word_entrances[j]){
                    System.out.println(sentences[j]);
                }
            }
        }
        return word_entrances;
    }
}