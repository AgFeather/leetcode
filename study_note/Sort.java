/*
堆是一个完全二叉树，优点就是除了最底层外，每一层都是满的。这样就可以用数组表示堆。
对于给定的节点下标i，可以很容易计算出这个节点的父节点和子节点。
Parents(i) = floor((i-1)/2)
Left(i) = 2*i+1
Right(i) = 2*(i+1)
二叉堆分为两种，最大堆和最小堆
最大堆：
- 最大堆中最大的元素出现在堆顶
- 堆中每个父节点都大于等于其子节点

最小堆：
- 同理最大堆


堆排序就是把最大堆堆顶的最大数取出，将剩余的堆继续调整为最大堆，再次将堆顶的最大数取出，这个过程持续到剩余数只有一个时结束。在堆中定义以下几种操作：

最大堆调整（Max-Heapify）：将堆的末端子节点作调整，使得子节点永远小于父节点
创建最大堆（Build-Max-Heap）：将堆所有数据重新排序，使其成为最大堆
堆排序（Heap-Sort）：移除位在第一个数据的根节点，并做最大堆调整的递归运算
*/



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
