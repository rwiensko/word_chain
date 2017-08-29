import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GraphOfLinks {

    private Set<Link> links = new HashSet<>();
    private List<String> dictionary;

    public GraphOfLinks(List<String> dictionary) {
        this.dictionary = dictionary;
    }

    public void build(int length) {
        dictionary = dictionary.stream().filter(s -> s.length() == length).collect(Collectors.toList());
        dictionary.forEach(word -> dictionary.forEach(anotherWord -> {
            if (canConnect(word, anotherWord)) {
                links.add(new Link(word, anotherWord));
            }
        }));
    }

    public boolean canConnect(String word, String anotherWord) {
        if (word.length() != anotherWord.length()) return false;
        int diff = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != anotherWord.charAt(i)) diff++;
        }
        return diff == 1;
    }

    public List<String> getCandidates(String word) {
        List<String> candidates = new ArrayList<>();
        links.forEach(link -> {
            if (link.getCurrent().equals(word)) {
                candidates.add(link.getNext());
            }
        });
        return candidates;
    }

    public Set<Link> getLinks() {
        return links;
    }
}
