// src/main/java/creational/prototype/ResourcePrototype.java
package creational_pattern.prototype;

import core.WellnessResource;

public class ResourcePrototype {
    private final WellnessResource prototype;

    public ResourcePrototype(WellnessResource prototype) {
        this.prototype = prototype;
    }

    public WellnessResource cloneResource(String newId) {
        return new WellnessResource(
            newId,
            prototype.getTitle(),
            prototype.getType()
        );
    }
}