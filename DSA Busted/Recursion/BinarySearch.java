public class BinarySearch {

    public static void main(String[] args) {
        int arr[]={2,4,5,7,8,9,444,555,2214,6641,82235,99998};
        if (binarySearch(arr,0,arr.length-1,6641))
            System.out.println("Element Found");
        else 
            System.out.println("Element Not Found");
    }

    private static boolean binarySearch(int arr[],int lb,int ub, int key){

        if (ub<lb)
            return false;
    
        int mid=lb+(ub-lb)/2;
        if(arr[mid]==key)
            return true;
        else if(arr[mid]>key)
            return binarySearch(arr,lb,mid-1,key);
        else
            return binarySearch(arr,mid+1,ub,key);
    }
}
