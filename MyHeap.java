import java.util.*;
import java.io.*;
public class MyHeap{
    //We discussed these 2 methods already:
    public static void main(String[] args) {
        int[] test = new int[]{0,2,5,1,8,3,5,3,9,1,2,8567,3};
        //pushDown(test,test.length,0);

        //System.out.println((int)(Math.pow(2,(int)(Math.log(test.length)/Math.log(2)))));
        //System.out.println(test.length - (1 + (int)Math.pow(2,(int)(Math.log(test.length)/Math.log(2)))));
        //heapify(test);
        heapPrint(test);
        //test = new int[]{4,0};
        //System.out.println(test.length - (1 + (int)Math.pow(2,(int)(Math.log(test.length)/Math.log(2)))));
        //test = new int[]{2,5,1,1};
        //System.out.println((int)Math.pow(2,(int)(Math.log(test.length)/Math.log(2))));
        //System.out.println(test.length - (1 + (int)Math.pow(2,(int)(Math.log(test.length)/Math.log(2)))));
        heapsort(test);


        System.out.println(Arrays.toString(test));
        //test = new int[]{0,2,5,6,8,12};
        //pushDown(test,test.length,0);
        heapPrint(test);
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
        System.out.println();
    }
    private static void pushDown(int[]data,int size,int index){
        for( int i = index; (i * 2) + 1 < size;){
            //heapPrint(data);
            //System.out.println();
            if(!((i * 2) + 2 < size) && data[i] < data[(i * 2) + 1]){
                int hold = data[(i * 2) + 1];
                data[(i * 2) + 1] = data[i];
                data[i] = hold;
                i = (i * 2) + 1;
            }
            else if ((i * 2) + 2 < size && data[(i * 2) + 1] < data[(i * 2) + 2] && data[i] < data[(i * 2) + 2]){
                int hold = data[(i * 2) + 2];
                data[(i * 2) + 2] = data[i];
                data[i] = hold;
                i = (i * 2) + 2;
            } else{
                if(data[i] < data[(i * 2) + 1]){
                    int hold = data[(i * 2) + 1];
                    data[(i * 2) + 1] = data[i];
                    data[i] = hold;
                    i = (i * 2) + 1;
                } else{
                    i++;
                }
            }
        }
    }

    private static void BpushDown(int[]data,int size,int index){
        for( int i = index; (i * 2) + 1 < size;){
            //heapPrint(data);
            //System.out.println();
            if(!((i * 2) + 2 < size)){
                int hold = data[(i * 2) + 1];
                data[(i * 2) + 1] = data[i];
                data[i] = hold;
                i = (i * 2) + 1;
            }
            else if ((i * 2) + 2 < size && data[(i * 2) + 1] < data[(i * 2) + 2]){
                int hold = data[(i * 2) + 2];
                data[(i * 2) + 2] = data[i];
                data[i] = hold;
                i = (i * 2) + 2;
            } else{
                int hold = data[(i * 2) + 1];
                data[(i * 2) + 1] = data[i];
                data[i] = hold;
                i = (i * 2) + 1;
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
        int A = (int)(Math.pow(2,(int)(Math.log(yo.length)/Math.log(2))));
        int a = (int)(Math.pow(2,(int)(Math.log(yo.length)/Math.log(2))))-1;
        int b = A/2 - (int)(((yo.length-a)+1)/2) + (yo.length-a);
        //System.out.println("b value" + b);
        for(int i = b-1; i > -1; i--){
            pushDown(yo, yo.length, i);
            //System.out.println("XD");
        }
    }
    //- convert the array into a valid heap. [ should be O(n) ]

    public static void heapsort(int[] yo){
        heapify(yo);
        for(int i = yo.length - 1; i > -1; i--){
            int hold = yo[0];
            yo[0] = yo[i];
            yo[i] = hold;
            pushDown(yo, i, 0);
        }
    }
    //sort the array by converting it into a heap then removing the largest value n-1 times. [ should be O(nlogn) ]
}
