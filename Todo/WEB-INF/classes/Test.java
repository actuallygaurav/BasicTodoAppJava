import java.util.ArrayList;
import java.util.*;
//import static java.lang.System.out;

class Test {

	public static void main(String[] args) {

		int arr[] = new int[] {1, 2, 4, 5};

		boolean res = new Solution().containsDublicate(arr);

		System.out.println(res);
	}
}



class Solution {

	public boolean containsDublicate(int[] nums) {

		List<Integer> l = new ArrayList<Integer>();

		for(int i: nums) {
			if(l.contains(i)) {
				return true;
			} else {
				l.add(i);
			}
		}


		return false;

	}
}
