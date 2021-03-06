package com.abhi.tutorial.bloomberg;

import java.util.HashMap;
import java.util.Map;

public class SubArraySum {
    public static int subarraySum(int[] nums, int k) {
        int count = 0, sum = 0;
        Map<Integer,Integer > map = new HashMap <> ();
        map.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k))
                count += map.get(sum - k);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        int[] in = {1,-1,0};
        System.out.println(subarraySum(in, 0));
    }
}
