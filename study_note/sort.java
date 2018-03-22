public class Sort{
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
