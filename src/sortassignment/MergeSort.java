package sortassignment;

import java.util.Scanner;



import java.util.Scanner;

public class MergeSort extends AbstractSortComponent {

    public static void main(String[] args) {
        int a[] = new int[8];
        MergeSort m = new MergeSort();
        Scanner in = new Scanner(System.in);

        System.out.println("Enter the numbers");

        for (int i = 0; i < a.length; i++) {
            a[i] = in.nextInt();

        }
        in.close();

        m.sort(a);

    }

    @Override
    public void sort(int[] c)
    {
        int n=c.length;
        if(n<2)
            return;
        int mid=n/2;
        int left = mid;
        int right = n-mid;
        int[] leftArray = new int[left];
        int[] rightArray = new int[right];
        for(int i=0;i<mid;i++)
        {
            leftArray[i] = c[i];
        }
        for(int i=mid;i<n;i++)
        {
            rightArray[i-mid] = c[i];
        }

        sort(leftArray);
        sort(rightArray);
        merge(leftArray,rightArray,c);

    }

    @Override
    public String sortName() {
        return this.getClass().getName();
    }

    void merge(int[] leftArray,int[] rightArray,int[] inputArray)
    {
        int leftSize = leftArray.length;
        int rightSize = rightArray.length;
        int i = 0, j = 0 , k = 0;

        while(i<leftSize && j<rightSize){
            if(leftArray[i] <= rightArray[j])
            {
                inputArray[k] = leftArray[i];
                i++;
                k++;
            }
            else
            {
                inputArray[k] = rightArray[j];
                j++;
                k++;
            }
        }

        while (i < leftSize) {
            inputArray[k] = leftArray[i];
            k++;
            i++;
        }
        while (j < leftSize) {
            inputArray[k] = rightArray[j];
            k++;
            j++;
        }

    }



    public static void printArray(int b[])
    {
        System.out.println("-------- Merge Sort ------- \n");
        for (int i = 0; i < b.length; i++) {
            System.out.println(b[i]);
        }
    }

}


















