package urdu.programmer.dldcalculator;

public class ConverterClass {

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
			case "a":
				dig = "10";
				break;
			case "B":
			case "b":
				dig = "11";
				break;
			case "C":
			case "c":
				dig = "12";
				break;
			case "D":
			case "d":
				dig = "13";
				break;
			case "E":
			case "e":
				dig = "14";
				break;
			case "F":
			case "f":
				dig = "15";

			default:
				break;
		}
		return dig;
	}
	// Decimal to all
	public String decimal_to_all(String str, long base) {
		//
		double num = Double.parseDouble(str);
		long whole_part = (long) num;
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
				long b_dig = (long) num1;
				if (base == 16) {
					String hex;
					hex = hexCode(b_dig + "");
					fraction = fraction + hex;

				}
				else {
					fraction = fraction + b_dig;
				}
				fractional_part = num1 - b_dig;
			} while (fractional_part != 0);
			return reverse(bin) + "." + fraction;
		}
		return reverse(bin);
	}

	/// Binary to all
	public String binary_to_all(String bin, long base) {
		double num;
		long whole;
		String wholeStr;
		if(isFloat(bin)) {
			num = Double.parseDouble(bin);
			whole = (long) num;
			wholeStr = whole + "";

		}
		else {
			wholeStr = bin;
		}

		long decimal = 0;

		int i;
		for (i = 0; i < wholeStr.length(); i++) {
			long digit = Long.parseLong(wholeStr.charAt(wholeStr.length() - 1 - i) + "");
			decimal = decimal + (digit * (long) Math.pow(2, i));
		}

		String deci;
		i++;
		if (isFloat(bin)) {
			double frac = 0;
			long k = -1;
			for (int j = i; j < bin.length(); j++) {
				if (bin.charAt(j) != '.') {
					long digit = Long.parseLong(bin.charAt(j) + "");
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
	public String octal_to_all(String octal, long base) {
		String bin = "";
		long whole;
		String wholeStr;
		int i;
		double num;


		if(isFloat(octal)) {
			num = Double.parseDouble(octal);
			whole = (long) num;
			wholeStr = whole + "";

		}
		else {
			wholeStr = octal;
		}

		// convert whole part longo binary
		for (i = 0; i < wholeStr.length(); i++) {
			String binDig = decimal_to_all((wholeStr.charAt(i) + ""), 2);
			for (long k = binDig.length(); k < 3; k++) {

				binDig = "0" + binDig;
			}
			bin = bin + binDig;
		}




		if (isFloat(octal)) {
			String frac = "";
			for (int j = i + 1; j < octal.length(); j++) {
				String binDig = decimal_to_all((octal.charAt(j) + ""), 2);
				for (long k = binDig.length(); k < 3; k++) {

					binDig = "0" + binDig;
				}
				frac = frac + binDig;
			}
			bin = bin + "." + frac;
		}
		for(int j = 0; j < bin.length(); j++) {
			if(bin.charAt(j) != '0') {
				String withoutZero = "";
				for(int k = j; j < bin.length(); k++) {
					withoutZero = withoutZero + bin.charAt(k);
					j++;
				}
				bin = withoutZero;
			}
		}
		return binary_to_all(bin, base);
	}


	// hex converter
	public String hex_to_all(String hex, long base) {
		String bin = "";
		for(int i = 0; i < hex.length(); i++) {
			if(hex.charAt(i) != '.') {
				String binDig = decimal_to_all(codeHex((hex.charAt(i) + "")), 2);
				for (long k = binDig.length(); k < 4; k++) {

					binDig = "0" + binDig;
				}

				bin = bin + binDig;


				if(isFloat(hex)) {
					if(hex.charAt(i+1) == '.') {
						String frac = "";
						for (int j = ++i; j < hex.length(); j++, i++) {
							if(hex.charAt(j) != '.') {
								binDig = decimal_to_all(codeHex((hex.charAt(j) + "")), 2);
								for (long k = binDig.length(); k < 4; k++) {

									binDig = "0" + binDig;
								}
								frac = frac + binDig;
							}
						}
						bin = bin + "." + frac;
					}
				}

			}

		}
		return binary_to_all(bin, base);
	}
}