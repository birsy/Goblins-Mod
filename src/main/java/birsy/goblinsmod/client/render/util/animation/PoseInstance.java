package birsy.goblinsmod.client.render.util.animation;

import birsy.goblinsmod.client.render.util.BirsyModelRenderer;

/**
 * Stores a rotation state of a specifc part, ex. swinging a sword or walking.
 * A model renderer dynamically lerps between different pose instances to create the final animation
 */
public class PoseInstance {
    public float rotateAngleX;
    public float rotateAngleY;
    public float rotateAngleZ;

    public float positionX;
    public float positionY;
    public float positionZ;

    public final float priority;

    private float interpolationFactor;

    public PoseInstance(BirsyModelRenderer modelRenderer, float priority) {
        modelRenderer.poses.add(this);
        this.priority = priority;
    }

    public void setRotation(float x, float y, float z) {
        this.rotateAngleX = x;
        this.rotateAngleY = y;
        this.rotateAngleZ = z;
    }

    public void setPosition(float x, float y, float z) {
        this.positionX = x;
        this.positionY = y;
        this.positionZ = z;
    }

    public void setInterpFactor(float factor) {
        interpolationFactor = factor;
    }

    public float getInterpFactor() {
        return this.interpolationFactor;
    }
}
