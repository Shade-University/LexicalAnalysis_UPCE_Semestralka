
package lexicalanalysis.tokens;

public enum SeparatorEnum {
    
    Equals("rovná se"),
    Comma("čárka"),
    Colon("dvojtečka"),
    Semicolon("středník"),
    White_char("bílý znak");
    
    private final String separator;
    private SeparatorEnum(String separator){
        this.separator = separator;
    }
    
    public SeparatorEnum getSeparator(String separator){
        for (SeparatorEnum sep : values()) {
            if(separator.equalsIgnoreCase(sep.separator))
                return sep;
        }
        return null; //TODO Maybe enum Separator_None
    }
    
    @Override
    public String toString(){
        return String.format("Separator{%s}", separator);
    }
    
}
