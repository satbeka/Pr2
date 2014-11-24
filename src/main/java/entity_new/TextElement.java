package entity_new;

/**
 * Created by 1 on 22.11.2014.
 */
public class TextElement implements ComponentTxt {
    public String getElement() {
        return element;
    }

    public void setElement(String element) {
        this.element = element;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name=null;
    private String element=null;
    @Override
    public void print() {

    }
}
