package lexicalanalysis.logic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.io.IOException;
import lexicalanalysis.tokens.IdentifierToken;
import lexicalanalysis.tokens.KeyToken;
import lexicalanalysis.tokens.KeyWordEnum;
import lexicalanalysis.tokens.NumberToken;
import lexicalanalysis.tokens.NumberTypeEnum;
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

    private final ReaderInterface reader; //Interface pro redukci funkcí a snadnější výměny readeru
    private final ArrayList<TokenAbstract> tokens; //Možná List interface na redukci funkcí ?
    private final StringBuffer identifier; //Stringbuffer pro časté opakování přidávání stringu
    private TokenEnum status;
    ///////////
    private Boolean isMultipleWhiteChars;
    private TokenEnum statusNow;
    private NumberTypeEnum numberType;

    public lexicalAnalysis(String path) throws FileNotFoundException {
        reader = new FileReaderImpl(path);
        tokens = new ArrayList();
        identifier = new StringBuffer();
    }

    public void scan() throws IOException {
        status = TokenEnum.NONE;
        isMultipleWhiteChars = false;
        numberType = NumberTypeEnum.DEC;

        int c;
        while ((c = reader.readChar()) != -1) {
            char character = (char) c;
            //isHex = false;
            statusNow = getStatus(character);

            if (statusNow == TokenEnum.Identifier || statusNow == TokenEnum.Number) {
                isMultipleWhiteChars = false;
                status = statusNow;
                numberType = NumberTypeEnum.DEC;

                while (statusNow == TokenEnum.Identifier || statusNow == TokenEnum.Number) {
                    identifier.append(character);
                    c = reader.readChar();
                    character = (char) c;
                    statusNow = getStatus(character);

                    if (status == TokenEnum.Number && identifier.length() == 1 && character == 'x') {
                        numberType = NumberTypeEnum.HEX;
                    } //Pokud to bylo číslo a jeho druhý znak je x, jedná se o hex číslo
                    else if (status == TokenEnum.Number && statusNow == TokenEnum.Identifier) {
                        status = TokenEnum.Identifier;
                    } //Pokud bylo číslo, ale našli jsme v něm písmeno, jedná se o identifikátor
                }

                if (status == TokenEnum.Identifier && numberType != NumberTypeEnum.HEX) {
                    String realIdentifier = identifier.toString();
                    if (identifier.length() > MAX_LENGTH_IDENTIFIER) {
                        realIdentifier = realIdentifier.substring(0, MAX_LENGTH_IDENTIFIER);
                    }
                    KeyWordEnum key = getKeyword(realIdentifier);
                    if (key != null) {
                        tokens.add(new KeyToken(key)); //Skončí -1 ?
                    } else {

                        tokens.add(new IdentifierToken(realIdentifier));
                    }
                } else if (numberType == NumberTypeEnum.HEX) {
                    String hexValue = identifier.toString().substring(2, identifier.length());
                    Integer value = Integer.parseInt(hexValue, 16);
                    tokens.add(new NumberToken(value));
                } else if (status == TokenEnum.Number) {
                    Integer value = Integer.parseInt(identifier.toString());
                    tokens.add(new NumberToken(value));
                }
                identifier.setLength(0);
            }

            if (statusNow == TokenEnum.Separator) {
                SeparatorEnum separator = getSeparator(character);
                if (separator != null) {
                    tokens.add(new SeparatorToken(separator));
                }
            }
        }
    }

    private TokenEnum getStatus(char c) {
        TokenEnum statusNow = TokenEnum.NONE;
        if (c == '=' || c == ':' || c == ';' || c == ','
                || c == '\n' || c == '\t' || c == ' ' || c == '\r') {
            statusNow = TokenEnum.Separator;
        } else if (c >= '0' && c <= '9') {
            statusNow = TokenEnum.Number;
        } else if (c >= 'a' && c <= 'z') {
            statusNow = TokenEnum.Identifier;
        }
        return statusNow;

    }

    private KeyWordEnum getKeyword(String word) {
        for (KeyWordEnum value : KeyWordEnum.values()) {
            if (word.equals(value.getKey())) {
                return value;
            }
        }
        return null;
    }

    private SeparatorEnum getSeparator(char character) {

        SeparatorEnum separator = null;
        if (character == '\n' || character == '\t' || character == ' ' || character == '\r') {
            if (!isMultipleWhiteChars) {
                isMultipleWhiteChars = true;
                separator = SeparatorEnum.White_char;
            }
            return separator; //Aby metoda nepokračovala a nenastavil se isMultipleChars na false
        } else if (character == '=') {
            separator = SeparatorEnum.Equals;
        } else if (character == ':') {
            separator = SeparatorEnum.Colon;
        } else if (character == ';') {
            separator = SeparatorEnum.Semicolon;
        } else if (character == ',') {
            separator = SeparatorEnum.Comma;
        }
        isMultipleWhiteChars = false;
        return separator;
    }

    public void showTokens() {
        for (TokenAbstract token : tokens) {
            System.out.println(token);
        }
    }

    public ArrayList<TokenAbstract> getList() {
        return tokens;
    } //List potřebuju kvůli testům

}
