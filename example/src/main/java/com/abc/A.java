package com.abc;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

class A {
   private static final List<String> staticList = Collections.singletonList("0");

   /* This is a comment */
   public void test() {
        // This is a comment
        Set<String> stringSet = Collections.singleton("aaa");
        List<String> stringList = Collections.singletonList("bbb");
        Map<String, Object> stringMap = Collections.singletonMap("a-key", "a-value");
   }
}
