package entity_new;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 1 on 22.11.2014.
 */
public class CompositeComponentTxt implements ComponentTxt {

    private ArrayList<ComponentTxt> listComponentTxt ;

    public ArrayList<ComponentTxt> getListComponentTxt() {
        return listComponentTxt;
    }

    public void setListComponentTxt(ArrayList<ComponentTxt> listComponentTxt) {
        this.listComponentTxt = listComponentTxt;
    }


    public CompositeComponentTxt() {
        this.listComponentTxt = new ArrayList<ComponentTxt>();
    }


    public void add(ComponentTxt componentTxt) {
        listComponentTxt.add(componentTxt);
    }


    public void remove(ComponentTxt componentTxt) {
        listComponentTxt.remove(componentTxt);
    }

    @Override
    public void print() {
        for (ComponentTxt componentTxt : listComponentTxt) {
            componentTxt.print();
        }
    }
}
