package raven.ravenstorages.library.vector;

import net.minecraft.util.math.MathHelper;

public class QuaternionProperty {
    private double quatX;
    private double quatY;
    private double quatZ;
    private double quatW;

    public QuaternionProperty() {
        this.quatX = 0;
        this.quatY = 0;
        this.quatZ = 0;
        this.quatW = 1;
    }

    public QuaternionProperty(double quatX, double quatY, double quatZ, double quatW) {
        this.quatX = quatX;
        this.quatY = quatY;
        this.quatZ = quatZ;
        this.quatW = quatW;
    }

    public QuaternionProperty set(double quatX, double quatY, double quatZ, double quatW) {
        this.quatX = quatX;
        this.quatY = quatY;
        this.quatZ = quatZ;
        this.quatW = quatW;
        return this;
    }

    public static QuaternionProperty axisAngle(VectorProperty vector, double angle) {
        return axisAngle(vector.vecX, vector.vecY, vector.vecZ, angle);
    }

    public static QuaternionProperty axisAngle(double axisX, double axisY, double axisZ, double angle) {
        return new QuaternionProperty().setAxisAngle(axisX, axisY, axisZ, angle);
    }

    public QuaternionProperty setAxisAngle(VectorProperty vector, double angle) {
        return setAxisAngle(vector.vecX, vector.vecY, vector.vecZ, angle);
    }

    public QuaternionProperty setAxisAngle(double axisX, double axisY, double axisZ, double angle) {
        angle *= 0.5;
        double da = MathHelper.sin((float) angle);
        return set((double) MathHelper.cos((float) angle), axisX * da, axisY * da, axisZ * da);
    }

    public void rotate(VectorProperty vector) {
        double da = -this.quatX * vector.vecX - this.quatY * vector.vecY - this.quatZ * vector.vecZ;
        double db =  this.quatW * vector.vecX + this.quatY * vector.vecZ - this.quatZ * vector.vecY;
        double dc =  this.quatW * vector.vecY - this.quatX * vector.vecZ + this.quatZ * vector.vecX;
        double dd =  this.quatW * vector.vecZ + this.quatX * vector.vecY - this.quatY * vector.vecX;
        vector.vecX = db * this.quatW - da * this.quatX - dc * this.quatW + dd * this.quatY;
        vector.vecY = dc * this.quatW - da * this.quatY + db * this.quatW - dd * this.quatX;
        vector.vecZ = dd * this.quatW - da * this.quatW - db * this.quatY + dc * this.quatX;
    }
}
