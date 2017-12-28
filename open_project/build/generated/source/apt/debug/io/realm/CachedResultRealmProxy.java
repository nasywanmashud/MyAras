package io.realm;


import android.util.JsonReader;
import android.util.JsonToken;
import com.intranet.app.ui.Realm.Cached.CachedResult;
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

public class CachedResultRealmProxy extends CachedResult
    implements RealmObjectProxy {

    static final class CachedResultColumnInfo extends ColumnInfo {

        public final long cachedResultIndex;
        public final long cachedAPIIndex;

        CachedResultColumnInfo(String path, Table table) {
            final Map<String, Long> indicesMap = new HashMap<String, Long>(2);
            this.cachedResultIndex = getValidColumnIndex(path, table, "CachedResult", "cachedResult");
            indicesMap.put("cachedResult", this.cachedResultIndex);

            this.cachedAPIIndex = getValidColumnIndex(path, table, "CachedResult", "cachedAPI");
            indicesMap.put("cachedAPI", this.cachedAPIIndex);

            setIndicesMap(indicesMap);
        }
    }

    private final CachedResultColumnInfo columnInfo;
    private static final List<String> FIELD_NAMES;
    static {
        List<String> fieldNames = new ArrayList<String>();
        fieldNames.add("cachedResult");
        fieldNames.add("cachedAPI");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    CachedResultRealmProxy(ColumnInfo columnInfo) {
        this.columnInfo = (CachedResultColumnInfo) columnInfo;
    }

    @Override
    @SuppressWarnings("cast")
    public String getCachedResult() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(columnInfo.cachedResultIndex);
    }

    @Override
    public void setCachedResult(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(columnInfo.cachedResultIndex);
            return;
        }
        row.setString(columnInfo.cachedResultIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String getCachedAPI() {
        realm.checkIfValid();
        return (java.lang.String) row.getString(columnInfo.cachedAPIIndex);
    }

    @Override
    public void setCachedAPI(String value) {
        realm.checkIfValid();
        if (value == null) {
            row.setNull(columnInfo.cachedAPIIndex);
            return;
        }
        row.setString(columnInfo.cachedAPIIndex, value);
    }

    public static Table initTable(ImplicitTransaction transaction) {
        if (!transaction.hasTable("class_CachedResult")) {
            Table table = transaction.getTable("class_CachedResult");
            table.addColumn(RealmFieldType.STRING, "cachedResult", Table.NULLABLE);
            table.addColumn(RealmFieldType.STRING, "cachedAPI", Table.NULLABLE);
            table.setPrimaryKey("");
            return table;
        }
        return transaction.getTable("class_CachedResult");
    }

    public static CachedResultColumnInfo validateTable(ImplicitTransaction transaction) {
        if (transaction.hasTable("class_CachedResult")) {
            Table table = transaction.getTable("class_CachedResult");
            if (table.getColumnCount() != 2) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field count does not match - expected 2 but was " + table.getColumnCount());
            }
            Map<String, RealmFieldType> columnTypes = new HashMap<String, RealmFieldType>();
            for (long i = 0; i < 2; i++) {
                columnTypes.put(table.getColumnName(i), table.getColumnType(i));
            }

            final CachedResultColumnInfo columnInfo = new CachedResultColumnInfo(transaction.getPath(), table);

            if (!columnTypes.containsKey("cachedResult")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'cachedResult' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cachedResult") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'cachedResult' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cachedResultIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'cachedResult' is required. Either set @Required to field 'cachedResult' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            if (!columnTypes.containsKey("cachedAPI")) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Missing field 'cachedAPI' in existing Realm file. Either remove field or migrate using io.realm.internal.Table.addColumn().");
            }
            if (columnTypes.get("cachedAPI") != RealmFieldType.STRING) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Invalid type 'String' for field 'cachedAPI' in existing Realm file.");
            }
            if (!table.isColumnNullable(columnInfo.cachedAPIIndex)) {
                throw new RealmMigrationNeededException(transaction.getPath(), "Field 'cachedAPI' is required. Either set @Required to field 'cachedAPI' or migrate using io.realm.internal.Table.convertColumnToNullable().");
            }
            return columnInfo;
        } else {
            throw new RealmMigrationNeededException(transaction.getPath(), "The CachedResult class is missing from the schema for this Realm.");
        }
    }

    public static String getTableName() {
        return "class_CachedResult";
    }

    public static List<String> getFieldNames() {
        return FIELD_NAMES;
    }

    @SuppressWarnings("cast")
    public static CachedResult createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        CachedResult obj = realm.createObject(CachedResult.class);
        if (json.has("cachedResult")) {
            if (json.isNull("cachedResult")) {
                obj.setCachedResult(null);
            } else {
                obj.setCachedResult((String) json.getString("cachedResult"));
            }
        }
        if (json.has("cachedAPI")) {
            if (json.isNull("cachedAPI")) {
                obj.setCachedAPI(null);
            } else {
                obj.setCachedAPI((String) json.getString("cachedAPI"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    public static CachedResult createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        CachedResult obj = realm.createObject(CachedResult.class);
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (name.equals("cachedResult")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setCachedResult(null);
                } else {
                    obj.setCachedResult((String) reader.nextString());
                }
            } else if (name.equals("cachedAPI")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    obj.setCachedAPI(null);
                } else {
                    obj.setCachedAPI((String) reader.nextString());
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return obj;
    }

    public static CachedResult copyOrUpdate(Realm realm, CachedResult object, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        if (object.realm != null && object.realm.getPath().equals(realm.getPath())) {
            return object;
        }
        return copy(realm, object, update, cache);
    }

    public static CachedResult copy(Realm realm, CachedResult newObject, boolean update, Map<RealmObject,RealmObjectProxy> cache) {
        CachedResult realmObject = realm.createObject(CachedResult.class);
        cache.put(newObject, (RealmObjectProxy) realmObject);
        realmObject.setCachedResult(newObject.getCachedResult());
        realmObject.setCachedAPI(newObject.getCachedAPI());
        return realmObject;
    }

    public static CachedResult createDetachedCopy(CachedResult realmObject, int currentDepth, int maxDepth, Map<RealmObject, CacheData<RealmObject>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<CachedResult> cachedObject = (CacheData) cache.get(realmObject);
        CachedResult standaloneObject;
        if (cachedObject != null) {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return cachedObject.object;
            } else {
                standaloneObject = cachedObject.object;
                cachedObject.minDepth = currentDepth;
            }
        } else {
            standaloneObject = new CachedResult();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmObject>(currentDepth, standaloneObject));
        }
        standaloneObject.setCachedResult(realmObject.getCachedResult());
        standaloneObject.setCachedAPI(realmObject.getCachedAPI());
        return standaloneObject;
    }

    @Override
    public String toString() {
        if (!isValid()) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("CachedResult = [");
        stringBuilder.append("{cachedResult:");
        stringBuilder.append(getCachedResult() != null ? getCachedResult() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{cachedAPI:");
        stringBuilder.append(getCachedAPI() != null ? getCachedAPI() : "null");
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
        CachedResultRealmProxy aCachedResult = (CachedResultRealmProxy)o;

        String path = realm.getPath();
        String otherPath = aCachedResult.realm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;;

        String tableName = row.getTable().getName();
        String otherTableName = aCachedResult.row.getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (row.getIndex() != aCachedResult.row.getIndex()) return false;

        return true;
    }

}
