package LabNull.HashMap;
/**
 * Implementation of Hash Map.
 * @author Somsubhra
 *
 */

import java.util.ArrayList;

public class HashMap<I,J> {
	
	private ArrayList<I> keys;
	private ArrayList<J> values;
	
	/**
	 * Constructor of a hash map.
	 */
	public HashMap(){
		keys = new ArrayList<I>();
		values = new ArrayList<J>();
	}
	
	/**
	 * Sets the value of a key in the hash map.
	 * @param key The key to be inserted
	 * @param value The value to be associated with the key
	 */
	public void setValue(I key, J value){
		
		keys.add(key);
		values.add(value);
		
	}
	
	/**
	 * Finds the value of a key in hash map.
	 * @param key The key whose value is to be found
	 * @return The value of the key
	 */
	public J getValue(I key){
		
		if(keys.indexOf(key)==-1){
			return null;
		}
		return values.get(keys.indexOf(key));
	}
	
	/**
	 * Finds the size of hash map.
	 * @return The size of hash map
	 */
	public int getSize(){
		return keys.size();
	}
	
	/**
	 * Finds the key at the given index.
	 * @param index The index of the key
	 * @return The key at the index
	 */
	public I getKey(int index){
		return keys.get(index);
	}

	/**
	 * Converts the hash map to string.
	 */
	public String toString(){
		String displayString= "";
		for(int i=0; i<getSize(); i++){
			displayString = displayString + this.getKey(i)+" : "+this.getValue(this.getKey(i))+"\n";
		}
		return displayString;
	}
	
	/**
	 * Delete a particular key-value pair from hash map.
	 * @param key The key which has to be deleted
	 */
	public void delete(I key){
		int i = keys.indexOf(key);
		keys.remove(i);
		values.remove(i);
		
	}
}
