package presentation;

import java.util.ArrayList;
import java.util.List;

import javax.swing.AbstractListModel;

public class ListaUsuariosModel extends AbstractListModel<String> {
	private List<String> nomes = new ArrayList<String>();
    
    public ListaUsuariosModel(){
        super();
    }
    
    public ListaUsuariosModel(List<String> dados){
        nomes.addAll(dados);
    }
    
    @Override
    public int getSize() {
        return nomes.size();
    }

    @Override
    public String getElementAt(int index) {
        return nomes.get(index);
    }
    
    public void add(String s) {
        nomes.add(s);
        fireIntervalAdded(this, nomes.size(), nomes.size());
    }
}
