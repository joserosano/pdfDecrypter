import java.io.IOException;

import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.pdmodel.encryption.BadSecurityHandlerException;

public class App {

	public static void main(String args[]) throws IOException, CryptographyException, BadSecurityHandlerException {
		Decrypter decrypter = new Decrypter();
		decrypter.decryptAndSave("C:\\coursera.pdf", "C:\\courseraDecrypted.pdf");
	}
}
