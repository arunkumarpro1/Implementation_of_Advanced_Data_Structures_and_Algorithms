package cs6301.g12.Implementation_of_Advanced_Data_Structures_and_Algorithms.lp1_l1;

public class LP1L1 {
	public static void main(String[] args) {
		Num x = new Num(-991242349);
		System.out.println(x.digits);
		Num y = new Num("-867576876924692");
		System.out.println(y.digits);
		//Num z = Num.add(x,y); //Ans should be 867577868167041
		Num s = Num.subtract(x,y); //Ans shld be 867575885682343
		System.out.println(s);
		Num a = Num.power(x, 8);
		System.out.println(a);
		//z.printList();
		/**
		 * Test Input
		 * add
		 * 991242349, -867576876924692
		 * -867575885682343
		 * -991242349, 867576876924692
		 * 867575885682343
		 * -991242349, -867576876924692
		 * -867577868167041
		 * 991242349, 867576876924692
		 * 867577868167041
		 * 
		 * subtract
		 * 991242349, 867576876924692
		 * -867575885682343
		 * 991242349, -867576876924692
		 * 867577868167041
		 * -991242349, 867576876924692
		 * -867577868167041
		 * -991242349, -867576876924692
		 * 867575885682343
		 * 
		 * **/
		
	}
}
