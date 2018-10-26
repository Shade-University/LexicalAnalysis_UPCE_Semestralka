package lexicalanalysis;

import java.io.FileNotFoundException;
import lexicalanalysis.tokens.IdentifierToken;
import lexicalanalysis.tokens.KeyToken;
import lexicalanalysis.tokens.KeyWordEnum;
import lexicalanalysis.tokens.NumberToken;
import lexicalanalysis.tokens.SeparatorEnum;
import lexicalanalysis.tokens.SeparatorToken;
import lexicalanalysis.tokens.TokenEnum;

import lexicalanalysis.logic.lexicalAnalysis;

/**
 *
 * @Vondra Tomáš
 */
public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        // TODO Načtení z args soubor
        String file = "C:\\Users\\user\\Documents\\NetBeansProjects\\LexicalAnalysis\\test.txt";
        lexicalAnalysis analysis = new lexicalAnalysis(file);
        analysis.scan();
        analysis.showTokens();
        
        
        //TODO čísla mám, ale ještě hexa čísla
        //TODO Několik prázdných znaků za sebou se má brát jako jeden
        
        
    }
    
}
