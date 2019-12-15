package leetcode.line;

import java.util.Arrays;

public class RomantoInteger {
	// http://www.rapidtables.com/convert/number/roman-numerals-converter.htm
	// has bug, CM=900, XCII=92, MCMLXXXIV=1984, 忘记考虑小数在大数左边的情况,例如I在X左边,C在M左边
	public static void main(String[] args) {
		RomantoInteger so = new RomantoInteger();
		// new bug MCMLXIX=1969
		System.out.println(so.romanToInt("MMMDLXXXVI"));// 15=10+5=10*10^0+5*10^0
	}

	public int romanToInt(String s) {
		int len = s.length();
		int partOne = 1;
		int partTwo = 1;
		int oldValueTwo = 0;
		boolean flag = false;
		int count = 0;
		for (int i = len - 1; i >= 0; i--) {
			if (!flag) {
				partOne = Arrays.binarySearch(digit, s.substring(i));
				//partOne = getDigit(s.substring(i));
				if (partOne > 0) {
					count = partOne;
				}
			}
			if (partOne <= 0) {
				flag = true;
			}
			if (flag) {
				char c = s.charAt(i);
				partTwo = getUnit(c);
				if (partTwo == 0) {
					partTwo = getDigit(String.valueOf(c));
					if (oldValueTwo > partTwo) {
						count = oldValueTwo - partTwo;
					}
				} else {
					if (oldValueTwo > partTwo) {
						count -= partTwo;
					} else {
						count += partTwo * (Math.pow(10, 0));
					}
				}
				oldValueTwo = partTwo;
			}
		}
		return count;
	}
	
	final String digit[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};

	private int getDigit(String c) {
		int num = 0;
		switch (c) {
		case "I":
			num = 1;
			break;
		case "II":
			num = 2;
			break;
		case "III":
			num = 3;
			break;
		case "IV":
			num = 4;
			break;
		case "V":
			num = 5;
			break;
		case "VI":
			num = 6;
			break;
		case "VII":
			num = 7;
			break;
		case "VIII":
			num = 8;
			break;
		case "IX":
			num = 9;
			break;
		default:
			num = 0;
			break;
		}
		return num;
	}

	private int getUnit(char c) {
		int num = 0;
		switch (c) {
		case 'X':
			num = 10;
			break;
		case 'L':
			num = 50;
			break;
		case 'C':
			num = 100;
			break;
		case 'D':
			num = 500;
			break;
		case 'M':
			num = 1000;
			break;
		default:
			num = 0;
			break;
		}
		return num;
	}
}
