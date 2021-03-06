package raven.ravenstorages.common.library.vector;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.vector.Vector3i;

public class VectorProperty {
    protected double vecX;
    protected double vecY;
    protected double vecZ;

    public VectorProperty(double vecX, double vecY, double vecZ) {
        this.vecX = vecX;
        this.vecY = vecY;
        this.vecZ = vecZ;
    }

    public VectorProperty(int vecX, int vecY, int vecZ) {
        this.vecX = vecX;
        this.vecY = vecY;
        this.vecZ = vecZ;
    }

    public VectorProperty() {
        this.vecX = 0.0D;
        this.vecY = 0.0D;
        this.vecZ = 0.0D;
    }

    public VectorProperty(TileEntity tileEntity) {
        this(
                tileEntity.getPos().getX(),
                tileEntity.getPos().getY(),
                tileEntity.getPos().getZ()
        );
    }

    public VectorProperty(Vector3d vector) {
        new VectorProperty(vector.x, vector.y, vector.z);
    }

    public VectorProperty(Vector3i vector) {
        new VectorProperty(vector.getX(), vector.getY(), vector.getZ());
    }

    public VectorProperty(Vector3f vector) {
        new VectorProperty(vector.getX(), vector.getY(), vector.getZ());
    }

    public VectorProperty copy() {
        return new VectorProperty(this.vecX, this.vecY, this.vecZ);
    }

    public static VectorProperty getMax(AxisAlignedBB aligned) {
        return new VectorProperty(aligned.maxX, aligned.maxY, aligned.maxZ);
    }

    public static VectorProperty getMin(AxisAlignedBB aligned) {
        return new VectorProperty(aligned.minX, aligned.minY, aligned.minZ);
    }

    public double getVecX() {
        return this.vecX;
    }

    public double getVecY() {
        return this.vecY;
    }

    public double getVecZ() {
        return this.vecZ;
    }

    public Vector3d ToVector3d() {
        return new Vector3d(this.vecX, this.vecY, this.vecZ);
    }

    public Vector3i ToVector3i() {
        return new Vector3i(this.vecX, this.vecY, this.vecZ);
    }

    public Vector3f ToVector3f() {
        return new Vector3f(((float) this.vecX), ((float) this.vecY), ((float) this.vecZ));
    }

    // Add Calc
    public VectorProperty add(double x, double y, double z) {
        this.vecX += x;
        this.vecY += y;
        this.vecZ += z;
        return this;
    }

    public VectorProperty add(float x, float y, float z) {
        this.vecX += x;
        this.vecY += y;
        this.vecZ += z;
        return this;
    }

    public VectorProperty add(VectorProperty vector) {
        this.vecX += vector.getVecX();
        this.vecY += vector.getVecY();
        this.vecZ += vector.getVecZ();
        return this;
    }

    public VectorProperty addX(double x) {
        this.vecX += x;
        return this;
    }

    public VectorProperty addX(float x) {
        this.vecX += x;
        return this;
    }

    public VectorProperty addY(double y) {
        this.vecY += y;
        return this;
    }

    public VectorProperty addY(float y) {
        this.vecY += y;
        return this;
    }

    public VectorProperty addZ(double z) {
        this.vecZ += z;
        return this;
    }

    public VectorProperty addZ(float z) {
        this.vecZ += z;
        return this;
    }

    // Subtract
    public VectorProperty subtract(double x, double y, double z) {
        this.vecX -= x;
        this.vecY -= y;
        this.vecZ -= z;
        return this;
    }

    public VectorProperty subtract(float x, float y, float z) {
        this.vecX -= x;
        this.vecY -= y;
        this.vecZ -= z;
        return this;
    }

    public VectorProperty subtract(Vector3i vector) {
        this.vecX -= vector.getX();
        this.vecY -= vector.getY();
        this.vecZ -= vector.getZ();
        return this;
    }

    public VectorProperty subtract(Vector3d vector) {
        this.vecX -= vector.x;
        this.vecY -= vector.y;
        this.vecZ -= vector.z;
        return this;
    }

    public VectorProperty subtract(VectorProperty vector) {
        this.vecX -= vector.getVecX();
        this.vecY -= vector.getVecY();
        this.vecZ -= vector.getVecZ();
        return this;
    }

    public VectorProperty subtractX(double x) {
        this.vecX -= x;
        return this;
    }

    public VectorProperty subtractX(float x) {
        this.vecX -= x;
        return this;
    }

    public VectorProperty subtractY(double y) {
        this.vecY -= y;
        return this;
    }

    public VectorProperty subtractY(float y) {
        this.vecY -= y;
        return this;
    }

    public VectorProperty subtractZ(double z) {
        this.vecZ -= z;
        return this;
    }

    public VectorProperty subtractZ(float z) {
        this.vecZ -= z;
        return this;
    }

    // Multiply
    public VectorProperty multiply(double multiply) {
        this.vecX *= multiply;
        this.vecY *= multiply;
        this.vecZ *= multiply;
        return this;
    }

    public VectorProperty multiply(float multiply) {
        this.vecX *= multiply;
        this.vecY *= multiply;
        this.vecZ *= multiply;
        return this;
    }

    public VectorProperty multiply(int multiply) {
        this.vecX *= multiply;
        this.vecY *= multiply;
        this.vecZ *= multiply;
        return this;
    }

    public VectorProperty multiply(Vector3i vector) {
        this.vecX *= vector.getX();
        this.vecY *= vector.getY();
        this.vecZ *= vector.getZ();
        return this;
    }

    public VectorProperty multiply(Vector3d vector) {
        this.vecX *= vector.x;
        this.vecY *= vector.y;
        this.vecZ *= vector.z;
        return this;
    }

    public VectorProperty multiply(VectorProperty vector) {
        this.vecX *= vector.getVecX();
        this.vecY *= vector.getVecY();
        this.vecZ *= vector.getVecZ();
        return this;
    }

    public VectorProperty negate(VectorProperty vector) {
        return this.multiply(-1);
    }

    // Divide
    public VectorProperty divide(VectorProperty vector) {
        this.vecX /= vector.getVecX();
        this.vecY /= vector.getVecY();
        this.vecZ /= vector.getVecZ();
        return this;
    }

    public VectorProperty divide(double divide) {
        this.vecX /= divide;
        this.vecY /= divide;
        this.vecZ /= divide;
        return this;
    }

    // Entity
    public static VectorProperty atCorner(Entity entity) {
        return new VectorProperty(entity.getPosX(), entity.getPosY(), entity.getPosZ());
    }

    public static VectorProperty atCenter(Entity entity) {
        return atCorner(entity).add(
                entity.getWidth()  / 2,
                entity.getHeight() / 2,
                entity.getWidth()  / 2
        );
    }

}
