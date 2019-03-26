# MusicFrame


#### 本音频框架集合了音乐服务，binderservice mediaplayer，普通的mediaplayer，SoundPool。结合LifecycleObserver，对生命周期，释放做了相应的处理。



---

# How to Use:

#### Step One: Add `CoverFlowView` to your project

1. Via XML:

如果想mediaplayer，做binder服务，或普通的mediapyer，需要把音频添加到assets,资源目录中。若果想用SoundPool做声音处理，需要创建raw，把声音放入里面。

2. soundPool使用 BaseApplication 中初始化音乐集合(via Java):

```java
     MusicFactory musicFactory = new MusicFactory();
        SoundPoolBase    soudPool = musicFactory.getSoudPool(this);
        ArrayList<String> strings = new ArrayList<>();
        strings.add("zhuan");
        soudPool.load(strings);


```

---

#### 获取音频池并执行相应处理:

```java
 MusicFactory musicFactory = new MusicFactory();
    SoundPoolBase    soudPool = musicFactory.getSoudPool(this);
      soudPool.playSound("zhuan",1);
```

.

#### 创建音频服务

```java
     MusicBase servieMusic = musicFactory.getServieMusic(this);
        servieMusic.setURLAndStart("music1.mp3",true);
```

#### 创建普通音频

```java
    //传入不同生命周期不同
        musicFactory.getNormalMusic(FragmetActivity);  //activity 中创建普通音频
          musicFactory.getNormalMusic(frament);  //frament 中创建普通音频
```



