package com.sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {0,1,2,3,-4,-7,-10};
		System.out.println("冒泡排序前数组:"+Arrays.toString(array));
		bubbleSort(array);
		System.out.println("冒泡排序后数组:"+Arrays.toString(array));
	}
	
	/**
	 * 冒泡排序原理:
	 * 第一次遍历的过程中,两两比较之后,最值被赋值给最后一个元素
	 * 此时,第二次由前向后的比较过程中,最后一位数据可以不参与比较
	 * 
	 * 优化:在某一次外层遍历过程中,没有发生比较时,此时数据已经有序,可以退出循环
	 */
	public static void bubbleSort(int[] array) {
		int length = array.length;
		int temp;
		boolean needSwap = false;
		for(int i = 0; i<length-1 ;i++) {
			for(int j = 0;j < length-(1+i); j++) {
				if(array[j] > array[j+1]) {
					temp = array[j+1];
					array[j+1] = array[j];
					array[j] = temp;
					//当前遍历中 进行了交换动作,需要进行下次遍历。
					//当前遍历中,没有交换动作,则已经排序完成
					needSwap = true;
				}
			}
			
			if(needSwap) {
				needSwap = false;	//标志位置为false 进行下一次循环
			}else {
				break;				//排序完成,退出循环
			}
		}
	}
	
}
