package com.tinkerpop.gremlin;

import com.tinkerpop.pipes.filter.FilterPipe;

/**
 * @author Marko A. Rodriguez (http://markorodriguez.com)
 */
public class Tokens {

    public static final String VERSION = "2.1.0-SNAPSHOT";
    public static final String LABEL = "label";
    public static final String ID = "id";

    public static enum T {
        gt, lt, eq, gte, lte, neq
    }

    public static FilterPipe.Filter mapFilter(final T t) {
        if (t.equals(T.eq))
            return FilterPipe.Filter.EQUAL;
        else if (t.equals(T.neq))
            return FilterPipe.Filter.NOT_EQUAL;
        else if (t.equals(T.lt))
            return FilterPipe.Filter.LESS_THAN;
        else if (t.equals(T.lte))
            return FilterPipe.Filter.LESS_THAN_EQUAL;
        else if (t.equals(T.gt))
            return FilterPipe.Filter.GREATER_THAN;
        else if (t.equals(T.gte))
            return FilterPipe.Filter.GREATER_THAN_EQUAL;
        else
            throw new IllegalArgumentException(t.toString() + " is an unknown filter type");
    }

    public static FilterPipe.Filter mapFlipFilter(final T t) {
        if (t.equals(T.eq))
            return FilterPipe.Filter.NOT_EQUAL;
        else if (t.equals(T.neq))
            return FilterPipe.Filter.EQUAL;
        else if (t.equals(T.lt))
            return FilterPipe.Filter.GREATER_THAN_EQUAL;
        else if (t.equals(T.lte))
            return FilterPipe.Filter.GREATER_THAN;
        else if (t.equals(T.gt))
            return FilterPipe.Filter.LESS_THAN_EQUAL;
        else if (t.equals(T.gte))
            return FilterPipe.Filter.LESS_THAN;
        else
            throw new IllegalArgumentException(t.toString() + " is an unknown filter type");
    }


}
