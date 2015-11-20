package simpledatabase;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Table extends Operator{
	public BufferedReader newBufferedReader = null;
	private BufferedReader br = null;
	private boolean getAttribute=false;
	private Tuple tuple;

	
	public Table(String from){
		this.from = from;
		
		//Create buffer reader
		try{
			br = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/datafile/"+from+".csv")));
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
		
	}

	
	/**
     * Create a new tuple and return the tuple to its parent.
     * Set the attribute list if you have not prepare the attribute list
     * @return the tuple
     */
	@Override
	public Tuple next(){
		newBufferedReader = new BufferedReader(new InputStreamReader(getClass().getResourceAsStream("/datafile/"+from+".csv")));
		boolean CheckAttribute = false;
		if(getAttribute == true){
			CheckAttribute = true;
		}else{
			CheckAttribute = false;
		}
		if(!CheckAttribute){
			try{
				String attLine = br.readLine();
				String dataLine = br.readLine();
				String tLine = br.readLine();
				tuple = new Tuple(attLine,dataLine,tLine);
				tuple.setAttributeName();
				tuple.setAttributeType();
				tuple.setAttributeValue();
				getAttribute = true;
			}catch(IOException e){
				e.printStackTrace();
			}
		}else{
			try{
				String tLine = br.readLine();

				if(tLine != null){
					try{
						String attributeLine = newBufferedReader.readLine();
						String dataTypeLine = newBufferedReader.readLine();
						tuple = new Tuple(attributeLine, dataTypeLine, tLine);
					}catch(IOException e){
						e.printStackTrace();
					}
					tuple.setAttributeName();
					tuple.setAttributeType();
					tuple.setAttributeValue();
				}else if(tLine == null){
					return null;
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}
		return tuple;
	}
	

	/**
     * The function is used to get the attribute list of the tuple
     * @return the attribute list
     */
	public ArrayList<Attribute> getAttributeList(){
		return tuple.getAttributeList();
	}
}