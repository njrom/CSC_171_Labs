public class Heap {

    public void heapify(int[] arr){
        int i = arr.length/2 -1;
        while(i >= 0){
            buildHeap(arr, i, arr.length);
            i -= 1;
        }
    }
    private void buildHeap(int[] arr, int i, int size){
        while(i < size){
            int index = i;
            int left = 2*i+1;
            int right = left + 1;
            if(left < size && arr[left] > arr[index]){
                index = left;
            }
            if(right < size && arr[right] > arr[index]){
                index = right;
            }
            if(index == i) return;

            int temp = arr[i];
            arr[i] = arr[index];
            arr[index] = temp;
            i = index;
        }

    }
    public void heapsort(int[] arr){
        this.heapify(arr);
        for(int i = arr.length -1; i >= 0; i--){
            int swap = arr[0];
            arr[0] = arr[i];
            arr[i] = swap; // Move max element to the end of the array then heapify the rest...  rinse and repeat
            buildHeap(arr, 0, i);
        }

    }
}
