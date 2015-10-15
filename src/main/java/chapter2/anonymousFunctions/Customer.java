package chapter2.anonymousFunctions;

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
		return getEnabledCustomerField(new Function1<Customer, String>() {
			@Override
			public String call(Customer customer) {
				return customer.address;
			}
		});
	}

	public static List<String> getEnabledCustomerStates() {
		return getEnabledCustomerField(new Function1<Customer, String>() {
			@Override
			public String call(Customer customer) {
				return customer.state;
			}
		});
	}

	public static List<String> getEnabledCustomerPrimaryContacts() {
		return getEnabledCustomerField(new Function1<Customer, String>() {
			@Override
			public String call(Customer customer) {
				return customer.primaryContact;
			}
		});
	}

	public static List<String> getEnabledCustomerDomains() {
		return getEnabledCustomerField(new Function1<Customer, String>() {
			@Override
			public String call(Customer customer) {
				return customer.domain;
			}
		});
	}

	public static List<Customer> getEnabledCustomers() {
		return getEnabledCustomerField(new Function1<Customer, Customer>() {
			@Override
			public Customer call(Customer customer) {
				return customer;
			}
		});
	}

	public static List<String> getEnabledCustomerEmail(final String someone) {
		return getEnabledCustomerField(new Function1<Customer, String>() {
			@Override
			public String call(Customer param) {
				return someone + "@" + param.domain;
			}
		});
	}

}
