import java.util.ArrayList;
import java.util.List;
public class ArrayOperator {
    public static int maxSum(int[]a){
        //最大字段和，主要是考虑负数
        int curr_sum = 0;
        int max_sum =0;
        for(int i =0; i< a.length;i++){
            if(curr_sum + a[i] < 0){
                curr_sum = 0;
            }else{
                curr_sum += a[i];
                max_sum = Math.max(max_sum,curr_sum);
            }
        }
        return max_sum;
    }
    public static int maxProduct(int[] a){
        //要注意考虑负数的情况
        int maxProduct=1; //保留正数的结果
        int minProduct = 1;//保留负数的结果
        int r = 1;
        for(int i=0;i<a.length;i++){
            if(a[i] > 0){
                maxProduct *= a[i];
                minProduct = Math.min(minProduct*a[i],1);
            }else if(a[i] == 0){
                maxProduct = 1;
                minProduct = 1;
            }else{
                int temp = maxProduct;
                maxProduct = Math.max(minProduct*a[i],1);
                minProduct = temp * a[i];
            }
            r = Math.max(r,maxProduct);
        }
        return r;
    }

    public static int maxDiffSubArrays(int[] nums){
        //左边最大子段和减去右边最小子段；左边最小子段和减去右边最大子段
        //最大子数组差
        int result = 0;
        if(nums==null || nums.length ==0)return 0;
        int length = nums.length;
        int[] max_left = new int[length];  //用于存放最大子段和
        int curr_num = 0;
        max_left[0] = nums[0];
        for(int i =1;i<length;i++){
            curr_num += nums[i];
            max_left[i] = Math.max(curr_num,max_left[i-1]);
            if(curr_num < 0) curr_num = 0;

        }
        int[] min_left =  new int[length]; //用于存放最小子段和
        curr_num = 0;
        min_left[0] = nums[0];
        for(int i = 1;i<length;i++){
            curr_num += nums[i];
            min_left[i] = Math.min(curr_num,min_left[i-1]);
            if(curr_num > 0) curr_num = 0;
        }
        int[] max_right = new int[length];
        curr_num = 0;
        max_right[length-1] = nums[length-1];
        for(int i = length-2; i>=0;i--){
            curr_num += nums[i];
            max_right[i] = Math.max(curr_num,max_right[i+1]);
            if(curr_num < 0) curr_num = 0;
        }
        int[] min_right = new int[length];
        curr_num = 0;
        min_right[length-1] = nums[length -1];
        for(int i = length-2;i>=0;i--){
            curr_num += nums[i];
            min_right[i] = Math.min(curr_num,min_right[i+1]);
            if(curr_num > 0) curr_num = 0;
        }
        for(int i =0 ;i< length-1 ;i++){
            result = Math.max(Math.abs(max_left[i]-min_right[i+1]),result);
            result = Math.max(Math.abs(min_left[i]-max_right[i+1]),result);
        }
         return result;
     }
    public static int[] maxSubArrays(int[] nums){
        //
        int length = nums.length;
        int[] max_left = new int[length];//用于保存每一个位置的最大子段和
        max_left[0] = nums[0];
        for(int i = 1; i< length;i++){
            if(max_left[i-1]<0 || max_left[i-1]+nums[i]<0){
                max_left[i] = nums[i];
            }else{
                max_left[i] = max_left[i-1]+nums[i];
            }
    }
        return max_left;
    }
    public static int maxTwoSubArrays(List<Integer> nums){
        //找出两个不重叠的子数组，使他们的和最大
        int size = nums.size();
        if(size ==0) return 0;
        int[] right = new int[size]; //用于保存右边每一个位置的最大字段和
        right[size -1] = nums.get(size-1);
        int curr_num = nums.get(size-1);
        for(int i = size-2;i >=0;i--){
            curr_num += nums.get(i);
            right[i] = Math.max(curr_num,right[i+1]);
            if(curr_num < 0) curr_num = 0;
        }

        int localMax = Integer.MIN_VALUE;
        int globalMax = Integer.MIN_VALUE;
        curr_num = 0;
        for(int i =0;i<nums.size()-1;i++){
            curr_num += nums.get(i);
            localMax = Math.max(localMax,curr_num);// 数组左边最大子段和
            globalMax = Math.max(globalMax,localMax+right[i+1]);
            if(curr_num < 0){
                curr_num = 0;
            }
        }
        return globalMax;
    }

    public static void main(String[] args) {
        int[] a = new int[]{2,3,-2,-4,5,6,-7,3,5};
        List<Integer> arrayList = new ArrayList<>();
        for(int num: a){
            arrayList.add(num);
        }
       // System.out.println(maxSum(a));
       // System.out.println(maxProduct(a));
       // System.out.println(maxTwoSubArrays(arrayList));
        System.out.println(maxDiffSubArrays(a));

    }
}
