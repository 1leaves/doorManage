package com.yyq.doormanage1.mapper;

import com.yyq.doormanage1.entity.Record;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Mapper
@Repository
public interface RecordMapper {
	
	List<Record> queryByUserId(Integer id);
	
	int save(Record record);
	
	int open(@Param("roomCode")String roomCode, @Param("token")String token);
}
