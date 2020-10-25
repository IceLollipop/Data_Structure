package com.linkedlist;

public class JosephCircleTest {
	public static void main(String[] args) {
		// 测试一把看看构建环形链表，和遍历是否ok
		JosephCircle circleSingleLinkedList = new JosephCircle();
		circleSingleLinkedList.addNode(25);// 加入5个节点
		circleSingleLinkedList.showCircle();
		//测试一把节点出圈是否正确
		circleSingleLinkedList.count(1, 5, 25);
	}
}


//约瑟夫环
class JosephCircle{
	//约瑟夫环首节点
	private Joseph first = null;
	
	//根据数值构建顺序节点，并添加入约瑟夫环
	public void addNode(int  number) {
		//数据不符合要求，无法添加
		if (number < 1) {
			System.out.println("number的值不正确");
			return;
		}
		//初始化 当前节点
		Joseph curNode = null;
		for(int index = 1;index < number ;index ++) {
			Joseph newNode  = new Joseph(index);
			if(index == 1) {
				//第一个实体节点,并且构建环
				first = newNode;
				first.setNext(first);
				curNode = first;
			}else {
				curNode.setNext(newNode);
				newNode.setNext(first);
				curNode = newNode;
			}
		}
		
	}
	
	//显示约瑟夫环信息
	public void showCircle() {
		if(first == null) {	//空环
			System.out.println("约瑟夫环为空！");
			return;
		}
		//遍历查看约瑟夫环数据
		Joseph curNode  = first;
		while (true) {
			System.out.printf("节点的编号 %d \n", curNode.getNo());
			if (curNode.getNext() == first) {// 说明已经遍历完毕
				break;
			}
			curNode = curNode.getNext(); // curNode后移
		}
	}
	
	/*
	 * @param startNo 起始位置
	 * @param countNo 间隔次数
	 * @param startNo 约瑟夫环节点个数
	 */
	public void count(int startNo,int countNo,int nums) {
		// 先对数据进行校验
		if (first == null || startNo < 1 || startNo > nums) {
			System.out.println("参数输入有误， 请重新输入");
			return;
		}
		
		// 创建要给辅助指针,帮助节点出圈
		Joseph helper = first;
		// 需求创建一个辅助指针(变量) helper , 事先应该指向环形链表的最后这个节点
		while (true) {
			if (helper.getNext() == first) { // 说明helper指向最后小孩节点
				break;
			}
			helper = helper.getNext();
		}
		
		
		//节点count前，先让 first 和  helper 移动 k - 1次
		for(int j = 0; j < startNo - 1; j++) {
			first = first.getNext();
			helper = helper.getNext();
		}
		
		//当小孩报数时，让first 和 helper 指针同时 的移动  m  - 1 次, 然后出圈
		//这里是一个循环操作，知道圈中只有一个节点
		while(true) {
			if(helper == first) { //说明圈中只有一个节点
				break;
			}
			//让 first 和 helper 指针同时 的移动 countNum - 1
			for(int j = 0; j < countNo - 1; j++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			//这时first指向的节点，就是要出圈的小孩节点
			System.out.printf("节点%d出圈\n", first.getNo());
			//这时将first指向的小孩节点出圈
			first = first.getNext();
			helper.setNext(first); //
		}
		System.out.printf("最后留在圈中的节点编号%d \n", first.getNo());
	}
}

//约瑟夫环 节点
class Joseph{
	public int number;
	
	public Joseph next;
	
	public Joseph(int number) {
		this.number = number;
	}
	
	public int getNo() {
		return this.number;
	}
	
	public void setNo(int number) {
		this.number = number;
	}
	
	public Joseph getNext() {
		return this.next;
	}
	
	public void setNext(Joseph next) {
		this.next = next;
	}
}