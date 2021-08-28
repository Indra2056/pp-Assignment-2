package library.fixbook;
import java.util.Scanner;


public class FixBookUI {

	public static enum UIState { INITIALISED, READY, FIXING, COMPLETED }; //changed uI_sTaTe to UIState 

	private fixBookControl control; //changed fIX_bOOK_cONTROL to fixBookControl and CoNtRoL to control
	private Scanner inPuT; //changed InPuT to inPut
	private UIState state; //changed uI_sTaTe to UIState and StAtE to state

	
	public FixBookUI(fixBookControl control) //changed fIX_bOOK_cONTROL to fixBookControl and CoNtRoL to control
	{
		this.Control = control; //changed CoNtRoL to control
		inPut = new Scanner(System.in);//changed InPuT to inPut
		state = UIState.INITIALISED;//changed uI_sTaTe to UIState and StAtE to state
		control.SetUI(this); //changed CoNtRoL to control and SeT_Ui to SetUI
	}


	public void UIState(UIState state)//changed uI_sTaTe to UIState
	{
		this.State = state;
	}

	
	public void run() //changed RuN to run
	{
		outPut("Fix Book Use Case UI\n");//changed OuTpUt to outPut
		
		while (true) {
			
			switch (state) //changed StAtE to state
			{
			
			case READY:
				String bookEntryString = inPut("Scan Book (<enter> completes): "); //changed BoOk_EnTrY_StRiNg to bookEntryString
				if (bookEntryString.length() == 0) //changed BoOk_EnTrY_StRiNg to bookEntryString
				{
					control.scanningComplete(); //changed cOnTrOl.SCannING_COMplete to control.scanningComplete
				}
				else {
					try {
						int bookId = Integer.valueOf(bookEntryString).intValue(); //changed BoOk_EnTrY_StRiNg to bookEntryString and BoOk_Id to bookId
						control.bookScanned(bookId); //changed  CoNtRoL to control, BoOk_ScAnNeD to bookScanned and BoOk_Id to bookId
					}
					catch (NumberFormatException e) {
						outPut("Invalid bookId"); //changed OuTpUt to outPut
					}
				}
				break;	
				
			case FIXING:
				String ans = iNpUt("Fix Book? (Y/N) : "); //changed AnS to ans and iNpUt to inPut
				boolean FiX = false;
				if (ans.toUpperCase().equals("Y")) //changed AnS to ans
					FiX = true;
				
				control.fixBook(FiX); //changed FiXBoOk to fixBook
				break;
								
			case COMPLETED:
				outPut("Fixing process complete"); //changed OuTpUt to outPut
				return;
			
			default:
				outPut("Unhandled state"); //changed OuTpUt to outPut
				throw new RuntimeException("FixBookUI : unhandled state :" + state);	//changed StAtE to state		
			
			}		
		}
		
	}

	
	private String inPut(String prompt) //changed iNpUt to inPut
	{
		System.out.print(prompt);
		return inPuT.nextLine(); //changed iNpUt to inPut
	}	
		
		
	private void outPut(Object object) //changed OuTpUt to outPut
	{
		System.out.println(object);
	}
	

	public void display(Object object) //changed dIsPlAy to display
	{
		outPut(object); //changed OuTpUt to outPut
	}
	
	
}


