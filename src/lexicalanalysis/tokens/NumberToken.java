
package lexicalanalysis.tokens;

public class NumberToken extends TokenAbstract{
    
    private final Integer value;

    public NumberToken(Integer number) {
        super(TokenEnum.Number);
        this.value = number;
    }
    
    public Integer getNumber(){
        return value;
    }
    
    @Override
    public String toString(){
        return String.format("NumberToken{value=%s}", value.toString());
    }
}
