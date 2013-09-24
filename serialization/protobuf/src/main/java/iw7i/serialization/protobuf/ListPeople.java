package iw7i.serialization.protobuf;

import java.io.FileInputStream;

import iw7i.serialization.protobuf.AddressBookProtos.AddressBook;
import iw7i.serialization.protobuf.AddressBookProtos.Person;

class ListPeople {
	public final static String DEFAULT_FILE_NAME = "address_book.pf";

	// Iterates though all people in the AddressBook and prints info about them.
	static void Print(AddressBook addressBook) {
		for (Person person : addressBook.getPersonList()) {
			System.out.println("Person ID: " + person.getId());
			System.out.println("  Name: " + person.getName());
			if (person.hasEmail()) {
				System.out.println("  E-mail address: " + person.getEmail());
			}

			for (Person.PhoneNumber phoneNumber : person.getPhoneList()) {
				switch (phoneNumber.getType()) {
				case MOBILE:
					System.out.print("  Mobile phone #: ");
					break;
				case HOME:
					System.out.print("  Home phone #: ");
					break;
				case WORK:
					System.out.print("  Work phone #: ");
					break;
				}
				System.out.println(phoneNumber.getNumber());
			}
		}
	}

	// Main function: Reads the entire address book from a file and prints all
	// the information inside.
	public static void main(String[] args) throws Exception {
		String filename = DEFAULT_FILE_NAME;
		if (args.length > 0) {
			filename = args[0];
		}

		// Read the existing address book.
		AddressBook addressBook = AddressBook.parseFrom(new FileInputStream(
				filename));

		Print(addressBook);
	}
}