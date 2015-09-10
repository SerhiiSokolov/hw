package tree;

public class TestTree {

	public static void main(String[] args) {
		//int[] ar={50,25,10,30,5,15,27,35,90,75,125,70,80,110,130};
		int[] ar={10,20,33,77,11,24,19};
		BsTree bsTree=new BsTree();
		bsTree.init(ar);
//		bsTree.add(19);
//		bsTree.add(20);
//		bsTree.add(21);
//		bsTree.print();
//		System.out.println("size="+bsTree.size());
//		bsTree.add(28);
		bsTree.print();
//		System.out.println("size="+bsTree.size());
//		int[] arr=bsTree.toArray();
//		for(int i:arr){
//		System.out.println(i);
//		}
//		System.out.println("leafs="+bsTree.leafs());
//		System.out.println("nodes="+bsTree.nodes());
//		System.out.println("hight="+bsTree.hight());
//		System.out.println("width="+bsTree.width());
//		bsTree.reverse();
//		System.out.println("After revers");
//		bsTree.print();
		bsTree.del(10);
		bsTree.print();
	}
}
