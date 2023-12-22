package app.rpgbuilder.adapters.options;

import app.rpgbuilder.R;

public final class OptionsRepository {
    private OptionsRepository() {}

    private static Option[] options = new Option[] {
        new Option("Adventure", "Test", R.drawable.sword),
            new Option("Library", "Test", R.drawable.book),
            new Option("Game", "Test", R.drawable.sword)
    };

    public static int size() {
        return options.length;
    }

    public static Option getOption(int index) {
        return options[index];
    }
}
