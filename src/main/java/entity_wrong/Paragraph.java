package entity_wrong;

import java.util.LinkedList;

/**
 * Created by 1 on 09.11.2014.
 */
public class Paragraph extends Text {

 private String elementParagraph;
 private int elementId;
    private LinkedList<Sentence> sentences;//=new LinkedList<entity_wrong.Sentence>();

    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
    }

    public LinkedList<Sentence> getSentences() {
        return sentences;
    }

    public void setSentences(LinkedList<Sentence> sentences) {
        this.sentences = sentences;
    }

    public String getElementParagraph() {

        return elementParagraph;
    }

    public void setElementParagraph(String elementParagraph) {
        this.elementParagraph = elementParagraph;
    }
}
