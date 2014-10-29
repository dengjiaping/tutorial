package com.tutorial.beanmapper.pongo;

public class Couple<S,T> {
    private S source;
    private T target;

    public Couple(S s, T t) {
        this.source=s;
        this.target=t;
    }

    /**
     *
     * @return the target
     */
    public T getTarget() {
        return target;
    }

    /**
     *
     * @param target set target
     */
    public void setTarget(T target) {
        this.target = target;
    }

    /**
     *
     * @return the source
     */
    public S getSource() {
        return source;
    }

    /**
     *
     * @param source set source value
     */
    public void setSource(S source) {
        this.source = source;
    }

    /**
     *
     * @return toString value
     */
    @Override
    public String toString() {
        return "Couple{" +
                "source=" + source +
                ", target=" + target +
                '}';
    }

    /**
     * (non-JavaDoc)
     * @param o
     * @return
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Couple couple = (Couple) o;

        if (!source.equals(couple.source)) return false;
        if (!target.equals(couple.target)) return false;

        return true;
    }

    /**
     * (non-Javadoc)
     * @return
     */
    @Override
    public int hashCode() {
        int result = source.hashCode();
        result = 31 * result + target.hashCode();
        return result;
    }
}
