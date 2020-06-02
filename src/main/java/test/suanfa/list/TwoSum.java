package test.suanfa.list;

import com.google.common.collect.Maps;

import java.util.Map;

/**
 * @Author : xiazhiyuan
 * @Description :
 * @Date : 2020/6/2
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] shus = new int[]{2,7,11,7,15};
        addToTarget(shus,14);
    }

    /**
     * Given an array of integers, find two numbers such that they add up to a specific target number.
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
     * You may assume that each input would have exactly one solution. Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     * 两数之和等于目标数
     * my
     * @param shus
     * @param target
     */
    public static void addToTarget(int[] shus,Integer target) {
        Map<Integer, Integer> map = Maps.newHashMap();
        for (int i = 0; i < shus.length; i++) {
            map.put(shus[i], i);
        }
        for (int i = 0; i < shus.length; i++) {
            if (map.get(target - shus[i]) != null && map.get(target - shus[i]) != i) {
                System.out.println("index1 =" + (i + 1) + " index2 = " + (map.get(target - shus[i]) + 1));
                break;
            }
        }
    }
}
