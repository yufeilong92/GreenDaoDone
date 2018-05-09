package com.example.dell.myapplication.db;

import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;

import java.util.List;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "USERINFOM".
*/
public class userinfomDao extends AbstractDao<userinfom, Long> {

    public static final String TABLENAME = "USERINFOM";

    /**
     * Properties of entity userinfom.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property Name = new Property(1, String.class, "name", false, "NAME");
        public final static Property Isreight = new Property(2, boolean.class, "isreight", false, "ISREIGHT");
        public final static Property Date = new Property(3, String.class, "date", false, "DATE");
        public final static Property MDatas = new Property(4, String.class, "mDatas", false, "M_DATAS");
    }

    private final StringConverter mDatasConverter = new StringConverter();

    public userinfomDao(DaoConfig config) {
        super(config);
    }
    
    public userinfomDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"USERINFOM\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: id
                "\"NAME\" TEXT," + // 1: name
                "\"ISREIGHT\" INTEGER NOT NULL ," + // 2: isreight
                "\"DATE\" TEXT," + // 3: date
                "\"M_DATAS\" TEXT);"); // 4: mDatas
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"USERINFOM\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, userinfom entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getIsreight() ? 1L: 0L);
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(4, date);
        }
 
        List mDatas = entity.getMDatas();
        if (mDatas != null) {
            stmt.bindString(5, mDatasConverter.convertToDatabaseValue(mDatas));
        }
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, userinfom entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        String name = entity.getName();
        if (name != null) {
            stmt.bindString(2, name);
        }
        stmt.bindLong(3, entity.getIsreight() ? 1L: 0L);
 
        String date = entity.getDate();
        if (date != null) {
            stmt.bindString(4, date);
        }
 
        List mDatas = entity.getMDatas();
        if (mDatas != null) {
            stmt.bindString(5, mDatasConverter.convertToDatabaseValue(mDatas));
        }
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public userinfom readEntity(Cursor cursor, int offset) {
        userinfom entity = new userinfom( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1), // name
            cursor.getShort(offset + 2) != 0, // isreight
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // date
            cursor.isNull(offset + 4) ? null : mDatasConverter.convertToEntityProperty(cursor.getString(offset + 4)) // mDatas
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, userinfom entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setName(cursor.isNull(offset + 1) ? null : cursor.getString(offset + 1));
        entity.setIsreight(cursor.getShort(offset + 2) != 0);
        entity.setDate(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setMDatas(cursor.isNull(offset + 4) ? null : mDatasConverter.convertToEntityProperty(cursor.getString(offset + 4)));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(userinfom entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(userinfom entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(userinfom entity) {
        return entity.getId() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
}
