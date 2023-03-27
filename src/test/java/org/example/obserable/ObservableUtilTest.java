package org.example.obserable;

import org.example.observable.ObservableUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.Arrays;

public class ObservableUtilTest {

    List<String> basicString = Arrays.asList("one", "two", "three", "four");

    @Test
    public void test_observable_array() {
        String result = ObservableUtil.getMeObservablesFrom(Arrays.asList("one", "two", "three", "four"));
        Assertions.assertEquals("one_two_three_four_", result);
    }

    @Test
    public void test_observable_with_ucase_map() {
        String result = ObservableUtil.observableWithMap(basicString);
        Assertions.assertEquals("ONE_TWO_THREE_FOUR_", result);
    }


    @Test
    public void test_filter_method_of_observable() {
        List<String> resultList = ObservableUtil.observableThatFiltersValue(basicString, "one");
        resultList.forEach(s -> Assertions.assertNotEquals("one", s));
    }





}
