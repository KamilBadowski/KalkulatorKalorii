package modelFx;

import javafx.beans.property.*;

public class ProductFx {

    private LongProperty id = new SimpleLongProperty();
    private StringProperty name = new SimpleStringProperty();
    private IntegerProperty calories = new SimpleIntegerProperty();

    public long getId() {
        return id.get();
    }

    public LongProperty idProperty() {
        return id;
    }

    public void setId(long id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getCalories() {
        return calories.get();
    }

    public IntegerProperty caloriesProperty() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories.set(calories);
    }

    @Override
    public String toString() {
        return "ProductFx{" +
                "id=" + id +
                ", name=" + name +
                ", calories=" + calories +
                '}';
    }
}
