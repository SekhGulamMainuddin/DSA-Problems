public class BubbleSort {
    public static void main(String[] args) {
        int arr[]={9,8,7,6,5,4,3,2,1};
        bubbleSort(arr,arr.length);
        for(int i=0;i<9;i++)
            System.out.print(arr[i]+" ");
    }

    private static void bubbleSort(int[] arr, int size) {
        if(size <= 1) {
            return;
        }

        for(int i=0; i<size-1; i++) {
            int temp = arr[i];
            arr[i] = arr[i+1];
            arr[i+1] = temp;
        }

        bubbleSort(arr, size-1);
    }
}