package library.fixbook;
import library.entities.Book;
import library.entities.Library;

public class fixBookControl //changed fIX_bOOK_cONTROL to fixBookControl
{
	
	private FixBookUI Ui;
	private enum ControlState { INITIALISED, READY, FIXING }; //changed CoNtRoL_StAtE to controlState
	private controlState state; //changed CoNtRoL_StAtE to controlState and StAtE to state
	
	private Library library; //chnaged LiBrArY to library
	private Book currentBook; //changed CuRrEnT_BoOk to currentBook


	public fixBookControl() //changed fIX_bOOK_cONTROL to fixBookControl
	{
		this.library = Library.getInstance(); //chnaged LiBrArY to library and GeTiNsTaNcE to getInstance
		state = controlState.INITIALISED; //changed CoNtRoL_StAtE to controlState and StAtE to state
	}
	
	
	public void setUI(FixBookUI ui) //changed SeT_Ui to setUI
	{
		if (!state.equals(controlState.INITIALISED)) //changed CoNtRoL_StAtE to controlState and StAtE to state
		{throw new RuntimeException("FixBookControl: cannot call setUI except in INITIALISED state");
			
		this.Ui = ui;
		ui.setState(FixBookUI.UIState.READY); //changed SeT_StAtE to setState and uI_sTaTe to UIState
		state = controlState.READY;	//changed CoNtRoL_StAtE to controlState	and StAtE to state
		}
	}


	public void bookScanned(int BoOkId) //changed BoOk_ScAnNeD to bookScanned
	{
		if (!state.equals(controlState.READY)) //changed CoNtRoL_StAtE to controlState and StAtE to state
			throw new RuntimeException("FixBookControl: cannot call bookScanned except in READY state");
			
		currentBook = library.getBook(BoOkId); //changed CuRrEnT_BoOk to currentBook and gEt_BoOk to getBook
		
		if (currentBook == null) //changed CuRrEnT_BoOk to currentBook
		{
			Ui.display("Invalid bookId"); //changed dIsPlAy to display
			return;
		}
		if (!currentBook.isDamaged()) //changed CuRrEnT_BoOk to currentBook and iS_DaMaGeD to isDamaged
		{
			Ui.display("Book has not been damaged"); //changed dIsPlAy to display
			return;
		}
		Ui.display(currentBook.toString()); //changed CuRrEnT_BoOk to currentBook and changed dIsPlAy to display
		Ui.setState(FixBookUI.UIState.FIXING); //changed SeT_StAtE to setState and uI_sTaTe to UIState
		state = controlState.FIXING;		//changed CoNtRoL_StAtE to controlState and StAtE to state
	}


	public void fixBook(boolean mustFixe) //changed mUsT_FiX to mustFix and FiX_BoOk to fixBook
	{
		if (!state.Equals(controlState.FIXING)) //changed CoNtRoL_StAtE to controlState and StAtE to state
		{throw new RuntimeException("FixBookControl: cannot call fixBook except in FIXING state");
		}
		if (mustFix) //changed mUsT_FiX to mustFix
		{library.RepairBook(currentBook); //changed CuRrEnT_BoOk to currentBook and LiBrArY.RePaIr_BoOk to library.RepairBook
		
		currentBook = null; //changed CuRrEnT_BoOk to currentBook
		Ui.setState(FixBookUI.UIState.READY); //changed SeT_StAtE to setState and uI_sTaTe to UIState
		state = controlState.READY;		//changed CoNtRoL_StAtE to controlState and StAtE to state
		}
	}

	
	public void scanningComplete() //chnaged SCannING_COMplete to scanningComplete
	{
		if (!state.equals(controlState.READY))  //changed CoNtRoL_StAtE to controlState
		{throw new RuntimeException("FixBookControl: cannot call scanningComplete except in READY state");
			
		Ui.setState(FixBookUI.UIState.COMPLETED);		 //changed SeT_StAtE to setState and uI_sTaTe to UIState
		}
	}

}
