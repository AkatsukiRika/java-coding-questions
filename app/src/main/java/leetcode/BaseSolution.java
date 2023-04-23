package leetcode;

import java.util.Collections;
import java.util.List;

public abstract class BaseSolution<T> {
    public abstract T performSingleTest();
    
    public List<T> performMultiTest() {
        return Collections.emptyList();
    }
}