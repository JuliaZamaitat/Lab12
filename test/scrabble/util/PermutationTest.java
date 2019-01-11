package scrabble.util;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PermutationTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void permutationStoresOriginalWord() {
		Permutation p = new Permutation("hallo");
		assertEquals("hallo", p.getWord());
	}

	@Test
	public void testNormalize2() {
		assertEquals("ab", (new Permutation("ab")).getNormalized());
	}

	@Test
	public void testNormalize3() {
		assertEquals("ab", (new Permutation("ba")).getNormalized());
	}

	@Test
	public void testNormalize4() {
		assertEquals("addehkms", (new Permutation("aksdehmd")).getNormalized());
	}

	@Test
	public void testEquals1() {
		assertTrue((new Permutation("abenr")).equals(new Permutation(
				"barne")));
	}

	@Test
	public void testEquals2() {
		assertTrue(new Permutation("berlin").equals(new Permutation("linber")));
	}
	
	@Test
	public void testEqual3() {
		assertFalse(new Permutation("berlin").equals(new Permutation("linper")));
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Test
	public void testEqualsOtherType() {
		assertFalse(new Permutation("berlin").equals(new Integer(42)));
	}

	/*
	@Test
	public void testToString() {
		// you may change this if you prefer another string representation of your Permutation
		assertEquals("[abc] bca", (new Permutation("bca")).toString());
	}*/

	@Test
	public void testNormalize1() {
		assertEquals("a", (new Permutation("a")).getNormalized());
	}

}
