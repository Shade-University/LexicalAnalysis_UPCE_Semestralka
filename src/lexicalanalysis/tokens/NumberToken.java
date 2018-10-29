package lexicalanalysis.tokens;

import java.util.Objects;

public class NumberToken extends TokenAbstract {

    private final Integer value;

    public NumberToken(Integer number) {
        super(TokenEnum.Number);
        this.value = number;
    }

    public Integer getNumber() {
        return value;
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final NumberToken other = (NumberToken) obj;
        if (!Objects.equals(this.value, other.value)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("NumberToken{value=%s}", value.toString());
    }
}
