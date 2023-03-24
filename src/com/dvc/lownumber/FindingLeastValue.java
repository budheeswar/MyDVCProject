package com.dvc.lownumber;

public class FindingLeastValue {

	public static void main(String[] args) {
		// number n1, n2
		String value1 = "23Pts";
		String value2 = "03Pts";

		//String s3 = value1.substring(0, 2);
		String s1=value1.replace("Pts", "");
		System.out.println("s1 "+s1);
		int n1=Integer.parseInt(s1);
		System.out.println("number n1 = "+n1 +" adding 2 "+(n1+2));
		if(n1 == 23) {
			System.out.println("pass");
		}
		
		String s2 = value2.substring(0, 2);
		int n2=Integer.parseInt(s2);
		
		int lower=(n1>n2)?n2:n1;
		System.out.println(lower);
		
		String s4="abcd";
		System.out.println(s4);
		if(s4 == "abcd") {
			s4="sdfghj";
			System.out.println(s4);
		}
		
		
		
	}

}
