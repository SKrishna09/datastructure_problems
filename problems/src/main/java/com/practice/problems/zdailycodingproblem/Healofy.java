package com.practice.problems.zdailycodingproblem;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.springframework.util.CollectionUtils;

public class Healofy {

	public static void main(String[] args) throws IOException, InterruptedException, ExecutionException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter How many Files You Want to Add");
		int nofiles = Integer.parseInt(br.readLine());
		ArrayList<File> list = new ArrayList<>(nofiles);

		for (int i = 0; i < nofiles; i++) {
			System.out.println("Enter File Name :::");
			File file = new File(br.readLine());
			list.add(file);
		}
		System.out.println(list);

		List<FileReaderTest> l = new ArrayList<>();
		List<Future<Map<String, Map<String, Integer>>>> result = new ArrayList<>();
		Map<String, Map<String, Integer>> processResult = new TreeMap<>();

		for (File file : list) {
			l.add(new FileReaderTest(file.getAbsolutePath()));
		}

		// Process each file and store results
		// For parallel processing use ExecutorService - no of files to be processed
		// simultaneously to be 5.
		ExecutorService executor = Executors.newFixedThreadPool(5);
		for (int i = 0; i < list.size(); i++) {
			result.add(executor.submit(l.get(i)));
		}

		// Combined Output
		for (int i = 0; i < result.size(); i++) {
			Map<String, Map<String, Integer>> temp = result.get(i).get();
			for (Map.Entry<String, Map<String, Integer>> entry : temp.entrySet()) {
				String key = entry.getKey();
				Map<String, Integer> val = entry.getValue();
				if (processResult.containsKey(key)) {
					Map<String, Integer> exceptions = processResult.get(key);
					if (CollectionUtils.isEmpty(exceptions)) {
						processResult.put(key, val);
					} else {
						for (Map.Entry<String, Integer> in : val.entrySet()) {
							String key1 = in.getKey();
							Integer val1 = in.getValue();
							if (exceptions.containsKey(in.getKey())) {
								exceptions.put(key1, (exceptions.get(key1)) + val1);
							} else {
								exceptions.put(key1, val1);
							}
						}
					}
				} else {
					processResult.put(key, val);
				}
			}
		}

		// print output
		for (Map.Entry<String, Map<String, Integer>> entry : processResult.entrySet()) {
			String key = entry.getKey();
			Map<String, Integer> value = entry.getValue();
			for (Map.Entry<String, Integer> in : value.entrySet()) {
				System.out.println(key + " " + in.getKey() + " " + in.getValue());
			}
		}
		executor.shutdown();
	}
}
