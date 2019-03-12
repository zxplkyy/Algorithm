public class QuickSort {
    public void swap(int[] a, int i,int j){
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
    public int partition(int[] a, int start, int end){
        //以第一个元素作为标杆，比它小的放在它左边，大的放在它右边,找出它的位置
        int i = start, j = end+1;
        int x = a[start];
        while(true){
           while(a[++i] < x);
           while(a[--j] > x);
           if(i >= j)break;
           swap(a,i,j);
        }

        a[start] = a[j];
        a[j] = x;
        return j;
    }
    public void quickSort(int[] a, int start, int end){
        if(start < end){
            int q = partition(a,start,end);
            quickSort(a,start,q-1);
            quickSort(a,q+1,end);
        }
    }

    public static void main(String[] args) {
        int[] a = new int[]{3,1,3,5,6,4,2,7};
        QuickSort quickSort = new QuickSort();
        quickSort.quickSort(a, 0,a.length-1);
        //quickSort.partition(a,0,a.length-1);
        for(int elem: a) {
            System.out.println(elem);
        }


    }
}
