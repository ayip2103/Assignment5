package simpledatabase;
import java.util.ArrayList;

public class Tuple{
	ArrayList<Attribute> attributeList; 
	Attribute attribute;
	private String comma = ",";
	String[] col;
	String[] col1;
	String[] col2;
	
	public Tuple(String attributeLine, String dataTypeLine, String tupleLine){
	
		col = attributeLine.split(comma);
		col1 = dataTypeLine.split(comma);
		col2 = tupleLine.split(comma);
		attributeList = new ArrayList<Attribute>();
		
	}
	
	public Tuple(ArrayList<Attribute> attributeJoinList){
		this.attributeList = attributeJoinList;
	}
	
	/**
     * Create a new attribute and set the attribute name
     */
	public void setAttributeName(){
		for(int i=0;i<col.length;i++){
			attribute = new Attribute();
			attribute.setAttributeName(col[i]);
			addAttriubteList();
		}
	}
	
	/**
     * Get the attribute name
     * @param i the position of the attribute in the attribute list
     * @return the attribute name
     */
	public String getAttributeName(int i) {
		return attributeList.get(i).getAttributeName();
		
	}
	
	/**
     * Set the attribute type within the attribute list
     */
	public void setAttributeType(){
		for(int i=0;i<col1.length;i++)
			attributeList.get(i).setAttributeType(col1[i]);
	}
	
	
	/**
     * Get the attribute type within the attribute list
     * @param i the position of the attribute in the attribute list
     * @return attributeType
     */
    public Type getAttributeType(int i) {
		
		return attributeList.get(i).getAttributeType();
	}
    
	/**
     * Set the attribute value within the attribute list
     */
	public void setAttributeValue(){
		for(int i=0;i<col2.length;i++){
			attributeList.get(i).setAttributeValue(getAttributeType(i), col2[i]);
		}
	}

	/**
     * Get the attribute value within the attribute list
     * @param i the position of the attribute in the attribute list
     * @return attributeValue
     */
	public Object getAttributeValue(int i){
		
		return attributeList.get(i).getAttributeValue();
	}
	
	/**
     * Insert the attribute into the attributeList
     */
	public void addAttriubteList(){
		attributeList.add(attribute);
	}
	
	/**
     * Get the attribute list
     * @return attributeList the attribute list as an ArrayList format
     */
	public ArrayList<Attribute> getAttributeList(){
		return attributeList;
	}
}