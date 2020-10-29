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
		System.out.println("��������ǰ����:"+Arrays.toString(array));
		quickSortSample(array,0,array.length-1);
		System.out.println("�������������:"+Arrays.toString(array));
	}
	
	/**
	 * ��������ԭ��:
	 * ���������Ƕ�ð�������㷨�ĸĽ�
	 * ͨ��һ������ ʹ��ĳ��index��ߵ����ݶ�С���ұߵ�����
	 * �ٵݹ���ÿ�������
	 */
	public static void quickSort(int[] array,int left,int right) {
		int curL = left;
		int curR = right;
		int temp;
		int pivotValue = array[(left+right)/2];
		
		while(curL<curR) {
			//���������curIndexλ�õ�ֵ����pivotValue���бȽ�
			while(array[curL]<pivotValue) {
				curL+=1;
			}
			while(array[curR]>pivotValue) {
				curR-=1;
			}
			//��ʱ�Ѿ��п��Ի��ཻ����curL��curR
			if(curL>=curR) {
				break;
			}
			//�������ҽ���
			temp = array[curL];
			array[curL] = array[curR];
			array[curR] = temp;
			
			//��ǰ������pivotValue��ͬʱ��,�����±�,����������ͬ���޷�˳������
			if(array[curL] == pivotValue) {
				curR -= 1;
			}
			if(array[curR] == pivotValue) {
				curL += 1;
			}
		}
		
		// ��� curL == curR, ����curL++, curR--, ����Ϊ����ջ���
		if (curL == curR) {
			curL += 1;
			curR -= 1;
		}
		//����ݹ�
		if(left < curR) {
			quickSort(array, left, curR);
		}
		//���ҵݹ�
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
		//����ݹ�
		if(left < curR) {
			quickSort(array, left, curR);
		}
		//���ҵݹ�
		if(right > curL) {
			quickSort(array, curL, right);
		}
		
	}
}
