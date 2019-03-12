public class HeapSort {
    //双亲节点大于子节点，当数组存储n个元素的堆时，叶节点的下标分别是n/2, n/2+1,n/2+2...,下标从0开始
    //O(nlogn)1.build heap 2. modify heap

    public void swap(int[] data,int i ,int j){
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    /***
     *
     * @param data 待排序数组
     * @param length
     * @param k 父节点位置
     */

//    public void HeapAdjust(int[] data, int length, int k) {
//
//        int temp = data[k];
//        int i = 2 * k + 1;
//        while (i < length) { //选取最小节点位置
//            if (i + 1 < length && data[i] > data[i + 1]) {
//                i++;
//            }
//            if (temp < data[i]) break; //保证父节点都小于子节点
//            data[k] = data[i];
//            k = i;
//            i = 2 * k + 1;
//        }
//        data[k] = temp;
//
//    }
    public void HeapAdjust(int[] data, int length,int k){
        int temp = data[k];
        int i = 2*k + 1;
        while(i < length){
            if(i+1 < length && data[i] < data[i+1]){
                i++;
            }
            if(temp > data[i])break;
            data[k] = data[i];
            k = i;
            i = 2*k + 1;
        }
        data[k] = temp;
    }


    public void heapSort(int[] data, int length) {
        if (data == null || length <= 0) return;
        for (int i = length / 2 - 1; i >= 0; --i) {
//            HeapAdjust(data, length, i);//从倒数第二层开始调整，保证每一层的父节点都大于子节点
            HeapAdjust(data,length,i);
        }
        //此时，最小点就在堆顶，即数组第一个元素
        for(int i = length -1; i>=0;--i){
            swap(data,0,i);
//            HeapAdjust(data,i,0);
            HeapAdjust(data,i,0);//每次都从第1层开始调整，保证第一层元素最大/小
        }
        return;

    }

    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();

        int[] data = new int[]{24,56,12,34,78,32};
        int length = data.length;
        heapSort.heapSort(data,length);
        for(int num:data){
            System.out.print(num+" ");
        }
    }
}
