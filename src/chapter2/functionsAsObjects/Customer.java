package chapter2.functionsAsObjects;

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

	private interface Function1<A1, B> {
		public B call(A1 param);
	}

	static private class CustomerName implements Function1<Customer, String> {

		@Override
		public String call(Customer customer) {
			return customer.name;
		}

	}

	static private class CustomerAddress implements Function1<Customer, String> {

		@Override
		public String call(Customer customer) {
			return customer.address;
		}

	}

	static private class CustomerState implements Function1<Customer, String> {

		@Override
		public String call(Customer customer) {
			return customer.state;
		}

	}

	static private class CustomerPrimaryContact implements Function1<Customer, String> {

		@Override
		public String call(Customer customer) {
			return customer.primaryContact;
		}

	}

	static private class CustomerDomain implements Function1<Customer, String> {

		@Override
		public String call(Customer customer) {
			return customer.domain;
		}

	}

	static private class CustomerAsCustomer implements Function1<Customer, Customer> {

		@Override
		public Customer call(Customer param) {
			return param;
		}

	}

	public static <B> List<B> getEnabledCustomerField(Function1<Customer, B> function) {
		ArrayList<B> outList = new ArrayList<B>();
		for (Customer customer : allCustomers) {
			if (customer.enabled) {
				outList.add(function.call(customer));
			}
		}
		return outList;
	}

	public static List<String> getEnabledCustomerNames() {
		return getEnabledCustomerField(new CustomerName());
	}

	public static List<String> getEnabledCustomerStates() {
		return getEnabledCustomerField(new CustomerState());
	}

	public static List<String> getEnabledCustomerPrimaryContacts() {
		return getEnabledCustomerField(new CustomerPrimaryContact());
	}

	public static List<String> getEnabledCustomerDomains() {
		return getEnabledCustomerField(new CustomerDomain());
	}

	public static List<Customer> getEnabledCustomers() {
		return getEnabledCustomerField(new CustomerAsCustomer());
	}

}
