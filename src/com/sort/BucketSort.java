package com.sort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class BucketSort{
	public static void main(String[] args) {
		int[] array = {0,100,2,3,4,7,10,12,13,50};
//		int[] array = {0,1};
		System.out.println("基数排序前数组:"+Arrays.toString(array));
		bucketSort(array);
		System.out.println("基数排序后数组:"+Arrays.toString(array));
	}
	
	
	public static void bucketSort(int[] array) {
		int minValue = array[0];
		int maxValue = array[0];
		
		//遍历数组元素找到最值
		for(int i=0;i<array.length;i++) {
			maxValue = Math.max(maxValue,array[i]);
			minValue = Math.min(minValue,array[i]);
		}
		
		//划分桶子数量		为啥+1? 因为除法运算会出去小数部分,当放置最大值的时候无处存放
		int bucketSize  = (maxValue - minValue)/array.length + 1;
		//创建tempArrayList存放数据
		ArrayList<ArrayList<Integer>> buckets = new ArrayList<>(bucketSize);
		for(int i=0;i<bucketSize;i++) {
			buckets.add(new ArrayList<Integer>());
		}
		System.out.println("minValue = "+minValue);
		System.out.println("maxValue = "+maxValue);
		System.out.println("bucketSize = "+bucketSize);
		//给不同的桶子赋值
		for(int i=0;i<array.length;i++) {
			int num  = (array[i]-minValue)/array.length;
			buckets.get(num).add(array[i]);
		}
		
		//对桶子内的数据进行排序
		for(int i=0;i<buckets.size();i++) {
			Collections.sort(buckets.get(i));
		}
		
		//5.输出全部元素 
		int i = 0; 
		for(ArrayList<Integer> intergers : buckets){ 
			for (Integer integer : intergers) { 
				array[i] = integer; i++; 
			} 
		}
		System.out.println(buckets.toString());
	}
}