package lexicalanalysis.logic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import lexicalanalysis.tokens.IdentifierToken;
import lexicalanalysis.tokens.KeyToken;
import lexicalanalysis.tokens.KeyWordEnum;
import lexicalanalysis.tokens.NumberToken;
import lexicalanalysis.tokens.SeparatorEnum;
import lexicalanalysis.tokens.SeparatorToken;
import lexicalanalysis.tokens.TokenAbstract;
import org.hamcrest.CoreMatchers;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert;

/**
 *
 * @author user
 */
public class lexicalAnalysisTest {

    public lexicalAnalysisTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of scan method, of class lexicalAnalysis.
     *
     * @throws java.io.FileNotFoundException
     */
    @Test
    public void testSeparators() throws FileNotFoundException {
        lexicalAnalysis instance = new lexicalAnalysis("C:\\Users\\user\\Documents\\NetBeansProjects\\LexicalAnalysis\\test\\testfiles\\testSeparators.txt");
        ArrayList<TokenAbstract> expected = new ArrayList<>(Arrays.asList(
                new SeparatorToken(SeparatorEnum.Equals),
                new SeparatorToken(SeparatorEnum.Comma),
                new SeparatorToken(SeparatorEnum.Colon),
                new SeparatorToken(SeparatorEnum.Semicolon),
                new SeparatorToken(SeparatorEnum.White_char)
        ));
        instance.scan();

        assertThat(instance.getList(), is(expected));

    }

    @Test
    public void testMultipleWhiteChars() throws FileNotFoundException {
        lexicalAnalysis instance = new lexicalAnalysis("C:\\Users\\user\\Documents\\NetBeansProjects\\LexicalAnalysis\\test\\testfiles\\testMultipleWhiteChars.txt");
        ArrayList<TokenAbstract> expected = new ArrayList<TokenAbstract>(Arrays.asList(
                new SeparatorToken(SeparatorEnum.Equals),
                new SeparatorToken(SeparatorEnum.Equals),
                new SeparatorToken(SeparatorEnum.White_char),
                new SeparatorToken(SeparatorEnum.Colon),
                new SeparatorToken(SeparatorEnum.White_char),
                new SeparatorToken(SeparatorEnum.Semicolon),
                new SeparatorToken(SeparatorEnum.White_char),
                new SeparatorToken(SeparatorEnum.Comma)
        ));
        instance.scan();

        assertThat(instance.getList(), is(expected));

    }

    @Test
    public void testKeywords() throws FileNotFoundException {
        lexicalAnalysis instance = new lexicalAnalysis("C:\\Users\\user\\Documents\\NetBeansProjects\\LexicalAnalysis\\test\\testfiles\\testKeywords.txt");
        ArrayList<TokenAbstract> expected = new ArrayList<TokenAbstract>(Arrays.asList(
                new KeyToken(KeyWordEnum.Begin),
                new SeparatorToken(SeparatorEnum.White_char),
                new KeyToken(KeyWordEnum.End),
                new SeparatorToken(SeparatorEnum.White_char),
                new KeyToken(KeyWordEnum.For),
                new SeparatorToken(SeparatorEnum.White_char),
                new KeyToken(KeyWordEnum.If),
                new SeparatorToken(SeparatorEnum.White_char),
                new KeyToken(KeyWordEnum.Then),
                new SeparatorToken(SeparatorEnum.White_char),
                new KeyToken(KeyWordEnum.Else),
                new SeparatorToken(SeparatorEnum.White_char),
                new KeyToken(KeyWordEnum.While),
                new SeparatorToken(SeparatorEnum.White_char),
                new KeyToken(KeyWordEnum.Return)
        ));
                
        instance.scan();

        assertThat(instance.getList(), is(expected));
    }
    
     @Test
    public void testNumbers() throws FileNotFoundException {
        lexicalAnalysis instance = new lexicalAnalysis("C:\\Users\\user\\Documents\\NetBeansProjects\\LexicalAnalysis\\test\\testfiles\\testDecValues.txt");
        ArrayList<TokenAbstract> expected = new ArrayList<TokenAbstract>(Arrays.asList(
                new NumberToken(10),
                new SeparatorToken(SeparatorEnum.White_char),
                new IdentifierToken("a"),
                new SeparatorToken(SeparatorEnum.Equals),
                new NumberToken(32),
                new SeparatorToken(SeparatorEnum.Semicolon),
                new SeparatorToken(SeparatorEnum.White_char),
                new IdentifierToken("10a5abc")      
        ));
                
        instance.scan();

        assertThat(instance.getList(), is(expected));
    }
    
    @Test
    public void testHexNumbers() throws FileNotFoundException {
        lexicalAnalysis instance = new lexicalAnalysis("C:\\Users\\user\\Documents\\NetBeansProjects\\LexicalAnalysis\\test\\testfiles\\testHexValues.txt");
        ArrayList<TokenAbstract> expected = new ArrayList<TokenAbstract>(Arrays.asList(
                new NumberToken(8),
                new SeparatorToken(SeparatorEnum.White_char),
                new NumberToken(10)
        ));
                
        instance.scan();

        assertThat(instance.getList(), is(expected));
    }
    
    @Test
    public void testLongIdentifier() throws FileNotFoundException {
        lexicalAnalysis instance = new lexicalAnalysis("C:\\Users\\user\\Documents\\NetBeansProjects\\LexicalAnalysis\\test\\testfiles\\testLongIdentifier.txt");
        ArrayList<TokenAbstract> expected = new ArrayList<TokenAbstract>(Arrays.asList(
               new IdentifierToken("abcdefghijklmnopqrstuvwxyzabcdef")
        ));
                
        instance.scan();

        assertThat(instance.getList(), is(expected));
    }
    
    @Test
    public void testComplete() throws FileNotFoundException {
        lexicalAnalysis instance = new lexicalAnalysis("C:\\Users\\user\\Documents\\NetBeansProjects\\LexicalAnalysis\\test\\testfiles\\testComplete.txt");
        ArrayList<TokenAbstract> expected = new ArrayList<TokenAbstract>(Arrays.asList(
               new KeyToken(KeyWordEnum.Begin),
               new SeparatorToken(SeparatorEnum.White_char),
               new IdentifierToken("a"),
               new SeparatorToken(SeparatorEnum.Comma),
               new IdentifierToken("b"),
               new SeparatorToken(SeparatorEnum.Equals),
               new NumberToken(100),
               new SeparatorToken(SeparatorEnum.Semicolon),
               new SeparatorToken(SeparatorEnum.White_char),
               new KeyToken(KeyWordEnum.If),
               new SeparatorToken(SeparatorEnum.Colon),
               new SeparatorToken(SeparatorEnum.White_char),
               new IdentifierToken("output"),
               new SeparatorToken(SeparatorEnum.Equals),
               new IdentifierToken("reallylooooooooooooooooooooooong"),
               new SeparatorToken(SeparatorEnum.Semicolon),
               new SeparatorToken(SeparatorEnum.White_char),
               new NumberToken(255),
               new SeparatorToken(SeparatorEnum.White_char),
               new NumberToken(24),
               new SeparatorToken(SeparatorEnum.White_char),
               new KeyToken(KeyWordEnum.End),
               new SeparatorToken(SeparatorEnum.Semicolon)
               
               
        ));
                
        instance.scan();

        assertThat(instance.getList(), is(expected));
    }
}
