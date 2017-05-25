package pl.marczak.ifixpicturesrenderer.connection.opc_da_model;

/**
 * Project "IfixPicturesRenderer"
 * <p>
 * Created by Lukasz Marczak
 * on 25.05.2017.
 */

public class Image {
    public final String title;
    public final String content;

    public Image(String title, String content) {
        this.title = title;
        this.content = content;
    }

    @Override public String toString() {
        return "Image{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
