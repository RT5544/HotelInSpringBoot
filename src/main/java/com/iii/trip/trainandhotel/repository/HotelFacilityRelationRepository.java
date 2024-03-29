package com.iii.trip.trainandhotel.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface HotelFacilityRelationRepository extends JpaRepository<HotelFacilityRelation, String> {


	@Query(value= "select hotel_facility_id from hotel_facility_relation where hotel_id = ?1",nativeQuery= true)
	List<String> findFacilityIdsByHotelId(String hotelId);

	@Transactional
	@Modifying
	@Query(value= "delete from hotel_facility_relation where hotel_id =?1" ,nativeQuery = true)
	void deleteByHotelId(String hotelId);

}
