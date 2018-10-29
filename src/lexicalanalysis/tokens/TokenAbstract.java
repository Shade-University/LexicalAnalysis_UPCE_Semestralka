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

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

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
    
}
