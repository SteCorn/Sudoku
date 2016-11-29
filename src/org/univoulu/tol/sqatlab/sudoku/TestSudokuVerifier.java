package org.univoulu.tol.sqatlab.sudoku;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestSudokuVerifier {
	
	SudokuVerifier sudoku = new SudokuVerifier();
	String correct="417369825632158947958724316825437169791586432346912758289643571573291684164875293";
	String incorrect="123456789912345678891234567789123456678912345567891234456789123345678912234567891";
	String incString_1 = "123456789 ";
	String incString_2 = " 123456789";
	String incString_3 = "12345b6789";
	String incString_4 = "12345 6789";
	
	@Test
	public void verifytest(){
		assertEquals(0,sudoku.verify(correct));
		assertEquals(-2,sudoku.verify(incorrect));
	}
	
	@Test
	public void isnumerictest() {
		//assertEquals(0,sudoku.verify(correct));
		//assertEquals(0,sudoku.verify(incorrect));
				
		
		assertEquals(true, sudoku.isnumber(correct));
		assertEquals(false, sudoku.isnumber(incString_1));
		assertEquals(false, sudoku.isnumber(incString_2));
		assertEquals(false, sudoku.isnumber(incString_3));
		assertEquals(false, sudoku.isnumber(incString_4));
	}
	
	@Test
	public void isonceingrid(){
		
		assertEquals(true, sudoku.isonceingrid(correct));
		assertEquals(false, sudoku.isonceingrid(incorrect));
		
	}
	
	@Test
	public void isonceinrow(){
		
		String incorow="123456789912345678891234567789123456678912345567891234456789123345678912234567899";
		assertEquals(true, sudoku.isonceinrow(correct));
		assertEquals(true, sudoku.isonceinrow(incorrect));
		assertEquals(false, sudoku.isonceinrow(incorow));
	}
	
	@Test
	public void isonceincolumn(){
		
		String incolumn="123456789912345678891234567789123456678912345567891234456789123345678911234567891";
		
		assertEquals(true, sudoku.isonceincolumn(correct));
		assertEquals(true, sudoku.isonceincolumn(incorrect));
		assertEquals(false, sudoku.isonceincolumn(incolumn));
	}
	
	@Test
	public void singlenumber(){
		
		String cor1="123456789";
		String inc1="0123456789";
		String inc2="1234567893";
		
		assertEquals(false, sudoku.singlenumber(inc2));
		assertEquals(false, sudoku.singlenumber(inc1));
		assertEquals(true, sudoku.singlenumber(cor1));
		
	}
	
}
