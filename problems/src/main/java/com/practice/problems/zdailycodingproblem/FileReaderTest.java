package com.practice.problems.zdailycodingproblem;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Callable;

import org.springframework.util.StringUtils;

public class FileReaderTest implements Callable<Map<String, Map<String, Integer>>> {

	String fileName;

	FileReaderTest(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public Map<String, Map<String, Integer>> call() throws Exception {

		Map<String, Map<String, Integer>> map = new TreeMap<>();
		File file = new File(this.fileName);
		BufferedReader b = new BufferedReader(new FileReader(file));
		b.readLine();
		String st;
		while ((st = b.readLine()) != null) {
			if (!StringUtils.isEmpty(st)) {
				String[] strInfo = st.split(" ");
				String time = strInfo[1];
				String exception = strInfo[2];
				if (map.containsKey(time)) {
					Map<String, Integer> exp = map.get(time);
					if (exp.containsKey(exception)) {
						exp.put(exception, (exp.get(exception)) + 1);
					} else {
						exp.put(exception, 1);
					}
				} else {
					Map<String, Integer> exp = new HashMap<>();
					exp.put(exception, 1);
					map.put(time, exp);
				}
			}
		}
		return map;
	}
}
