package com.tca;

import java.io.Serializable;

class A implements Serializable
{
     private int i=11;
     private int j=22;
     
     
	@Override
	public String toString() {
		return "A [i=" + i + ", j=" + j + "]";
	}
 
}

public class Demo
{
	public static void main(String[] args)
	{	
		A ob = new A();
		System.out.println(ob);

	}

}
