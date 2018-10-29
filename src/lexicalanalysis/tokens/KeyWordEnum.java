package lexicalanalysis.tokens;

public enum KeyWordEnum {
    
    Begin("begin"),
    End("end"),
    For("for"),
    If("if"),
    Then("then"),
    Else("else"),
    While("while"),
    Return("return");
    
    private final String key;
    private KeyWordEnum(String key){
        this.key = key;
    }
    
    public String getKey(){
        return key;
    }
    
    /*public static KeyWordEnum getKeyword(String key){
        for (KeyWordEnum value : values()) {
            if(key.equals(value.getKey()))
                return value;
        }
        return null; //Možná vytvořit Key_none ?
        
    } Nakonec tato metoda přesunuta do lexicalAnalysis*/
    
    @Override
    public String toString(){
        return String.format("KeyWord{key=%s}", key);
    }
    
}
