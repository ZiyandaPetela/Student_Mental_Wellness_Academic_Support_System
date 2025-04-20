// src/main/java/creational/abstractfactory/ResourceFactory.java
package creational.abstractfactory;

import core.WellnessResource;

public interface ResourceFactory {
    WellnessResource createArticle(String id, String title);
    WellnessResource createVideo(String id, String title);
}

