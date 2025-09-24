package com.product.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test extends Parent {

	public Test() {
		System.out.println("Child constructor");
	}
	
	public void draw() {
		super.draw();
		System.out.println("Child");
		// 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parent p = new Test();
		p.draw();
		
		System.out.println("******************");
		Test t = new Test();
		t.draw();

		List<String> words = Arrays.asList("cat", "dog", "lion", "bat", "tiger", "cat", "dog", "cat");
		Map<Integer, List<String>> map = words.stream().collect(Collectors.groupingBy(s -> s.length()));
		System.out.println(map);

		Map<String, Long> occurence = words.stream().collect(Collectors.groupingBy(s -> s, Collectors.counting()));
		System.out.println(occurence);
		
		List<String> words1 = List.of("eat", "tea", "ate", "ten", "net");
		Map<String, List<String>> anagramMap = new HashMap<>();

		for (String word : words1) {
			char[] chars = word.toCharArray();
			Arrays.sort(chars);
			String sortedWord = new String(chars); // Sorted characters form the key
			if(anagramMap.containsKey(sortedWord)) {
				List<String> l = anagramMap.get(sortedWord);
				l.add(word);
				anagramMap.put(sortedWord, l);
			}
			else {
				List<String> l = new ArrayList<>();
				l.add(word);
				anagramMap.put(sortedWord, l);

			}
			//anagramMap.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
		}
		
		System.out.println( new ArrayList<>(anagramMap.values())); 
		
		List<String> num = List.of("1one","two","3three");
			List<String> num1 = num.stream().filter(s->Character.isDigit(s.charAt(0))).toList();
		
		System.out.println(num1);
	}

}
