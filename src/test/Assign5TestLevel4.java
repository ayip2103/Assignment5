package test;
import simpledatabase.FormRAtree;
import simpledatabase.Operator;
import simpledatabase.Tuple;
import junit.framework.TestCase;

public class Assign5TestLevel4 extends TestCase {
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
	*				 FROM Student 
	*				 JOIN CourseEnroll 
	*				 WHERE CourseEnroll.courseID="COMP2021" 
	*				 ORDER BY id;*/
	
	public void testLevel4(){
	   int cnt = 0;
	   selectText = "Name";
       fromText = "Student";
       joinText = "CourseEnroll";
       whereText = "CourseEnroll.courseID=\"COMP2021\"";
       orderText = "id";
       
       tree = new FormRAtree(selectText,fromText,joinText,whereText,orderText);
       root = tree.structureTree();
       
       tuple = root.next();
       while(tuple != null){
       	if(next == false)
       		tuple = root.next();
			
			if(cnt == 0){
				assertTrue(tuple.getAttributeValue(0).equals("\"Eric\""));
				cnt++;
			}
			else if(cnt == 1){
				assertTrue(tuple.getAttributeValue(0).equals("\"Chris\""));
				cnt++;
			}
			else if(cnt == 2){
				assertTrue(tuple.getAttributeValue(0).equals("\"Chr\""));
				cnt++;
			}
			
			next = false;
       }
       assertTrue(cnt==3);
	}

}