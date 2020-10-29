package com.sort;

import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int[] array = {0,1,2,3,-4,-7,-10,20};
//		int[] array = {0,1};
		System.out.println("Shell����ǰ����:"+Arrays.toString(array));
		shellSort(array);
		System.out.println("Shell�������������:"+Arrays.toString(array));
	}
	
	/**
	 * Shell����ԭ��:	������������
	 * ������в�������,��һ�ηֳ�gap = length/2����  ÿ��2��,����gap�Ĳ�����������в�������
	 * �ٴη��� gap/=2 �Ĳ���
	 * ���Բο� https://segmentfault.com/a/1190000013967025
	 */
	public static void shellSort(int[] array) {
		int length = array.length;
		
		for(int gap = length/2 ;gap > 0 ;gap/=2) {
			// gap���໥֮��ļ��,���gap�������Ԫ�ؾ���һ��
			//�������ѭ��,���δ����1-n������ĵ�1-n�������������Ԫ��
			for(int i = gap ;i<length;i++) {
				int j = i;
				int temp = array[j];
				while (j - gap >= 0 && temp < array[j - gap]) {
					//�ƶ�
					array[j] = array[j-gap];
					j -= gap;
				}
				//���˳�while�󣬾͸�temp�ҵ������λ��
				array[j] = temp;
			}
			
		}

	}
}
