import java.util.*;
import java.io.*;
public class MyHeap{
    //We discussed these 2 methods already:
    public static void main(String[] args) {
        int[] test = new int[]{1,5,7,8,1,5,9,12,125,7554,234,-1,4,0,2,5};
        System.out.println((Math.log(test.length)/Math.log(2))+1);
        //System.out.println(Math.pow(2,((int)(Math.log(test.length)/Math.log(2))))/2);
        //heapify(test);
        heapPrint(test);
        test = new int[]{1,5,7,8,1,5,9,12,125,7554,234,-1,4,0,2};
                System.out.println((int)(Math.log(test.length)/Math.log(2))+1);
        test = new int[]{1,5,7,8,1,5,9,12,125,7554,234,-1,4,0,2,5,1};
                System.out.println((int)(Math.log(test.length)/Math.log(2))+1);

        //heapsort(test);
        System.out.println(Arrays.toString(test));
    }
    private static void heapPrint(int[] data){
        int count = 1;
        for(int i = 0, j = 0; j < data.length; i++, j++){
            if(i >= count){
                count = count * 2;
                i = 0;
                System.out.println();
            }
            System.out.print(data[j] + " ");
        }
    }
    private static void pushDown(int[]data,int size,int index){
        for( int i = index; (i * 2) + 1 < size; i = (i * 2) + 1){
            if(!((i * 2) + 2 < size)){
                if (data[i] < data[(i * 2) + 1]){
                    int hold = data[(i * 2) + 1];
                    data[(i * 2) + 1] = data[i];
                    data[i] = hold;
                }
            } else if (data[(i * 2) + 1] < data[(i * 2) + 2] && data[i] < data[(i * 2) + 2]){
                int hold = data[(i * 2) + 2];
                data[(i * 2) + 2] = data[i];
                data[i] = hold;
            } else{
                if(data[i] < data[(i * 2) + 1]){
                    int hold = data[(i * 2) + 1];
                    data[(i * 2) + 1] = data[i];
                    data[i] = hold;
                }
            }
        }
    }

    private static void BpushDown(int[]data,int size,int index){
        for( int i = index; (i * 2) + 1 < size; i = (i * 2) + 1){
            if(!((i * 2) + 2 < size)){
                if (data[i] < data[(i * 2) + 1]){
                    int hold = data[(i * 2) + 1];
                    data[(i * 2) + 1] = data[i];
                    data[i] = hold;
                }
            } else if (data[(i * 2) + 1] < data[(i * 2) + 2]){
                int hold = data[(i * 2) + 2];
                data[(i * 2) + 2] = data[i];
                data[i] = hold;
            } else{
                int hold = data[(i * 2) + 1];
                data[(i * 2) + 1] = data[i];
                data[i] = hold;
            }
        }
    }
    /*
     - size  is the number of elements in the data array.
     - push the element at index i downward into the correct position. This will swap with the larger of the child nodes provided thatchild is larger. This stops when a leaf is reached, or neither child is larger. [ should be O(logn) ]
     - precondition: index is between 0 and size-1 inclusive
     - precondition: size is between 0 and data.length-1 inclusive.
*/
     private static void pushUp(int[]data,int index){
         for(int i = index; (i - 1) / 2 < data.length && data[i] > data[(i - 1) / 2]; i = (i - 1) / 2){
             int hold = data[(i - 1) / 2];
             data[(i - 1) / 2] = data[i];
             data[i] = hold;
         }
     }
     //- push the element at index i up into the correct position. This will swap it with the parent node until the parent node is larger or the root is reached. [ should be O(logn) ]
    // - precondition: index is between 0 and data.length-1 inclusive.


//We will discuss this today:
    public static void heapify(int[] yo){
        for(int i = 0; i < Math.pow(2,((int)(Math.log(yo.length)/Math.log(2))))/2 - 1; i++){
            pushDown(yo, yo.length, i);
            System.out.println("XD");
        }
    }
    //- convert the array into a valid heap. [ should be O(n) ]

    public static void heapsort(int[] yo){
        heapify(yo);
        for(int i = yo.length - 1; i > -1; i--){
            int hold = yo[0];
            yo[0] = yo[i];
            yo[i] = hold;
            BpushDown(yo, i, 0);
        }
    }
    //sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]
}
