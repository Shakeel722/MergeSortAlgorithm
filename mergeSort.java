public class mergeSort {

    // time complexity is O(nlogn).


    public static void divide(int[] arr , int si , int ei){ 

// since we are using divide and conquer 


// base case 
if(si >= ei){
    return;
}


    // Divide our array 

 int mid = (si + ei) / 2;
 divide(arr, si , mid);
 divide(arr, mid+1, ei);


 // Conquer our array and merge it doing sorting
 conquer(arr, si, mid, ei );




    }

    public static void conquer(int[] arr, int si,  int mid , int ei){

        int merged[] = new int[ei-si+1];

        int idx1 = si; // to track the left part of array 
        int idx2 = mid + 1; // to track the right part of array
        int x = 0; // to track our merged array index

        // sorting 

        while (idx1 <= mid && idx2<= ei) {
            
        
        if(arr[idx1] <= arr[idx2]){ // when idx1(left) element is larger 

            merged[x ++] = arr[idx1++];
        } 
        else{ 
            // when idx2(right) element is larger

            merged[x++] = arr[idx2++];
        }


        // copying the remaining elements after comparisions 

        while(idx1 <= mid){
            merged[x++] = arr[idx1++];

        }

        while(idx2 <= ei){
            merged[x++] = arr[idx2++];
        }

    }

    // copying original elements from the merged array



    for(int i=0 ,  j= si; i<merged.length ; i++, j++){
        arr[j] = merged[i];
    }
    }


    public static void main(String[] args){

        int[] nums = { 3, 24, 2, 45, 90};
       int  n = nums.length;

        // calling my merge sort method
        divide(nums,0 , n-1);

        // printing array
        for(int i: nums){
            System.out.print(i + " ");
        }
    }


    
}