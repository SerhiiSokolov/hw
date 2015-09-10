package tree;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class BSTest {
	BS bs=null;

	@Parameterized.Parameters
	public static Collection<Object[]> primeNumbers()
	{
		return Arrays.asList(new Object[][]{
			{ new BsTree() }			
		});
	}
	public BSTest(BS bs)
	{
		this.bs=bs;
	}

	@Before
	public void setUp()
	{
		bs.clear();
	}

	//=====================================
	// size, init, toArray, print
	//=====================================
	@Test
	public void testSize_null() 
	{
		int[] ini = null;
		bs.init(ini);
		assertEquals(0, bs.size());
		int[] exp = {};
		int[] act = bs.toArray();
		bs.print();
		assertArrayEquals(exp, act);
	}
	@Test
	public void testSize_0() 
	{
		int[] ini = {};
		bs.init(ini);
		assertEquals(0, bs.size());
		int[] exp = {};
		int[] act = bs.toArray();
		bs.print();
		assertArrayEquals(exp, act);
	}
	@Test
	public void testSize_1() 
	{

		int[] ini = {10};
		bs.init(ini);
		assertEquals(1, bs.size());
		int[] exp = {10};
		int[] act = bs.toArray();
		bs.print();
		assertArrayEquals(exp, act);
	}
	@Test
	public void testSize_2() 
	{
		int[] ini = {10,20};
		bs.init(ini);
		assertEquals(2, bs.size());
		int[] exp = {10,20};
		int[] act = bs.toArray();
		bs.print();
		assertArrayEquals(exp, act);
	}
	@Test
	public void testSize_many() 
	{

		int[] ini = {10,20,33,77,11,24,19};
		bs.init(ini);
		assertEquals(7, bs.size());
		int[] exp = {10,11,19,20,24,33,77};
		int[] act = bs.toArray();
		bs.print();
		assertArrayEquals(exp, act);
	}
	//=====================================
	// clear
	//=====================================
	@Test
	public void testClear() 
	{
		int[] ini = {10,20,33,77,11,24,19};
		bs.init(ini);
		assertEquals(7, bs.size());
		bs.clear();
		assertEquals(0, bs.size());
	}	

	//=====================================
	// add
	//=====================================
	@Test
	public void testAdd() 
	{
		int[] ini = {};
		bs.init(ini);
		bs.add(99);
		assertEquals(1, bs.size());
		int[] exp = {99};
		int[] act = bs.toArray();
		assertArrayEquals(exp, act);
	}
	@Test
	public void testAdd_1() 
	{
		int[] ini = {10};
		bs.init(ini);
		bs.add(99);
		assertEquals(2, bs.size());
		int[] exp = {10,99};
		int[] act = bs.toArray();
		assertArrayEquals(exp, act);
	}
	@Test
	public void testAdd_2() 
	{

		int[] ini = {10,20};
		bs.init(ini);
		bs.add(99);
		assertEquals(3, bs.size());
		int[] exp = {10,20,99};
		int[] act = bs.toArray();
		assertArrayEquals(exp, act);
	}
	@Test
	public void testAdd_many() 
	{

		int[] ini = {10,20,33,77,11,24,19};
		bs.init(ini);
		bs.add(99);
		assertEquals(8, bs.size());
		int[] exp = {10,11,19,20,24,33,77,99};
		int[] act = bs.toArray();
		assertArrayEquals(exp, act);
	}

	//=====================================
	// toString
	//=====================================
	@Test
	public void toString_Null() 
	{
		int[] ini = {};
		bs.init(ini);
		String exp = "";
		String act = bs.toString();
		assertEquals(exp, act);
	}
	@Test
	public void toString_1() 
	{
		int[] ini = {10};
		bs.init(ini);
		String exp = "[10,]";
		String act = bs.toString();
		assertEquals(exp, act);
	}
	@Test
	public void toString_2() 
	{
		int[] ini = {10,20};
		bs.init(ini);
		String exp = "[10,20,]";
		String act = bs.toString();
		assertEquals(exp, act);
	}
	@Test
	public void toString_many() 
	{
		int[] ini = {10,20,33,77,11,24,19};
		bs.init(ini);
		String exp = "[10,11,19,20,24,33,77,]";
		String act = bs.toString();
		assertEquals(exp, act);
	}

	//=====================================
	// nodes
	//=====================================

	@Test
	public void nodes_null() 
	{
		int[] ini = {};
		bs.init(ini);
		int exp = 0;
		int act = bs.nodes();
		assertEquals(exp, act);
	}	
	@Test
	public void nodes_1() 
	{
		int[] ini = {10};
		bs.init(ini);
		int exp = 0;
		int act = bs.nodes();
		assertEquals(exp, act);
	}	
	@Test
	public void nodes_2() 
	{
		int[] ini = {10,20};
		bs.init(ini);
		int exp = 1;
		int act = bs.nodes();
		assertEquals(exp, act);
	}
	@Test
	public void nodes_many() 
	{
		int[] ini = {10,20,33,77,11,24,19};
		bs.init(ini);
		int exp = 4;
		int act = bs.nodes();
		assertEquals(exp, act);
	}

	//=====================================
	// leafs
	//=====================================
	@Test
	public void leafs_null() 
	{
		int[] ini = {};
		bs.init(ini);
		int exp = 0;
		int act = bs.leafs();
		assertEquals(exp, act);
	}	
	@Test
	public void leafs_1() 
	{
		int[] ini = {10};
		bs.init(ini);
		int exp = 1;
		int act = bs.leafs();
		assertEquals(exp, act);
	}	
	@Test
	public void leafs_2() 
	{
		int[] ini = {10,20};
		bs.init(ini);
		int exp = 1;
		int act = bs.leafs();
		assertEquals(exp, act);
	}
	@Test
	public void leafs_many() 
	{
		int[] ini = {10,20,33,77,11,24,19};
		bs.init(ini);
		int exp = 3;
		int act = bs.leafs();
		assertEquals(exp, act);
	}

	//=====================================
	// hight
	//=====================================
	@Test
	public void hight_null() 
	{
		int[] ini = {};
		bs.init(ini);
		int exp = 0;
		int act = bs.hight();
		assertEquals(exp, act);
	}	
	@Test
	public void hight_1() 
	{
		int[] ini = {10};
		bs.init(ini);
		int exp = 1;
		int act = bs.hight();
		assertEquals(exp, act);
	}	
	@Test
	public void hight_2() 
	{
		int[] ini = {10,20};
		bs.init(ini);
		int exp = 2;
		int act = bs.hight();
		assertEquals(exp, act);
	}
	@Test
	public void hight_many() 
	{
		int[] ini = {10,20,33,77,11,24,19};
		bs.init(ini);
		int exp = 4;
		int act = bs.hight();
		assertEquals(exp, act);
	}

	//=====================================
	// width
	//=====================================
	@Test
	public void width_null() 
	{
		int[] ini = {};
		bs.init(ini);
		int exp = 0;
		int act = bs.width();
		assertEquals(exp, act);
	}	
	@Test
	public void width_1() 
	{
		int[] ini = {10};
		bs.init(ini);
		int exp = 1;
		int act = bs.width();
		assertEquals(exp, act);
	}	
	@Test
	public void width_2() 
	{
		int[] ini = {10,20};
		bs.init(ini);
		int exp = 1;
		int act = bs.width();
		assertEquals(exp, act);
	}
	@Test
	public void width_many() 
	{
		int[] ini = {10,20,33,77,11,24,19};
		bs.init(ini);
		int exp = 3;
		int act = bs.width();
		assertEquals(exp, act);
	}
	//=====================================
	// reverse
	//=====================================
	@Test
	public void testReverse_0() 
	{

		int[] ini = {};
		bs.init(ini);
		bs.reverse();
		int[] exp = {};
		int[] act = bs.toArray();
		assertArrayEquals(exp, act);
	}
	@Test
	public void testReverse_1() 
	{

		int[] ini = {10};
		bs.init(ini);
		bs.reverse();
		int[] exp = {10};
		int[] act = bs.toArray();
		assertArrayEquals(exp, act);
	}
	@Test
	public void testReverse_2() 
	{

		int[] ini = {10,20};
		bs.init(ini);
		bs.reverse();
		int[] exp = {20,10};
		int[] act = bs.toArray();
		assertArrayEquals(exp, act);
	}
	@Test
	public void testReverse_many() 
	{					
		int[] ini = {10,20,33,77,11,24,19};
		bs.init(ini);
		bs.reverse();
		int[] exp = {77,33,24,20,19,11,10};
		int[] act = bs.toArray();
		assertArrayEquals(exp, act);
	}
}
