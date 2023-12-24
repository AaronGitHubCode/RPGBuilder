package app.rpgbuilder.adapters.options;

import app.rpgbuilder.R;

public final class OptionsRepository {
    private OptionsRepository() {}

    private static Option[] options = new Option[] {
        new Option("Adventure", "Test", R.drawable.sword),
            new Option("Library", "Test", R.drawable.book),
            new Option("Jukebox", "Test", R.drawable.sword),
            new Option("Options", "Test", R.drawable.book),
            new Option("Builder", "Test", R.drawable.book)
    };

    public static int size() {
        return options.length;
    }

    public static Option getOption(int index) {
        return options[index];
    }
}
