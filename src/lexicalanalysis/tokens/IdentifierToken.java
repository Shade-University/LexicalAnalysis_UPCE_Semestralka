package lexicalanalysis.tokens;

import java.util.Objects;

public class IdentifierToken extends TokenAbstract {

    private final String identifier;

    public IdentifierToken(String identifier) {
        super(TokenEnum.Identifier);
        this.identifier = identifier;
    }

    public String getIdentifier() {
        return identifier;
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
        final IdentifierToken other = (IdentifierToken) obj;
        if (!Objects.equals(this.identifier, other.identifier)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return String.format("IdentifierToken{%s}", identifier);
    }
}
