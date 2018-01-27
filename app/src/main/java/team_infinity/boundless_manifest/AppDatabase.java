package team_infinity.boundless_manifest;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by Vallyath on 2018-01-26.
 */

@Database(entities = {UserInfoRoom.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static AppDatabase appDb;
    public static String DATABASE_NAME = "User_Information";
    public abstract UserInfoDao userInfo();


}
