package org.apollo.net.release.r317;

import org.apollo.game.event.impl.EquipEvent;
import org.apollo.net.codec.game.DataTransformation;
import org.apollo.net.codec.game.DataType;
import org.apollo.net.codec.game.GamePacket;
import org.apollo.net.codec.game.GamePacketReader;
import org.apollo.net.release.EventDecoder;

/**
 * An {@link EventDecoder} for the {@link EquipEvent}.
 * @author Graham
 */
public final class EquipEventDecoder extends EventDecoder<EquipEvent> {

	@Override
	public EquipEvent decode(GamePacket packet) {
		GamePacketReader reader = new GamePacketReader(packet);
		int id = (int) reader.getUnsigned(DataType.SHORT);
		int slot = (int) reader.getUnsigned(DataType.SHORT, DataTransformation.ADD);
		int interfaceId = (int) reader.getUnsigned(DataType.SHORT, DataTransformation.ADD);
		return new EquipEvent(interfaceId, id, slot);
	}

}
