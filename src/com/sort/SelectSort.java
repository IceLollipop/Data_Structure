package com.sort;

import java.util.Arrays;

public class SelectSort {
	public static void main(String[] args) {
		int[] array = {0,1,2,3,-4,-7,-10};
		System.out.println("ѡ������ǰ����:"+Arrays.toString(array));
		selectSort(array);
		System.out.println("ѡ�����������:"+Arrays.toString(array));
	}
	
	/**
	 * ѡ������ԭ��:
	 * �ڵ�һ��ѭ����ʱ��,�ȼٶ���һ��Ԫ������ֵ,��¼index��value
	 * �ڱ�����ʱ��,���ζԱȵ�ǰֵ����ֵ�Ĵ�С,���Ҽ�¼�µ���ֵ��index��value
	 * �ڵ�ǰ��������֮��,����������ֵ������ѭ���ĵ�һ��ֵ
	 * 
	 * ѭ����һ��֮��,������ǰ��������Ѿ�����ֵ��,������Ҫ����Ƚ�
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
			
			//���������ҵ�����ֵ������ѭ������ǰ��
			if(minIndex != i) {
				array[minIndex] = array[i];
				array[i] = minValue;
			}
		}

	}
}
