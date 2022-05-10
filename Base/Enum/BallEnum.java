package Base.Enum;

public enum BallEnum {

    BASKETBALL(1),
    BASEBALL(2);

    public int val;

    BallEnum(int i) {
        val = i;
    }

    public int getId() {
        return val;
    }

    @Override
    public String toString() {
        return "BallEnum{" +
                "val=" + val +
                '}';
    }
}
