import java.util.ArrayList;

public class FUNC {
	// Check if the email address we give has @
	/*
	 * public static boolean checkM(String mail) { for (int i =0 ; i < mail.length()
	 * ; i++) if (mail.charAt(i) == '@') return true; return false; }
	 */

	
	// Checks if all the answers that are given in CASE when it enters a new patient
	// are true
	// it returns true if all the answers are correct
	public static boolean checkALL(boolean arr[]) {
		int a = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == true) {
				a++;
			}
		}
		if (a == arr.length) {
			return true;
		} else {
			return false;
		}
	}

	// Checks if the name that we give contains the characters between A-Z or a-z
	// It checks if the name we give is valid
	public static boolean checkName(String name) {
		int a = 0;
		for (int i = 0; i < name.length() - 1; i++) {
			// Returns the char value at the specified index.
			if (!((name.charAt(i) >= 'a' && name.charAt(i) <= 'z')
					|| (name.charAt(i) >= 'A' && name.charAt(i) <= 'Z'))) {
				a++;

			}

		}
		if (a == 0) {
			return false;
		} else {
			return true;
		}

	}

	// Based on the SSN we give, it deletes a patient
	/*
	 * public static void deleteCase(String amka, ArrayList<CASE> P) { for (int i =
	 * 0; i < P.size() - 1; i++) { if (P.get(i).get$ssn().equals(amka)) {
	 * P.remove(i); return; } } }
	 */

}
