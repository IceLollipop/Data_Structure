package com.search;

public class BinarySearch {
	public static void main(String[] args) {
		//int arr[] = { 1, 8, 10, 89,1000,1000, 1234 };
		int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 , 11, 12, 13,14,15,16,17,18,19,20 };
		int resIndex = binarySearch(arr, 0, arr.length - 1, 15);
		System.out.println("resIndex=" + resIndex);
	}
	
	public static int binarySearch(int[] arr, int left, int right, int findVal) {
		// �� left > right ʱ��˵���ݹ��������飬����û���ҵ�
		if (left > right) {
			return -1;
		}
		int mid = (left + right) / 2;
		int midVal = arr[mid];

		if (findVal > midVal) { // �� �ҵݹ�
			return binarySearch(arr, mid + 1, right, findVal);
		} else if (findVal < midVal) { // ����ݹ�
			return binarySearch(arr, left, mid - 1, findVal);
		} else { 
			
			return mid;
		}

	}
}
