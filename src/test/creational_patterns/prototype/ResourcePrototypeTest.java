// src/test/java/creational/prototype/ResourcePrototypeTest.java
package test.creational_patterns.prototype;

import core.WellnessResource;
import creational.prototype.ResourcePrototype;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ResourcePrototypeTest {
    @Test
    void testResourceCloning() {
        WellnessResource original = new WellnessResource("RES-101", "Stress Guide", "ARTICLE");
        ResourcePrototype prototype = new ResourcePrototype(original);
        WellnessResource clone = prototype.cloneResource("RES-102");

        assertNotSame(original, clone);
        assertEquals(original.getTitle(), clone.getTitle());
    }
}