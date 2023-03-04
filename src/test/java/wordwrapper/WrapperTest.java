package wordwrapper;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class WrapperTest {
    @Before
    public void setUp() throws Exception {
        wordWrap = new WordWrap();
    }

    @Test
    public void should_wrap() {
        assertWraps(null, 1, "");
        assertWraps("", 1, "");
        assertWraps("x", 1, "x");
        assertWraps("xx", 1, "x\nx");
        assertWraps("xxx", 1, "x\nx\nx");
        assertWraps("x x", 1, "x\nx");
        assertWraps("x xx", 3, "x\nxx");
        assertWraps("four score and seven years ago our fathers brought forth upon this continent", 7, "four\nscore\nand\nseven\nyears\nago our\nfathers\nbrought\nforth\nupon\nthis\ncontine\nnt");
    }

    private void assertWraps(String s, int width, String expected) {
        assertThat(wordWrap.wrap(s, width), is(expected));
    }

    WordWrap wordWrap;

}
