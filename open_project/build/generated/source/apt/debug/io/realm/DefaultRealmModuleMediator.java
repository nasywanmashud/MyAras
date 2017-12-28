package io.realm;


import android.util.JsonReader;
import io.realm.internal.ColumnInfo;
import io.realm.internal.ImplicitTransaction;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.RealmProxyMediator;
import io.realm.internal.Table;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import com.intranet.app.ui.Model.JSON.UserInfoJSON;
import com.intranet.app.ui.Realm.Cached.CachedResult;

@io.realm.annotations.RealmModule
class DefaultRealmModuleMediator extends RealmProxyMediator {

    private static final Set<Class<? extends RealmObject>> MODEL_CLASSES;
    static {
        Set<Class<? extends RealmObject>> modelClasses = new HashSet<Class<? extends RealmObject>>();
        modelClasses.add(UserInfoJSON.class);
        modelClasses.add(CachedResult.class);
        MODEL_CLASSES = Collections.unmodifiableSet(modelClasses);
    }

    @Override
    public Table createTable(Class<? extends RealmObject> clazz, ImplicitTransaction transaction) {
        checkClass(clazz);

        if (clazz.equals(UserInfoJSON.class)) {
            return UserInfoJSONRealmProxy.initTable(transaction);
        } else if (clazz.equals(CachedResult.class)) {
            return CachedResultRealmProxy.initTable(transaction);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public ColumnInfo validateTable(Class<? extends RealmObject> clazz, ImplicitTransaction transaction) {
        checkClass(clazz);

        if (clazz.equals(UserInfoJSON.class)) {
            return UserInfoJSONRealmProxy.validateTable(transaction);
        } else if (clazz.equals(CachedResult.class)) {
            return CachedResultRealmProxy.validateTable(transaction);
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public List<String> getFieldNames(Class<? extends RealmObject> clazz) {
        checkClass(clazz);

        if (clazz.equals(UserInfoJSON.class)) {
            return UserInfoJSONRealmProxy.getFieldNames();
        } else if (clazz.equals(CachedResult.class)) {
            return CachedResultRealmProxy.getFieldNames();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public String getTableName(Class<? extends RealmObject> clazz) {
        checkClass(clazz);

        if (clazz.equals(UserInfoJSON.class)) {
            return UserInfoJSONRealmProxy.getTableName();
        } else if (clazz.equals(CachedResult.class)) {
            return CachedResultRealmProxy.getTableName();
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmObject> E newInstance(Class<E> clazz, ColumnInfo columnInfo) {
        checkClass(clazz);

        if (clazz.equals(UserInfoJSON.class)) {
            return clazz.cast(new UserInfoJSONRealmProxy(columnInfo));
        } else if (clazz.equals(CachedResult.class)) {
            return clazz.cast(new CachedResultRealmProxy(columnInfo));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public Set<Class<? extends RealmObject>> getModelClasses() {
        return MODEL_CLASSES;
    }

    @Override
    public <E extends RealmObject> E copyOrUpdate(Realm realm, E obj, boolean update, Map<RealmObject, RealmObjectProxy> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) ((obj instanceof RealmObjectProxy) ? obj.getClass().getSuperclass() : obj.getClass());

        if (clazz.equals(UserInfoJSON.class)) {
            return clazz.cast(UserInfoJSONRealmProxy.copyOrUpdate(realm, (UserInfoJSON) obj, update, cache));
        } else if (clazz.equals(CachedResult.class)) {
            return clazz.cast(CachedResultRealmProxy.copyOrUpdate(realm, (CachedResult) obj, update, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmObject> E createOrUpdateUsingJsonObject(Class<E> clazz, Realm realm, JSONObject json, boolean update)
        throws JSONException {
        checkClass(clazz);

        if (clazz.equals(UserInfoJSON.class)) {
            return clazz.cast(UserInfoJSONRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else if (clazz.equals(CachedResult.class)) {
            return clazz.cast(CachedResultRealmProxy.createOrUpdateUsingJsonObject(realm, json, update));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmObject> E createUsingJsonStream(Class<E> clazz, Realm realm, JsonReader reader)
        throws IOException {
        checkClass(clazz);

        if (clazz.equals(UserInfoJSON.class)) {
            return clazz.cast(UserInfoJSONRealmProxy.createUsingJsonStream(realm, reader));
        } else if (clazz.equals(CachedResult.class)) {
            return clazz.cast(CachedResultRealmProxy.createUsingJsonStream(realm, reader));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

    @Override
    public <E extends RealmObject> E createDetachedCopy(E realmObject, int maxDepth, Map<RealmObject, RealmObjectProxy.CacheData<RealmObject>> cache) {
        // This cast is correct because obj is either
        // generated by RealmProxy or the original type extending directly from RealmObject
        @SuppressWarnings("unchecked") Class<E> clazz = (Class<E>) realmObject.getClass().getSuperclass();

        if (clazz.equals(UserInfoJSON.class)) {
            return clazz.cast(UserInfoJSONRealmProxy.createDetachedCopy((UserInfoJSON) realmObject, 0, maxDepth, cache));
        } else if (clazz.equals(CachedResult.class)) {
            return clazz.cast(CachedResultRealmProxy.createDetachedCopy((CachedResult) realmObject, 0, maxDepth, cache));
        } else {
            throw getMissingProxyClassException(clazz);
        }
    }

}