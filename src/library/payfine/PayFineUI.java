package library.payfine;
import java.util.Scanner;


public class PayFineUI {


	public static enum UIState { INITIALISED, READY, PAYING, COMPLETED, CANCELLED }; // changed uI_sTaTe to UIState

	private payFineControl control; // changed pAY_fINE_cONTROL to payFineControl and CoNtRoL to control
	private Scanner input;
	private UIState state; // changed uI_sTaTe to UIState and StAtE to state

	
	public PayFineUI(payFineControl control) // changed pAY_fINE_cONTROL to payFineControl
	{
		this.control = control; //changed CoNtRoL to control
		input = new Scanner(System.in);
		state = UIState.INITIALISED; // changed uI_sTaTe to UIState and StAtE to state
		control.setUI(this); //chnaged SeT_uI to setUI
	}
	
	
	public void setState(UIState state)  // changed uI_sTaTe to UIState and SeT_StAtE to setState
	{
		this.state = state; //changed StAtE to state
	}


	public void RuN() {
		output("Pay Fine Use Case UI\n");
		
		while (true) {
			
			switch (state) //changed StAtE to state
			{
			
			case READY:
				String memStr = input("Swipe member card (press <enter> to cancel): "); //changed Mem_Str to memStr
				if (memStr.length() == 0) //changed Mem_Str to memStr
				{
					control.cancel(); //changed CoNtRoL.CaNcEl to control.cancel 
					break;
				}
				try {
					int Member_ID = Integer.valueOf(memStr).intValue();//changed Mem_Str to memStr
					control.cardSwiped(Member_ID); //changed CaRd_sWiPeD to cardSwiped
				}
				catch (NumberFormatException e) {
					output("Invalid memberId");
				}
				break;
				
			case PAYING:
				double amount = 0; //changed AmouNT to amount
				String amtStr = input("Enter amount (<Enter> cancels) : ");
				if (amtStr.length() == 0)  //changed Amt_Str to amtStr
				{
					control.cancel(); //changed CoNtRoL.CaNcEl to control.cancel
					break;
				}
				try {
					amount = Double.valueOf(amtStr).doubleValue(); //changed AmouNT to amount and Amt_Str to amtStr
				}
				catch (NumberFormatException e) {}
				if (amount <= 0) //changed AmouNT to amount
					{
					output("Amount must be positive");
					break;
				}
				control.payFine(amount); //changed AmouNT to amount
				break;
								
			case CANCELLED:
				output("Pay Fine process cancelled");
				return;
			
			case COMPLETED:
				output("Pay Fine process complete");
				return;
			
			default:
				output("Unhandled state");
				throw new RuntimeException("FixBookUI : unhandled state :" + state);			
			
			}		
		}		
	}

	
	private String input(String prompt) {
		System.out.print(prompt);
		return input.nextLine();
	}	
		
		
	private void output(Object object) {
		System.out.println(object);
	}	
			

	public void display(Object object) //changed DiSplAY to display
	{
		output(object);
	}


}





