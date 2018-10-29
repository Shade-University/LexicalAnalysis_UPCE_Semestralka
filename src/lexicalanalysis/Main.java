package lexicalanalysis;

import java.io.IOException;

import lexicalanalysis.logic.lexicalAnalysis;

/**
 *
 * @Vondra Tomáš
 */
public class Main {

    public static void main(String[] args) {
        String file;
        if (args.length <= 0) {
            System.out.println("Nebyl vybrán žádný soubor. Vybírám defaultní");
            System.out.println("============================================");
            file = System.getProperty("user.dir") + "\\test.txt";
        } else {
            file = args[0];
        }
        try {
            lexicalAnalysis analysis = new lexicalAnalysis(file);
            analysis.scan();
            analysis.showTokens();
        } catch (IOException ex) {
            System.out.println("Něco se nepovedlo: ");
            System.out.println(ex.toString());
        }
    }

}
