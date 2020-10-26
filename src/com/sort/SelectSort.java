package com.sort;

import java.util.Arrays;

public class SelectSort {
	public static void main(String[] args) {
		int[] array = {0,1,2,3,-4,-7,-10};
		System.out.println("选择排序前数组:"+Arrays.toString(array));
		selectSort(array);
		System.out.println("选择排序后数组:"+Arrays.toString(array));
	}
	
	/**
	 * 选择排序原理:
	 * 在第一次循环的时候,先假定第一个元素是最值,记录index和value
	 * 在遍历的时候,依次对比当前值和最值的大小,并且记录新的最值的index和value
	 * 在当前遍历结束之后,真正交换最值到本轮循环的第一个值
	 * 
	 * 循环完一轮之后,数组最前面的数据已经是最值了,不再需要参与比较
	 */
	public static void selectSort(int[] array) {
		int length = array.length;
		
		for(int i= 0;i < length-1;i++) {
			int minValue = array[i];
			int minIndex = i;
			for(int j = i+1; j<length;j++) {
				if(array[j] < minValue) {
					minIndex = j;
					minValue = array[j];
				}
			}
			
			//真正交换找到的最值到本轮循环的最前列
			if(minIndex != i) {
				array[minIndex] = array[i];
				array[i] = minValue;
			}
		}

	}
}
