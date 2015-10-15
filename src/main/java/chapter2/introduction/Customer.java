package chapter2.introduction;

import java.util.ArrayList;
import java.util.List;

public class Customer {

	public static ArrayList<Customer> allCustomers = new ArrayList<Customer>();
	public Integer id = 0;

	public String name = "";
	public String address = "";
	public String state = "";
	public String primaryContact = "";
	public String domain = "";
	public Boolean enabled = true;

	public Customer() {
	}

	public static List<String> getEnabledCustomerNames() {
		ArrayList<String> outList = new ArrayList<String>();
		for (Customer customer : allCustomers) {
			if (customer.enabled) {
				outList.add(customer.name);
			}
		}
		return outList;
	}

	public static List<String> getEnabledCustomerStates() {
		ArrayList<String> outList = new ArrayList<String>();
		for (Customer customer : allCustomers) {
			if (customer.enabled) {
				outList.add(customer.state);
			}
		}
		return outList;
	}

	public static List<String> getEnabledCustomerPrimaryContacts() {
		ArrayList<String> outList = new ArrayList<String>();
		for (Customer customer : allCustomers) {
			if (customer.enabled) {
				outList.add(customer.primaryContact);
			}
		}
		return outList;
	}

	public static List<String> getEnabledCustomerDomains() {
		ArrayList<String> outList = new ArrayList<String>();
		for (Customer customer : allCustomers) {
			if (customer.enabled) {
				outList.add(customer.domain);
			}
		}
		return outList;
	}

}
