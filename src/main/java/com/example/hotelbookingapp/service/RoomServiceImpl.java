import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomRepository roomRepository;

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));
    }

    @Override
    public Room createRoom(Room room) {
        // Add any additional validation or business logic before saving
        return roomRepository.save(room);
    }

    @Override
    public Room updateRoom(Long id, Room room) {
        // Check if the room with the given id exists
        Room existingRoom = getRoomById(id);

        // Update the existing room
        existingRoom.setHotel(room.getHotel());
        existingRoom.setRoomNumber(room.getRoomNumber());

        // Save the updated room
        return roomRepository.save(existingRoom);
    }

    @Override
    public void deleteRoom(Long id) {
        roomRepository.deleteById(id);
    }
}
