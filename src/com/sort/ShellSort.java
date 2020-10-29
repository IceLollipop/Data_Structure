package com.sort;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] array = {0,1,2,3,-4,-7,-10,20};
//		int[] array = {0,1};
		System.out.println("Shell排序前数组:"+Arrays.toString(array));
		shellSort(array);
		System.out.println("Shell插入排序后数组:"+Arrays.toString(array));
	}
	
	/**
	 * Shell排序原理:	增量插入排序
	 * 分组进行插入排序,第一次分出gap = length/2个组  每组2个,按照gap的步长的数组进行插入排序
	 * 再次分组 gap/=2 的步长
	 * 可以参考 https://segmentfault.com/a/1190000013967025
	 */
	public static void shellSort(int[] array) {
		int length = array.length;
		
		for(int gap = length/2 ;gap > 0 ;gap/=2) {
			// gap是相互之间的间隔,相隔gap个间隔的元素就是一组
			//下面这个循环,依次处理第1-n个分组的第1-n个待插入排序的元素
			for(int i = gap ;i<length;i++) {
				int j = i;
				int temp = array[j];
				while (j - gap >= 0 && temp < array[j - gap]) {
					//移动
					array[j] = array[j-gap];
					j -= gap;
				}
				//当退出while后，就给temp找到插入的位置
				array[j] = temp;
			}
			
		}

	}
}
