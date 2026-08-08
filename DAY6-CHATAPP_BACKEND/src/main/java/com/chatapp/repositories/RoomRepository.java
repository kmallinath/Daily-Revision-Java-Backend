package com.chatapp.repositories;


import com.chatapp.entities.Room;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface RoomRepository extends MongoRepository<Room, String> {
    //get room using room id
    Room findByRoomId(String roomId);
}
