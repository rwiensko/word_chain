import java.util.Arrays;
import java.util.List;

public class Link {

    private String current;
    private String next;

    public Link(String current, String next) {
        this.current = current;
        this.next = next;
    }

    public List<String> asArray() {
        return Arrays.asList(current, next);
    }

    public String getCurrent() {
        return current;
    }

    public String getNext() {
        return next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Link link = (Link) o;

        if (current != null ? !current.equals(link.current) : link.current != null) return false;
        return next != null ? next.equals(link.next) : link.next == null;
    }

    @Override
    public int hashCode() {
        int result = current != null ? current.hashCode() : 0;
        result = 31 * result + (next != null ? next.hashCode() : 0);
        return result;
    }
}
