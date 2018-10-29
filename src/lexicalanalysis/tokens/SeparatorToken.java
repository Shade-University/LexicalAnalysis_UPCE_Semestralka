package lexicalanalysis.tokens;

public class SeparatorToken extends TokenAbstract {

    private final SeparatorEnum separator;

    public SeparatorToken(SeparatorEnum separator) {
        super(TokenEnum.Separator);
        this.separator = separator;
    }

    public SeparatorEnum getSeparator() {
        return separator;
    }

    @Override
    public String toString() {
        return String.format("SeparatorToken{%s}", separator);
    }

    //kvůli testům
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
        final SeparatorToken other = (SeparatorToken) obj;
        if (this.separator != other.separator) {
            return false;
        }
        return true;
    }

}
