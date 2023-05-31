import java.util.Scanner;

public class Calc{
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the expression");
		String exp = sc.nextLine();
		int len = exp.length();
		int pos1 = 0;
		int pos2 = 0;
		int p1 = checkForBracket(exp, len, pos1);
		int p2 = checkForCloseBrac(exp, len, pos2);
		int result = met(exp, p1, p2);
		exp = met2(exp, result, p1, p2, len);
		len=exp.length();
		int fresult = fmet(exp, p1, len);
		System.out.println("The position of opening and closing brackets are: " + p1 + ", " + p2);
		System.out.println("The result for the expression is: " + String.valueOf(result));
		System.out.println("The final expression is: " + exp);
		System.out.println("The final result is: " + fresult);
			}

	static int checkForBracket(String e, int l, int p){
		for (int i=0; i<l; i++) {
			char a = e.charAt(i);
			if (a=='(')
			p=i;
		}		
		return p;
	}
	static int checkForCloseBrac(String f, int le, int q) {
		for (int j=0; j<le; j++) {
			char b = f.charAt(j);
			if (b == ')')
				q=j;
		}
		return q;
	}
	static int met(String e1, int p11, int p21) {
		String val="";
		int res=0;
		char symbol='+';
		for (int k=p11+1; k<p21; k++) {
			char d = e1.charAt(k);
			if (d=='+' || d == '-' || d == '*' || d == '/') {
		if(symbol== '+') {
			res = res+Integer.valueOf(val);
			val="";
		}
		if (symbol=='-') {
			res = res - Integer.valueOf(val);
			val="";
		}
		if (symbol=='*') {
			res = res * Integer.valueOf(val);
			val="";
		}
		if (symbol=='/') {
			res = res / Integer.valueOf(val);
			val="";
		}
		symbol=d;
		}
		else {
			val=val+d;
		}
		if(k==p21-1) {
			if(symbol== '+') {
		res = res+Integer.valueOf(val);
		val="";
			}
			if (symbol=='-') {
		res = res-Integer.valueOf(val);
		val="";
			}
			if (symbol=='*') {
		res = res*Integer.valueOf(val);
		val="";
			}
			if (symbol=='/') {
		res = res/Integer.valueOf(val);
		val="";
			}
		}
			}

				return res;
	}
	static String met2(String ep, int r, int pf, int pl, int fl) {
		String exp2="";
		for (int n=0; n<pf; n++) {
			exp2 = exp2+ep.charAt(n);
		}
		ep=exp2+ String.valueOf(r);
		for (int o=pl+1; o<fl; o++) {
			exp2 = exp2+ep.charAt(o);
		}
		return ep;
	}
	static int fmet(String e3, int pf, int pl) {
		String val1="";
		int res1=0;
		char symbol1='+';
		for (int k1=0; k1<pl; k1++) {
			char d1 = e3.charAt(k1);
			if (d1=='+' || d1 == '-' || d1 == '*' || d1 == '/') {
		if(symbol1== '+') {
			res1 = res1+Integer.valueOf(val1);
			val1="";
		}
		if (symbol1=='-') {
			res1 = res1 - Integer.valueOf(val1);
			val1="";
		}
		if (symbol1=='*') {
			res1 = res1 * Integer.valueOf(val1);
			val1="";
		}
		if (symbol1=='/') {
			res1 = res1 / Integer.valueOf(val1);
			val1="";
		}
		symbol1=d1;
		}
		else {
			val1=val1+d1;
		}
		if(k1==pl-1) {
			if(symbol1== '+') {
		res1 = res1+Integer.valueOf(val1);
		val1="";
			}
			if (symbol1=='-') {
		res1 = res1-Integer.valueOf(val1);
		val1="";
			}
			if (symbol1=='*') {
		res1 = res1*Integer.valueOf(val1);
		val1="";
			}
			if (symbol1=='/') {
		res1 = res1/Integer.valueOf(val1);
		val1="";
			}
		}
			}	
		return res1;
	}

}