package com.bizpattern.example.jlang;

import java.util.ArrayList;

public class SampleGenerics {

	/**
	 * How to make method generic. You have to pass the method variable as generic.
	 * However, in order for the compiler to understand O in the method parameter is
	 * generic not a class type defined somewhere we have to tell that to the
	 * compiler. We do that by putting generic in the header. In this case we did
	 * put the I and O in header and after that if one of them O is referred as
	 * class type and compiler is able to distinguish.
	 * 
	 * @param <I>
	 * @param <O>
	 * @return
	 */

	public static <I, O> String genericMethod(O t) {
		return "A";
	}

	public static void main(String[] args) {
		System.out.println(genericMethod(new ArrayList<String>()));
	}

}
