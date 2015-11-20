package simpledatabase;
import java.util.ArrayList;

public class Projection extends Operator{
	
	ArrayList<Attribute> newAttributeList;
	private String attributePredicate;


	public Projection(Operator child, String attributePredicate){
		
		this.attributePredicate = attributePredicate;
		this.child = child;
		newAttributeList = new ArrayList<Attribute>();
		
	}
	
	
	/**
     * Return the data of the selected attribute as tuple format
     * @return tuple
     */
	@Override
	public Tuple next(){
		Tuple tuple_temp = child.next();
		newAttributeList = new ArrayList<Attribute>();

		if(tuple_temp != null){
			int i = 0;
			do{
				boolean NameEql = tuple_temp.getAttributeList().get(i).getAttributeName().equals(attributePredicate)? true : false ;
				if(NameEql){
					newAttributeList.add(tuple_temp.getAttributeList().get(i));
				}
				i++;
			}while(i<tuple_temp.getAttributeList().size());
			return new Tuple(newAttributeList);
	}else{
		return null;
		}
	}
	
	/**
     * The function is used to get the attribute list of the tuple
     * @return attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		return child.getAttributeList();
	}

}