import Container;

package Set;
public interface Set extends Container {
    void add(Object obj);

    boolean contains(Object obj);

    Object[] toArray();
}