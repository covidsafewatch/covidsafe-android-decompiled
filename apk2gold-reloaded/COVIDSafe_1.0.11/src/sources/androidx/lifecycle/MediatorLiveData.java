package androidx.lifecycle;

import androidx.arch.core.internal.SafeIterableMap;
import java.util.Iterator;
import java.util.Map.Entry;

public class MediatorLiveData<T> extends MutableLiveData<T> {
    private SafeIterableMap<LiveData<?>, Source<?>> mSources = new SafeIterableMap<>();

    private static class Source<V> implements Observer<V> {
        final LiveData<V> mLiveData;
        final Observer<? super V> mObserver;
        int mVersion = -1;

        Source(LiveData<V> liveData, Observer<? super V> observer) {
            this.mLiveData = liveData;
            this.mObserver = observer;
        }

        /* access modifiers changed from: 0000 */
        public void plug() {
            this.mLiveData.observeForever(this);
        }

        /* access modifiers changed from: 0000 */
        public void unplug() {
            this.mLiveData.removeObserver(this);
        }

        public void onChanged(V v) {
            if (this.mVersion != this.mLiveData.getVersion()) {
                this.mVersion = this.mLiveData.getVersion();
                this.mObserver.onChanged(v);
            }
        }
    }

    public <S> void addSource(LiveData<S> liveData, Observer<? super S> observer) {
        Source source = new Source(liveData, observer);
        Source source2 = (Source) this.mSources.putIfAbsent(liveData, source);
        if (source2 == null || source2.mObserver == observer) {
            if (source2 == null && hasActiveObservers()) {
                source.plug();
            }
            return;
        }
        throw new IllegalArgumentException("This source was already added with the different observer");
    }

    public <S> void removeSource(LiveData<S> liveData) {
        Source source = (Source) this.mSources.remove(liveData);
        if (source != null) {
            source.unplug();
        }
    }

    /* access modifiers changed from: protected */
    public void onActive() {
        Iterator it = this.mSources.iterator();
        while (it.hasNext()) {
            ((Source) ((Entry) it.next()).getValue()).plug();
        }
    }

    /* access modifiers changed from: protected */
    public void onInactive() {
        Iterator it = this.mSources.iterator();
        while (it.hasNext()) {
            ((Source) ((Entry) it.next()).getValue()).unplug();
        }
    }
}
