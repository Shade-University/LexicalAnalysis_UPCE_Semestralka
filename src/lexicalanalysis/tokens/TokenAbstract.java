package lexicalanalysis.tokens;

public abstract class TokenAbstract {
    
    private final TokenEnum tokenEnum;
    
    public TokenAbstract(TokenEnum tokenEnum){
        this.tokenEnum = tokenEnum;
    }
    
    public TokenEnum getEnum(){
        return tokenEnum;
    }

    //Kvůli testům
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TokenAbstract other = (TokenAbstract) obj;
        if (this.tokenEnum != other.tokenEnum) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString(){
        return String.format("Token{Enum=%s}", tokenEnum);
    }
    
}
