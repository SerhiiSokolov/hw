package tree;

public class BsTree implements BS {
	private Node root=null;
	private int count=0;
	private int[] array;
	private String string;
	public void init(int ini[]){
		if(ini==null) root=null;
		else {
			for(int i:ini){
				add(i);
			}
		}
	}

	public void add(int val) {
		if(root==null) root=new Node(val);
		else{ 
			addNode(root,val);
		}
	}
	private void addNode(Node next,int val){
		if(next.data>val){
			if(next.left==null){
				next.left=new Node(val);
			}
			else{
				addNode(next.left, val);
			}
		}
		else if(next.data<val){
			if(next.right==null){
				next.right=new Node(val);
			}
			else{
				addNode(next.right, val);
			}
		}
	}

	public void clear(){
		root=null;
	}

	@Override
	public int size() {
		count=0;
		getSize(root);
		return count; 
	}
	private void getSize(Node next){
		if(next==null) return;
		getSize(next.left);
		count++;
		getSize(next.right);
	}

	@Override
	public int[] toArray() {
		array=new int[size()];
		count=0;
		getArray(root);
		return array;
	}
	private void getArray(Node next) {
		if(next==null) return;
		getArray(next.left);
		array[count++]=next.data;
		getArray(next.right);
	}

	@Override
	public void del(int val) {
		root = delData(val, root );
	}
	private Node delData(int val, Node next) {
		if( next == null )
			return null;   // Item not found; do nothing
		if(val<next.data){
			next.left=delData(val,next.left);
		}
		else if(val>next.data){
			next.right=delData(val, next.right);

		}
		else if(next.left!=null && next.right!=null){
			next.data=findMin(next.right).data;
			next.right=delData(next.data, next.right);
		}
		else {
			if(next.left!=null){
				next=next.left;
			}
			else{
				next=next.right;
			}
		}
		return next;
	}
	private Node findMin(Node next) {    
		if( next == null )
			return null;
		else if( next.left == null )
			return next;
		return findMin(next.left);
	}

	@Override
	public int nodes() {
		count=0;
		getNodes(root);
		return count;
	}
	private void getNodes(Node next) {
		if(next==null) return;
		getNodes(next.left);
		if(next.left!=null||next.right!=null) {
			count++;
		}
		getNodes(next.right);
	}

	@Override
	public int leafs() {
		count=0;
		getLeafs(root);
		return count;
	}
	private void getLeafs(Node next) {
		if(next==null) return;
		getLeafs(next.left);
		if(next.left==null&&next.right==null) {
			count++;
		}
		getLeafs(next.right);
	}

	@Override
	public int hight() {
		count=getHight(root);
		return count;
	}
	private int getHight(Node next) {
		if(next == null) return 0;
		return 1 + Math.max(getHight(next.left), getHight(next.right));
	}

	@Override
	public int width() {
		Node next=root;
		int maxWidth=0;
		int i;
		int width=0;
		int h=hight();
		for(i=1;i<=h;i++){
			width=getWidth(next, i);
			if(width > maxWidth)
				maxWidth  = width;
		}
		return maxWidth;
	}
	private int getWidth(Node next,int level)
	{
		if (next==null) return 0;
		if (level == 1) return 1;
		else 
			return getWidth(next.left, level-1) +  getWidth(next.right, level-1);
	}

	@Override
	public void reverse() {
		makeRevers(root);
	}	
	private void makeRevers(Node next){
		Node temp=next;
		if(next!=null)
		{
			if(next.left!=null  ||  next.right!=null) 
			{
				temp = next.left;
				next.left = next.right;
				next.right = temp;
				makeRevers(next.left);
				makeRevers(next.right);
			}	
		}
	}

	@Override
	public void print() {
		System.out.println("Print tree:");
		printTree(root);
		System.out.println();
	}
	private void printTree(Node next){
		if(next==null) return;
		printTree(next.left);
		System.out.print(next.data+",");
		printTree(next.right);
	}

	public String toString(){
		if(root==null) string="";
		else{ 
			string="[";
			getString(root);
			string+="]";
		}
		return string;
	}	
	private void getString(Node next) {
		if(next==null) return;
		getString(next.left);
		string=string+next.data+",";
		getString(next.right);
	}

	private class Node{
		int data;
		Node left;
		Node right;
		public Node(int data){
			this.data=data;
		}
	}
}
