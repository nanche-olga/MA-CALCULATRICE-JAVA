package projet4;

import java.util.Scanner;

class employee {
	static String newOperation = "/", result;
	
}

public class Calculator {
	private String operation;

	public Calculator() {
	}

	public void newOperation() {
		System.out.println("");
		Scanner sssc = new Scanner(System.in);
		operation = sssc.nextLine();

	}

	public String getOperation() {
		return (operation);
	}

	public int verifyOperation() {
		for (int i = 0; i < operation.length(); i++) {
			char str, str30;
			str = operation.charAt(i);
			boolean strIsOperator = str == '/' || str == '*' || str == '+' || str == '-' || str == '=';
			if (i == operation.length() - 1 && strIsOperator)
				return (i);
			if (i == 0 && (str == '/' || str == '*'))
				return (i);
			if (i < operation.length() - 2) {
				str30 = operation.charAt(i + 1);
				boolean str3IsOperator = str30 == '/' || str30 == '*' || str30 == '+' || str30 == '-' || str30 == '=';
				if ((strIsOperator) && (str3IsOperator)) {

					if (i < operation.length() - 4 && i >= 3)
						return (i);
					else
						return (i);
				}
			}
		}
		return -1;

	}

	public String calculate() {
		int m1,m2;
		
	    if(countSubOperation(operation)==1)
	    {
		return calculateSimpleOperation(operation);
		}
		else {
			String newOperation=operation;
			int nombreOperation = countSubOperation(newOperation);
			while (nombreOperation!=1 ) {
				while(newOperation.contains("/")&&nombreOperation!=1) {
					if(newOperation.charAt(nextOperator(0,newOperation))=='/'&&nombreOperation!=1) {
						int m6=nextOperator(0,newOperation);
						int m7=nextOperator(m6,newOperation);
						String m5=division(newOperation.substring(0,m7));
						newOperation=m5+newOperation.substring(m7,newOperation.length());
						nombreOperation = countSubOperation(newOperation);
						 System.out.println("newOperation="+newOperation);
					}
					if(newOperation.charAt(previousOperator(newOperation.length()-1,newOperation))=='/'&&nombreOperation!=1) {
						int m6=previousOperator(newOperation.length()-1,newOperation);
						int m7=previousOperator(m6,newOperation);
						String m5=division(newOperation.substring((m7+1),newOperation.length()));
						newOperation=newOperation.substring(0,(m7+1))+m5;
						nombreOperation = countSubOperation(newOperation);
						 System.out.println("newOperation="+newOperation);
					}

					for(int i=0;i < newOperation.length();i++) {
						char nombre =newOperation.charAt(i);
						if(nombre=='/'&&nombreOperation!=1) {
							m1=previousOperator(i,newOperation);
						    m2=nextOperator(i,newOperation);
						    System.out.println("m1="+m1);
						     System.out.println("m2="+m2);
						    String m4=newOperation.substring((m1+1),m2);
						    String m3=calculateSimpleOperation(m4);
						    newOperation=newOperation.substring(0,(m1+1))+m3+newOperation.substring(m2,newOperation.length());
						    nombreOperation = countSubOperation(newOperation);
						    System.out.println("newOperation="+newOperation);
						    }
						}
				    }
				
					while(newOperation.contains("*")&&nombreOperation!=1) {
						if(newOperation.charAt(nextOperator(0,newOperation))=='*'&&nombreOperation!=1) {
							int m6=nextOperator(0,newOperation);
							int m7=nextOperator(m6,newOperation);
							String m5=multiplication(newOperation.substring(0,m7));
							newOperation=m5+newOperation.substring(m7,newOperation.length());
							nombreOperation = countSubOperation(newOperation);
							 System.out.println("newOperation="+newOperation);
						}
						if(newOperation.charAt(previousOperator(newOperation.length()-1,newOperation))=='*'&&nombreOperation!=1) {
							int m6=previousOperator(newOperation.length()-1,newOperation);
							int m7=previousOperator(m6,newOperation);
							String m5=multiplication(newOperation.substring((m7+1),newOperation.length()));
							newOperation=newOperation.substring(0,(m7+1))+m5;
							nombreOperation = countSubOperation(newOperation);
							 System.out.println("newOperation="+newOperation);
						}

						for(int i=0;i < newOperation.length();i++) {
							char nombre =newOperation.charAt(i);
							if(nombre=='*'&&nombreOperation!=1) {
								m1=previousOperator(i,newOperation);
							    m2=nextOperator(i,newOperation);
							    System.out.println("m1="+m1);
							     System.out.println("m2="+m2);
							    String m4=newOperation.substring((m1+1),m2);
							    String m3=calculateSimpleOperation(m4);
							    newOperation=newOperation.substring(0,(m1+1))+m3+newOperation.substring(m2,newOperation.length());
							    nombreOperation = countSubOperation(newOperation);
							    System.out.println("newOperation="+newOperation);
							    
							    }
							}
					    }
					
						while(newOperation.contains("+")&&nombreOperation!=1) {
							
							if(newOperation.charAt(nextOperator(0,newOperation))=='+'&&nombreOperation!=1) {
								int m6=nextOperator(0,newOperation);
								int m7=nextOperator(m6,newOperation);
								System.out.println("m7="+m7);
								String m5=addition(newOperation.substring(0,m7));
								newOperation=m5+newOperation.substring(m7,newOperation.length());
								nombreOperation = countSubOperation(newOperation);
								System.out.println("newOperation="+newOperation);
							}
							if(newOperation.charAt(previousOperator(newOperation.length()-1,newOperation))=='+'&&nombreOperation!=1) {
								int m6=previousOperator(newOperation.length()-1,newOperation);
								int m7=previousOperator(m6,newOperation);
								String m5=addition(newOperation.substring((m7+1),newOperation.length()));
								newOperation=newOperation.substring(0,(m7+1))+m5;
								nombreOperation = countSubOperation(newOperation);
								System.out.println("newOperation="+newOperation);
							}

							for(int i=0;i < newOperation.length();i++) {
								char nombre =newOperation.charAt(i);
								if(nombre=='+'&&nombreOperation!=1) {
									m1=previousOperator(i,newOperation);
								    m2=nextOperator(i,newOperation);
								    System.out.println("m1="+m1);
								     System.out.println("m2="+m2);
								    String m4=newOperation.substring((m1+1),m2);
								    String m3=calculateSimpleOperation(m4);
								    newOperation=newOperation.substring(0,(m1+1))+m3+newOperation.substring(m2,newOperation.length());
								    nombreOperation = countSubOperation(newOperation);
								    System.out.println("newOperation="+newOperation);
								    }
								}
						    }
						while(newOperation.contains("-")&&nombreOperation!=1) {
							if(newOperation.charAt(nextOperator(0,newOperation))=='-'&&nombreOperation!=1) {
								int m6=nextOperator(0,newOperation);
								int m7=nextOperator(m6,newOperation);
								String m5=soustraction(newOperation.substring(0,m7));
								newOperation=m5+newOperation.substring(m7,newOperation.length());
								nombreOperation = countSubOperation(newOperation);
								System.out.println("newOperation="+newOperation);
							}
							if(newOperation.charAt(previousOperator(newOperation.length()-1,newOperation))=='-'&&nombreOperation!=1) {
								int m6=previousOperator(newOperation.length()-1,newOperation);
								int m7=previousOperator(m6,newOperation);
								String m5=soustraction(newOperation.substring((m7+1),newOperation.length()));
								newOperation=newOperation.substring(0,(m7+1))+m5;
								nombreOperation = countSubOperation(newOperation);
								System.out.println("newOperation="+newOperation);
							}

							for(int i=0;i < newOperation.length();i++) {
								char nombre =newOperation.charAt(i);
								if(nombre=='-'&&nombreOperation!=1) {
									m1=previousOperator(i,newOperation);
								    m2=nextOperator(i,newOperation);
								    System.out.println("m1="+m1);
								     System.out.println("m2="+m2);
								    String m4=newOperation.substring((m1+1),m2);
								    String m3=calculateSimpleOperation(m4);
								    newOperation=newOperation.substring(0,(m1+1))+m3+newOperation.substring(m2,newOperation.length());
								    nombreOperation = countSubOperation(newOperation);
								    System.out.println("newOperation="+newOperation);
								    }
								}
						    }
						
						
							
						newOperation=calculateSimpleOperation(newOperation);
						nombreOperation = countSubOperation(newOperation);
						 System.out.println("nombreOperation="+nombreOperation);
					    System.out.println("newOperation="+newOperation);
						return newOperation;
			    }
					return "il ny'a pas d'opération";
					}
				
			}
	public int nextOperator(int n, String str) {
		for (int i = n + 1; i < str.length(); i++) {
			char nombre = str.charAt(i);
			if (nombre == '/' || nombre == '*' || nombre == '+' || nombre == '-' || nombre == '=') {
				return i;
			}

		}
		return -1;
	}

	public int previousOperator(int n, String str) {
		for (int i = n - 1; i >= 0; i--) {
			char nombre = str.charAt(i);
			if (nombre == '/' || nombre == '*' || nombre == '+' || nombre == '-' || nombre == '=') {
				return i;
			}

		}
		return -1;

	}

	private int countSubOperation(String expression) {
		int c = 0;
		for (int i = 0; i < expression.length(); i++) {
			
			char nombre = expression.charAt(i);
			if (nombre == '/' || nombre == '*' || nombre == '+' || nombre == '-' || nombre == '=') {
				if(i==0) {
					c=0;
				}
				else {
				c++;
				}
			}
		}
		return (c);
	}

	private String calculateSimpleOperation(String mimiOperation) {
		char signe;
		for (int i =1 ; i < mimiOperation.length(); i++) {
			signe = mimiOperation.charAt(i);

			if (signe == '/') {
				return division(mimiOperation);
			}
			if (signe == '*') {
				return multiplication(mimiOperation);
			}
			if (signe == '+') {
				return addition(mimiOperation);
			}
			if (signe == '-') {
				return soustraction(mimiOperation);
			}
		}
		return "";
	}

	private String division(String st) {
		if (st.contains("/")) {
			String[] str = st.split("\\/");
			String A = str[0];
			String B = str[1];
			double C = Double.parseDouble(A);
			double D = Double.parseDouble(B);
			return Double.toString(C / D);
		}

		return "";
	}

	private String multiplication(String st) {
		String l;
		if (st.contains("*")) {
			String[] str = st.split("\\*");
			String A = str[0];
			String B = str[1];
			double C = Double.parseDouble(A);
			double D = Double.parseDouble(B);
			return Double.toString(C * D);
		}

		return "";
	}

	private String addition(String st) {
		// String l;
		if (st.contains("+")) {
		        int m2=st.lastIndexOf("+");
				String A=st.substring(0,m2);
				String B=st.substring((m2+1),st.length());
				double C = Double.parseDouble(A);
				double D = Double.parseDouble(B);
				double E =C + D;
				return Double.toString(E);
		
		}

		return "";
	}

	private String soustraction(String st) {
		
		if (st.contains("-")) {
			 int m2=st.lastIndexOf("-");
				String A=st.substring(0,m2);
				String B=st.substring((m2+1),st.length());
				double C = Double.parseDouble(A);
				double D = Double.parseDouble(B);
				double E =C - D;
				return Double.toString(E);
		}

		return "";
	}

}
