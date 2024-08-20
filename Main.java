import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean wieder = true;


        while (wieder) {

            System.out.println("Bitte Auswählen:");
            System.out.println("1 für Encrypten");
            System.out.println("2 für Decoden");
            System.out.println("0 für program beenden!");

            int wahl = scanner.nextInt();
            scanner.nextLine();

            switch (wahl) {
                case 1:

                    System.out.println("Bitte Text eingeben: ");
                    String text = scanner.nextLine();

                    int shiftValue = 3;
                    String encryptedText = encryptCeasarCipher(text, shiftValue);


                    System.out.println("Verschlusselt  Text ist :" + encryptedText);

                    break;


                case 2:
                    System.out.println("Bitte Text eingeben: ");
                    String encryptedTextToDecode = scanner.nextLine();

                    int decodeShiftValue = 3;
                    String decryptedText = decryptCeasarCipher(encryptedTextToDecode, decodeShiftValue);


                    System.out.println("Unverschlusselt  Text ist : " + decryptedText);

                    break;

                case 0:
                    System.out.println("program wird beendet");
                    break;

                default:
                    System.out.println("Ungutiege Wahl");
                    break;
            }
        }
        if (wieder){
            System.out.println("Möchten Sie wiederholen? ('j' für JA 'n' für Nein.");
            String antwort =scanner.nextLine();

            if(antwort.equalsIgnoreCase("n")){
                wieder = false;
                System.out.println("Program wird beendet.");
            }
        }



        scanner.close();
    }

    static String encryptCeasarCipher(String text, int shiftValue) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int asciiCode = text.charAt(i);
            int newAsciiCode = asciiCode + shiftValue;
            if (newAsciiCode < 127) {
                encryptedText.append((char) newAsciiCode);

            } else {
                encryptedText.append((char) ((newAsciiCode % 127) + 32));
            }

        }
        return encryptedText.toString();


    }

    static String decryptCeasarCipher(String text, int decodeShiftValue) {
        StringBuilder encryptedTextToDecode = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            int asciiCode = text.charAt(i);
            int newAsciiCode = asciiCode - decodeShiftValue;
            if (newAsciiCode >= 32) {
                encryptedTextToDecode.append((char) newAsciiCode);

            } else {
                encryptedTextToDecode.append((char) (127-(32-newAsciiCode)));
            }

        }
        return encryptedTextToDecode.toString();

    }
}