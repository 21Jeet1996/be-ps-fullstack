package com.product.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Employee {
	public static int countSubstring(String input, String target) {
		System.out.println( input.replace(target, ""));
		System.out.println( input.length());
		System.out.println( input.replace(target, "").length());

		return (input.length() - input.replace(target, "").length()) / target.length();
	}


	public static void main(String[] args) {

		  String a = "babababagcfdrabhabhufgabgdffgusabaugdyfaaababbbabcah"; // dynamic input
		    String sub = "aba";             // dynamic target

		    int count = countSubstring(a, sub);
		    System.out.println("Occurrences of '" + sub + "': " + count);

	}

}
