package lexicalanalysis.tokens;

public abstract class TokenAbstract {
    
    private final TokenEnum tokenEnum;
    
    public TokenAbstract(TokenEnum tokenEnum){
        this.tokenEnum = tokenEnum;
    }
    
    public TokenEnum getEnum(){
        return tokenEnum;
    }
    
    @Override
    public String toString(){
        return String.format("Token{Enum=%s}", tokenEnum);
    }
    
}
