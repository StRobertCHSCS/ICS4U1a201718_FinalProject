package team_infinity.boundless_manifest;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

/**
 * Created by Vallyath on 2018-01-26.
 */

@Dao
public interface UserInfoDao {

    @Query("SELECT * FROM userInfo")
    List<UserInfoRoom>  getAll();

    @Insert
    void insertAll(UserInfoRoom data);
}
