package com.tedu.dao;

import java.util.List;

import com.tedu.entity.Family;
import com.tedu.entity.Result;
import com.tedu.entity.U_family;

public interface FamilyDao {
	
	Family findById(int familyId) ;

	Result<List<Family>> checkFamily(int userId);

	Result<List<Family>> createFamily(Family  family);

	Result<List<Family>> loadFamilyMembers(int familyId);

	void createApply(int userId, String username, int familyId,String familyname, int fcreaterId);

	Result<List<U_family>> loadApply(int userId);

	Result<List<U_family>> updateApply(int u_familyId, int userId, int familyId, int fcreaterId, int isRefuse);

	Result<List<Family>> searchFamily(int familyId);

}
