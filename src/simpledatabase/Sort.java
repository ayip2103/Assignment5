package simpledatabase;

import java.util.ArrayList;

public class Sort extends Operator {

	private ArrayList<Attribute> newAttributeList;
	private String orderPredicate;
	ArrayList<Tuple> tuplesResult;

	public Sort(Operator child, String orderPredicate) {
		this.child = child;
		this.orderPredicate = orderPredicate;
		newAttributeList = new ArrayList<Attribute>();
		tuplesResult = new ArrayList<Tuple>();

	}

	/**
	 * The function is used to return the sorted tuple
	 * 
	 * @return tuple
	 */
	@Override
	public Tuple next() {
		boolean CheckEmpty = false;
		boolean wpEmptyCheck = false;
		int index = 0;
		ArrayList<Tuple> workplace = new ArrayList<Tuple>();
		
		Tuple tuple_temp = child.next();
		while (tuple_temp != null) {
			workplace.add(tuple_temp);
			tuple_temp = child.next();
		}
		
		if(tuplesResult.isEmpty()){
			CheckEmpty = true;
		}else if (tuplesResult.isEmpty()){
			CheckEmpty = false;
		}
		if (CheckEmpty) {
			
			if(workplace.isEmpty()){
				wpEmptyCheck = true;
			}
			if(wpEmptyCheck){
				return null;
			}
			tuple_temp = workplace.get(0);
			int tupleSize = tuple_temp.getAttributeList().size();
			do{
				if(tuple_temp.getAttributeName(index).equals(orderPredicate)){
					break;
				}
				index++;
			}while(index < tupleSize);
			
			do{
				int i = 0;
				int j = 0;
				do{
					boolean CompareVal = false;
					String val1 = workplace.get(i).getAttributeValue(index).toString();
					String val2 = workplace.get(j).getAttributeValue(index).toString();
					if(val1.compareTo(val2) < 0){
						CompareVal = true;
					}
					if(CompareVal){
						j = i;
					}
					i++;
				}while(i < workplace.size());
				tuplesResult.add(workplace.get(j));
				workplace.remove(j);
			}while(workplace.isEmpty() == false);
			
		}
		Tuple TuplesResult = tuplesResult.remove(0);
		
		
		return TuplesResult;
	}

	/**
	 * The function is used to get the attribute list of the tuple
	 * 
	 * @return attribute list
	 */
	public ArrayList<Attribute> getAttributeList() {
		return child.getAttributeList();
	}

}