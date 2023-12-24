package app.rpgbuilder.adapters.options;

public final class Option {
    private final String name;
    private final String description;

    private final int imgResource;

    private boolean newer;

    public Option(final String name, final String description, final int imgResource) {
        this.name = name;
        this.description = description;
        this.imgResource = imgResource;

        newer = true;
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

    public void neverAgainNew() {
        newer = false;
    }
}
