package raven.ravenstorages.library.vector;

import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
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

    public static final VectorProperty NEUTRAL = new VectorProperty(0, 0, 0);

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

    public Vector3d toVector3d() {
        return new Vector3d(this.vecX, this.vecY, this.vecZ);
    }

    public Vector3i toVector3i() {
        return new Vector3i(this.vecX, this.vecY, this.vecZ);
    }

    public Vector3f toVector3f() {
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

    public VectorProperty normalize() {
        double mag = magnitude();
        if (mag != 0) { multiply(1 / mag); }
        return this;
    }

    public double magnitude() {
        return Math.sqrt(vecX * vecX + vecY * vecY + vecZ * vecZ);
    }

    public VectorProperty crossProduct(VectorProperty vector) {
        double da = vecY * vector.vecZ - vecZ * vector.vecY;
        double db = vecZ * vector.vecX - vecX * vector.vecZ;
        double dc = vecX * vector.vecY - vecY * vector.vecX;
        this.vecX = da;
        this.vecY = db;
        this.vecZ = dc;
        return this;
    }

    public VectorProperty perpendicular() {
        if (this.vecZ == 0) { return crossProductZ(); }
        return crossProductX();
    }

    public VectorProperty crossProductX() {
        double da = this.vecZ;
        double db = -this.vecY;
        this.vecX = 0;
        this.vecY = da;
        this.vecZ = db;
        return this;
    }

    public VectorProperty crossProductY() {
        double da = -this.vecZ;
        double db = this.vecX;
        this.vecX = da;
        this.vecY = 0;
        this.vecZ = db;
        return this;
    }

    public VectorProperty crossProductZ() {
        double da = this.vecY;
        double db = -this.vecX;
        this.vecX = da;
        this.vecY = db;
        this.vecZ = 0;
        return this;
    }

    public VectorProperty rotate(double angle, VectorProperty axis) {
        QuaternionProperty.axisAngle(axis.copy().normalize(), angle).rotate(this);
        return this;
    }

    public VectorProperty rotate(QuaternionProperty quat) {
        quat.rotate(this);
        return this;
    }

    public double distance(VectorProperty target) {
        return getDistance(this.vecX, this.vecY, this.vecZ, target.vecX, target.vecY, target.vecZ);
    }

    public static double getDistance(double xA, double yA, double zA, double xB, double yB, double zB) {
        double dx = xA - xB;
        double dy = yA - yB;
        double dz = zA - zB;
        return MathHelper.sqrt(dx * dx + dy * dy + dz * dz);
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

    // Tile Entity
    public static VectorProperty atCenter(TileEntity tileEntity) {
        return new VectorProperty(tileEntity).divide(2);
    }

}
