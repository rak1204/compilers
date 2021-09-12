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

public class Sym {
	public String symtype;
	
	public Sym(String type) {
		this.symtype = type;
		
	}
	
	public String getType() {
		return symtype;
	}
	
	public String toString() {
		return symtype;
	}
}
