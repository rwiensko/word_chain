import com.google.common.collect.Sets;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class GraphOfLinksTest {

    private List<String> dictionary;
    private Set<Link> links;
    @Test
    public void createGraphOfLinks() {
        givenDictionary();
        givenLinks();
        GraphOfLinks graph = new GraphOfLinks(dictionary);
        graph.build(3);
        Assert.assertEquals(links, graph.getLinks());
    }

    @Test
    public void canConnect() {
        givenDictionary();
        GraphOfLinks graph = new GraphOfLinks(dictionary);
        graph.build(3);
        Assert.assertTrue(graph.canConnect("cat", "cot"));
        Assert.assertFalse(graph.canConnect("cat", "dog"));
    }

    private void givenLinks() {
        Link link12 = new Link("cat", "cot");
        Link link21 = new Link("cot", "cat");
        Link link23 = new Link("cot", "cog");
        Link link32 = new Link("cog", "cot");
        Link link34 = new Link("cog", "dog");
        Link link43 = new Link("dog", "cog");
        this.links = Sets.newHashSet(link12, link21, link23, link32, link34, link43);
    }

    private void givenDictionary() {
        this.dictionary = Arrays.asList("cat", "cot", "cog", "dog");
    }


}
