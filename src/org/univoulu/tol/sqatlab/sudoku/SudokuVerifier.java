package org.univoulu.tol.sqatlab.sudoku;

import com.sun.xml.internal.ws.util.StringUtils;

public class SudokuVerifier {

	public int verify(String candidateSolution) {
		// returns 1 if the candidate solution is correct
		int validity = 0;
		
			if (isnumber(candidateSolution) == false){
				validity = -1;
				}else if (isonceingrid(candidateSolution) == false){
					validity = -2;
				}else if (isonceinrow(candidateSolution) == false){
					validity = -3;
				}else if (isonceincolumn(candidateSolution) == false){
				validity = -4;
				}
		
		return validity;
	
	}
	

	public boolean isnumber(String candidateSolution){
		boolean result=true;
		int i=0;
		
		char[] numberstring;
		numberstring=candidateSolution.toCharArray();
		
		for(i=0;(i<numberstring.length && result);i++){
			if(Character.isDigit(numberstring[i])==false){
				result=false;
			}
		}
		return result;
	}
	
	
	public boolean isonceingrid(String candidateSolution){
		
		boolean result=true;
		String[] grid= new String[9];
		grid=creategrid(candidateSolution);
		int i=0;
		
		for(i=0;i<grid.length;i++){
			if(singlenumber(grid[i])==false){
				result=false;
			}
		}
		return result;
	}

	public boolean isonceinrow(String candidateSolution) {
		boolean result=true;
		
		String[] row= new String[9];
		row=createrow(candidateSolution);
		int i=0;
		
		for(i=0;i<row.length;i++){
			if(singlenumber(row[i])==false){
				result=false;
			}
		}
		return result;
	}


	public boolean isonceincolumn(String candidateSolution) {
		boolean result=true;
		
		String[] column= new String[9];
		column=createcolumn(candidateSolution);
		int i=0;
		
		for(i=0;i<column.length;i++){
			if(singlenumber(column[i])==false){
				result=false;
			}
		}
		return result;
	}


	private String[] creategrid(String candidateSolution) {
		String[] grid= new String[9];
		
		int i,j,k,jump,count=0;
		
		for(i=0;i<9;i++){
			grid[i]="";
		}
		
		char[] numberstring;
		numberstring=candidateSolution.toCharArray();
		jump=0;
		for(k=0;k<9;k++){			
			for(i=jump;i<numberstring.length && count<3;i+=9){
				count++;
				for(j=i;j<(i+3);j++){
					grid[k]=grid[k]+numberstring[j];
					
				}
			}
			count=0;
			jump=jump+3;
			
			if(jump==9||jump==36||jump==63){
				jump=jump+18;
			}
				
		}
			
		return grid;
	}
	
	
	private String[] createrow(String candidateSolution) {
		String[] row= new String[9];
		
		int i,j,k,jump,count=0;
		
		for(i=0;i<9;i++){
			row[i]="";
		}
		
		char[] numberstring;
		numberstring=candidateSolution.toCharArray();
		jump=0;
		for(k=0;k<9;k++){			
			for(i=jump;i<numberstring.length && count<9;i+=9){
				for(j=i;j<(i+9);j++){
					row[k]=row[k]+numberstring[j];
					count++;
				}
			}
			count=0;
			jump=jump+9;			
		}
			
		return row;
	}

	private String[] createcolumn(String candidateSolution) {
		String[] column= new String[9];
		
		int i,j,k,jump,count=0;
		
		for(i=0;i<9;i++){
			column[i]="";
		}
		
		char[] numberstring;
		numberstring=candidateSolution.toCharArray();
		jump=0;
		for(k=0;k<9;k++){			
			for(i=jump;i<9 && count<9;i++){
				for(j=i;j<numberstring.length;j+=9){
					column[k]=column[k]+numberstring[j];
					count++;
				}
			}
			count=0;
			jump++;			
		}
			
		return column;
	}

	
	

	public boolean singlenumber(String string) {
		boolean result=true;
		int i,j=0;
		
		char[] numberstring;
		numberstring=string.toCharArray();
		for(i=0;i<numberstring.length;i++){
			for(j=i+1;j<numberstring.length && result;j++){
				if(numberstring[i]==numberstring[j]){
					result=false;
				}
			}
		}
		
		return result;
	}
}

