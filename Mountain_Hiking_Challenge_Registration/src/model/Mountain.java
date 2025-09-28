package model;

public class Mountain {
    private String code;
    private String name;
    private String province;
    private String description;

    public Mountain(String name, String code, String province, String description) {
        this.name = name;
        this.code = code;
        this.province = province;
        this.description = description;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Mountain{" + "code=" + code + ", name=" + name + ", province=" + province + ", description=" + description + '}';
    }
}
