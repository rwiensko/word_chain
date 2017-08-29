import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class WordChain {

    private GraphOfLinks graphOfLinks;

    public WordChain(List<String> dictionary) {
        this.graphOfLinks = new GraphOfLinks(dictionary);
    }

    public List<String> chainWords(String start, String end) {
        graphOfLinks.build(start.length());
        return traverse(start, end, graphOfLinks.getLinks());
    }

    private List<String> traverse(String current, String end, Set<Link> links) {
        if (graphOfLinks.canConnect(current, end)) return new Link(current, end).asArray();
        else {
            List<String> candidates = graphOfLinks.getCandidates(current);

            List<String> chain = new ArrayList<>();
            chain.add(current);
            if (candidates.contains(end)) {
                chain.add(end);
                return chain;
            }
            for (String candidate : candidates) {
                links.remove(new Link(candidate, current));
                links.remove(new Link(current, candidate));
                List<String> traversed = traverse(candidate, end, links);
                if (!traversed.isEmpty()) {
                    chain.addAll(traversed);
                    return chain;
                }
            }
        }
        return new ArrayList<>();
    }
}
