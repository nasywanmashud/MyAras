package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import com.intranet.app.ui.Model.JSON.UserInfoJSON;
import io.realm.RealmFieldType;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.LinkView;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Table;
import io.realm.internal.TableOrView;
import io.realm.internal.android.JsonUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserInfoJSONRealmProxy extends UserInfoJSON
    implements RealmObjectProxy {

    static final class UserInfoJSONColumnInfo extends ColumnInfo {

        public final long userInfoIndex;

        UserInfoJSONColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(1);
            this.userInfoIndex = getValidColumnIndex(path, table, "UserInfoJSON", "userInfo");
            indicesMap.put("userInfo", this.userInfoIndex);

            setIndicesMap(indicesMap);
        }
    }

    private final UserInfoJSONColumnInfo columnInfo;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("userInfo");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    UserInfoJSONRealmProxy(ColumnInfo columnInfo) {
        this.columnInfo = (UserInfoJSONColumnInfo) columnInfo;
    }

    @Override
    @SuppressWarnings("cast")
    public String getUserInfo() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(columnInfo.userInfoIndex);
    }

    @Override
    public void setUserInfo(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(columnInfo.userInfoIndex);
            return;
        }
        row.setString(columnInfo.userInfoIndex, value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_UserInfoJSON")) {
            Table table = transaction.getTable("class_UserInfoJSON");
            table.addColumn(RealmFieldType.STRING, "userInfo", Table.NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_UserInfoJSON");
    }

    public static UserInfoJSONColumnInfo validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_UserInfoJSON")) {
            Table table = transaction.getTable("class_UserInfoJSON");
            if (table.getColumnCount() != 1) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 1 but was " + table.getColumnCount());
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 1; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final UserInfoJSONColumnInfo columnInfo = new UserInfoJSONColumnInfo(transaction.getPath(), table);

            if (!columnTypes.containsKey("userInfo")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'userInfo' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("userInfo") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'userInfo' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.userInfoIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'userInfo' is required. Either set @Required to field 'userInfo' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The UserInfoJSON class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_UserInfoJSON";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static UserInfoJSON createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        UserInfoJSON obj = realm.createObject(UserInfoJSON.class);
        if (json.has("userInfo")) {
            if (json.isNull("userInfo")) {
                obj.setUserInfo(null);
            } else {
                obj.setUserInfo((String) json.getString("userInfo"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    public static UserInfoJSON createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        UserInfoJSON obj = realm.createObject(UserInfoJSON.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("userInfo")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setUserInfo(null);
                } else {
                    obj.setUserInfo((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static UserInfoJSON copyOrUpdate(Realm realm, UserInfoJSON object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static UserInfoJSON copy(Realm realm, UserInfoJSON newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        UserInfoJSON realmObject = realm.createObject(UserInfoJSON.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setUserInfo(newObject.getUserInfo());
        return realmObject;
    }

    public static UserInfoJSON createDetachedCopy(UserInfoJSON realmObject, int currentDepth, int maxDepth, Map<RealmObject, CacheData<RealmObject>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<UserInfoJSON> cachedObject = (CacheData) cache.get(realmObject);
        UserInfoJSON standaloneObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return cachedObject.object;
            } else {
                standaloneObject = cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            standaloneObject = new UserInfoJSON();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmObject>(currentDepth, standaloneObject));
        }
        standaloneObject.setUserInfo(realmObject.getUserInfo());
        return standaloneObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("UserInfoJSON = [");
        stringBuilder.append("{userInfo:");
        stringBuilder.append(getUserInfo() != null ? getUserInfo() : "null");
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public int hashCode() {
        String realmName = realm.getPath();
        String tableName = row.getTable().getName();
        long rowIndex = row.getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInfoJSONRealmProxy aUserInfoJSON = (UserInfoJSONRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aUserInfoJSON.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aUserInfoJSON.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aUserInfoJSON.row.getIndex()) return false;

        return true;
    }

}
