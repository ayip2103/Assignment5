package simpledatabase;
import java.util.ArrayList;

public class Selection extends Operator{
	
	ArrayList<Attribute> attributeList;
	String whereTablePredicate;
	String whereAttributePredicate;
	String whereValuePredicate;

	
	public Selection(Operator child, String whereTablePredicate, String whereAttributePredicate, String whereValuePredicate) {
		this.child = child;
		this.whereTablePredicate = whereTablePredicate;
		this.whereAttributePredicate = whereAttributePredicate;
		this.whereValuePredicate = whereValuePredicate;
		attributeList = new ArrayList<Attribute>();

	}
	
	
	/**
     * Get the tuple which match to the where condition
     * @return the tuple
     */
	@Override
	public Tuple next(){
		boolean ChildCondition = false;
		String table = child.from;
		if(table.equals(whereTablePredicate)){
			ChildCondition = false;
		}else if(!table.equals(whereTablePredicate)){
			ChildCondition = true;
		}
		if (ChildCondition){
			return child.next();
		}
		Tuple tuple_temp = child.next();
		while (tuple_temp != null){
			int i = 0;
			boolean NameEql = false;
			boolean ValueEql = false;
			while(i<child.getAttributeList().size()){
				NameEql = child.getAttributeList().get(i).getAttributeName().equals(whereAttributePredicate)? true : false;
				ValueEql = child.getAttributeList().get(i).getAttributeValue().equals(whereValuePredicate)? true : false;
				if(NameEql && ValueEql){
					attributeList = child.getAttributeList();
					return tuple_temp;
				}
				i++;
			}
			tuple_temp = child.next();
		}
		return null;	
	}
	
	/**
     * The function is used to get the attribute list of the tuple
     * @return the attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		
		return(child.getAttributeList());
	}

}