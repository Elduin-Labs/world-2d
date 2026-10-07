package com.elduin.world_2d.mixin;

import com.elduin.world_2d.client.SideView;
import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import net.minecraft.client.Camera;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

/**
 * Parks the camera to the side of you, looking north, so east is on the right
 * of the screen. The third-person camera always sits behind where it looks, so
 * pointing it north puts it south of you.
 */
@Mixin(Camera.class)
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public abstract class CameraMixin {

	@ModifyVariable(method = "setRotation", at = @At("HEAD"), argsOnly = true, ordinal = 0)
	private float world_2d$lookNorth(float yRot) {
		return SideView.isActive() ? 180.0F : yRot;
	}

	@ModifyVariable(method = "setRotation", at = @At("HEAD"), argsOnly = true, ordinal = 1)
	private float world_2d$lookLevel(float xRot) {
		return SideView.isActive() ? 0.0F : xRot;
	}

	@Inject(method = "getMaxZoom", at = @At("HEAD"), cancellable = true)
	private void world_2d$fixedDistance(float distance, CallbackInfoReturnable<Float> cir) {
		if (SideView.isActive()) {
			// Never pull the camera in because a block is in the way:
			// the data pack clears the blocks in front of you instead.
			cir.setReturnValue(SideView.CAMERA_DISTANCE);
		}
	}
}
