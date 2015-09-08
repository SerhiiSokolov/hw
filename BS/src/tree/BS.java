package tree;

public interface BS {
	int size();
	void init(int[] ini);
	int[] toArray();
	void clear();
	void add(int val);
	void del(int val);
	String toString();
	int nodes();
	int leafs();
	int hight();
	int width();
	void reverse();
	void print();
}
