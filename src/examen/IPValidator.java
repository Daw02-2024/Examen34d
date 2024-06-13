/*
 * @author Alejandro
 * @version 1.0
 *  
 */
package examen;
/*
 * Clase IPBValidator
 */
public class IPValidator {
	
	 /* String que indica el patron de las IP
	 */public static String ipPattern;
	/*
	 * @ip Tu direccion a insertar
	 * @ipClass La clase de tu direccion
	 */
	public static boolean validateIPAndClass(String ip, char ipClass) {
		boolean validIPClass = true;
		ipPattern = "^(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)"
				+ "\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.(25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
		java.util.regex.Pattern pattern = java.util.regex.Pattern.compile(ipPattern);
		java.util.regex.Matcher matcher = pattern.matcher(ip);
		if (!matcher.matches()) {
			validIPClass = false;
		} else {
			int firstOctet = Integer.parseInt(matcher.group(1));
			if (firstOctet <= 126) {
				validIPClass = ipClass == 'A';
			} else if (firstOctet <= 191) {
				validIPClass = ipClass == 'B';
			} else if (firstOctet <= 223) {
				validIPClass = ipClass == 'C';
			} else if (firstOctet <= 239) {
				validIPClass = ipClass == 'D';
			} else if (firstOctet <= 255) {
				validIPClass = ipClass == 'E';
			}
		}
		/*
		 * Devuelve el valor que se haya conseguido
		 */
		return validIPClass;
	}
}