
/*
堆排序：

[堆定义]
堆是具有下列性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆；
或者每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆。

[算法思想]
将待排序的序列构造成一个大顶堆。此时，整个序列的最大值就是堆顶的根节点。
将它移走(其实就是将其与堆数组的末尾元素交换，此时末尾元素就是最大值)，
然后将剩余的n-1个序列重新构造成一个堆，这样就会得到n个元素中的次最大值。
如此反复执行，就能得到一个有序序列了。

[堆表示]
使用数组表示堆，其中父节点和左右子节点的关系为：
parent(i) = (i-1)/2;
left(i) = i * 2 +1;
right(i) = (i+1) * 2 ;
 */

class HeapSort{
    public void heapSort(int[] arr){
        //将待排序的序列构建为一个最大堆
        for (int i = 0 ; i<arr.length ; i++) {
            heapAdjust(arr, i, arr.length);
        }
        //逐步将堆顶（最大值）与末尾元素交换，然后对剩下的n-i个元素继续进行调整成为最大堆
        for (int i = arr.length-1 ; i>0 ;i-- ) {
            swap(arr, 0, i);
            heapAdjust(arr, 0, i);
        }
    }
    public void heapAdjust(int[] arr, int i, int length){
        int childIndex;
        int fatherValue = arr[i];
        for (; 2*i+1 < length ; i = childIndex ) {
            childIndex = 2*i+1;
            //如果左子树小于右子树，则需要比较右子树和父节点
            if(childIndex+1 < length && arr[childIndex] < arr[childIndex+1])
                childIndex++; //序号加一，指向右子树
            //如果父节点小于孩子节点，则需要交换两个节点
            if(fatherValue < arr[childIndex])
                arr[i] = arr[childIndex];
            else
                break;
        }
        arr[i] = fatherValue;
    }
    public void swap(int[] arr, int index1, int index2){
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
