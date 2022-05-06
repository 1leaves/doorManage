package com.yyq.doormanage1.mapper;

import com.yyq.doormanage1.entity.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Mapper
@Repository
public interface RoomMapper {

	int save(Room room);
	
	List<Room> queryByParams(@Param("params")Map<String,Object> params);
	
	int delete(Integer id);
	
	int update(Room room);
	
	Room queryById(@Param("id")Integer id);
	
	List<Room> queryAll();

    List<Room> queryByUserId(Integer id);

    int relieve(Integer userId, Integer roomId);

	List<Room> powerAudit(@Param("params")Map<String, Object> params);

	int auth(Integer status, Integer id, Integer userId);

    List<Room> roomOfUser(@Param("params")Map<String, Object> params);

    List<Room> applyList(@Param("params")Map<String, Object> params);
}
