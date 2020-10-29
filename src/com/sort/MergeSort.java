package com.sort;

import java.util.Arrays;

public class MergeSort {
	
	/**
	 * 	参考  https://my.oschina.net/u/4408862/blog/4267178
	 *  归并排序原理:
	 *	
	 */
	public static void main(String[] args) {
		int[] array = {0,1,2,3,-4,-7,-10};
//		int[] array = {0,1};
		System.out.println("归并排序前数组:"+Arrays.toString(array));
		int[] sortedArray = divide(array,0,array.length-1);
		System.out.println("归并排序后数组:"+Arrays.toString(sortedArray));
	}
	
	public static int[] divide(int[] array,int left,int right) {
		int mid = (left+right)/2;
		
		if(left<right) {
			divide(array,left,mid);
			divide(array,mid+1,right);
			
			merge(array,left,mid,right);
		}
		return array;
	}
	
	public static void merge(int[] array,int left,int mid,int right) {
		//创建临时数组
		int[] temp = new int[right-left+1];
		
		int leftIndex = left;
		int rightIndex = mid+1;
		
		int index = 0;
		//先将较小的数组移动到temp数组中
		while( leftIndex<=mid && rightIndex<=right) {
			if(array[leftIndex]<array[rightIndex]) {
				temp[index++] = array[leftIndex++];
			}else {
				temp[index++] = array[rightIndex++];
			}
		}
		
		//将剩余数组添加到temp数组中,以下两个条件只会成立一个
		while(leftIndex <= mid) {
			temp[index++] = array[leftIndex++];
		}
		while(rightIndex <= right) {
			temp[index++] = array[rightIndex++];
		}
		
		// temp数组覆盖原来数组
		for(int x=0;x<temp.length;x++){
			array[x+left] = temp[x];
		}
		
	}
}
