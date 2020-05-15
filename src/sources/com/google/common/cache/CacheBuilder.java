package com.google.common.cache;

import com.google.common.base.Ascii;
import com.google.common.base.Equivalence;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Supplier;
import com.google.common.base.Suppliers;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.LocalCache;
import com.google.errorprone.annotations.CheckReturnValue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;

public final class CacheBuilder<K, V> {
    static final Supplier<AbstractCache.StatsCounter> CACHE_STATS_COUNTER = new Supplier<AbstractCache.StatsCounter>() {
        public AbstractCache.StatsCounter get() {
            return new AbstractCache.SimpleStatsCounter();
        }
    };
    private static final int DEFAULT_CONCURRENCY_LEVEL = 4;
    private static final int DEFAULT_EXPIRATION_NANOS = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final int DEFAULT_REFRESH_NANOS = 0;
    static final CacheStats EMPTY_STATS = new CacheStats(0, 0, 0, 0, 0, 0);
    static final Supplier<? extends AbstractCache.StatsCounter> NULL_STATS_COUNTER = Suppliers.ofInstance(new AbstractCache.StatsCounter() {
        public void recordEviction() {
        }

        public void recordHits(int i) {
        }

        public void recordLoadException(long j) {
        }

        public void recordLoadSuccess(long j) {
        }

        public void recordMisses(int i) {
        }

        public CacheStats snapshot() {
            return CacheBuilder.EMPTY_STATS;
        }
    });
    static final Ticker NULL_TICKER = new Ticker() {
        public long read() {
            return 0;
        }
    };
    static final int UNSET_INT = -1;
    private static final Logger logger = Logger.getLogger(CacheBuilder.class.getName());
    int concurrencyLevel = -1;
    long expireAfterAccessNanos = -1;
    long expireAfterWriteNanos = -1;
    int initialCapacity = -1;
    @MonotonicNonNullDecl
    Equivalence<Object> keyEquivalence;
    @MonotonicNonNullDecl
    LocalCache.Strength keyStrength;
    long maximumSize = -1;
    long maximumWeight = -1;
    long refreshNanos = -1;
    @MonotonicNonNullDecl
    RemovalListener<? super K, ? super V> removalListener;
    Supplier<? extends AbstractCache.StatsCounter> statsCounterSupplier = NULL_STATS_COUNTER;
    boolean strictParsing = true;
    @MonotonicNonNullDecl
    Ticker ticker;
    @MonotonicNonNullDecl
    Equivalence<Object> valueEquivalence;
    @MonotonicNonNullDecl
    LocalCache.Strength valueStrength;
    @MonotonicNonNullDecl
    Weigher<? super K, ? super V> weigher;

    enum NullListener implements RemovalListener<Object, Object> {
        INSTANCE;

        public void onRemoval(RemovalNotification<Object, Object> removalNotification) {
        }
    }

    enum OneWeigher implements Weigher<Object, Object> {
        INSTANCE;

        public int weigh(Object obj, Object obj2) {
            return 1;
        }
    }

    private CacheBuilder() {
    }

    public static CacheBuilder<Object, Object> newBuilder() {
        return new CacheBuilder<>();
    }

    public static CacheBuilder<Object, Object> from(CacheBuilderSpec cacheBuilderSpec) {
        return cacheBuilderSpec.toCacheBuilder().lenientParsing();
    }

    public static CacheBuilder<Object, Object> from(String str) {
        return from(CacheBuilderSpec.parse(str));
    }

    /* access modifiers changed from: package-private */
    public CacheBuilder<K, V> lenientParsing() {
        this.strictParsing = false;
        return this;
    }

    /* access modifiers changed from: package-private */
    public CacheBuilder<K, V> keyEquivalence(Equivalence<Object> equivalence) {
        Preconditions.checkState(this.keyEquivalence == null, "key equivalence was already set to %s", (Object) this.keyEquivalence);
        this.keyEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    /* access modifiers changed from: package-private */
    public Equivalence<Object> getKeyEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.keyEquivalence, getKeyStrength().defaultEquivalence());
    }

    /* access modifiers changed from: package-private */
    public CacheBuilder<K, V> valueEquivalence(Equivalence<Object> equivalence) {
        Preconditions.checkState(this.valueEquivalence == null, "value equivalence was already set to %s", (Object) this.valueEquivalence);
        this.valueEquivalence = (Equivalence) Preconditions.checkNotNull(equivalence);
        return this;
    }

    /* access modifiers changed from: package-private */
    public Equivalence<Object> getValueEquivalence() {
        return (Equivalence) MoreObjects.firstNonNull(this.valueEquivalence, getValueStrength().defaultEquivalence());
    }

    public CacheBuilder<K, V> initialCapacity(int i) {
        boolean z = true;
        Preconditions.checkState(this.initialCapacity == -1, "initial capacity was already set to %s", this.initialCapacity);
        if (i < 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.initialCapacity = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    public int getInitialCapacity() {
        int i = this.initialCapacity;
        if (i == -1) {
            return 16;
        }
        return i;
    }

    public CacheBuilder<K, V> concurrencyLevel(int i) {
        boolean z = true;
        Preconditions.checkState(this.concurrencyLevel == -1, "concurrency level was already set to %s", this.concurrencyLevel);
        if (i <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z);
        this.concurrencyLevel = i;
        return this;
    }

    /* access modifiers changed from: package-private */
    public int getConcurrencyLevel() {
        int i = this.concurrencyLevel;
        if (i == -1) {
            return 4;
        }
        return i;
    }

    public CacheBuilder<K, V> maximumSize(long j) {
        boolean z = true;
        Preconditions.checkState(this.maximumSize == -1, "maximum size was already set to %s", this.maximumSize);
        Preconditions.checkState(this.maximumWeight == -1, "maximum weight was already set to %s", this.maximumWeight);
        Preconditions.checkState(this.weigher == null, "maximum size can not be combined with weigher");
        if (j < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "maximum size must not be negative");
        this.maximumSize = j;
        return this;
    }

    public CacheBuilder<K, V> maximumWeight(long j) {
        boolean z = true;
        Preconditions.checkState(this.maximumWeight == -1, "maximum weight was already set to %s", this.maximumWeight);
        Preconditions.checkState(this.maximumSize == -1, "maximum size was already set to %s", this.maximumSize);
        this.maximumWeight = j;
        if (j < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "maximum weight must not be negative");
        return this;
    }

    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> weigher(Weigher<? super K1, ? super V1> weigher2) {
        boolean z = true;
        Preconditions.checkState(this.weigher == null);
        if (this.strictParsing) {
            if (this.maximumSize != -1) {
                z = false;
            }
            Preconditions.checkState(z, "weigher can not be combined with maximum size", this.maximumSize);
        }
        this.weigher = (Weigher) Preconditions.checkNotNull(weigher2);
        return this;
    }

    /* access modifiers changed from: package-private */
    public long getMaximumWeight() {
        if (this.expireAfterWriteNanos == 0 || this.expireAfterAccessNanos == 0) {
            return 0;
        }
        return this.weigher == null ? this.maximumSize : this.maximumWeight;
    }

    /* access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> Weigher<K1, V1> getWeigher() {
        return (Weigher) MoreObjects.firstNonNull(this.weigher, OneWeigher.INSTANCE);
    }

    public CacheBuilder<K, V> weakKeys() {
        return setKeyStrength(LocalCache.Strength.WEAK);
    }

    /* access modifiers changed from: package-private */
    public CacheBuilder<K, V> setKeyStrength(LocalCache.Strength strength) {
        Preconditions.checkState(this.keyStrength == null, "Key strength was already set to %s", (Object) this.keyStrength);
        this.keyStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    /* access modifiers changed from: package-private */
    public LocalCache.Strength getKeyStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.keyStrength, LocalCache.Strength.STRONG);
    }

    public CacheBuilder<K, V> weakValues() {
        return setValueStrength(LocalCache.Strength.WEAK);
    }

    public CacheBuilder<K, V> softValues() {
        return setValueStrength(LocalCache.Strength.SOFT);
    }

    /* access modifiers changed from: package-private */
    public CacheBuilder<K, V> setValueStrength(LocalCache.Strength strength) {
        Preconditions.checkState(this.valueStrength == null, "Value strength was already set to %s", (Object) this.valueStrength);
        this.valueStrength = (LocalCache.Strength) Preconditions.checkNotNull(strength);
        return this;
    }

    /* access modifiers changed from: package-private */
    public LocalCache.Strength getValueStrength() {
        return (LocalCache.Strength) MoreObjects.firstNonNull(this.valueStrength, LocalCache.Strength.STRONG);
    }

    public CacheBuilder<K, V> expireAfterWrite(long j, TimeUnit timeUnit) {
        boolean z = true;
        Preconditions.checkState(this.expireAfterWriteNanos == -1, "expireAfterWrite was already set to %s ns", this.expireAfterWriteNanos);
        if (j < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "duration cannot be negative: %s %s", j, (Object) timeUnit);
        this.expireAfterWriteNanos = timeUnit.toNanos(j);
        return this;
    }

    /* access modifiers changed from: package-private */
    public long getExpireAfterWriteNanos() {
        long j = this.expireAfterWriteNanos;
        if (j == -1) {
            return 0;
        }
        return j;
    }

    public CacheBuilder<K, V> expireAfterAccess(long j, TimeUnit timeUnit) {
        boolean z = true;
        Preconditions.checkState(this.expireAfterAccessNanos == -1, "expireAfterAccess was already set to %s ns", this.expireAfterAccessNanos);
        if (j < 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "duration cannot be negative: %s %s", j, (Object) timeUnit);
        this.expireAfterAccessNanos = timeUnit.toNanos(j);
        return this;
    }

    /* access modifiers changed from: package-private */
    public long getExpireAfterAccessNanos() {
        long j = this.expireAfterAccessNanos;
        if (j == -1) {
            return 0;
        }
        return j;
    }

    public CacheBuilder<K, V> refreshAfterWrite(long j, TimeUnit timeUnit) {
        Preconditions.checkNotNull(timeUnit);
        boolean z = true;
        Preconditions.checkState(this.refreshNanos == -1, "refresh was already set to %s ns", this.refreshNanos);
        if (j <= 0) {
            z = false;
        }
        Preconditions.checkArgument(z, "duration must be positive: %s %s", j, (Object) timeUnit);
        this.refreshNanos = timeUnit.toNanos(j);
        return this;
    }

    /* access modifiers changed from: package-private */
    public long getRefreshNanos() {
        long j = this.refreshNanos;
        if (j == -1) {
            return 0;
        }
        return j;
    }

    public CacheBuilder<K, V> ticker(Ticker ticker2) {
        Preconditions.checkState(this.ticker == null);
        this.ticker = (Ticker) Preconditions.checkNotNull(ticker2);
        return this;
    }

    /* access modifiers changed from: package-private */
    public Ticker getTicker(boolean z) {
        Ticker ticker2 = this.ticker;
        if (ticker2 != null) {
            return ticker2;
        }
        return z ? Ticker.systemTicker() : NULL_TICKER;
    }

    @CheckReturnValue
    public <K1 extends K, V1 extends V> CacheBuilder<K1, V1> removalListener(RemovalListener<? super K1, ? super V1> removalListener2) {
        Preconditions.checkState(this.removalListener == null);
        this.removalListener = (RemovalListener) Preconditions.checkNotNull(removalListener2);
        return this;
    }

    /* access modifiers changed from: package-private */
    public <K1 extends K, V1 extends V> RemovalListener<K1, V1> getRemovalListener() {
        return (RemovalListener) MoreObjects.firstNonNull(this.removalListener, NullListener.INSTANCE);
    }

    public CacheBuilder<K, V> recordStats() {
        this.statsCounterSupplier = CACHE_STATS_COUNTER;
        return this;
    }

    /* access modifiers changed from: package-private */
    public boolean isRecordingStats() {
        return this.statsCounterSupplier == CACHE_STATS_COUNTER;
    }

    /* access modifiers changed from: package-private */
    public Supplier<? extends AbstractCache.StatsCounter> getStatsCounterSupplier() {
        return this.statsCounterSupplier;
    }

    public <K1 extends K, V1 extends V> LoadingCache<K1, V1> build(CacheLoader<? super K1, V1> cacheLoader) {
        checkWeightWithWeigher();
        return new LocalCache.LocalLoadingCache(this, cacheLoader);
    }

    public <K1 extends K, V1 extends V> Cache<K1, V1> build() {
        checkWeightWithWeigher();
        checkNonLoadingCache();
        return new LocalCache.LocalManualCache(this);
    }

    private void checkNonLoadingCache() {
        Preconditions.checkState(this.refreshNanos == -1, "refreshAfterWrite requires a LoadingCache");
    }

    private void checkWeightWithWeigher() {
        boolean z = true;
        if (this.weigher == null) {
            if (this.maximumWeight != -1) {
                z = false;
            }
            Preconditions.checkState(z, "maximumWeight requires weigher");
        } else if (this.strictParsing) {
            if (this.maximumWeight == -1) {
                z = false;
            }
            Preconditions.checkState(z, "weigher requires maximumWeight");
        } else if (this.maximumWeight == -1) {
            logger.log(Level.WARNING, "ignoring weigher specified without maximumWeight");
        }
    }

    public String toString() {
        MoreObjects.ToStringHelper stringHelper = MoreObjects.toStringHelper((Object) this);
        int i = this.initialCapacity;
        if (i != -1) {
            stringHelper.add("initialCapacity", i);
        }
        int i2 = this.concurrencyLevel;
        if (i2 != -1) {
            stringHelper.add("concurrencyLevel", i2);
        }
        long j = this.maximumSize;
        if (j != -1) {
            stringHelper.add("maximumSize", j);
        }
        long j2 = this.maximumWeight;
        if (j2 != -1) {
            stringHelper.add("maximumWeight", j2);
        }
        if (this.expireAfterWriteNanos != -1) {
            stringHelper.add("expireAfterWrite", (Object) this.expireAfterWriteNanos + "ns");
        }
        if (this.expireAfterAccessNanos != -1) {
            stringHelper.add("expireAfterAccess", (Object) this.expireAfterAccessNanos + "ns");
        }
        LocalCache.Strength strength = this.keyStrength;
        if (strength != null) {
            stringHelper.add("keyStrength", (Object) Ascii.toLowerCase(strength.toString()));
        }
        LocalCache.Strength strength2 = this.valueStrength;
        if (strength2 != null) {
            stringHelper.add("valueStrength", (Object) Ascii.toLowerCase(strength2.toString()));
        }
        if (this.keyEquivalence != null) {
            stringHelper.addValue((Object) "keyEquivalence");
        }
        if (this.valueEquivalence != null) {
            stringHelper.addValue((Object) "valueEquivalence");
        }
        if (this.removalListener != null) {
            stringHelper.addValue((Object) "removalListener");
        }
        return stringHelper.toString();
    }
}
