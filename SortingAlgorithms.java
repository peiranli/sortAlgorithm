import java.util.*;      



public class SortingAlgorithm {
  
  protected static selectionSort =
    // Code from memory
    new SortingExperiment() {
      protected void sort(int list[])
      {
        for (int j=list.length-1; j>0; j--)
        {
          int maxpos = 0;
          for (int k=1; k<=j; k++)
          {
            if (list[k]>list[maxpos])
            {
              maxpos = k;
            }
          }
          if (j != maxpos)    // Only move if we must
          {
            int temp = list[j];
            list[j] = list[maxpos];
            list[maxpos] = temp;
          }
        }
      };
  };
  
  
  
  protected static insertionSort() {
    protected void sort(int list[])
    {
      for (int j=1; j<list.length; j++)
      {
        int temp = list[j];
        int k = j;
        while( k > 0 && list[k-1]>temp )
        {
          list[k] = list[k-1];
          k--;
        }
        list[k] = temp; 
      }
    };
  };
  
  
  
  protected static bubbleSort(){ 
    protected void sort(int list[])
    {
      int temp;
      do {
        temp = list[0];
        for (int j=1; j<list.length; j++)
        {
          if (list[j-1]>list[j])
          {
            temp = list[j];
            list[j] = list[j-1];
            list[j-1] = temp;
          }
        }
      } while (temp != list[0]);
    };
  };
  
  protected static checkSort() {
    protected void sort(int list[])
    {
      for (int i = 1; i < list.length; i++) {
        if(list[i] < list[i - 1]){
          sorted = false;
          break;
        }
      }
      if(!sorted){
        permuteHelper(list, 0);
      }
    }
   
    private void permuteHelper(int[] list, int index){
      if (index == list.length - 1) {
        //check if it is sorted
        int count = 0;
        for (int i = 1; i < list.length; i++) {
          count++;
          if(list[i] < list[i - 1]){
            sorted = false;
            break;
          }
        }
        //corner case
        if((count == list.length - 1) && list[list.length - 1] > list[list.length - 2]){
          sorted = true;
        }
        return;
      }
      for (int i = index; i < list.length; i++) {
        int temp = list[index];
        list[index] = list[i];
        list[i] = temp;
        permuteHelper(list, index + 1);
        if(sorted){//early return 
          return;
        }
        // swap back
        movements += 3;
        temp = list[index];
        list[index] = list[i];
        list[i] = temp;
      }
    };   
  };
  
  protected static quickSort() {
    protected void sort(int list[])
    {
      qsort(list, 0, list.length-1);
    }
    
    // Helper to actually do the quicksort
    private void qsort(int list[], int low, int high) 
    {
      if (low<high)
      {        
        int pivot = partition(list, low, high);
        qsort(list, low, pivot);
        qsort(list, pivot+1, high); 
      }
    }
    
    // Partition the list for quick sort
    private int partition(int list[], int low, int high)
    {
      int temp = list[low];
      int i = low-1;
      int j = high+1;
      while(true)
      {
        do {
          j--;
        } while (list[j] > temp);
        do {
          i++;
        } while (list[i] < temp);
        if (i < j)
        {
          int swapTemp = list[i];
          list[i] = list[j];
          list[j] = swapTemp;
        }
        else
        {
          return j;
        }
      }
    }; 
  };
  
  protected static mergeSort() {
    protected void sort(int list[])
    {
      msort(list, 0, list.length-1);
    }
     
    private void msort(int list[], int low, int high) 
    {
      if (low<high)
      {
        int mid = (low+high)/2;
        msort(list, low, mid);
        msort(list, mid+1, high);
        merge(list, low, mid, high);
      }
    }
      
    private void merge(int list[], int low, int mid, int high)
    {
      int h = low;
      int i = 0;
      int j = mid+1;
      int otherList[] = new int[high-low+1];
      while ((h <= mid) && (j <= high))
      {
        if (list[h] <= list[j])
        {
          otherList[i] = list[h];
          h++;
        }
        else
        {
          otherList[i] = list[j];
          j++;
        }
        i++;
      }
      if (h>mid)
      {
        for (int k=j; k<=high; k++)
        {
          otherList[i] = list[k];
          i++;
        }
      }
      else
      {
        for (int k=h; k<=mid; k++)
        {
          otherList[i] = list[k];
          i++;
        }
      }
      
      for (int m=0; m<otherList.length; m++)
      {
        list[low+m] = otherList[m];
      }
    };
  };
}
