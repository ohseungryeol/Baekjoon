package Practice;

public class BinarySearchPrac {
    static int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    public static void main(String[] args) {
        int low =0;
        int high = arr.length-1;


        System.out.println(BinarySearch(8,low,high));
    }

    public static int BinarySearch(int key, int low, int high){
        while(low<=high){
            int mid = (low+high)/2;
            if(arr[mid]==key){
                return mid;
            } else if (arr[mid]<key){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }

        return -1;
    }
}
