package ud.antlr.json.operand;

import javax.json.JsonObject;

public class Operand {

    private Object value;
    private String strValue;
    private Long longValue;
    private Double doubleValue;
    private Boolean boolValue;

    public Operand() {
        reset();
    }

    public String getStrValue() {
        return strValue;
    }

    public Operand setStrValue(String strValue) {
        reset();
        this.strValue = strValue;

        return this;
    }

    public Long getLongValue() {
        return longValue;
    }

    public Operand setLongValue(Long longValue) {
        reset();
        this.longValue = longValue;

        return this;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public Operand setDoubleValue(Double doubleValue) {
        reset();
        this.doubleValue = doubleValue;

        return this;
    }

    public Boolean getBoolValue() {
        return boolValue;
    }

    public Operand setBoolValue(Boolean boolValue) {
        reset();
        this.boolValue = boolValue;
        return this;
    }

    public Object getValue() {
        return value;
    }

    public Operand setValue(Object value) {
        reset();
        this.value = value;
        return this;
    }

    public Operand setValue(JsonObject item, String name) {
        reset();

        switch (item.get(name).getValueType()) {
            case STRING:
                this.value = item.getString(name);
                break;

            case TRUE:
            case FALSE:
                this.value = item.getBoolean(name);
                break;

            case NULL:
                this.value = null;
                break;

            case NUMBER:
                // TODO: Handle other number types.
                this.value = item.getJsonNumber(name).doubleValue();
                break;

            default:
                // TODO: Handle various value types.
                this.value = item.get(name);
        }

        return this;
    }

    public Long toLong() {
        if (getValue() instanceof Long) {
            return (Long) getValue();

        } else if (getValue() instanceof Double) {
            return ((Double) getValue()).longValue();

        } else if (getValue() instanceof Integer) {
            return ((Integer) getValue()).longValue();
        }

        return null;
    }

    public Double toDouble() {
        if (getValue() instanceof Double) {
            return (Double) getValue();

        } else if (getValue() instanceof Long) {
            return ((Long) getValue()).doubleValue();

        } else if (getValue() instanceof Integer) {
            return ((Integer) getValue()).doubleValue();
        }

        return null;
    }

    private void reset() {
        value = null;
        strValue = null;
        longValue = null;
        doubleValue = null;
        boolValue = null;
    }
}
