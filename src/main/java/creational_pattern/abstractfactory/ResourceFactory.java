// src/main/java/creational/abstractfactory/ResourceFactory.java
package creational_pattern.abstractfactory;

import core.WellnessResource;

public interface ResourceFactory {
    WellnessResource createArticle(String id, String title);
    WellnessResource createVideo(String id, String title);
}

