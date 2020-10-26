package com.sort;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
//		int[] array = {0,1,2,3,-4,-7,-10};
		int[] array = {0,1};
		System.out.println("插入排序前数组:"+Arrays.toString(array));
		insertSort(array);
		System.out.println("插入排序后数组:"+Arrays.toString(array));
	}
	
	/**
	 * 插入排序原理:
	 * 把数组的第一个元素当作有序表,把数据的其他元素当作无序表
	 * 从后往前遍历无序表，寻找插入位置，并且将有序表的插入节点之后的元素依次后移
	 */
	public static void insertSort(int[] array) {
		int length = array.length;
 
		for(int i=1;i<length;i++) {
			int insertValue = array[i];
			int insertIndex = i-1;
			
			while( insertIndex >=0 && insertValue > array[insertIndex]) {
				array[insertIndex + 1] = array[insertIndex];
				insertIndex--;
			}
			System.out.println("插入index:"+insertIndex);
			if( insertIndex + 1 !=i ) {
				array[insertIndex+1] = insertValue;
			}
		}

	}
}
