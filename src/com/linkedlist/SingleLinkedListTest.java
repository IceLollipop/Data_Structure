package com.linkedlist;

public class SingleLinkedListTest {
	public static void main(String[] args) {
		SingleLinkedList list = new SingleLinkedList();
		
		list.addNode(new Node(1,"String1"));
		list.addNode(new Node(2,"String2"));
		list.addNode(new Node(3,"String3"));
		list.addNode(new Node(4,"String4"));
		list.addNode(new Node(5,"String5"));
		
		list .deleteNode(3);
		list.updateNode(new Node(5,"UpdateString1"));
		list.listNode();
	}
}

class SingleLinkedList {
	//单链表中,只需要一个空数据头节点即可,
	private Node head = new Node(0,"");
	
	//查询头节点
	public Node getHead() {
		return this.head;
	}
	
	//新增节点
	public void addNode(Node newNode) {
		Node curNode = head;
		//从头节点一直向后查询到可插入位置
		while(true) {
			if(curNode.next != null) {
				curNode = curNode.next;
			}else {
				curNode.next = newNode;
				System.out.println("添加了节点"+newNode+'!');
				break;
			}
		}
		System.out.println("添加节点流程结束！");
	}
	
	//展示所有节点
	public void listNode() {
		Node curNode = head;
		if(curNode.next == null) {
			System.out.println("当前单向链表为空！");
		}
		//找到第一个数据节点
		curNode = curNode.next;
		while(true) {
			if(curNode.next != null) {
				System.out.println(curNode);
				curNode = curNode.next;
			}else {
				System.out.println(curNode);
				break;
			}
		}
	}
	
	//根据节点number值删除节点
	public void deleteNode(int number) {
		Node curNode = head;
		boolean checkedNode = false;
		//遍历数组节点
		while(true) {
			if(curNode.next != null) {
				System.out.println(curNode);
				if(curNode.next.number == number) {
					checkedNode = true;
					break;
				}
				curNode = curNode.next;
			}else {
				break;
			}
		}
		if(checkedNode) {
			//有待删除节点
			curNode.next = curNode.next.next;
			System.out.println("待删除的节点已经删除！");
		}else {
			System.out.println("当前链表没有待删除的节点！");
		}
	}
	
	
	//根据节点类型值
	public void updateNode(Node newNode) {
		Node curNode = head;
		boolean checkedNode = false;
		//遍历数组节点
		while(true) {
			if(curNode.next != null) {
				System.out.println(curNode);
				if(curNode.next.number == newNode.number) {
					checkedNode = true;
					break;
				}
				curNode = curNode.next;
			}else {
				break;
			}
		}
		if(checkedNode) {
			//有待删除节点
			curNode.next.number = newNode.number;
			curNode.next.name = newNode.name;
			System.out.println("节点信息已经修改");
		}else {
			System.out.println("没有可以修改的节点!");
		}
	}
	
}

class Node{
	//节点值
	public int number;
	public String name;

	//指向下一个节点
	public Node next;
	
	public Node(int number,String name) {
		this.number = number;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Node [number=" + number + ", name=" + name + "]";
	}
}
