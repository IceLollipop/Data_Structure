package com.sort;

import java.util.Arrays;

public class MergeSort {
	
	/**
	 * 	�ο�  https://my.oschina.net/u/4408862/blog/4267178
	 *  �鲢����ԭ��:
	 *	
	 */
	public static void main(String[] args) {
		int[] array = {0,1,2,3,-4,-7,-10};
//		int[] array = {0,1};
		System.out.println("�鲢����ǰ����:"+Arrays.toString(array));
		int[] sortedArray = divide(array,0,array.length-1);
		System.out.println("�鲢���������:"+Arrays.toString(sortedArray));
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
		//������ʱ����
		int[] temp = new int[right-left+1];
		
		int leftIndex = left;
		int rightIndex = mid+1;
		
		int index = 0;
		//�Ƚ���С�������ƶ���temp������
		while( leftIndex<=mid && rightIndex<=right) {
			if(array[leftIndex]<array[rightIndex]) {
				temp[index++] = array[leftIndex++];
			}else {
				temp[index++] = array[rightIndex++];
			}
		}
		
		//��ʣ��������ӵ�temp������,������������ֻ�����һ��
		while(leftIndex <= mid) {
			temp[index++] = array[leftIndex++];
		}
		while(rightIndex <= right) {
			temp[index++] = array[rightIndex++];
		}
		
		// temp���鸲��ԭ������
		for(int x=0;x<temp.length;x++){
			array[x+left] = temp[x];
		}
		
	}
}
