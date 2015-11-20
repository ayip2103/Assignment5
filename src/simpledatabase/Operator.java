package simpledatabase;

import java.util.ArrayList;


public class Operator implements Iterator{
	
	protected Operator child;
	protected Operator leftChild;
	protected Operator rightChild;
	String from;
	
	public Operator getChild(){
		return child;
	}
	
	
	@Override
	public Tuple next() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public ArrayList<Attribute> getAttributeList(){
		return null;
	}

}