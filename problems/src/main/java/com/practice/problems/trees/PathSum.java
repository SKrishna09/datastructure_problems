package com.practice.problems.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class PathSum {

	public static TreeNode root;

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
			left = null;
			right = null;
		}
	}

	public static void main(String[] args) {
		PathSum tree = new PathSum();
		tree.root = new TreeNode(1);
		tree.root.left = new TreeNode(2);
		tree.root.right = new TreeNode(3);
		tree.root.left.left = new TreeNode(4);
		tree.root.left.right = new TreeNode(5);
		LinkedList<Integer> sub = new LinkedList<>();
		//hasPathSum(root, sub, 0, 7);
		System.out.println("TreePathSum::" + hasSum);
		
		List<Integer> l = new ArrayList<Integer>();
		l.add(10);
		l.add(20);
		l.add(7);
		System.out.println(minSum(l,4));
	}

	static boolean hasSum = false;
	public static void hasPathSum(TreeNode A, LinkedList<Integer> sub, int sum, int B) {
		if (null == A)
			return;
		sub.addLast(A.val);
		sum += A.val;
		if (null == A.left && null == A.right) {
			if (sum == B) {
				hasSum = true;
				return;
			}
		} else {
			hasPathSum(A.left, sub, sum, B);
			hasPathSum(A.right, sub, sum, B);
			sum -= sub.getLast();
			sub.removeLast();
		}
	}
	
	public static int goodSegment(List<Integer> badNumbers, int l, int r) {
        Collections.sort(badNumbers);
        
        Integer prevnumber = null;
        Integer currnumber = null;
        Integer diff = Integer.MIN_VALUE;
        Integer lastDiff = null;
        int j = 0;
        for(Integer i : badNumbers){
            if(i >= l && i <= r){
                if(j == 0){
                    if(l < i){
                        diff = (i-1) - l;
                    }
                    currnumber = i-1;
                }else{
                    prevnumber = currnumber;
                    currnumber = i - 1;
                }
                j++;
            }
            if((null != prevnumber && null != currnumber) && prevnumber >=0 && currnumber >=0){
                int d = currnumber - prevnumber;
                if(d > diff)
                    diff = d;
                if(r >= i){
                    lastDiff = r - (i-1); 
                }    
            }
        }
        if(lastDiff > diff)
        	diff = lastDiff;
        return diff;
}

	public static int minSum(List<Integer> num, int k) {
		 Collections.sort(num);
	        int count = k;
	        
	        int j = 0;
	        Integer[] ar = new Integer[num.size()];
	        for(Integer i : num){
	            ar[j] = i;
	            j++;
	        }
	         Arrays.sort(ar, Collections.reverseOrder());

	        /*for(int x = 0; x < ar.length; x++){
	             int val = ar[x];
	                Double ans = Math.ceil(val/2); 
	                ar[x] = ans.intValue();
	                 Arrays.sort(ar, Collections.reverseOrder());
	                count--;
	                x--;
	                if(count == 0)
	                break;
	        }*/
	         for(int x = 0; x < ar.length; x++){
	             	int val = ar[x];
	                Double ans = Math.ceil(val/2);
	                int an;
	                if(val % 2 == 0) {
	                	an = ans.intValue();
	                }else {
	                	an = ans.intValue()+1;
	                }
	                ar[x] = an;
	                Arrays.sort(ar, Collections.reverseOrder());
	                count--;
	                x--;
	                if(count == 0)
	                break;
	        }

	        int sum = 0;
	        for(int y = 0; y < ar.length; y++){
	                sum+= ar[y];
	        }
	        return sum; 
    }

}
