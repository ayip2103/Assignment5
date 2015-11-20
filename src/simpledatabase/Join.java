package simpledatabase;
import java.util.ArrayList;

public class Join extends Operator{

	private ArrayList<Attribute> newAttributeList;
	private String joinPredicate;
	ArrayList<Tuple> tuples1;

	
	//Join Constructor, join fill
	public Join(Operator leftChild, Operator rightChild, String joinPredicate){
		this.leftChild = leftChild;
		this.rightChild = rightChild;
		this.joinPredicate = joinPredicate;
		newAttributeList = new ArrayList<Attribute>();
		tuples1 = new ArrayList<Tuple>();
		
	}

	
	/**
     * It is used to return a new tuple which is already joined by the common attribute
     * @return the new joined tuple
     */
	//The record after join with two tables
	@Override
	public Tuple next(){
		Tuple Ltuple = leftChild.next();	
		do{
			tuples1.add(Ltuple);	
			Ltuple = leftChild.next();
		}while(Ltuple != null);
		
		Tuple Rtuple= rightChild.next();
		boolean Checknull = false;
		if(Rtuple != null){
			Checknull = true;
		}
		while(Checknull){
			int temp = 0;
			do{
				Ltuple = tuples1.get(temp);
				int i = 0;
				do{
					int j = 0;
					do{
						boolean NameEql = Rtuple.getAttributeName(i).equals(Ltuple.getAttributeName(j))? true : false ;
						if(NameEql){
							boolean ValueEql = Rtuple.getAttributeValue(i).equals(Ltuple.getAttributeValue(j))? true : false ;
							if(ValueEql){
								int n = 0;
								newAttributeList = new ArrayList<Attribute>();
								do{
									newAttributeList.add(Ltuple.getAttributeList().get(n));
									n++;
								}while(n<Ltuple.getAttributeList().size());
								
								int m = 0;
								do{
									if(m != i){
										newAttributeList.add(Rtuple.getAttributeList().get(m));
									}
									m++;
								}while(m<Rtuple.getAttributeList().size());
								return new Tuple(newAttributeList);
							}
						}
						j++;
					}while(j<Ltuple.getAttributeList().size());
					i++;
				}while(i<Rtuple.getAttributeList().size());
				temp++;
			}while(temp < tuples1.size());
			Rtuple= rightChild.next();
		}
		return null;
	}
	
	
	/**
     * The function is used to get the attribute list of the tuple
     * @return attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		if(joinPredicate.isEmpty())
			return child.getAttributeList();
		else
			return(newAttributeList);
	}

}