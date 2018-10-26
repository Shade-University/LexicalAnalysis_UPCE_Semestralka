package lexicalanalysis.tokens;

public class KeyToken extends TokenAbstract {
    
    private final KeyWordEnum keyWord;

    public KeyToken(KeyWordEnum keyWord) {
        super(TokenEnum.Keyword);
        this.keyWord = keyWord;
    }
    
    public KeyWordEnum getKeyword(){
        return keyWord;
    }
    
    @Override
    public String toString(){
        return String.format("KeyToken{klicoveSlovo=%s}", keyWord);
    }
    
    
    
}
