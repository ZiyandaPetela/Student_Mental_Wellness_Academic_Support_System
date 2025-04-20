// src/test/java/creational/abstractfactory/AnxietyResourceFactoryTest.java
package test.creational.abstractfactory;

import core.WellnessResource;
import creational.abstractfactory.ResourceFactory;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class AnxietyResourceFactoryTest {
    @Test
    void testAnxietyArticleCreation() {
        ResourceFactory factory = new AnxietyResourceFactory();
        WellnessResource article = factory.createArticle("ART-101", "Coping with Anxiety");
        assertAll(
            () -> assertEquals("ARTICLE", article.getType()),
            () -> assertTrue(article.getTopics().contains("Anxiety"))
        );
    }
}