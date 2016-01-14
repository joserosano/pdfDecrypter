import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.exceptions.COSVisitorException;
import org.apache.pdfbox.exceptions.CryptographyException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.BadSecurityHandlerException;
import org.apache.pdfbox.pdmodel.encryption.StandardDecryptionMaterial;

public class Decrypter {

	public void decryptAndSave(String filePath, String sourceFilePath) {
		try {
			PDDocument pdDocument = PDDocument.load(filePath);
			System.out.println("File encrypted: " + pdDocument.isEncrypted());
			pdDocument.setAllSecurityToBeRemoved(true);
			StandardDecryptionMaterial sdm = new StandardDecryptionMaterial("");//this is the owner default password. if the file has a real pass, place it here
			pdDocument.openProtection(sdm);
			System.out.println("File encrypted: " + pdDocument.isEncrypted());

			File outputFile = new File(sourceFilePath);
			pdDocument.save(outputFile);
		} catch (IOException | CryptographyException | BadSecurityHandlerException | COSVisitorException ex) {
			ex.printStackTrace();
		}
	}
}