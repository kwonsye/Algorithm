package pck1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Test2 {

	public static void customSort(int[] arr) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		HashMap<Integer, List<Integer>> listmap = new HashMap<Integer, List<Integer>>();

		for (int component : arr) {
			if (!map.containsKey(component))
				map.put(component, 1);
			else
				map.replace(component, map.get(component) + 1);
		}

		for (int key : map.keySet()) {
			int count = map.get(key);
			List<Integer> list=new ArrayList<Integer>();
			if (!listmap.containsKey(count)) {
				list.add(key);
				listmap.put(count, list);
			}
			// 있으면
			else
				listmap.get(count).add(key);
		}
		
		
		//출력
		for(int key:listmap.keySet()) {
			Collections.sort(listmap.get(key));

			Iterator<Integer> iterator=listmap.get(key).iterator();
			while(iterator.hasNext()) {
				int value=iterator.next();
				for(int count=0;count<key;count++)
					System.out.println(value);
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		customSort(new int[] {1,3,4,58000000});
	}

}
