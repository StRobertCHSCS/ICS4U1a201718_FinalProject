package team_infinity.boundless_manifest;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

/**
 * Created by Vallyath on 2018-01-26.
 */

//@Dao, scrapped and not in use
public interface UserInfoDao
{

    //@Query("SELECT * FROM userInfo")
    List<UserInfoRoom>  getAll();

    //@Insert
    public void insertAll(UserInfoRoom data);

    //@Update
    public void updateAll(UserInfoRoom data);

    //@Delete
    public void deleteAll(UserInfoRoom data);
}
