package William.main;

public class mainProgram {
	public static void main(String [] args)
	{
//B1 and B2 shows initiation message but picture doesn't show. Instruction says it should show initiation message. 
//uses \n so that it follows the output with no space on the last line
		
	BankAccount B1 = new BankAccount("Johnson","Bobby","123456",2390.00,3400.00,2);
	BankAccount B2 = new BankAccount("Thomas","Richard","654888",5360.00,5400.00,2.5);
	BankAccount B3 = new BankAccount("Turner","James","622898",360.00,5400.00,2.1);
	System.out.println();
	System.out.println("Task 1");
	B1.depositToChecking(100.32);
	System.out.println();
	System.out.println("Task 2");
	B1.depositToSavings(2000.00);
	System.out.println();
	System.out.println("Task 3");
	B1.withdrawFromChecking(90.00);
	System.out.println();
	System.out.println("Task 4");
	B1.displayAccountInfo();
	System.out.println("\n");
	System.out.println("Task 5");
	B2.depositToChecking(1230.02);
	System.out.println();
	System.out.println("Task 6");
	B2.depositToSavings(1000.00);
	System.out.println();
	System.out.println("Task 7");
	B2.withdrawFromSavings(765.00);
	System.out.println();
	System.out.println("Task 8");
	B2.displayAccountInfo();
	System.out.println("\n");
	System.out.println("Task 9");
	B3.displayAccountInfo();
	}
}
