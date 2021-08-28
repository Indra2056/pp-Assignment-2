package library.entities;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SuppressWarnings("serial")
public class Member implements Serializable {

	private String lastName; //changed LaSt_NaMe to lastName
	private String firstName; // changed FiRsT_NaMe to firstName
	private String emailAddress;// changed EmAiL_AdDrEsS to emailAddress
	private int phoneNumber; // changed PhOnE_NuMbEr to phoneNumber
	private int memberId; //changed MeMbEr_Id to memberId
	private double finesOwing; // changed FiNeS_OwInG to finesOwing
	
	private Map<Integer, Loan> currentLoans; //changed cUrReNt_lOaNs to currentLoans

	
	public Member(String lastName, String firstName, String emailAddress, int phoneNumber, int memberId) {
		this.lastName = lastName; //changed LaSt_NaMe and  to lastName
		this.firstName = firstName; // changed FiRsT_NaMe to firstName
		this.emailAddress = emailAddress; // changed EmAiL_AdDrEsS to emailAddress
		this.phoneNumber = phoneNumber; // changed PhOnE_NuMbEr to phoneNumber
		this.memberId = memberId; //changed MeMbEr_Id to memberId
		
		this.currentLoans = new HashMap<>(); //changed cUrReNt_lOaNs to currentLoans
	}

	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("Member:  ").append(memberId).append("\n") //changed MeMbEr_Id to memberId
		  .append("  Name:  ").append(lastName).append(", ").append(firstName).append("\n") //changed LaSt_NaMe and  to lastName
		  .append("  Email: ").append(emailAddress).append("\n") // changed EmAiL_AdDrEsS to emailAddress
		  .append("  Phone: ").append(phoneNumber) // changed PhOnE_NuMbEr to phoneNumber
		  .append("\n")
		  .append(String.format("  Fines Owed :  $%.2f", finesOwing)) //changed FiNeS_OwInG to finesOwing
		  .append("\n");
		
		for (Loan LoAn : currentLoans.values()) //changed cUrReNt_lOaNs to currentLoans
		{ 
			sb.append(LoAn).append("\n");
		}		  
		return sb.toString();
	}

	
	public int getId() //changed GeT_ID to getId
	{
		return memberId; //changed MeMbEr_Id to memberId
	}

	
	public List<Loan> getLoans() {
		return new ArrayList<Loan>(currentLoans.values()); // changed cUrReNt_lOaNs to currentLoans
	}

	
	public int getNumbersOfCurrentLoan()  // changed gEt_nUmBeR_Of_CuRrEnT_LoAnS to getNumbersOfCurrentLoan
	 {
		return currentLoans.size(); //changed cUrReNt_lOaNs to currentLoans
	}

	
	public double finesOwed() //change FiNeS_OwEd to finesOwed
	{
		return finesOwed; //change FiNeS_OwEd to finesOwed
	}

	
	public void takeOutLoan(Loan loan) 
	{
		if (!currentLoans.containsKey(loan.getId())) //changed cUrReNt_lOaNs to currentLoans
			{currentLoans.put(loan.getId(), loan);  }  //changed cUrReNt_lOaNs to currentLoans
		
		else 
			throw new RuntimeException("Duplicate loan added to member");
				
	}

	
	public String () {
		return lastName; // changed  LaSt_NaMe to lastName
	}

	
	public String getFirstNAme) {
		return firstNAme; //changed FiRsT_NaMe to firstName
	}


	public void addFine(double fine) //changed AdD_FiNe to addFine
	{
		finesOwing += fine; //changed FiNeS_OwInG to finesOwing
	}
	
	public double payFine(double amount) //changed PaY_FiNe to payFine
	{
		if (amount < 0) 
			throw new RuntimeException("Member.payFine: amount must be positive");
		
		double change = 0;
		if (amount > finesOwing) //changed FiNeS_OwInG to finesOwing
		{
			change = amount - finesOwing; //changed FiNeS_OwInG to finesOwing
			finesOwing = 0;  //changed FiNeS_OwInG to finesOwing
		}
		else 
			finesOwing = amount;  //changed FiNeS_OwInG to finesOwing
		
		return change;
	}


	public void dischanrgeLoan(Loan loan) //changed dIsChArGeLoAn to dischanrgeLoan
	{
		if (currentLoans.containsKey(loan.getId()))  //changed cUrReNt_lOaNs to currentLoans and GeT_Id to getId
			{currentLoans.remove(loan.getId());}     //changed cUrReNt_lOaNs to currentLoans and GeT_Id to getId
		
		else 
			throw new RuntimeException("No such loan held by member");

				
	}

}
