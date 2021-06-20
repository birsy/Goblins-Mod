package birsy.goblinsmod.client.render.util;

import birsy.goblinsmod.client.render.util.animation.PoseInstance;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.client.renderer.model.Model;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;

import java.util.Comparator;
import java.util.List;

public class BirsyModelRenderer extends ModelRenderer
{
	public float defaultRotationPointX;
	public float defaultRotationPointY;
	public float defaultRotationPointZ;
	
	public float defaultRotateAngleX;
	public float defaultRotateAngleY;
	public float defaultRotateAngleZ;

	public List<PoseInstance> poses;

	private final ObjectList<ModelRenderer> childModels = new ObjectArrayList<>();

	public Vector3d defaultModelRendererPosition = new Vector3d(this.defaultRotationPointX, this.defaultRotationPointY, this.defaultRotationPointZ);
	public Vector3d modelRendererPosition = new Vector3d(this.rotationPointX, this.rotationPointY, this.rotationPointZ);

	public BirsyModelRenderer(Model model, int texOffX, int texOffY) {super(model, texOffX, texOffY);}
	
	@Override
	public void setRotationPoint(float rotationPointXIn, float rotationPointYIn, float rotationPointZIn) {
		this.rotationPointX = rotationPointXIn;
		this.rotationPointY = rotationPointYIn;
		this.rotationPointZ = rotationPointZIn;
		
		this.defaultRotationPointX = this.rotationPointX;
        this.defaultRotationPointY = this.rotationPointY;
        this.defaultRotationPointZ = this.rotationPointZ;
	}
	
	public void copyModelAngles(BirsyModelRenderer modelRendererIn) {
		this.rotateAngleX = modelRendererIn.rotateAngleX;
		this.rotateAngleY = modelRendererIn.rotateAngleY;
		this.rotateAngleZ = modelRendererIn.rotateAngleZ;
		
		this.rotationPointX = modelRendererIn.rotationPointX;
		this.rotationPointY = modelRendererIn.rotationPointY;
		this.rotationPointZ = modelRendererIn.rotationPointZ;
	  	
	  	this.defaultRotateAngleX = modelRendererIn.rotateAngleX;
	  	this.defaultRotateAngleY = modelRendererIn.rotateAngleY;
	  	this.defaultRotateAngleZ = modelRendererIn.rotateAngleZ;
	  	
	  	this.defaultRotationPointX = modelRendererIn.rotationPointX;
	  	this.defaultRotationPointY = modelRendererIn.rotationPointY;
	  	this.defaultRotationPointZ = modelRendererIn.rotationPointZ;
	}

	public void setRotation (Vector3d rotation) {
		this.rotationPointX = (float) rotation.getX();
		this.rotationPointY = (float) rotation.getY();
		this.rotationPointZ = (float) rotation.getZ();
	}

	public void setRotation (Vector3f rotation) {
		this.rotationPointX = rotation.getX();
		this.rotationPointY = rotation.getY();
		this.rotationPointZ = rotation.getZ();
	}

	public void setRotation (float x, float y, float z) {
		this.rotationPointX = x;
		this.rotationPointY = y;
		this.rotationPointZ = z;
	}

	public void cancelRotation(BirsyModelRenderer... modelRenderers) {
		for (BirsyModelRenderer modelRenderer : modelRenderers) {
			this.rotateAngleX -= modelRenderer.rotateAngleX;
			this.rotateAngleY -= modelRenderer.rotateAngleY;
			this.rotateAngleZ -= modelRenderer.rotateAngleZ;
		}
	}

	/**
	 * Sorting these is expensive, so only sort them when the model is defined..
	 * DO NOT CALL ON RENDER!
	 */
	public void sortPoses() {
		poses.sort((o1, o2) -> Float.compare(o1.priority, o2.priority));
	}

	public void getPoseRotation() {
		for (PoseInstance pose : poses) {
			this.rotateAngleX = MathHelper.lerp(pose.getInterpFactor(), this.rotateAngleX, pose.rotateAngleX);
		}
	}
}
