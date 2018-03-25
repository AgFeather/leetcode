public class MaxHeapSort{
	int[] heap;
	int heapsize:
	public MaxHeapSort(int[] array){
		this.heap = array;
		this.heapsize = array.length;
	}
	public void buildMaxHeap(){
		for (int i = heapsize/2-1;i>=0 ;i-- ) {
			maxMolify(i);//自底向上将当前树最大堆化
		}
	}
	public void heapSort(){
		for (int i=0; i<heap.length; i++) {
			//执行n次，将每个当前最大的值放到堆末尾
			int temp = heap[0];
			heap[0] = heap[heapsize-1];
			heap[heapsize-1] = temp;
			heapsize-1;
			maxMolify(0);
		}
	}
	public void maxMolify(int i){
		int l = left(i);
		int r = right(i);
		int largest;
		if (l<heapsize&&heap[1]>heap[i])
			largest=1;
		else
			largest=i;
		if (r<heapsize && heap[r]>heap[largest])
			largest=r;
		if (largest==i || largest>=heapsize)//如果largest等于i说明i是最大元素 largest超出heap范围说明不存在比i节点大的子女
			return;
		int temp=heap[i];//交换i与largest对应的元素位置，在largest位置递归调用maxify
		heap[i] = heap[largest];
		heap[largest] = temp;
		maxMolify(largest);		
	}
	public void increaseValue(int i, int val){
		heap[i] = val;
		if (i>=heapsize||i<=0||heap[i]>=val)
			return;
		int p = parent(i);
		if (heap[p]>=val)
			return;
		heap[i] = heap[p];
		increaseValue(p, val);
	}
	private int parent(int i){
		return (i-1)/2;
	}
	private int left(int i){
		return 2*(i+1)-1;
	}
	private int right(int i){
		return 2*(i+1);
	}
}






public class Sort{

	public static void main(String[] args) {
		int[] array = {4,6,9,4,2,3,2,1,0};
		Sort = new Sort();
		
	}

	public void shellSort(int[] array){
		int gap = array.length / 2;
		for (; gap>0; gap/=2) {//不断缩小gap，直到1为止
			for (int j=0; (j+gap)<array.length; j++) {//使用当前gap进行组内插入排序
				for (int k=0;(k+gap)<array.length ;k+=gap ) {
					if (array[k]>array[k+gap]) {
						swap(array, k, k+gap);
					}
				}
				
			}
			
		}
	}


	public void mergeSort(int[] array){
		if (array.length<=1) {
			return array;
		}
		int num = array.length >> 1;
		int[] leftArr = Arrays.copyOfRange(array, 0, num);
		int[] rightArr = Arrays.copyOfRange(array, num, arr.length);
		return mergeTwoArray(mergeSort(leftArr), mergeSort(rightArr));
	}
	public void mergeTwoArray(int[] arr1, int[] arr2){
		int i = 0, j = 0, k = 0;
		int[] result = new int[arr1.length + arr2.length];
		while(i < arr1.length && j < arr2.length){
			if (arr1[i] <= arr2[j]) {
				result[k++] = arr1[i++];
			}else{
				result[k++] = arr2[j++];
			}
		}
		while(i<arr1.length){
			result[k++] = arr1[i++];
		}
		while(j<arr2.length){
			result[k++] = arr2[j++];
		}
		return result;
	}


	public void radixSort(int[] array){
		if (array.length <= 1) {
			return;
		}
		//取得数组中的最大数，并取得位数
		for (int i = 0; i<array.length; i++) {
			if (max<array[i]) {
				max=array[i];
			}
		}
		int maxDigit = 1;
		while(max / 10 > 0){
			maxDigit++;
			max = max/10;
		}

		 //申请一个桶空间
		int[][] buckets = new int[10][array.length];
		int base = 10;
		 //从低位到高位，对每一位遍历，将所有元素分配到桶中
	    for(int i = 0; i < maxDigit; i++){
	        int[] bktLen = new int[10];        //存储各个桶中存储元素的数量
	        
	        //分配：将所有元素分配到桶中
	        for(int j = 0; j < arr.length; j++){
	            int whichBucket = (arr[j] % base) / (base / 10);
	            buckets[whichBucket][bktLen[whichBucket]] = arr[j];
	            bktLen[whichBucket]++;
	        }

	        //收集：将不同桶里数据挨个捞出来,为下一轮高位排序做准备,由于靠近桶底的元素排名靠前,因此从桶底先捞
	        int k = 0;
	        for(int b = 0; b < buckets.length; b++){
	            for(int p = 0; p < bktLen[b]; p++){
	                arr[k++] = buckets[b][p];
	            }
	        }

	        System.out.println("Sorting: " + Arrays.toString(arr));
	        base *= 10;
	    }
		
	}

	public void quickSort(int[] array){
		/*
		average: O(nlogn) best:O(nlogn) worst:O(n^2)
		*/
		qSort(array, 0, array.length-1);
	}
	public void qSort(int[] array, int l, int r){
		if (l>=r) {return;}
		int flag = array[l]; //保存flag的值，因为在接下来的循环会覆盖掉flag
		int left = l;
		int right = r;
		while(left<right){
			while (left<right&&array[right] >= flag) {
				right--;//从right to left找到第一个小于flag值的index
			}
			array[left] = array[right];//因为已经记录了flag值，直接覆盖
			while (left<right&&array[left] <= flag) {
				left++;//从left to right找到第一个大于flag值的index
			}
			array[right] = array[left];		
		}
		array[left] = flag;
		qSort(array, l, left-1);
		qSort(array, left+1, r);
	}


	public void selectSort(int[] array){
		/*
		O(n^2)
		*/
		for (int i = 0; i<array.length; i++) {
			int min = i;
			for (int j = i+1; j<array.length; j++) {
				if (array[min]>array[j]) {
					min = j;
				}
			}
			swap(array, i, min);
		}
		printArray(array);
	}


	public void bubbleSort(int[] array){
		/*
		O(n^2)
		*/
    	for (int i = 0; i < array.length; i++) {
    		for (int j = 0; j<array.length-i-1;j++ ) {
    			if (array[j]>array[j+1]) {
    				swap(array, j, j+1);
    			}
    		}
    	}
    }


    public void insertSort(int[] array){
    	/*
		O(n^2)
    	*/
    	for (int i = 1; i<array.length; i++) {
    		for (int j = i; j>0; j--) {
    			if (array[j]>=array[j-1]) {
    				break;
    			}
    			else {
    				swap(array, j, j-1);
    			}
    		}
    	}
    	printArray(array);
    }






    public void swap(int[] array, int a, int b){
    	int temp = array[a];
    	array[a] = array[b];
    	array[b] = temp;
    }
    public void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
}
