package com.sort;

import java.util.Arrays;

public class BubbleSort {
	public static void main(String[] args) {
		int[] array = {0,1,2,3,-4,-7,-10};
		System.out.println("ð������ǰ����:"+Arrays.toString(array));
		bubbleSort(array);
		System.out.println("ð�����������:"+Arrays.toString(array));
	}
	
	/**
	 * ð������ԭ��:
	 * ��һ�α����Ĺ�����,�����Ƚ�֮��,��ֵ����ֵ�����һ��Ԫ��
	 * ��ʱ,�ڶ�����ǰ���ıȽϹ�����,���һλ���ݿ��Բ�����Ƚ�
	 * 
	 * �Ż�:��ĳһ��������������,û�з����Ƚ�ʱ,��ʱ�����Ѿ�����,�����˳�ѭ��
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
					//��ǰ������ �����˽�������,��Ҫ�����´α�����
					//��ǰ������,û�н�������,���Ѿ��������
					needSwap = true;
				}
			}
			
			if(needSwap) {
				needSwap = false;	//��־λ��Ϊfalse ������һ��ѭ��
			}else {
				break;				//�������,�˳�ѭ��
			}
		}
	}
	
}
