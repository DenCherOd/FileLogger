package logger;

public enum LoggingLevel {
    INFO(0, "INFO"),
    DEBUG(1, "DEBUG");

    public final int level;
    public final String title;

    private LoggingLevel(int level, String title) {
        this.level = level;
        this.title = title;
    }

    public int getLevelValue() {
        return level;
    }

    public String getLevelTitle() {
        return title;
    }
}
