package fullstack.homework.Course2.enums;

public enum AgeCategory {
    YOUNG("1-30"),
    MIDDLE("31-50"),
    OLD("50+");

    private final String ageCategory;

    AgeCategory(String ageCategory) {
        this.ageCategory = ageCategory;
    }

    public String getAgeCategory() {
        return this.ageCategory;
    }
}
