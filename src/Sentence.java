public class Sentence {
    private static final String punctuationSymbols = ",.!?;";
    private SentenceElement[] sentenceElements;

    public Sentence(SentenceElement[] sentenceElements) {
        this.sentenceElements = sentenceElements;
    }

    public Sentence(String sentence_str) {
        String[] sentence_elements_str = sentence_str.split("(?=[" + punctuationSymbols + "])|\\s");
        sentenceElements = new SentenceElement[sentence_elements_str.length];
        String sentence_element_str;
        for (int i = 0; i < sentence_elements_str.length; i++) {
            sentence_element_str = sentence_elements_str[i];
            if (punctuationSymbols.contains(sentence_element_str)){
                sentenceElements[i] = new Punctuation(sentence_element_str);
            } else {
                sentenceElements[i] = new Word(sentence_element_str);
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sentence_str = new StringBuilder();
        for (int i = 0; i < sentenceElements.length; i++) {
            sentence_str.append(
                    (i != 0 && sentenceElements[i] instanceof Word ? " " : "") +
                            sentenceElements[i].toString()
            );
        }
        return sentence_str.toString();
    }

    public int find_word_entrances() {
        int word_entrances = 0;

        for (SentenceElement sentenceElement : sentenceElements) {
            if (sentenceElement instanceof Word) {
                word_entrances++;
            }
        }

        return word_entrances;
    }
}