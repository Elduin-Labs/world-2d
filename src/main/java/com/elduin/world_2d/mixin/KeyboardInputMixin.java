package com.elduin.world_2d.mixin;

import com.elduin.world_2d.client.SideView;
import dev.kikugie.fletching_table.annotation.MixinEnvironment;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.ClientInput;
import net.minecraft.client.player.KeyboardInput;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.phys.Vec2;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * In 2D there are only two ways to walk: left and right.
 * A walks left, D walks right, and you turn to face the way you go.
 * W and Space both jump. Walking toward or away from the camera is switched off.
 */
@Mixin(KeyboardInput.class)
@MixinEnvironment(type = MixinEnvironment.Env.CLIENT)
public abstract class KeyboardInputMixin extends ClientInput {

	@Inject(method = "tick", at = @At("RETURN"))
	private void world_2d$sideways(CallbackInfo ci) {
		if (!SideView.isActive()) {
			return;
		}

		Input keys = this.keyPresses;
		boolean goLeft = keys.left() && !keys.right();
		boolean goRight = keys.right() && !keys.left();

		if (goLeft) {
			SideView.faceLeft();
		} else if (goRight) {
			SideView.faceRight();
		}

		boolean walking = goLeft || goRight;
		this.keyPresses = new Input(walking, false, false, false, keys.jump() || keys.forward(), keys.shift(), keys.sprint());
		this.moveVector = new Vec2(0.0F, walking ? 1.0F : 0.0F);

		LocalPlayer player = Minecraft.getInstance().player;
		if (player != null) {
			float facing = SideView.facing();
			player.setYRot(facing);
			player.yRotO = facing;
			player.setYHeadRot(facing);
			player.yHeadRotO = facing;
			player.yBodyRot = facing;
			player.yBodyRotO = facing;
		}
	}
}
