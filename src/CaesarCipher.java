
public class CaesarCipher {
	private String cipherText;
	public CaesarCipher() {
		cipherText = "";
	}
	public String CipherAllCharacter(int shift, String plainText) {
		for(int i = 0; i < plainText.length(); i++) {
			cipherText = cipherText + (char)((plainText.charAt(i) + shift) % 127);
		}
		return cipherText;
	}
	
	public String CipherAlphabetOnly(int shift, String plainText) {
		int convertForm = 0;
		for(int i = 0; i < plainText.length(); i++) {
			if(plainText.charAt(i) >= 65 && plainText.charAt(i) <= 90) {
				convertForm = ((plainText.charAt(i) - 64) + shift) % 26;
				if(convertForm == 0)
				{
					convertForm = 26;
				}
				cipherText = cipherText + (char)(convertForm + 64);
			}
			else if(plainText.charAt(i) >= 97 && plainText.charAt(i) <= 122) {
				convertForm = ((plainText.charAt(i) - 96) + shift) % 26;
				if(convertForm == 0)
				{
					convertForm = 26;
				}
				cipherText = cipherText + (char)(convertForm + 96);
			}
			else {
				cipherText = cipherText + plainText.charAt(i);
			}
		}
		return cipherText;
	}
}
