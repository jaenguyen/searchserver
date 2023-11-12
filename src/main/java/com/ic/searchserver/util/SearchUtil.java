package com.ic.searchserver.util;

import java.util.function.Supplier;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import lombok.val;

public class SearchUtil {

    public static Supplier<Query> supplierByName(String key) {
        Supplier<Query> supplier = () -> Query.of(q -> q.match(matchQueryWithName(key)));
        return supplier;
    }

    public static MatchQuery matchQueryWithName(String key) {
        val matchQuery = new MatchQuery.Builder();
        return matchQuery.field("name").query(key).build();
    }
}
