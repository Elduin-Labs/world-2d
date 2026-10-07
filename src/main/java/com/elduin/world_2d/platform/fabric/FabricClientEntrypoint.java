package com.elduin.world_2d.platform.fabric;

//? fabric {

import com.elduin.world_2d.ModTemplate;
import com.elduin.world_2d.client.SideView;
import dev.kikugie.fletching_table.annotation.fabric.Entrypoint;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

@Entrypoint("client")
public class FabricClientEntrypoint implements ClientModInitializer {

	@Override
	public void onInitializeClient() {
		ModTemplate.onInitializeClient();
		ClientTickEvents.END_CLIENT_TICK.register(SideView::tick);
	}

}
//?}
