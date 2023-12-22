package app.rpgbuilder.adapters.options;

public class Option {
    private final String name;
    private final String description;

    private final int imgResource;

    public Option(final String name, final String description, final int imgResource) {
        this.name = name;
        this.description = description;
        this.imgResource = imgResource;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getImgResource() {
        return imgResource;
    }
}
