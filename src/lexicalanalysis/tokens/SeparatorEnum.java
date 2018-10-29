package lexicalanalysis.tokens;

public enum SeparatorEnum {

    Equals("rovná se"),
    Comma("čárka"),
    Colon("dvojtečka"),
    Semicolon("středník"),
    White_char("bílý znak"),
    Separator_None("");

    private final String separator;

    private SeparatorEnum(String separator) {
        this.separator = separator;
    }

    public String getSeparator() {
        return separator;
    }

    @Override
    public String toString() {
        return String.format("Separator{%s}", separator);
    }

}
