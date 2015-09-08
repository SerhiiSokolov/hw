package tree;

public class BsTree implements BS {
	Node root=null;
	static int count=0;
	
	public void init(int ini[]){
		for(int i:ini){
			System.out.println("i="+i);
			add(i);
		}
	}

	public void add(int val) {
		Node node=new Node(val);
		Node next=null;
		if (root==null) root=node;
		else{ 
			next=root;
			next=findParent(next, node);
			if(next.data>node.data) next.left=node;
			else next.right=node;
		}
		System.out.println("end");
	}

	public void clear(){
		root=null;
	}
	
	private Node findParent(Node parent, Node node) {
		Node tmp=null;
		while (parent!=null)
		{
			System.out.println("parent data="+parent.data);
			if(node.data>parent.data) {		
				tmp=parent;
				parent=parent.right;
				System.out.println("right "+ tmp.data);
			}
			else  {
				tmp=parent;
				parent=parent.left;
				System.out.println("left "+ tmp.data);
			}
		}

		System.out.println("Data of parent element is "+tmp.data);
		return tmp;
	}

	@Override
	public int size() {		
		Node next=root;
		
		return count;
	}

	@Override
	public int[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void del(int val) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int nodes() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int leafs() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hight() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int width() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void reverse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void print() {
		// TODO Auto-generated method stub
		
	}
	
	public class Node{
		int data;
		Node left;
		Node right;
		public Node(int data){
			this.data=data;
		}
	}
}
