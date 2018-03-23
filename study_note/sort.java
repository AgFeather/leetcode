public class Sort{
	
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

    public static void main(String[] args) {
		int[] array = {4,6,9,4,2,3,2,1,0};
		Sort = new Sort();
		
	}
    public void bubbleSort(int[] array){
    	for (int i = 0; i < array.length; i++) {
    		for (int j = 0; j<array.length-i-1;j++ ) {
    			if (array[j]>array[j+1]) {
    				swap(array, j, j+1);
    			}
    		}
    	}
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
