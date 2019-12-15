package systemdesign.parkinglot;

/**
 * @author Jeff
 * @version V1.0
 * @description
 * @date 2019/4/6 08:00
 */
public enum SizeEnum {
    /**
     * Small
     */
    S(1, "Small"),
    /**
     * Middle
     */
    M(2, "Middle"),
    /**
     * Large
     */
    L(3, "Large"),
    /**
     * XLarge
     */
    XL(4, "XLarge");

    int value;
    String name;

    SizeEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public static SizeEnum getByValue(int value) {
        for (SizeEnum sizeEnum : SizeEnum.values()) {
            if (sizeEnum.value == value) {
                return sizeEnum;
            }
        }
        throw new IllegalArgumentException("No element matches " + value);
    }

    public static SizeEnum getByName(String name) {
        for (SizeEnum sizeEnum : SizeEnum.values()) {
            if (sizeEnum.name.equals(name)) {
                return sizeEnum;
            }
        }
        throw new IllegalArgumentException("No element matches " + name);
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }
}
