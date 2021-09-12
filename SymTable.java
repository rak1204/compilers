///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            P1
// Files:            SymTable, Sym, DuplicateSymException, EmptySymTableException, WrongArgumentException
// Semester:         spring 2019
//
// Author:           Rahil Kakar
// Email:            kakar@wisc.edu
// CS Login:         rahil
// Lecturer's Name:  Loris D'Antoni
     
import java.util.*;
public class SymTable {
	
	private LinkedList<HashMap<String,Sym>> symTable;
	
	//constructor for symtable
	public SymTable() {
		symTable = new LinkedList<HashMap<String,Sym>>();
		
		symTable.addFirst(new HashMap<String,Sym>());
	}
	//add idname and sym to first hashmap in symtable
	public void addDecl(String idName, Sym sym)throws DuplicateSymException, 
	EmptySymTableException, 
	WrongArgumentException {
		

		//check empty
		if(symTable.size() <= 0)
		{
			throw new EmptySymTableException();
		}
		//check both idname and sym
		if(idName == null && sym == null )
		{	
			throw new WrongArgumentException("Id name and sym are null.");
		}
		
		//check idname
		if(idName == null )
		{	
			throw new WrongArgumentException("Id name is null.");
		}
		//check sym
		if(sym == null)
		{	
			throw new WrongArgumentException("Sym is null.");
		}
		
		// Check for duplicates
		if(symTable.peek().containsKey(idName))
		{
			throw new DuplicateSymException();
		}
		
		
		
		symTable.peek().put(idName, sym);
		
		
	}
	
	public void addScope() {
		
		symTable.addFirst(new HashMap<String,Sym>());
	}
	
	public Sym lookupLocal(String idName) 
			throws EmptySymTableException
	{
		
		if(symTable.size() < 1)
			throw new EmptySymTableException();
		
		
		return symTable.peek().get(idName);

		
	}
	//Return sym for the specific idname
	public Sym lookupGlobal(String idName) 
			throws EmptySymTableException
	{
		
        for(HashMap<String,Sym> temp : symTable)

        {

        	Sym check = temp.get(idName);

        	if(check != null)
        	{
        		return check;
        	}
        }
        
		return null;
		
	}
	
	
	 //	Remove the HashMap from the front of the list.
	// 	@throws EmptySymTableException - when no HashMaps to remove
	public void removeScope() 
			throws EmptySymTableException
	{
		if(symTable.size() < 1)
			throw new EmptySymTableException();

		symTable.remove();
	}
	
	//Prints sym table 
	public void print() {
		
        String output = "\n=== Sym Table ===\n";

        for(HashMap<String,Sym> temp : symTable)

        	{

        		output = output + (temp.toString() + "\n");

        	}
        output = output + "\n";
        System.out.print(output);
		
	}

	
}
