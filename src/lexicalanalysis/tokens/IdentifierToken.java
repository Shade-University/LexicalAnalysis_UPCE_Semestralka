package lexicalanalysis.tokens;

public class IdentifierToken extends TokenAbstract {
    
    private final String identifier;

    public IdentifierToken(String identifier) {
        super(TokenEnum.Identifier);
        this.identifier = identifier;
    }
    
    public String getIdentifier(){
        return identifier;
    }
    
    @Override
    public String toString(){
        return String.format("IdentifierToken{%s}", identifier);
    }
}
