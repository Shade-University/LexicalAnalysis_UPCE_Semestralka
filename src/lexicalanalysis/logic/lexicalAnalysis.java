package lexicalanalysis.logic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import lexicalanalysis.tokens.IdentifierToken;
import lexicalanalysis.tokens.KeyToken;
import lexicalanalysis.tokens.KeyWordEnum;
import lexicalanalysis.tokens.NumberToken;
import lexicalanalysis.tokens.SeparatorEnum;
import lexicalanalysis.tokens.SeparatorToken;
import lexicalanalysis.tokens.TokenAbstract;
import lexicalanalysis.tokens.TokenEnum;

/**
 *
 * @author Tomáš Vondra
 */
public class lexicalAnalysis {

    private final static Integer MAX_LENGTH_IDENTIFIER = 32;

    private final FileReaderImpl reader;
    private final ArrayList<TokenAbstract> tokens;
    private final StringBuffer identifier;
    private TokenEnum status;
    private Boolean isMultipleWhiteChars = false;

    public lexicalAnalysis(String path) throws FileNotFoundException {
        reader = new FileReaderImpl(path);
        tokens = new ArrayList();
        identifier = new StringBuffer();
    }

    public void scan() {
        try {
            int c;
            while ((c = reader.readChar()) != -1) {
                char character = (char) c;

                TokenEnum statusNow = getStatus(character);

                if (statusNow == TokenEnum.Separator && status == TokenEnum.Identifier) {
                    KeyWordEnum key = KeyWordEnum.getKeyword(identifier.toString());
                    if (key != null) {
                        tokens.add(new KeyToken(key));
                    } else {
                        tokens.add(new IdentifierToken(identifier.toString()));
                    }
                    identifier.setLength(0);
                } else if(statusNow == TokenEnum.Separator && status == TokenEnum.Number){
                    Integer value = Integer.parseInt(identifier.toString());
                    tokens.add(new NumberToken(value));
                    identifier.setLength(0);
                }
                if (statusNow == TokenEnum.Separator) {
                    handleSeparator(character);
                } else if (statusNow == TokenEnum.Identifier || statusNow == TokenEnum.Number) {
                    identifier.append(character);
                    isMultipleWhiteChars = false;
                }
                status = statusNow;
            }
        } catch (IOException ex) {
            Logger.getLogger(lexicalAnalysis.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private TokenEnum getStatus(char c) {
        TokenEnum statusNow = TokenEnum.NONE;
        if (c == '=' || c == ':' || c == ';' || c == ','
                || c == '\n' || c == '\t' || c == ' ' || c == '\r') {
            statusNow = TokenEnum.Separator;
        } else if(c >= '0' && c <= '9') {      
            statusNow = TokenEnum.Number;
        } else {
            statusNow = TokenEnum.Identifier;
        }
        return statusNow; //TODO Hex number

    }

    private void handleSeparator(char character) {

        if (character == '\n' || character == '\t' || character == ' ' || character == '\r') {
            if (!isMultipleWhiteChars) {
                tokens.add(new SeparatorToken(SeparatorEnum.White_char));
                isMultipleWhiteChars = true;
            }
            return;//Přeskočí zbytek metody
        } else if (character == '=') {
            tokens.add(new SeparatorToken(SeparatorEnum.Equals));
        } else if (character == ':') {
            tokens.add(new SeparatorToken(SeparatorEnum.Colon));
        } else if (character == ';') {
            tokens.add(new SeparatorToken(SeparatorEnum.Semicolon));
        } else if (character == ',') {
            tokens.add(new SeparatorToken(SeparatorEnum.Comma));
        }

    }

    public void showTokens() {
        for (TokenAbstract token : tokens) {
            System.out.println(token);
        }
    }

}
