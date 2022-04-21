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
	
}
