import java.lang.Exception;
public class BinarySearch {

    public int lower_bound(int[] data,int k) throws  Exception{
        //返回第一个大于等于目标值所在的位置
        if(data.length == 0) throw new Exception("There is no data");
        else{
            int start = 0;
            int last = data.length-1;
            while(start < last){
                int mid  = (start + last)/2;
                if(data[mid] >= k) last = mid;
                else{
                    start = mid + 1;
                }
            }
            return start;

        }


    }
    public int upper_bound(int[] data,int target) throws Exception{
        //返回第一个大于等于目标值的位置
        if(data.length == 0) throw new Exception("There is no data");
        else{
            int start = 0, last = data.length -1;
            while(start < last){
                int mid = (start + last) / 2;
                if(target >= data[mid]){
                    start = mid+1;
                }else{
                    last = mid;
                }

            }
           return start;
        }


    }
    public int binSearch(int[] data,int key){
        //折半查找非递归方式
        int start = 0, last = data.length - 1;
        while (start <= last){
            int mid = (start + last)/2;
            if(data[mid] == key){
                return mid;
            }else if(data[mid]> key){
                last = mid -1;
            }else{
                start = mid + 1;
            }

        }
        return -1;
    }
    public int binSearch(int[] data, int start, int end,int key){
        //折半查找递归实现
        int mid = (start + end)/2;
        if(data[mid] == key) return mid;
        if(start >= end) return -1;
        else if(key > data[mid]) return binSearch(data,mid+1,end,key);
        else if(key < data[mid]) return binSearch(data,start,mid-1,key);
        return -1;
    }

    public static void main(String[] args) throws  Exception{
        int[] data = new int[]{1,2,3,4,4,4,5,8};
        BinarySearch binarySearch = new BinarySearch();
        //System.out.println(binarySearch.lower_bound(data,4));
        //System.out.println(binarySearch.upper_bound(data,4));
        System.out.println(binarySearch.binSearch(data,5));
        System.out.println(binarySearch.binSearch(data,0,7,4));

    }
}
