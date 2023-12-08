package constant;

public enum MainFeature {
    ORDER(1),
    PAY(2),
    EXIT(3);

    int feature;
    MainFeature(int feature) {
        this.feature = feature;
    }

    public int getFeature() {
        return feature;
    }
}
