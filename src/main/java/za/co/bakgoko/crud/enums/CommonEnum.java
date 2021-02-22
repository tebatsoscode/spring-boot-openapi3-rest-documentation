package za.co.bakgoko.crud.enums;

public enum CommonEnum {
    EXCEPTION("Exception"),
    SUCCESS_POST("Successfully Created Student "),
    ERROR_MESSAGE("Successfully Created Student "),
    SUCCESS_PUT("Successfully Updated Student "),
    SUCCESS_DELETE("Successfully Deleted Student "),
    SUCCESS("Success");

    private String value;

    CommonEnum(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}