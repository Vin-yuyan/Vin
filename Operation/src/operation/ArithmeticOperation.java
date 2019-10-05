package operation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ArithmeticOperation {
	public static void main(String[] args) {
		String str = "0.34 +3.9*(7 - 2*  3.6) /0.66+8-(9.3+8/3)";
		BigDecimal result = cal(str);
		System.out.println(result);
	}
 
	public static BigDecimal cal(String str) {
		List<String> list = new ArrayList<>();
		char[] arr = str.toCharArray();
		StringBuffer tmpStr = new StringBuffer();
		for (char c : arr) {
			if (c >= '0' && c <= '9') {
				tmpStr.append(c);
			} else if (c == '.') {
				if (tmpStr.indexOf(".") > 0) {
					throw new RuntimeException("非法字符");
				}
				tmpStr.append(c);
			}
			else if (c == '+' || c == '-' || c == '*' || c == '/' || c == '(' || c == ')') {
				if (tmpStr.length() > 0) {
					list.add(tmpStr.toString());
					tmpStr.setLength(0);
				}
				list.add(c + "");
			}
			else if (c == ' ') {
				continue;
			} else {
				throw new RuntimeException("非法字符");
			}
		}
		if (tmpStr.length() > 0) {
			list.add(tmpStr.toString());
		}
		List<String> strList = new ArrayList<>();
		Stack<String> stack = new Stack<>();
		String tmp;
		for (String s : list) {
			if (s.equals("(")) {
				stack.push(s);
			}
			else if (s.equals(")")) {
				while (!(tmp = stack.pop()).equals("(")) {
					strList.add(tmp);
				}
			}
			else if (s.equals("*") || s.equals("/")) {
				while (!stack.isEmpty()) {
					tmp = stack.peek();
					if (tmp.equals("*") || tmp.equals("/")) {
						stack.pop();
						strList.add(tmp);
					} else {
						break;
					}
				}
				stack.push(s);
			} else if (s.equals("+") || s.equals("-")) {
				while (!stack.isEmpty()) {
					// 取出栈顶元素
					tmp = stack.peek();
					if (!tmp.equals("(")) {
						stack.pop();
						strList.add(tmp);
					} else {
						break;
					}
				}
				stack.push(s);
			}
			else {
				strList.add(s);
			}
		}
		while (!stack.isEmpty()) {
			strList.add(stack.pop());
		}
		Stack<BigDecimal> newStack = new Stack<>();
		for (String s : strList) {
			if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
				BigDecimal b1 = newStack.pop();
				BigDecimal b2 = newStack.pop();
				switch (s) {
				case "+":
					newStack.push(b2.add(b1));
					break;
				case "-":
					newStack.push(b2.subtract(b1));
					break;
				case "*":
					newStack.push(b2.multiply(b1));
					break;
				case "/":
					newStack.push(b2.divide(b1, 9, BigDecimal.ROUND_HALF_UP));
					break;
				}
			}
			else {
				newStack.push(new BigDecimal(s));
			}
		}
		return newStack.peek();
	}
}
