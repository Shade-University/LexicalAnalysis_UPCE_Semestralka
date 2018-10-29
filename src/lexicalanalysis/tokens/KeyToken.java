package lexicalanalysis.tokens;

public class KeyToken extends TokenAbstract {

    private final KeyWordEnum keyWord;

    public KeyToken(KeyWordEnum keyWord) {
        super(TokenEnum.Keyword);
        this.keyWord = keyWord;
    }

    public KeyWordEnum getKeyword() {
        return keyWord;
    }

    @Override
    public String toString() {
        return String.format("KeyToken{klicoveSlovo=%s}", keyWord);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        return hash;
    }

    //kvůli testům
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
        final KeyToken other = (KeyToken) obj;
        if (this.keyWord != other.keyWord) {
            return false;
        }
        return true;
    }

}
