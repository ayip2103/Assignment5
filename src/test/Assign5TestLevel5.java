package test;
import simpledatabase.FormRAtree;
import simpledatabase.Operator;
import simpledatabase.Tuple;
import junit.framework.TestCase;

public class Assign5TestLevel5 extends TestCase {
    private String selectText;
    private String fromText;
    private String joinText;
    private String whereText;
    private String orderText;
    FormRAtree tree;
    Operator root;
    Tuple tuple;
	boolean next = true;
	
	/*SQL Statement: SELECT Name
	 *  			 FROM Student 
	 *  			 WHERE Student.Programme=
	 *  			 (SELECT Programme 
	 *				 FROM Student 
	 *				 WHERE Student.Scheme="Computing")*/
	
	public void testLevel5(){
		   int cnt = 0;
		   
		   selectText = "Programme";
	       fromText = "Student";
	       joinText = "";
	       whereText = "Student.Scheme=\"Computing\"";
	       orderText = "";
		
	       tree = new FormRAtree(selectText,fromText,joinText,whereText,orderText);
	       root = tree.structureTree();
	     
	       tuple = (Tuple)root.next();
	      
	       if(tuple != null){
	    	   selectText = "Name";
	    	   fromText = "Student";
	    	   joinText = "";
	    	   whereText = "Student.Programme="+tuple.getAttributeValue(0);
	    	   orderText = "";
	    	   cnt++;
	    	   
	    	   tree = new FormRAtree(selectText,fromText,joinText,whereText,orderText);
	    	   root = tree.structureTree();
	       
	    	   tuple = root.next();
	    	   while(tuple != null){
	    		   if(next == false)
	    			   tuple = root.next();
	    	   
	    		   if(cnt == 1){
	    			   assertTrue(tuple.getAttributeValue(0).equals("\"Eric\""));
	    			   cnt++;
	    		   }
	    		   else if(cnt == 2){
	    			   assertTrue(tuple.getAttributeValue(0).equals("\"Chr\""));
	    			   cnt++;
	    		   }
	    	   
	    		   next = false;
	    	   }
	    	   
	       }
	       assertTrue(cnt==3);
	}

}