package raven.ravenstorages.effects.entities.base;

import raven.ravenstorages.library.vector.VectorProperty;

import java.util.Random;

public abstract class BaseFXEntity {
    protected final  long id;
    protected static long idCounter = 0L;
    protected int age = 0;
    protected int maxAge = 50;
    protected int rejuvenationCount = 0;

    protected VectorProperty posProperty;

    protected static final Random random = new Random();

    protected BaseFXEntity(VectorProperty property) {
        this.id = idCounter;
        idCounter++;
        this.posProperty = property;
    }

    @SuppressWarnings({"unchecked", "UnusedReturnValue"})
    public <T extends BaseFXEntity> T setMaxAge(int maxAge) {
        this.maxAge = maxAge;
        return (T) this;
    }

    @SuppressWarnings({"unchecked", "UnusedReturnValue"})
    public <T extends BaseFXEntity> T setPosProperty(VectorProperty prop) {
        this.posProperty = prop.copy();
        return (T) this;
    }

    @SuppressWarnings({"unchecked", "UnusedReturnValue"})
    public <T extends BaseFXEntity> T add(VectorProperty add) {
        this.posProperty.add(add);
        return (T) this;
    }

    @SuppressWarnings({"unchecked", "UnusedReturnValue"})
    public <T extends BaseFXEntity> T onMove(VectorProperty moveProp) {
        this.setPosProperty(this.getPosProperty().add(moveProp));
        return (T) this;
    }

    public void rejuvenation() { this.age = 0; }

    public long getId() { return id; }

    public int getAge() { return age; }

    public int getMaxAge() { return maxAge; }

    public int getRejuvenationCount() { return rejuvenationCount; }

    public boolean isRemovable() { return this.age >= this.maxAge; }

    public VectorProperty getPosProperty() { return posProperty; }
}
