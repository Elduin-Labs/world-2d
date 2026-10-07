package com.elduin.world_2d.client;

import com.elduin.world_2d.ModTemplate;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.decoration.painting.PaintingVariant;

/**
 * The 2D World data pack ships a tiny painting that nothing ever uses. The game
 * sends every player the list of paintings, so if that painting is there, the
 * data pack is on and we turn the side view on. No data pack, no side view.
 */
public final class SideView {

	/** How far the camera sits away from the line you walk along. */
	public static final float CAMERA_DISTANCE = 8.0F;

	private static final ResourceKey<PaintingVariant> MARKER = ResourceKey.create(
			Registries.PAINTING_VARIANT, Identifier.fromNamespaceAndPath(ModTemplate.MOD_ID, "side_view"));

	private static boolean active;

	/** Which way you face: 90 is left on the screen, -90 is right. */
	private static float facing = -90.0F;

	private SideView() {
	}

	public static boolean isActive() {
		return active;
	}

	public static float facing() {
		return facing;
	}

	public static void faceLeft() {
		facing = 90.0F;
	}

	public static void faceRight() {
		facing = -90.0F;
	}

	public static void tick(Minecraft mc) {
		active = mc.level != null
				&& mc.player != null
				&& mc.level.registryAccess()
						.lookup(Registries.PAINTING_VARIANT)
						.map(paintings -> paintings.containsKey(MARKER))
						.orElse(false);

		if (active && mc.options.getCameraType() != CameraType.THIRD_PERSON_BACK) {
			// We need to see ourselves, so keep the camera outside the head.
			mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
		}
	}
}
