package week3level4;

import java.util.List;

public final class MyImmutableClass {
	private final int variable;
	private final List<Integer> integersList;
		
	public MyImmutableClass(int var, List<Integer> list) {
		this.variable = var;
		this.integersList = list;
	}

	public int getVariable() {
		return variable;
	}

	public List<Integer> getIntegersList() {
		return integersList;
	}
	
}
