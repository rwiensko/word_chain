import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class WordChainTest {

    @Test
    public void wordChain() {
        WordChain wordChain = new WordChain(Arrays.asList("cat", "cot", "cog", "dog", "fhg"));
        List<String> expected = Arrays.asList("cat", "cot", "cog", "dog");
        List<String> actual = wordChain.chainWords("cat", "dog");
        System.out.println(expected);
        System.out.println(actual);
        Assert.assertEquals(expected, actual);
    }

}
