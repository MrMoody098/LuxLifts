package App.Vehicles;

import App.Map.MapItem;

public interface Type extends MapItem {
    void drive();

    void fly();

    void land();

    void sail();

    // other common methods
}