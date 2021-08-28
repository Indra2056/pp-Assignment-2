package library.payfine;
import library.entities.Library;
import library.entities.Member;

public class payFineControl //changed pAY_fINE_cONTROL to payFineControl
{
	
	private PayFineUI Ui;
	private enum controlState { INITIALISED, READY, PAYING, COMPLETED, CANCELLED }; //changed cOnTrOl_sTaTe to controlState
	private controlState state; //changed cOnTrOl_sTaTe to controlState and StAtE to state
	
	private Library library; // changed LiBrArY to library
	private Member member; //chnaged MeMbEr to member


	public payFineControl() //changed pAY_fINE_cONTROL to payFineControl
	{
		this.library = Library.getInstance(); //changed GeTiNsTaNcE to getInstance and LiBrArY to library
		state = controlState.INITIALISED; //changed cOnTrOl_sTaTe to controlState and StAtE to state
	}
	
	
	public void setUI(PayFineUI uI) //changed SeT_uI to setUI
	{
		if (!state.equals(controlState.INITIALISED)) //changed cOnTrOl_sTaTe to controlState and StAtE to state
		{
			throw new RuntimeException("PayFineControl: cannot call setUI except in INITIALISED state");
		}	
		this.Ui = uI;
		uI.setState(PayFineUI.UIState.READY); //changed SeT_StAtE to setState
		state = controlState.READY;		//changed cOnTrOl_sTaTe to controlState and StAtE to state
	}


	public void cardSwiped(int memberId) //changed CaRd_sWiPeD to cardSwiped and MeMbEr_Id to memberId
	{
		if (!state.equals(controlState.READY)) //changed cOnTrOl_sTaTe to controlState and StAtE to state
		{throw new RuntimeException("PayFineControl: cannot call cardSwiped except in READY state");
			
		member = library.getMember(memberId); //chnaged MeMbEr to member, gEt_MeMbEr to getMember and MeMbEr_Id to memberId
		}
		if (member == null) //chnaged MeMbEr to member
		{
			Ui.display("Invalid Member Id"); //changed DiSplAY to display
			return;
		}
		Ui.display(member.toString()); //chnaged MeMbEr to member and changed DiSplAY to display 
		Ui.setState(PayFineUI.UIState.PAYING); //changed SeT_StAtE to setState and uI_sTaTe to UIState
		state = controlState.PAYING; //changed cOnTrOl_sTaTe to controlState and StAtE to state
	}
	
	
	public void cancel() //changed CaNcEl to cancel
	{
		Ui.setState(PayFineUI.UIState.CANCELLED); //changed SeT_StAtE to setState and uI_sTaTe to UIState
		state = controlState.CANCELLED; //changed cOnTrOl_sTaTe to controlState and StAtE to state
	}


	public double payFine(double amount) //changed PaY_FiNe to payFine
	{
		if (!state.equals(controlState.PAYING))  //changed cOnTrOl_sTaTe to controlState and StAtE to state
		{throw new RuntimeException("PayFineControl: cannot call payFine except in PAYING state");
			
		double change = member.payFine(amount); }//changed ChAnGe to change and PaY_FiNe to payFine
		if (change > 0) //changed ChAnGe to change
		{Ui.display(String.format("Change: $%.2f", change)); //changed DiSplAY to display and changed ChAnGe to change
		
		Ui.display(member.toString()); //changed DiSplAY to display
		Ui.setState(PayFineUI.UIState.COMPLETED); //changed SeT_StAtE to setState and uI_sTaTe to UIState
		state = controlState.COMPLETED; //changed cOnTrOl_sTaTe to controlState
		return change; //changed ChAnGe to change
		}
	}
	


}


