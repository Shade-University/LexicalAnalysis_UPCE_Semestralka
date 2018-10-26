package lexicalanalysis.tokens;

public class SeparatorToken extends TokenAbstract {
    
    private final SeparatorEnum separator;

    public SeparatorToken(SeparatorEnum separator) {
        super(TokenEnum.Separator);
        this.separator = separator;
    }
    
    public SeparatorEnum getSeparator(){
        return separator;
    }
    
    @Override
    public String toString(){
        return String.format("SeparatorToken{%s}", separator);
    }
    
}
