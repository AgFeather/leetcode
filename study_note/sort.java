/*
对常见的排序算法进行总结和java实现：

比较排序：
1. 插入排序：时间复杂度O(n2)，优于选择，稳定排序
2. 希尔排序：时间复杂度O(n^3/2)，优于插入，不稳定排序
3. 选择排序：时间复杂度O(n2)，优于冒泡，稳定排序
4. 冒泡排序：时间复杂度O(n2)，最差
5. 快速排序：时间复杂度O(nlogn)，不稳定排序
6. 归并排序：时间复杂度O(nlogn)，空间复杂度O(n)，稳定排序
7. 堆排序：时间复杂度O(nlogn)，不稳定排序

非比较排序：
7. 桶排序：时间复杂度O(n+c)，桶数量越大效率越高，数量等于max-min时退化成计数排序，但同样也需要更大的空间。稳定排序
8. 基数排序：时间复杂度O(n+rd))
9. 计数排序：时间复杂度O(n)，需要知道排序数据的最大最小值，计数排序对数据范围较大的数组需要大量的内存


总结：
1. 从平均时间来看，快速排序是效率最高的，但快速排序在最坏情况下的时间性能不如堆排序和归并排序。而后者相比较的结果是，
在n较大时归并排序使用时间较少，但使用辅助空间较多。

2. 上面说的简单排序包括除希尔排序之外的所有冒泡排序、插入排序、简单选择排序。其中直接插入排序最简单，
但序列基本有序或者n较小时，直接插入排序是好的方法，因此常将它和其他的排序方法，如快速排序、归并排序等结合在一起使用。

3. 基数排序的时间复杂度也可以写成O(d*n)。因此它最使用于n值很大而关键字较小的的序列。若关键字也很大，
而序列中大多数记录的最高关键字均不同，则亦可先按最高关键字不同，将序列分成若干小的子序列，而后进行直接插入排序。

4. 从方法的稳定性来比较，基数排序是稳定的内排方法，所有时间复杂度为O(n^2)的简单排序也是稳定的。
但是快速排序、堆排序、希尔排序等时间性能较好的排序方法都是不稳定的。稳定性需要根据具体需求选择。

5. 上面的算法实现大多数是使用线性存储结构，像插入排序这种算法用链表实现更好，省去了移动元素的时间。
具体的存储结构在具体的实现版本中也是不同的。
 */






public class Sort{
    public static void main(String[] args) {
		int[] array = {4,6,9,4,2,3,2,1,0};
		Sort = new Sort();
	}


    public void insertSort(int[] nums) {
		for (int i = 1; i < nums.length; i++) {
			if (nums[i]<nums[i-1]) {
				for (int j = i-1; j >= 0; j--) {
					if (nums[j]>nums[j+1])
						swap(nums, j+1, j);
                    else
						break;
				}
			}
		}
	}


    public void shellSort(int[] nums) {
		//希尔排序，注意循环层数
		int mark = nums.length/2;
		while(mark >= 1) {
			sSort(nums, mark);
			mark /= 2;
		}
	}
	public void sSort(int[] nums, int mark) {
		for (int i = mark; i < nums.length; i++) {
			int temp = nums[i];
			int j = i - mark;
			while (j>=0 && nums[j] > temp) {
				nums[j + mark] = nums[j];
				j -= mark;
			}
			nums[j + mark] = temp;
		}
	}


	public void selectSort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			int min = i;
			for (int j = i+1; j < nums.length; j++) {
				if (nums[j]<nums[min])
					min = j;
			}
			swap(nums, min, i);
		}
	}


	public void bubbleSort(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums.length - i - 1; j++) {
				if (nums[j]>nums[j+1])
					swap(nums, j, j+1);
			}
		}
	}


    public void quickSort(int[] nums) {
		//快速排序，注意每个条件判断的边界问题
		qSort(nums, 0, nums.length-1);
	}
	public void qSort(int[] nums, int left, int right) {
		if (left >= right) {
			return;
		}
		int center = nums[left];
		int r = right;
		int l = left;
		while (r > l) {
			while(nums[r] >= center && r > l) r--; //>=的等于号非常重要，要不r，l不会移动，陷入死循环
			nums[l] = nums[r];//因为已经记录了l的值（center），所以只需要直接覆盖即可
			while(nums[l] <= center && r > l) l++;
			nums[r] = nums[l];
		}
		nums[l] = center;
		qSort(nums, left, l - 1);
		qSort(nums, l + 1, right);
	}


	public void mergeSort(int[] nums) {
		//归并排序分作两步：1.将数组进行递归二分，2.自底向上不断对两个子数组进行合并
		mSort(nums, 0, nums.length-1);
	}
	public void mSort(int[] nums, int left, int right) {
		if (left >= right)
			return;
		int mid = (left + right) / 2;
		mSort(nums, left, mid);
		mSort(nums, mid+1, right);
		merge(nums, left, mid, right);
	}
	public void merge(int[] nums, int left, int center, int right) {
		int i = left;
		int j = center + 1;
		int[] temp = new int[right - left + 1];//新建一个数组暂存对两个小数组合并后的顺序数组
		int k = 0;
		while(i <= center && j <= right) {
			if (nums[i] <= nums[j])
				temp[k] = nums[i++];
			else
				temp[k] = nums[j++];
			k++;
		}
		while(i <= center)
			temp[k++] = nums[i++];
		while(j <= right)
			temp[k++] = nums[j++];
		for (int k2 = 0; k2 < temp.length; k2++)
			nums[left + k2] = temp[k2];
	}


    public void bucketSort(int[] nums){
        /*
        桶排序是一种非比较排序，基本思想是把待排序数组划分为n个大小相同的自区间（桶）
        每个自取件各自排序然后合并。计数排序是桶排序的一种特殊情况，可以把计数排序当成每个桶里只有一个元素的情况。

        过程分析：
        1.找出待排序数组中的最大值max、最小值min
        2.我们使用 动态数组ArrayList 作为桶，桶里放的元素也用 ArrayList 存储。桶的数量为(max-min)/arr.length+1
        3.遍历数组 arr，计算每个元素 arr[i] 放的桶
        4.每个桶各自排序
        5.遍历桶数组，把排序好的元素放进输出数组
         */
        int max = nums[0];
        int min = nums[0];
        for (int i = 0; i<nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[i]);
        }
        //桶个数
        int bucketNum = (max - min) / nums.length + 1;
        ArrayList<ArrayList<Integer>> buckerArr = new ArrayList<>(bucketNum);
        for (int i = 0; i<bucketNum; i++) {
            buckerArr.add(new ArrayList<Integer>());
        }
        //将每个元素放入桶中
        for (int i = 0; i<nums.length; i++) {
            int num = (arr[i] - min) / nums.length;
            buckerArr.get(num).add(arr[i]);
        }
        //对每个桶进行排序
        for(int i = 0; i<buckerArr.size(); i++){
            Collection.sort(buckerArr.get(i));
        }
        int i = 0;
        for (ArrayList<Integer> tempList : buckerArr) {
            for (Integer tempNum : tempList) {
                num[i] = tempNum;
                i++;
            }
        }
    }


    public void countSort(int[] nums) {
		//计数排序，时间复杂度可以达到O(n)，前提是我们知道待排序数组的最大值
		//主要思想是，新建一个以最大值为长度的数组，用其对每个数的出现次数进行统计
		//最后遍历计数数组，遇到非0元素即将i加入到数组中。
		int max_value = 100;
		int[] temp = new int[max_value];
		for (int i = 0; i < nums.length; i++) {
			temp[nums[i]] += 1;
		}
		int index = 0; //排序后数组的循环索引 < nums.length
		for (int i = 0; i < temp.length; i++) {
			while(temp[i] > 0) {
				nums[index++] = i;
				temp[i]--;
			}
		}
	}


    public void radixSort(int nums){
        int exp = 1; //指数，按照当前位进行排序。exp=1表示按照个位排序
        int max = nums[0];
        for (int i = 1; i<nums.length; i++) {
            max = Math.max(max, nums[i]);
        }
        //从个位开始，对数组nums进行排序
        while(max/exp > 0){
            rSort(nums, exp);
            exp *= 10;
        }
    }
    public void rSort(int[] nums, int exp){
        int[] output = new int[nums.length];
        int[] buckets = new int[10];
        //将数据出现的次数存储在buckets中
        for(int i = 0; i<nums.length; i++)
            buckets[ (nums[i]/exp)%10 ]++;

        // 更改buckets[i]。目的是让更改后的buckets[i]的值，是该数据在output[]中的位置。
         for (int i = 1; i < 10; i++)
             buckets[i] += buckets[i - 1];

         // 将数据存储到临时数组output[]中
         for (int i = nums.length - 1; i >= 0; i--) {
             output[buckets[ (nums[i]/exp)%10 ] - 1] = nums[i];
             buckets[ (nums[i]/exp)%10 ]--;
         }

        // 将排序好的数据赋值给a[]
         for (int i = 0; i < a.length; i++)
             nums[i] = output[i];
    }


    //辅助函数
	public void swap(int[] nums, int a, int b) {
		int temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
	public void print(int[] nums) {
		for (int i = 0; i < nums.length; i++)
			System.out.print(nums[i] + " ");
		System.out.println();
	}
}
