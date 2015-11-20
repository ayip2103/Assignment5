package simpledatabase;
public class Type{
	
	DataTypes type;
	
	enum DataTypes{
		INTEGER, DOUBLE, LONG, SHORT, FLOAT, STRING, BOOLEAN, CHAR, BYTE
	}
	
	public Type(String type){
		
		switch(type){
			case "int":
				this.type = DataTypes.INTEGER;
				break;
			case "double":
				this.type = DataTypes.DOUBLE;
				break;
			case "long":
				this.type = DataTypes.LONG;
				break;
			case "short":
				this.type = DataTypes.SHORT;
				break;
			case "float":
				this.type = DataTypes.FLOAT;
				break;
			case "String":
				this.type = DataTypes.STRING;
				break;
			case "boolean":
				this.type = DataTypes.BOOLEAN;
				break;
			case "char":
				this.type = DataTypes.CHAR;
				break;
			case "byte":
				this.type = DataTypes.BYTE;
				break;
			
		}
		
	
		
	}
	
}