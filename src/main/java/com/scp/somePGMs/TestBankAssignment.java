package com.scp.somePGMs;

import java.util.Arrays;

public class TestBankAssignment {
	public static void main(String[] args) {
		Customer[] listofCustomers = generateDummyData(6);
		// AB
		RBIBank sbiBank = new SBI();
		RBIBank hdfcBank = new HDFC();
		RBIBank iciciBank = new ICICI();

		for (Customer customer : listofCustomers) {
			if (BankNames.HDFC.equals(customer.getBankType())) {
				double interest = hdfcBank.calculateInterest(customer.getAccountBalance());
				customer.setInterestOnBalance(interest);
			} else if (BankNames.SBI.equals(customer.getBankType())) {
				double interest = sbiBank.calculateInterest(customer.getAccountBalance());
				customer.setInterestOnBalance(interest);
			} else if (BankNames.ICICI.equals(customer.getBankType())) {
				double interest = iciciBank.calculateInterest(customer.getAccountBalance());
				customer.setInterestOnBalance(interest);
			}
		}

		System.out.println("List Of Customers " + Arrays.toString(listofCustomers));

		double sbiTotalInterest = 0;
		double hdfcTotalInterest = 0;
		double iciciTotalInterest = 0;

		for (Customer customer : listofCustomers) {

			if (BankNames.HDFC.equals(customer.getBankType())) {
				hdfcTotalInterest += customer.getInterestOnBalance();
			} else if (BankNames.SBI.equals(customer.getBankType())) {
				sbiTotalInterest += customer.getInterestOnBalance();
			} else if (BankNames.ICICI.equals(customer.getBankType())) {
				iciciTotalInterest += customer.getInterestOnBalance();
			}
		}

		System.out.println("Total Interest paid By SBI -- " + sbiTotalInterest);
		System.out.println("Total Interest paid By HDFC -- " + hdfcTotalInterest);
		System.out.println("Total Interest paid By ICICI -- " + iciciTotalInterest);

	}

	// generate Random Customer Data/dummy customer data -- to test bank
	// assignment
	private static Customer[] generateDummyData(int numOfCustomer) {
		Customer[] listofCustomers = new Customer[numOfCustomer];

		BankNames bankKaNaam = null;
		for (int i = 0; i < numOfCustomer; i++) {
			if (i % 3 == 0)
				bankKaNaam = BankNames.SBI;
			else if (i % 4 == 0) {
				bankKaNaam = BankNames.ICICI;
			} else
				bankKaNaam = BankNames.HDFC;
			listofCustomers[i] = new Customer(i + 1, "Customer" + i, 29, bankKaNaam, i * 15000, GenderTypes.Male);
		}
		return listofCustomers;
	}
}

enum BankNames {
	HDFC, SBI, ICICI
}

enum GenderTypes {
	Male, Female
}

class Customer {
	private int customerId;
	private String customerName;
	private int custAge;
	private BankNames bankType; // private String bankType;
	private double accountBalance;
	private GenderTypes gender; // GenderTypes gender;
	private double interestOnBalance;

	public Customer(int customerId, String customerName, int custAge, BankNames bankType, double accountBalance,
			GenderTypes gender) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.custAge = custAge;
		this.bankType = bankType;
		this.accountBalance = accountBalance;
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "\n\n Customer [customerId=" + customerId + ", customerName=" + customerName + ", custAge=" + custAge
				+ ", bankType=" + bankType + ", accountBalance=" + accountBalance + ", gender=" + gender
				+ ", interestOnBalance=" + interestOnBalance + "]";
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public int getCustAge() {
		return custAge;
	}

	public void setCustAge(int custAge) {
		this.custAge = custAge;
	}

	public BankNames getBankType() {
		return bankType;
	}

	public void setBankType(BankNames bankType) {
		this.bankType = bankType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public GenderTypes getGender() {
		return gender;
	}

	public void setGender(GenderTypes gender) {
		this.gender = gender;
	}

	public double getInterestOnBalance() {
		return interestOnBalance;
	}

	public void setInterestOnBalance(double interestOnBalance) {
		this.interestOnBalance = interestOnBalance;
	}

}

abstract class RBIBank {
	abstract double calculateInterest(double accountBalance);
}

class HDFC extends RBIBank {

	@Override
	double calculateInterest(double accountBalance) {
		// TODO Auto-generated method stub
		return accountBalance * 0.07;
	}

	

}

class ICICI extends RBIBank {

	@Override
	double calculateInterest(double accountBalance) {
		// System.out.println("Inside ICICi Calculate Interest");
		return accountBalance * 0.08;
	}

}

class SBI extends RBIBank {

	@Override
	double calculateInterest(double accountBalance) {
		// System.out.println("Inside SBI Calculate Interest");
		return accountBalance * 0.09;
	}

}
