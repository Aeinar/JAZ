package services;

import java.util.ArrayList;
import java.util.List;

import domain.LoanApplication;

public class LoanService {

	private List<LoanApplication> loans = new ArrayList<LoanApplication>();
	
	public void add(LoanApplication application){
		 if(loans.contains(application))
			 return;
		 loans.add(application);
	}
	 
	public List<LoanApplication> getAll(){
		return loans;
	} 
}
