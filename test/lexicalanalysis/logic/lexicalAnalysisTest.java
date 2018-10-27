package lexicalanalysis.logic;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
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
                new SeparatorToken(SeparatorEnum.Comma)
        ));
        instance.scan();

        assertThat(instance.getList(), is(expected));

    }

}
