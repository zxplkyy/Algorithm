public class MergeSort {
    //一个数组有n个数据，把这个数组看作是n个有序的子序列，每个子序列长度为1，然后两两归并，得到[n/2]个长度为2的子序列，然后再继续
    //时间复杂的O(nlogn) 空间：递归O(n+logn) 非递归：O(n)
    //每次都合并两个有序的数组
    public static void mergeSort(int[] data, int low,int high){
        int mid = (low + high) /2;
        if(low < high){
            mergeSort(data,low,mid);
            mergeSort(data,mid+1,high);
            merge(data,low,mid,high);

        }
    }
    public static void mergeSort2(int[] data){
        int length = data.length;
        int k = 1;
        while(k < length){
            mergePass(data,k,length);
            k*=2;
        }
    }
    private static void mergePass(int[] data,int k,int n){
        //将数组中的相邻的有k个元素的字序两两
        int i= 0;
        while(i<n-2*k+1){
            merge(data,i,i+k-1,i+2*k-1);
            i += 2*k;
        }
        if(i<n-k) merge(data,i,i+k-1,n-1); //合并不足k的部分

    }
    private static void merge(int[] data, int low, int mid,int high){
        //合并两个有序数组
        int[] temp = new int[high-low+1];
        int i = low, j = mid+1,k=0;
        //将记录由小到大放进temp数组
        for(;i<=mid&&j<=high;k++){
            if(data[i] < data[j]){
                temp[k] = data[i++];
            }else{
                temp[k] = data[j++];
            }
        }
        while(i<=mid) temp[k++] = data[i++];
        while (j<=high) temp[k++] = data[j++];
        //将temp中的元素写入待排数组中
        for(int l=0;l < temp.length;l++){
            data[low+l] = temp[l];
        }
    }


    public static void main(String[] args) {
        int[] data = new int[]{23,45,67,21,12,34,18,25};
        //mergeSort(data,0,data.length-1);
        mergeSort2(data);
        for(int num:data){
            System.out.print(num+" ");
        }
    }
}
