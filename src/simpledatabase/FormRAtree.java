package simpledatabase;
import java.util.Iterator;

public class FormRAtree{

	String attributePredicate;
	String fromPredicate;
	String joinPredicate;
	String whereText;
	String orderPredicate;
	String[] col;
	String[] col1;
	String whereTablePredicate;
	String whereAttributePredicate;
	String whereValuePredicate;
	
	public FormRAtree(String selectText,String fromText,String joinText,String whereText,String orderText){
		this.attributePredicate=selectText;
		this.fromPredicate=fromText;
		this.joinPredicate=joinText;
		this.whereText=whereText;
		this.orderPredicate=orderText;
		parseText();
	}
	
	/**
     * To parse the where statement and separate into table name, attribute name and attribute value
     */
	public void parseText(){
		if(!whereText.isEmpty()){
			//split CourseEnroll.courseID = ¡§COMP2021¡¨ into three parts
			col = whereText.split("\\.");
			col1 = col[1].split("\\=");
		
			whereTablePredicate = col[0];
			whereAttributePredicate = col1[0];
			whereValuePredicate = col1[1];
		}
		else{
			whereTablePredicate = "";
			whereAttributePredicate = "";
			whereValuePredicate = "";
		}
	
	}
	
	/**
     * Set up the tree according to the FROM, WHERE, JOIN, SORTED BY and SELECT statement
     * @return projection the top operator of the tree
     */
	public Operator structureTree(){
		//select and from
		if(!attributePredicate.isEmpty() && !fromPredicate.isEmpty() && joinPredicate.isEmpty() && whereTablePredicate.isEmpty() && orderPredicate.isEmpty()){
			Operator table = new Table(fromPredicate);
			Operator projection = new Projection(table,attributePredicate);
			return projection;
		}
		
		//select, join, where and from
		else if(!attributePredicate.isEmpty() && !fromPredicate.isEmpty() && !joinPredicate.isEmpty() && !whereTablePredicate.isEmpty() && orderPredicate.isEmpty()){
			Operator table = new Table(fromPredicate);
	    	Operator table1 = new Table(joinPredicate);
	    	Operator selection = new Selection(table,whereTablePredicate,whereAttributePredicate,whereValuePredicate);
	    	Operator selection1 = new Selection(table1,whereTablePredicate,whereAttributePredicate,whereValuePredicate);
	    	Operator join = new Join(selection,selection1,joinPredicate); 
	    	Operator projection = new Projection(join,attributePredicate);
	    	return projection;
		}
		//select, join, order and from
		else if(!attributePredicate.isEmpty() && !fromPredicate.isEmpty() && !joinPredicate.isEmpty() && whereTablePredicate.isEmpty() && !orderPredicate.isEmpty()){
			Operator table = new Table(fromPredicate);
			Operator table1 = new Table(joinPredicate);
			Operator join = new Join(table,table1,joinPredicate); 
			Operator sort = new Sort(join,orderPredicate);
	    	Operator projection = new Projection(sort,attributePredicate);
	    	return projection;
		}
			
		//select, where, order and from
		else if(!attributePredicate.isEmpty() && !fromPredicate.isEmpty() && joinPredicate.isEmpty() && !whereTablePredicate.isEmpty() && !orderPredicate.isEmpty()){
			Operator table = new Table(fromPredicate);
			Operator selection = new Selection(table,whereTablePredicate,whereAttributePredicate,whereValuePredicate);
			Operator sort = new Sort(selection,orderPredicate);
	    	Operator projection = new Projection(sort,attributePredicate);
	    	return projection;
		}
		//
		//select, where and from
		else if(!attributePredicate.isEmpty() && !fromPredicate.isEmpty() && joinPredicate.isEmpty() && !whereTablePredicate.isEmpty() && orderPredicate.isEmpty()){
			Operator table = new Table(fromPredicate);
	    	Operator selection = new Selection(table,whereTablePredicate,whereAttributePredicate,whereValuePredicate);
	    	Operator projection = new Projection(selection,attributePredicate);
	    	return projection;
		}
		//select, order and from
		else if(!attributePredicate.isEmpty() && !fromPredicate.isEmpty() && joinPredicate.isEmpty() && whereTablePredicate.isEmpty() && !orderPredicate.isEmpty()){
			Operator table = new Table(fromPredicate);
	    	Operator sort = new Sort(table,orderPredicate);
	    	Operator projection = new Projection(sort,attributePredicate);
	    	return projection;
		}
		//select, join and from
		else if(!attributePredicate.isEmpty() && !fromPredicate.isEmpty() && !joinPredicate.isEmpty() && whereTablePredicate.isEmpty() && orderPredicate.isEmpty()){
			Operator table = new Table(fromPredicate);
			Operator table1 = new Table(joinPredicate);
			Operator join = new Join(table,table1,joinPredicate); 
	    	Operator projection = new Projection(join,attributePredicate);
	    	return projection;
		}
		//all
		else if(!attributePredicate.isEmpty() && !fromPredicate.isEmpty() && !joinPredicate.isEmpty() && !whereTablePredicate.isEmpty() && !orderPredicate.isEmpty()){
			Operator table = new Table(fromPredicate);
	    	Operator table1 = new Table(joinPredicate);
	    	Operator selection = new Selection(table,whereTablePredicate,whereAttributePredicate,whereValuePredicate);
	    	Operator selection1 = new Selection(table1,whereTablePredicate,whereAttributePredicate,whereValuePredicate);
	    	Operator join = new Join(selection,selection1,joinPredicate); 
	    	Operator sort = new Sort(join,orderPredicate);
	    	Operator projection = new Projection(sort,attributePredicate);
	    	return projection;
		}
		else
			return null;
		
	}
	
}