package William.main;
import java.text.DecimalFormat;
public class BankAccount {
//declare all private varaibles inside the class
	private String accountNumber;
	private String lastName;
	private String firstName;
	private String taxIDNumber ;
	private double checkingBalance;
	private double minCheckingBalance;
	private double maxCheckingWithdrawal;
	private double savingsBalance;
	private double minSavingBalance;
	private double maxSavingWithdrawal;
	private double savingsInterestRate;
	public static int AccountCount = 0;
//constructor that constructs the object
	public BankAccount( String lastName, String firstName, String taxIDNumber,
			double checkingBalance, double savingsBalance, double savingsInterestRate) {
		AccountCount +=1;
		this.lastName = lastName;
		this.firstName = firstName;
		this.taxIDNumber = taxIDNumber;
		accountNumber = "A-00"+AccountCount;
		if (checkingBalance >1000 && savingsBalance >500) {
//check if the checkingbalance is greater than 1000 and the savingbalance is greater than 500
			this.checkingBalance = checkingBalance;
			minCheckingBalance = 0.25*checkingBalance;
			maxCheckingWithdrawal = 0.4*checkingBalance;
			this.savingsBalance = savingsBalance;
			minSavingBalance = 0.55*savingsBalance;
			maxSavingWithdrawal = 0.2*savingsBalance;
			this.savingsInterestRate = savingsInterestRate;
//instruction says to display this if is fully initialized and fill the requirements 
			System.out.println("Account "+accountNumber+" HAS BEEN CREATED ");
		}
		else {
			this.checkingBalance = 0;
			minCheckingBalance = 0;
			maxCheckingWithdrawal = 0;
			this.savingsBalance = 0;
			minSavingBalance = 0;
			maxSavingWithdrawal = 0;
			this.savingsInterestRate = 0;
			System.out.println("Account "+accountNumber+" IS PENDING ADDITIONAL FUNDS");
		}
		}
	
//Getters and Setters 
	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastname) {
		this.lastName = lastname;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}


	public String getTaxIDNumber() {
		return taxIDNumber;
	}


	public void setTaxIDNumber(String taxIDNumber) {
		this.taxIDNumber = taxIDNumber;
	}


	public double getCheckingBalance() {
		return checkingBalance;
	}


	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}


	public double getMinCheckingBalance() {
		return minCheckingBalance;
	}


	public void setMinCheckingBalance(double minCheckingBalance) {
		this.minCheckingBalance = minCheckingBalance;
	}


	public double getMaxCheckingWithdrawl() {
		return maxCheckingWithdrawal;
	}


	public void setMaxCheckingWithdrawl(double maxCheckingWithdrawl) {
		this.maxCheckingWithdrawal = maxCheckingWithdrawl;
	}


	public double getSavingsBalance() {
		return savingsBalance;
	}


	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}


	public double getMinSavingBalance() {
		return minSavingBalance;
	}


	public void setMinSavingBalance(double minSavingBalance) {
		this.minSavingBalance = minSavingBalance;
	}


	public double getMaxSavingWithdrawal() {
		return maxSavingWithdrawal;
	}


	public void setMaxSavingWithdrawal(double maxSavingWithdrawal) {
		this.maxSavingWithdrawal = maxSavingWithdrawal;
	}


	public double getSavingsInterestRate() {
		return savingsInterestRate;
	}


	public void setSavingsInterestRate(double savingsInterestRate) {
		this.savingsInterestRate = savingsInterestRate;
	}
//first method: Prints all of the information out (implements getters)
	public void displayAccountInfo() {
		  DecimalFormat dF = new DecimalFormat("#0.0#");
		System.out.println("Account Number: "+accountNumber);
		System.out.println("Name on Account: "+this.firstName+" "+this.lastName);
		System.out.println("Tax ID Number: "+this.taxIDNumber);
		System.out.println("_____________"+"BALANCES"+"_____________");
		System.out.println("\t"+"Checking: "+"$"+dF.format(this.checkingBalance));
		System.out.println("\t"+"Savings: "+"$"+dF.format(this.savingsBalance));
		System.out.println("_____________"+"ALLOWANCES"+"_____________");
		System.out.println("Minimum Checking Balance: "+"$"+dF.format(getMinCheckingBalance()));
		System.out.println("Maximum Checking Withdrawal: "+"$"+dF.format(getMaxCheckingWithdrawl()));
		System.out.println("Minimum Savings Balance: "+"$"+getMinSavingBalance());
		System.out.println("Maximum Checking Withdrawal: "+"$"+dF.format(getMaxSavingWithdrawal()));
		System.out.print("--------------------------------------------------------");
	}
//Second Method: add money through addition into Checking Account (implements setters)
	public boolean depositToChecking(double d) {
		setCheckingBalance(this.checkingBalance+=d);
		System.out.println("$"+d+" deposited to Checking");
		return true;
	}
//Third method: add money through addition into Savings Account 
	public boolean depositToSavings(double d) {
		setSavingsBalance(this.savingsBalance += d);
		System.out.println("$"+d+" deposited to Savings");
		return true;
	}
//Fourth method: withdrawl moneey from checking account
	public boolean withdrawFromChecking(double d) {
		boolean checker = true;
	//checks whether after a transaction, your account still fits the minCheckingBalance (used to make sure that the REMAINING after withdrawl still fits)
		double checkingifislessthanmin = this.checkingBalance-d;
		
/*first conditon: checks if the current balance is higher or equal to the the amount of money the user wants to withdrawl
 *  (>= BECAUSE YOU CAN TECHNICALLY WITHDRAWL ALL OF YOUR MONEY)
 */
//second condition: checks if after a withdrawl that the REMAINING still fits the minimum
		if (this.checkingBalance>=d && checkingifislessthanmin >this.minCheckingBalance ) {
			setCheckingBalance(this.checkingBalance-=d);
			System.out.println("$"+d+" withdrawn from Checking");
		}
		else {
			System.out.println("Withdraw cannot be made");
			checker = false;
		}
		return checker;
	}
//Fifth method: Same process as method 4
	public boolean withdrawFromSavings(double d) {
		boolean checker = true;
		double checkingifislessthanmin = this.savingsBalance-d;
		if (this.savingsBalance>=d && checkingifislessthanmin >this.minSavingBalance) {
			setSavingsBalance(this.savingsBalance -= d);
			System.out.println("$"+d+" withdrawn from Savings");
		}
		else {
			System.out.println("Withdraw cannot be made");
			checker = false;
		}
		return checker;
	}
	
	

}
