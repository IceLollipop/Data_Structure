package com.queue;

import java.util.Scanner;

/*
 * @author Zhang
 * @Date 2020.10.18
 * 本练习主要目的是:使用环形数组实现队列功能
 */

public class ArraySimulationQueue {
	public static void main(String[] args) {
		
		System.out.println("测试数组模拟环形队列的案例~~~");
		// 创建一个环形队列
		Queue queue = new Queue(4); //说明设置4, 其队列的有效数据最大是3
		char key = ' '; // 接收用户输入
		Scanner scanner = new Scanner(System.in);//
		boolean loop = true;
		// 输出一个菜单
		while (loop) {
			System.out.println("s(show): 显示队列");
			System.out.println("e(exit): 退出程序");
			System.out.println("a(add): 添加数据到队列");
			System.out.println("g(get): 从队列取出数据");
			System.out.println("h(head): 查看队列头的数据");
			key = scanner.next().charAt(0);// 接收一个字符
			switch (key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("输入一个数");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':// 取出数据
				try {
					int res = queue.getQueue();
					System.out.printf("取出的数据是%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'h':  // 查看队列头的数据
				try {
					int res = queue.headQueue();
					System.out.printf("队列头的数据是%d\n", res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'e': // 退出
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
		System.out.println("程序退出~~");
	}
}

class Queue{
	private int maxSize;
	private int front;
	private int rear;
	private int[] array;
	
	public Queue(int maxSize){
		this.maxSize = maxSize;
		this.array = new int[maxSize];
	}
	
	public boolean isEmpty() {
		//判断当前队列是否为空
		return front == rear;
	}
	
	public boolean isFull() {
		return (rear+1) % maxSize == front;
	}
	
	public void addQueue(int n) {
		//把数据添加入队列,如果数据已经满了，无法插入
		if(isFull()) {
			System.out.println("当前队列数据已满!");
			return;
		}
	
		array[rear] = n ;
		rear = (rear + 1) % maxSize;
	}
	
	public int getQueue() {
		if(isEmpty()) {
			throw new RuntimeException("当前队列为空!");
		}
		int value  = array [front];
		front  = ( front + 1 ) % maxSize;
		return value;
	}
	
	public void showQueue() {
		if (isEmpty()) {
			System.out.println("当前队列为空!");
			return;
		}

		for (int i = front; i < front + size() ; i++) {
			System.out.printf("arr[%d]=%d\n", i % maxSize, array[i % maxSize]);
		}
	}
	
	public int size() {
		return (rear - front + maxSize) % maxSize;
	}
	
	public int headQueue() {
		
		if (isEmpty()) {
			throw new RuntimeException("当前队列为空!");
		}
		return array[front];
	}
	
}