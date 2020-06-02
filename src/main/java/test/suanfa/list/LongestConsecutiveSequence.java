package test.suanfa.list;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Author : xiazhiyuan
 * @Description :
 * @Date : 2020/5/29
 */
public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] shus = new int[]{4,8,3,9,13,12,11,5,7};
        System.out.println("======================"+longestConsecutive(shus)) ;
    }

    /**
     * 找出给定数组中最长的连续数列，返回长度
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     * For example, Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
     * my
     * @param shus
     * @return
     */
    public static int longestConsecutive(int[] shus){
        Map<Integer,Boolean> countMap = Maps.newHashMap();
        for(int shu:shus){
            countMap.put(shu,true);
        }
        int totalMax = 1;
        for (int shu:shus){
            int max = 1;
            int j = 1;
            while (countMap.get(shu+j) !=null && countMap.get(shu+j)){
                max++;
                j++;
            }
            totalMax = Math.max(totalMax,max);
        }

        return totalMax;
    }
}
