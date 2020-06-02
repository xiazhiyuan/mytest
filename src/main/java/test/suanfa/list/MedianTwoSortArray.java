package test.suanfa.list;

/**
 * @Author : xiazhiyuan
 * @Description :
 * 两个有序数组找出第k大的元素
 * @Date : 2020/5/28
 */
public class MedianTwoSortArray {
    public static void main(String[] args) {
        int[] a = new int[]{10,11,13,15,18,19};
        int[] b = new int[]{1,4 ,5 ,7 ,9};
        //1 ,2,3,4,4,5,6,7,8,9,10
        //5
        System.out.println(MedianTwoSortArray.search(a,b,11));;

    }

    /**
     * my
     * @param a
     * @param b
     * @return
     */
    public static int search(int a[],int b[],int k){
        int lengthA = a.length;
        int lengthB = b.length;
        if(lengthA == 0 && lengthB == 0){
            return 0;
        }
        if(lengthA == 0 ){
            return b[lengthB/2];
        }
        if(lengthB == 0){
            return a[lengthA/2];
        }
        int searchIndex = k-1;
        int maxIndex = 0;
        int medianValue = Math.min(a[0],b[0]);
        int indexA =  a[0]<=b[0]?1:0;
        int indexB = a[0]>b[0]?1:0;;
        while (true){
            if(indexA<lengthA && (indexB>=lengthB ||  a[indexA] < b[indexB])  ){
                if(a[indexA] >= medianValue){
                    maxIndex++;
                    medianValue = a[indexA];
                }
                indexA++;

            }else{
                if( b[indexB] >= medianValue ){
                    maxIndex++;
                    medianValue = b[indexB];
                }
                indexB ++;

            }
            if(maxIndex == searchIndex){
                return medianValue;
            }
        }
    }


}
