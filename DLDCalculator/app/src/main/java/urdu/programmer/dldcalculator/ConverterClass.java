package urdu.programmer.dldcalculator;

class Convertor {
	public static String reverse(String value) {
		String reversed = "";
		for (int i = 0; i < value.length(); i++) {
			reversed = reversed + value.charAt(value.length() - 1 - i);
		}
		return reversed;
	}

	static boolean isFloat(String str) {
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '.') {
				return true;
			}
		}
		return false;
	}

	static String hexCode(String dig) {
		switch (dig) {
		case "10":
			dig = "A";
			break;
		case "11":
			dig = "B";
			break;
		case "12":
			dig = "C";
			break;
		case "13":
			dig = "D";
			break;
		case "14":
			dig = "E";
			break;
		case "15":
			dig = "F";
			break;
		default:
			break;
		}
		return dig;
	}
	
	static String codeHex(String dig) {
		switch (dig) {
		case "A":
			dig = "10";
			break;
		case "B":
			dig = "11";
			break;
		case "C":
			dig = "12";
			break;
		case "D":
			dig = "13";
			break;
		case "E":
			dig = "14";
			break;
		case "F":
			dig = "15";
			break;
		default:
			break;
		}
		return dig;
	}
	// Decimal to all
	public String decimal_to_all(String str, int base) {
		//
		double num = Double.parseDouble(str);
		int whole_part = (int) num;
		double fractional_part = num - whole_part;
		String bin = "";

		// converting whole part
		while (whole_part != 0) {
			String digit = String.valueOf(whole_part % base);
			if (base == 16) {
				digit = hexCode(digit);
			}
			bin = bin + digit;
			whole_part = whole_part / base;

		}

		// converting fractional part
		if (isFloat(str)) {
			String fraction = "";
			double num1;
			do {
				num1 = fractional_part * base;

				int b_dig = (int) num1;
				fraction = fraction + b_dig;
				fractional_part = num1 - b_dig;
			} while (fractional_part != 0);
			return reverse(bin) + "." + fraction;
		}
		return reverse(bin);
	}

	/// Binary to all
	public String binary_to_all(String bin, int base) {

		double num = Double.parseDouble(bin);
		int whole = (int) num;

		String wholeStr = whole + "";
		int decimal = 0;

		int i;
		for (i = 0; i < wholeStr.length(); i++) {
			int digit = Integer.parseInt(wholeStr.charAt(wholeStr.length() - 1 - i) + "");
			decimal = decimal + (digit * (int) Math.pow(2, i));
		}

		String deci;
		i++;
		if (isFloat(bin)) {
			double frac = 0;
			int k = -1;
			for (int j = i; j < bin.length(); j++) {
				if (bin.charAt(j) != '.') {
					int digit = Integer.parseInt(bin.charAt(j) + "");
					frac = frac + (digit * Math.pow(2, k));
					k--;
				}
			}
			deci = decimal_to_all(((decimal + frac) + ""), base);

		} else {
			deci = decimal_to_all((decimal + ""), base);
		}
		return deci;
	}
	
	// octal to all number system
	public String octal_to_all(String octal, int base) {
		String bin = "";
		int whole = (int) Double.parseDouble(octal);
		String wholeStr = whole + "";
		int i;

		// convert whole part into binary
		for (i = 0; i < wholeStr.length(); i++) {
			String binDig = decimal_to_all((wholeStr.charAt(i) + ""), 2);
			for (int k = binDig.length(); k < 3; k++) {

				binDig = "0" + binDig;
			}
			bin = bin + binDig;
		}

		if (isFloat(octal)) {
			String frac = "";
			for (int j = i + 1; j < octal.length(); j++) {
				String binDig = decimal_to_all((octal.charAt(j) + ""), 2);
				for (int k = binDig.length(); k < 3; k++) {

					binDig = "0" + binDig;
				}
				frac = frac + binDig;
			}
			bin = bin + "." + frac;
		}
		return binary_to_all(bin, base);
	}
	
	
	// hex converter
	public String hex_to_all(String hex, int base) {
		String bin = "";
		for(int i = 0; i < hex.length(); i++) {
			if(hex.charAt(i) != '.') {
				String binDig = decimal_to_all(codeHex((hex.charAt(i) + "")), 2);
				for (int k = binDig.length(); k < 4; k++) {

					binDig = "0" + binDig;
				}
				bin = bin + binDig;
				if(hex.charAt(i+1) == '.') {
					String frac = "";
					for (int j = ++i; j < hex.length(); j++, i++) {
						if(hex.charAt(j) != '.') {
						binDig = decimal_to_all(codeHex((hex.charAt(j) + "")), 2);
						for (int k = binDig.length(); k < 4; k++) {

							binDig = "0" + binDig;
						}
						frac = frac + binDig;
					}
					}
					bin = bin + "." + frac;
				}
			}
			
		}
		return binary_to_all(bin, base);
	}
}