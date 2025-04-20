package creational.abstractfactory;

import core.WellnessResource;

public class AnxietyResourceFactory implements ResourceFactory {
    
    @Override
    public WellnessResource createArticle(String id, String title) {
        WellnessResource article = new WellnessResource(id, title, "ARTICLE");
        article.addTopic("Anxiety");
        return article;
    }

    @Override
    public WellnessResource createVideo(String id, String title) {
        WellnessResource video = new WellnessResource(id, title, "VIDEO");
        video.addTopic("Anxiety");
        return video;
    }
}