package com.sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int[] array = {0,1,2,3,-4,-7,7,-10};
//		int[] array = new int[10];
//		for(int index = 0;index<array.length;index++) {
//			array[index] =(int) (Math.random()*10);
//		}
//		Arrays.sort(array);
		System.out.println("快速排序前数组:"+Arrays.toString(array));
		quickSortSample(array,0,array.length-1);
		System.out.println("快速排序后数组:"+Arrays.toString(array));
	}
	
	/**
	 * 快速排序原理:
	 * 快速排序是对冒泡排序算法的改进
	 * 通过一次排序 使得某个index左边的数据都小于右边的数据
	 * 再递归调用快速排序
	 */
	public static void quickSort(int[] array,int left,int right) {
		int curL = left;
		int curR = right;
		int temp;
		int pivotValue = array[(left+right)/2];
		
		while(curL<curR) {
			//左右两侧的curIndex位置的值都和pivotValue进行比较
			while(array[curL]<pivotValue) {
				curL+=1;
			}
			while(array[curR]>pivotValue) {
				curR-=1;
			}
			//此时已经有可以互相交换的curL和curR
			if(curL>=curR) {
				break;
			}
			//进行左右交换
			temp = array[curL];
			array[curL] = array[curR];
			array[curR] = temp;
			
			//当前数据与pivotValue相同时候,更新下标,否则数据相同会无法顺利结束
			if(array[curL] == pivotValue) {
				curR -= 1;
			}
			if(array[curR] == pivotValue) {
				curL += 1;
			}
		}
		
		// 如果 curL == curR, 必须curL++, curR--, 否则为出现栈溢出
		if (curL == curR) {
			curL += 1;
			curR -= 1;
		}
		//向左递归
		if(left < curR) {
			quickSort(array, left, curR);
		}
		//向右递归
		if(right > curL) {
			quickSort(array, curL, right);
		}
	}
	
	
	public static void quickSortSample(int[] array,int left,int right) {
		int temp;
		int curL = left;
		int curR = right;
		int compareValue = array[(right-left)/2];
		
		while(curL<curR) {
			while(curL<curR && array[curL]<=compareValue) {
				curL++;
			}
			while(curL<curR && array[curR]>=compareValue) {
				curL--;
			}
			
			if(curL>=curR) {
				break;
			}
			temp = array[curL];
			array[curL] = array[curR];
			array[curR] = temp;
			
			if(array[curL] == compareValue) {
				curL++;
			}
			if(array[curR] == compareValue) {
				curR--;
			}
		}
		if(curL == curR) {
			curL++;
			curR--;
		}
		//向左递归
		if(left < curR) {
			quickSort(array, left, curR);
		}
		//向右递归
		if(right > curL) {
			quickSort(array, curL, right);
		}
		
	}
}
