package com.sort;

import java.util.Arrays;

public class InsertSort {
	public static void main(String[] args) {
//		int[] array = {0,1,2,3,-4,-7,-10};
		int[] array = {0,1};
		System.out.println("��������ǰ����:"+Arrays.toString(array));
		insertSort(array);
		System.out.println("�������������:"+Arrays.toString(array));
	}
	
	/**
	 * ��������ԭ��:
	 * ������ĵ�һ��Ԫ�ص��������,�����ݵ�����Ԫ�ص��������
	 * �Ӻ���ǰ���������Ѱ�Ҳ���λ�ã����ҽ������Ĳ���ڵ�֮���Ԫ�����κ���
	 */
	public static void insertSort(int[] array) {
		int length = array.length;
 
		for(int i=1;i<length;i++) {
			int insertValue = array[i];
			int insertIndex = i-1;
			
			while( insertIndex >=0 && insertValue > array[insertIndex]) {
				array[insertIndex + 1] = array[insertIndex];
				insertIndex--;
			}
			System.out.println("����index:"+insertIndex);
			if( insertIndex + 1 !=i ) {
				array[insertIndex+1] = insertValue;
			}
		}

	}
}
