package leetcode.google;

public enum Digit {
	I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9);

	private int index;

	private Digit(int index) {
		this.index = index;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public static int getNumber(String s) {  
        for (Digit d : Digit.values()) {  
            if (d.name().equals(s)) {  
                return d.index; 
            }  
        }  
        return 0;  
    }

	public static void main(String[] args) {
		System.out.println(getNumber("IV"));
	}
}
