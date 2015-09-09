package tree;

public class TestTree {

	public static void main(String[] args) {
		//int[] ar={12,10,22,5,8,6,18};
		int[] ar={5,2,6};
		BsTree bsTree=new BsTree();
		bsTree.init(ar);
//		bsTree.add(19);
//		bsTree.print();
//		System.out.println("size="+bsTree.size());
//		bsTree.add(28);
		bsTree.print();
//		System.out.println("size="+bsTree.size());
//		int[] arr=bsTree.toArray();
//		for(int i:arr){
//		System.out.println(i);
//		}
		System.out.println("leafs="+bsTree.leafs());
		System.out.println("nodes="+bsTree.nodes());
		System.out.println("hight="+bsTree.hight());
	}
}
