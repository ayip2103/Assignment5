package simpledatabase;

import simpledatabase.Type.DataTypes;

public class Attribute{
	
	String attributeName;
	Type attributeType;
	Object attributeValue;

	
	public Attribute(){

	}
	
	/**
     * Set the attribute name
     * @param str the attribute name
     */
	public void setAttributeName(String str) {
		attributeName = str;		
	}
		
	/**
     * Set the attribute type
     * @param type the attribute type
     */
	public void setAttributeType(String type) {		
		attributeType = new Type(type);
	}
		
	/**
     * Set the attribute value
     * @param type the attribute type
     * @param str the attribute value
     */
	public void setAttributeValue(Type type, String str) {
		switch(type.type){
			case INTEGER:
				attributeValue = Integer.parseInt(str);
				break;
				
			case DOUBLE:
				attributeValue = Double.parseDouble(str);
				break;
				
			case LONG:
				attributeValue = Long.parseLong(str);
				break;
				
			case SHORT:
				attributeValue = Short.parseShort(str);
				break;
				
			case FLOAT:
				attributeValue = Float.parseFloat(str);
				break;
				
			case STRING:
				attributeValue = str;
				break;
				
			case BOOLEAN:
				attributeValue = Boolean.parseBoolean(str);
				break;
				
			case CHAR:
				attributeValue = str.charAt(0);
				break;
				
			case BYTE:
				attributeValue = Byte.parseByte(str);
				break;

		}
	}
		
	/**
     * Get the attribute type
     * @return attributeName the attribute name
     */
	public String getAttributeName() {
		return attributeName;
	}
		
	/**
     * Get the attribute type
     * @return attributeType the attribute type
     */
	public Type getAttributeType() {
		return attributeType;
	}
	
	/**
     * Get the attribute value
     * @return attributeValue the attribute value
     */
	public Object getAttributeValue(){
		return attributeValue;
	}
		
	
}