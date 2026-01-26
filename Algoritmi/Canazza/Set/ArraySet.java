package Set;
public class ArraySet implements Set {
    public ArraySet() {
        v = new Object[INITSIZE];
        vSize = 0;
    }

    public void makeEmpty() {
        vSize = 0;
    }

    public boolean isEmpty() {
        return (vSize == 0);
    }

    public void add(Object x)// prestazioni O(n) (usa contains)
    {
        if (contains(x))
            return;
        if (vSize == v.length)
            v = resize(2 * vSize);
        v[vSize++] = x;
    }

    public boolean contains(Object x) // metodo con prestaz. O(n)
    {
        for (int i = 0; i < vSize; i++)
            if (v[i].equals(x))
                return true;// non si puo` usare
        return false;
    } // compareTo perche` x e` solo un Object

    public Object[] toArray() // metodo con prestazioni O(n).
    {
        Object[] x = new Object[vSize]; // Creiamo un nuovo array
        System.arraycopy(v, 0, x, 0, vSize);// altrimenti si viola
        return x;
    } // l’incapsulamento

    private Object[] resize(int newLength) {
        if (newLength < v.length)
            throw new IllegalArgumentException();
        Object[] newv = new Object[newLength];
        System.arraycopy(v, 0, newv, 0, v.length);
        return newv;
    }// solito codice
     // campi di esemplare e var. statiche

    public static Set union(Set s1, Set s2) {
        Set x = new ArraySet();
        // inseriamo gli elementi del primo insieme
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++)
            x.add(v[i]);
        // inseriamo tutti gli elementi del
        // secondo insieme, sfruttando le
        // proprietà di add (niente duplicati...)
        v = s2.toArray();
        for (int i = 0; i < v.length; i++)
            x.add(v[i]);
        return x;
    }

    public static Set intersection(Set s1, Set s2) {
        Set x = new ArraySet();
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++)
            if (s2.contains(v[i]))
                x.add(v[i]);
        // inseriamo solo gli elementi che
        // appartengono anche al secondo
        // insieme, sfruttando le proprieta’
        // di add (niente duplicati...)
        return x;
    }

    public static Set subtract(Set s1, Set s2) {
        Set x = new ArraySet();
        Object[] v = s1.toArray();
        for (int i = 0; i < v.length; i++)
            if (!s2.contains(v[i]))
                x.add(v[i]);
        // inseriamo solo gli elementi che
        // *non* appartengono al secondo
        // insieme, sfruttando le proprieta’
        // di add (niente duplicati...)
        return x;
    }

    private Object[] v;
    private int vSize;
    private static int INITSIZE = 100;
}