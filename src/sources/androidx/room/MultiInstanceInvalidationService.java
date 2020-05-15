package androidx.room;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteCallbackList;
import android.os.RemoteException;
import android.util.Log;
import androidx.room.IMultiInstanceInvalidationService;
import java.util.HashMap;

public class MultiInstanceInvalidationService extends Service {
    private final IMultiInstanceInvalidationService.Stub mBinder = new IMultiInstanceInvalidationService.Stub() {
        public int registerCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, String str) {
            if (str == null) {
                return 0;
            }
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                MultiInstanceInvalidationService multiInstanceInvalidationService = MultiInstanceInvalidationService.this;
                int i = multiInstanceInvalidationService.mMaxClientId + 1;
                multiInstanceInvalidationService.mMaxClientId = i;
                if (MultiInstanceInvalidationService.this.mCallbackList.register(iMultiInstanceInvalidationCallback, Integer.valueOf(i))) {
                    MultiInstanceInvalidationService.this.mClientNames.put(Integer.valueOf(i), str);
                    return i;
                }
                MultiInstanceInvalidationService multiInstanceInvalidationService2 = MultiInstanceInvalidationService.this;
                multiInstanceInvalidationService2.mMaxClientId--;
                return 0;
            }
        }

        public void unregisterCallback(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, int i) {
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                MultiInstanceInvalidationService.this.mCallbackList.unregister(iMultiInstanceInvalidationCallback);
                MultiInstanceInvalidationService.this.mClientNames.remove(Integer.valueOf(i));
            }
        }

        public void broadcastInvalidation(int i, String[] strArr) {
            synchronized (MultiInstanceInvalidationService.this.mCallbackList) {
                String str = MultiInstanceInvalidationService.this.mClientNames.get(Integer.valueOf(i));
                if (str == null) {
                    Log.w("ROOM", "Remote invalidation client ID not registered");
                    return;
                }
                int beginBroadcast = MultiInstanceInvalidationService.this.mCallbackList.beginBroadcast();
                for (int i2 = 0; i2 < beginBroadcast; i2++) {
                    try {
                        int intValue = ((Integer) MultiInstanceInvalidationService.this.mCallbackList.getBroadcastCookie(i2)).intValue();
                        String str2 = MultiInstanceInvalidationService.this.mClientNames.get(Integer.valueOf(intValue));
                        if (i != intValue && str.equals(str2)) {
                            MultiInstanceInvalidationService.this.mCallbackList.getBroadcastItem(i2).onInvalidation(strArr);
                        }
                    } catch (RemoteException e) {
                        Log.w("ROOM", "Error invoking a remote callback", e);
                    } catch (Throwable th) {
                        MultiInstanceInvalidationService.this.mCallbackList.finishBroadcast();
                        throw th;
                    }
                }
                MultiInstanceInvalidationService.this.mCallbackList.finishBroadcast();
            }
        }
    };
    final RemoteCallbackList<IMultiInstanceInvalidationCallback> mCallbackList = new RemoteCallbackList<IMultiInstanceInvalidationCallback>() {
        public void onCallbackDied(IMultiInstanceInvalidationCallback iMultiInstanceInvalidationCallback, Object obj) {
            MultiInstanceInvalidationService.this.mClientNames.remove(Integer.valueOf(((Integer) obj).intValue()));
        }
    };
    final HashMap<Integer, String> mClientNames = new HashMap<>();
    int mMaxClientId = 0;

    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }
}
