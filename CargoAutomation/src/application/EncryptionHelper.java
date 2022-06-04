package application;

import java.math.BigInteger;
import java.security.MessageDigest;

public class  EncryptionHelper {

	public static String EncryptionMD5(String IncomingPassword) {

		try {
			IncomingPassword = IncomingPassword + "Mask%-5";
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] Encrypted = md.digest(IncomingPassword.getBytes());
			BigInteger Number = new BigInteger(1, Encrypted);
			String EncryptedPassword = Number.toString(16);
			while (EncryptedPassword.length() < 32) {
				EncryptedPassword = "0" + EncryptedPassword;
			}

			return EncryptedPassword;
		} catch (Exception exception) {
			AlertManagementHelper EncryptionMDEror = new AlertManagementHelper("Encryption Error", "Encryption Error",
					"Encryption failed");
			EncryptionMDEror.ErorAlter("Encryption Error", "Encryption Error", "Encryption failed" + exception.toString());
			throw new RuntimeException(exception);
		}
	}

}
