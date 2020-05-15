package androidx.transition;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.util.Xml;
import android.view.InflateException;
import android.view.ViewGroup;
import androidx.collection.ArrayMap;
import androidx.core.content.res.TypedArrayUtils;
import java.io.IOException;
import java.lang.reflect.Constructor;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class TransitionInflater {
    private static final ArrayMap<String, Constructor<?>> CONSTRUCTORS = new ArrayMap<>();
    private static final Class<?>[] CONSTRUCTOR_SIGNATURE = {Context.class, AttributeSet.class};
    private final Context mContext;

    private TransitionInflater(Context context) {
        this.mContext = context;
    }

    public static TransitionInflater from(Context context) {
        return new TransitionInflater(context);
    }

    public Transition inflateTransition(int i) {
        XmlResourceParser xml = this.mContext.getResources().getXml(i);
        try {
            Transition createTransitionFromXml = createTransitionFromXml(xml, Xml.asAttributeSet(xml), (Transition) null);
            xml.close();
            return createTransitionFromXml;
        } catch (XmlPullParserException e) {
            throw new InflateException(e.getMessage(), e);
        } catch (IOException e2) {
            throw new InflateException(xml.getPositionDescription() + ": " + e2.getMessage(), e2);
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    public TransitionManager inflateTransitionManager(int i, ViewGroup viewGroup) {
        XmlResourceParser xml = this.mContext.getResources().getXml(i);
        try {
            TransitionManager createTransitionManagerFromXml = createTransitionManagerFromXml(xml, Xml.asAttributeSet(xml), viewGroup);
            xml.close();
            return createTransitionManagerFromXml;
        } catch (XmlPullParserException e) {
            InflateException inflateException = new InflateException(e.getMessage());
            inflateException.initCause(e);
            throw inflateException;
        } catch (IOException e2) {
            InflateException inflateException2 = new InflateException(xml.getPositionDescription() + ": " + e2.getMessage());
            inflateException2.initCause(e2);
            throw inflateException2;
        } catch (Throwable th) {
            xml.close();
            throw th;
        }
    }

    private Transition createTransitionFromXml(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        Transition transition2;
        int depth = xmlPullParser.getDepth();
        TransitionSet transitionSet = transition instanceof TransitionSet ? (TransitionSet) transition : null;
        loop0:
        while (true) {
            transition2 = null;
            while (true) {
                int next = xmlPullParser.next();
                if ((next != 3 || xmlPullParser.getDepth() > depth) && next != 1) {
                    if (next == 2) {
                        String name = xmlPullParser.getName();
                        if ("fade".equals(name)) {
                            transition2 = new Fade(this.mContext, attributeSet);
                        } else if ("changeBounds".equals(name)) {
                            transition2 = new ChangeBounds(this.mContext, attributeSet);
                        } else if ("slide".equals(name)) {
                            transition2 = new Slide(this.mContext, attributeSet);
                        } else if ("explode".equals(name)) {
                            transition2 = new Explode(this.mContext, attributeSet);
                        } else if ("changeImageTransform".equals(name)) {
                            transition2 = new ChangeImageTransform(this.mContext, attributeSet);
                        } else if ("changeTransform".equals(name)) {
                            transition2 = new ChangeTransform(this.mContext, attributeSet);
                        } else if ("changeClipBounds".equals(name)) {
                            transition2 = new ChangeClipBounds(this.mContext, attributeSet);
                        } else if ("autoTransition".equals(name)) {
                            transition2 = new AutoTransition(this.mContext, attributeSet);
                        } else if ("changeScroll".equals(name)) {
                            transition2 = new ChangeScroll(this.mContext, attributeSet);
                        } else if ("transitionSet".equals(name)) {
                            transition2 = new TransitionSet(this.mContext, attributeSet);
                        } else if ("transition".equals(name)) {
                            transition2 = (Transition) createCustom(attributeSet, Transition.class, "transition");
                        } else if ("targets".equals(name)) {
                            getTargetIds(xmlPullParser, attributeSet, transition);
                        } else if ("arcMotion".equals(name)) {
                            if (transition != null) {
                                transition.setPathMotion(new ArcMotion(this.mContext, attributeSet));
                            } else {
                                throw new RuntimeException("Invalid use of arcMotion element");
                            }
                        } else if ("pathMotion".equals(name)) {
                            if (transition != null) {
                                transition.setPathMotion((PathMotion) createCustom(attributeSet, PathMotion.class, "pathMotion"));
                            } else {
                                throw new RuntimeException("Invalid use of pathMotion element");
                            }
                        } else if (!"patternPathMotion".equals(name)) {
                            throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                        } else if (transition != null) {
                            transition.setPathMotion(new PatternPathMotion(this.mContext, attributeSet));
                        } else {
                            throw new RuntimeException("Invalid use of patternPathMotion element");
                        }
                        if (transition2 == null) {
                            continue;
                        } else {
                            if (!xmlPullParser.isEmptyElementTag()) {
                                createTransitionFromXml(xmlPullParser, attributeSet, transition2);
                            }
                            if (transitionSet != null) {
                                break;
                            } else if (transition != null) {
                                throw new InflateException("Could not add transition to another transition.");
                            }
                        }
                    }
                }
            }
            transitionSet.addTransition(transition2);
        }
        return transition2;
    }

    private Object createCustom(AttributeSet attributeSet, Class<?> cls, String str) {
        Object newInstance;
        Class<? extends U> asSubclass;
        String attributeValue = attributeSet.getAttributeValue((String) null, "class");
        if (attributeValue != null) {
            try {
                synchronized (CONSTRUCTORS) {
                    Constructor<? extends U> constructor = CONSTRUCTORS.get(attributeValue);
                    if (constructor == null && (asSubclass = Class.forName(attributeValue, false, this.mContext.getClassLoader()).asSubclass(cls)) != null) {
                        constructor = asSubclass.getConstructor(CONSTRUCTOR_SIGNATURE);
                        constructor.setAccessible(true);
                        CONSTRUCTORS.put(attributeValue, constructor);
                    }
                    newInstance = constructor.newInstance(new Object[]{this.mContext, attributeSet});
                }
                return newInstance;
            } catch (Exception e) {
                throw new InflateException("Could not instantiate " + cls + " class " + attributeValue, e);
            }
        } else {
            throw new InflateException(str + " tag must have a 'class' attribute");
        }
    }

    private void getTargetIds(XmlPullParser xmlPullParser, AttributeSet attributeSet, Transition transition) throws XmlPullParserException, IOException {
        int depth = xmlPullParser.getDepth();
        while (true) {
            int next = xmlPullParser.next();
            if ((next == 3 && xmlPullParser.getDepth() <= depth) || next == 1) {
                return;
            }
            if (next == 2) {
                if (xmlPullParser.getName().equals("target")) {
                    TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_TARGET);
                    int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "targetId", 1, 0);
                    if (namedResourceId != 0) {
                        transition.addTarget(namedResourceId);
                    } else {
                        int namedResourceId2 = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "excludeId", 2, 0);
                        if (namedResourceId2 != 0) {
                            transition.excludeTarget(namedResourceId2, true);
                        } else {
                            String namedString = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "targetName", 4);
                            if (namedString != null) {
                                transition.addTarget(namedString);
                            } else {
                                String namedString2 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "excludeName", 5);
                                if (namedString2 != null) {
                                    transition.excludeTarget(namedString2, true);
                                } else {
                                    String namedString3 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "excludeClass", 3);
                                    if (namedString3 != null) {
                                        try {
                                            transition.excludeTarget(Class.forName(namedString3), true);
                                        } catch (ClassNotFoundException e) {
                                            obtainStyledAttributes.recycle();
                                            throw new RuntimeException("Could not create " + namedString3, e);
                                        }
                                    } else {
                                        String namedString4 = TypedArrayUtils.getNamedString(obtainStyledAttributes, xmlPullParser, "targetClass", 0);
                                        if (namedString4 != null) {
                                            transition.addTarget(Class.forName(namedString4));
                                        }
                                    }
                                }
                            }
                        }
                    }
                    obtainStyledAttributes.recycle();
                } else {
                    throw new RuntimeException("Unknown scene name: " + xmlPullParser.getName());
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        return r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.transition.TransitionManager createTransitionManagerFromXml(org.xmlpull.v1.XmlPullParser r5, android.util.AttributeSet r6, android.view.ViewGroup r7) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r4 = this;
            int r0 = r5.getDepth()
            r1 = 0
        L_0x0005:
            int r2 = r5.next()
            r3 = 3
            if (r2 != r3) goto L_0x0012
            int r3 = r5.getDepth()
            if (r3 <= r0) goto L_0x0054
        L_0x0012:
            r3 = 1
            if (r2 == r3) goto L_0x0054
            r3 = 2
            if (r2 == r3) goto L_0x0019
            goto L_0x0005
        L_0x0019:
            java.lang.String r2 = r5.getName()
            java.lang.String r3 = "transitionManager"
            boolean r3 = r2.equals(r3)
            if (r3 == 0) goto L_0x002b
            androidx.transition.TransitionManager r1 = new androidx.transition.TransitionManager
            r1.<init>()
            goto L_0x0005
        L_0x002b:
            java.lang.String r3 = "transition"
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0039
            if (r1 == 0) goto L_0x0039
            r4.loadTransition(r6, r5, r7, r1)
            goto L_0x0005
        L_0x0039:
            java.lang.RuntimeException r6 = new java.lang.RuntimeException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "Unknown scene name: "
            r7.append(r0)
            java.lang.String r5 = r5.getName()
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            throw r6
        L_0x0054:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.TransitionInflater.createTransitionManagerFromXml(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.ViewGroup):androidx.transition.TransitionManager");
    }

    private void loadTransition(AttributeSet attributeSet, XmlPullParser xmlPullParser, ViewGroup viewGroup, TransitionManager transitionManager) throws Resources.NotFoundException {
        Scene scene;
        Transition inflateTransition;
        TypedArray obtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, Styleable.TRANSITION_MANAGER);
        int namedResourceId = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "transition", 2, -1);
        int namedResourceId2 = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "fromScene", 0, -1);
        Scene scene2 = null;
        if (namedResourceId2 < 0) {
            scene = null;
        } else {
            scene = Scene.getSceneForLayout(viewGroup, namedResourceId2, this.mContext);
        }
        int namedResourceId3 = TypedArrayUtils.getNamedResourceId(obtainStyledAttributes, xmlPullParser, "toScene", 1, -1);
        if (namedResourceId3 >= 0) {
            scene2 = Scene.getSceneForLayout(viewGroup, namedResourceId3, this.mContext);
        }
        if (namedResourceId >= 0 && (inflateTransition = inflateTransition(namedResourceId)) != null) {
            if (scene2 == null) {
                throw new RuntimeException("No toScene for transition ID " + namedResourceId);
            } else if (scene == null) {
                transitionManager.setTransition(scene2, inflateTransition);
            } else {
                transitionManager.setTransition(scene, scene2, inflateTransition);
            }
        }
        obtainStyledAttributes.recycle();
    }
}
